package controllers;

import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import models.Pelanggan;
import views.PelangganPage;

/**
 *
 * @author Kelompok urut 2
 */
public class PelangganController {
    public static PelangganController controller;
    public static Pelanggan model;
    public static PelangganPage view;
    
    private static String latestId;
    
    public void initialize() {
        view.BHapus.setEnabled(false);
        view.BUbah.setEnabled(false);
        view.TFKode.setEditable(false);
        
        refreshId();
        populateDataPelanggan();
        resetInput();
    }
    
    public void refreshId() {
        latestId = getLatestId();
        view.TFKode.setText(latestId);
    }
    
    public static javax.swing.table.DefaultTableModel getDataPelanggan() {
        java.sql.ResultSet dataPelanggan = Pelanggan.getPelangganData();
        String[] columns = {"ID", "Nama", "Jenis Kelamin", "Alamat"};

        javax.swing.table.DefaultTableModel tableModel = new javax.swing.table.DefaultTableModel(columns, 0);

        try {
            while ( dataPelanggan.next() ) {
                String[] data = {
                    dataPelanggan.getString("kd_pelanggan"),
                    dataPelanggan.getString("nama_pelanggan"),
                    dataPelanggan.getString("jenis_kelamin"),
                    dataPelanggan.getString("alamat")
                };

                tableModel.addRow(data);
            }
        } catch ( java.sql.SQLException e ) {
            System.out.println(e);
        }
        
        return tableModel;
    }
    
    public static void populateDataPelanggan() {
        javax.swing.table.DefaultTableModel tableModel = getDataPelanggan();
        view.TPelanggan.setModel(tableModel);
    }
    
    public void resetInput() {
        view.BTambah.setEnabled(true);
        view.BHapus.setEnabled(false);
        view.BUbah.setEnabled(false);
        view.TFKode.setText(latestId);
        view.TFNama.setText("");
        view.TAalamat.setText("");
        view.RL.setSelected(false);
        view.RP.setSelected(false);
        view.buttonGroup1.clearSelection();
    }
    
    public void handleAddData() {
        boolean isSuccessInsert = model.addPelangganData(
            view.TFKode.getText(),
            view.TFNama.getText(),
            view.TAalamat.getText(),
            view.RL.isSelected()
        );
        
        String message;
        if ( isSuccessInsert ) {
            message = "DATA BARU BERHASIL DIMASUKKAN!";
            refreshId();
            populateDataPelanggan();
            resetInput();
        } else {
            message = "DATA GAGAL DITAMBAH!";
        }
        
        javax.swing.JOptionPane.showMessageDialog(view, message);
    }
    
    public void handleDeleteData(String kd_pelanggan){
        int choice = javax.swing.JOptionPane.showConfirmDialog(null, "Konfirmasi Hapus", "KOnfirmasi", javax.swing.JOptionPane.YES_NO_OPTION);
        if ( choice == javax.swing.JOptionPane.YES_OPTION ) {
            boolean isSuccessDelete = model.deletePelangganData(kd_pelanggan);
            String message;
            if ( isSuccessDelete ) {
                message = "DATA BERHASIL DIHAPUS!";
                refreshId();
                populateDataPelanggan();
                resetInput();
            } else {
                message = "DATA GAGAL DIHAPUS!";
            }

            javax.swing.JOptionPane.showMessageDialog(view, message);
        }
    }
    
    public void handleUpdateData(String kd_pelanggan){
        String gender = "P";
        if ( view.RL.isSelected() ){
            gender = "L";
        }
        
        boolean isSuccessUpdate = model.updatePelangganData(
            view.TFKode.getText(),
            view.TFNama.getText(),
            gender,
            view.TAalamat.getText()
        );
        
        String message;
        if ( isSuccessUpdate ) {
            message = "DATA BARU BERHASIL DIUBAH!";
            refreshId();
            populateDataPelanggan();
            resetInput();
        } else {
            message = "DATA GAGAL DIUBAH!";
        }
        
        javax.swing.JOptionPane.showMessageDialog(view, message);
    }
    
    public void handleSearchData() {
        String s = view.TFSearch.getText();
        DefaultTableModel ob = (DefaultTableModel) view.TPelanggan.getModel();
        TableRowSorter<DefaultTableModel> obj = new TableRowSorter<>(ob);
        view.TPelanggan.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(s));
    }
    
    public String getLatestId() {
        String id = model.getLatestId();
        id = String.format("%s%03d", "PL", Integer.parseInt(id.replaceAll("\\D", "")) + 1);
        return id;
    }
    
    public void handleSelectedRow() {
        view.BTambah.setEnabled(false);
        view.BHapus.setEnabled(true);
        view.BUbah.setEnabled(true);
        int i = view.TPelanggan.getSelectedRow();
        javax.swing.table.TableModel tmodel = view.TPelanggan.getModel();
        view.TFKode.setText(tmodel.getValueAt(i, 0).toString());
        view.TFNama.setText(tmodel.getValueAt(i, 1).toString());
        view.TAalamat.setText(tmodel.getValueAt(i, 3).toString());
        String sex = tmodel.getValueAt(i, 2).toString();
            if( sex.equals("L") ){
                view.RL.setSelected(true);
            } else {
                view.RP.setSelected(true);
            }
    }
    
    public void goToPreviousPage() {
        jmvc.Navigator.view("home");
        view.dispose();
    }
}