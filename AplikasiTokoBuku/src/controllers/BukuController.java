package controllers;

import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import models.Buku;
import views.BukuPage;

/**
 *
 * @author Samuel
 */
public class BukuController {
    public static BukuController controller;
    public static Buku model;
    public static BukuPage view;
    
    private static String latestId;
    
    public void initialize() {
        view.CBJenis.addItem("PILIH");
        view.CBJenis.addItem("Novel");
        view.CBJenis.addItem("Komik");
        view.CBJenis.addItem("Biografi");
        view.CBJenis.addItem("Buku Sekolah");
        
        view.TFkode.setEditable(false);
        
        view.setLocationRelativeTo(null);
       
        view.BHapus.setEnabled(false);
        view.BUbah.setEnabled(false);
        
        refreshId();
        populateDataBuku("");
        resetInput();
    }
    
    public void refreshId() {
        latestId = getLatestId();
        view.TFkode.setText(latestId);
    }
    
    public static javax.swing.table.DefaultTableModel getDataBuku(String... params) {
        String mode = (params.length > 0) ? params[0] : "";
        java.sql.ResultSet dataBuku = Buku.getBookData();

        String[] columns = (mode.equals("minimized"))
            ? new String[]{"ID", "Judul", "Penulis", "Penerbit", "Tahun", "Stok", "Harga Jual"}
            : new String[]{"ID", "Judul", "Jenis", "Penulis", "Penerbit", "Tahun", "Stok", "Harga Pokok", "Harga Jual"};

        javax.swing.table.DefaultTableModel tableModel = new javax.swing.table.DefaultTableModel(columns, 0);

        try {
            while (dataBuku.next()) {
                String[] data = (mode.equals("minimized"))
                    ? new String[]{dataBuku.getString("kd_buku"), dataBuku.getString("judul"), dataBuku.getString("penulis"),
                                   dataBuku.getString("penerbit"), dataBuku.getString("tahun"),
                                   Integer.toString(dataBuku.getInt("stok")), Integer.toString(dataBuku.getInt("harga_jual"))}
                    : new String[]{dataBuku.getString("kd_buku"), dataBuku.getString("judul"), dataBuku.getString("jenis"),
                                   dataBuku.getString("penulis"), dataBuku.getString("penerbit"),
                                   dataBuku.getString("tahun"), Integer.toString(dataBuku.getInt("stok")),
                                   Integer.toString(dataBuku.getInt("harga_pokok")), Integer.toString(dataBuku.getInt("harga_jual"))};

                tableModel.addRow(data);
            }
        } catch (java.sql.SQLException e) {
            System.out.println(e);
        }
        
        return tableModel;
    }
    
    public static void populateDataBuku(String... params) {
        javax.swing.table.DefaultTableModel tableModel = getDataBuku(params);
        view.TBuku.setModel(tableModel);
    }
    
    public void resetInput() {
        view.BTambah.setEnabled(true);
        view.BHapus.setEnabled(false);
        view.BUbah.setEnabled(false);
        view.CBJenis.setSelectedItem("PILIH");
        view.TFkode.setText(latestId);
        view.TFTahun.setText("");
        view.TFStok.setText("");
        view.TFPenulis.setText("");
        view.TFPenerbit.setText("");
        view.TFJudul.setText("");
        view.TFHargaPokok.setText("");
        view.TFHargaJual.setText("");
    }
    
    public void handleAddData() {
        boolean isSuccessInsert = model.addBookData(
            view.TFkode.getText(),
            view.TFJudul.getText(),
            view.CBJenis.getSelectedItem().toString(),
            view.TFPenulis.getText(),
            view.TFPenerbit.getText(),
            view.TFTahun.getText(),
            Integer.parseInt(view.TFStok.getText()),
            Integer.parseInt(view.TFHargaPokok.getText()),
            Integer.parseInt(view.TFHargaJual.getText())
        );
        
        String message;
        if ( isSuccessInsert ) {
            message = "DATA BARU BERHASIL DIMASUKKAN!";
            refreshId();
            populateDataBuku("");
            resetInput();
        } else {
            message = "DATA GAGAL DITAMBAH!";
        }
        
        javax.swing.JOptionPane.showMessageDialog(view, message);
    }
    
    public void handleDeleteData(String kd_buku) {
        int choice = javax.swing.JOptionPane.showConfirmDialog(null, "Konfirmasi Hapus", "KOnfirmasi", javax.swing.JOptionPane.YES_NO_OPTION);
        if ( choice == javax.swing.JOptionPane.YES_OPTION ){
            boolean isSuccessDelete = model.deleteBookData(kd_buku);
            
            String message;
            if ( isSuccessDelete ) {
                message = "DATA BERHASIL DIHAPUS!";
                refreshId();
                populateDataBuku("");
                resetInput();
            } else {
                message = "DATA GAGAL DIHAPUS!";
            }

            javax.swing.JOptionPane.showMessageDialog(view, message);
        }
    }
    
    public void handleUpdateData(String kd_buku){
        boolean isSuccessUpdate = model.updateBookData(
            view.TFkode.getText(),
            view.TFJudul.getText(),
            view.CBJenis.getSelectedItem().toString(),
            view.TFPenulis.getText(),
            view.TFPenerbit.getText(),
            view.TFTahun.getText(),
            Integer.parseInt(view.TFStok.getText()),
            Integer.parseInt(view.TFHargaPokok.getText()),
            Integer.parseInt(view.TFHargaJual.getText())
        );
        
        String message;
        if ( isSuccessUpdate ) {
            message = "DATA BARU BERHASIL DIUBAH!";
            refreshId();
            populateDataBuku("");
            resetInput();
        } else {
            message = "DATA GAGAL DIUBAH!";
        }
        
        javax.swing.JOptionPane.showMessageDialog(view, message);
    }
    
    public void handleSearchData(){
        String s = view.TFSearch.getText();
        DefaultTableModel ob = (DefaultTableModel) view.TBuku.getModel();
        TableRowSorter<DefaultTableModel> obj = new TableRowSorter<>(ob);
        view.TBuku.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(s));
    }
    
    public String getLatestId() {
        String id = model.getLatestId();
        id = String.format("%s%04d", "K", Integer.parseInt(id.replaceAll("\\D", "")) + 1);
        return id;
    }
    
    public void handleSelectedRow() {
        view.BTambah.setEnabled(false);
        view.BHapus.setEnabled(true);
        view.BUbah.setEnabled(true);
        DefaultTableModel tmodel = (DefaultTableModel) view.TBuku.getModel();
        int selectedRow = view.TBuku.getSelectedRow();
        try {
            view.TFkode.setText(tmodel.getValueAt(selectedRow, 0).toString());
            view.TFTahun.setText(tmodel.getValueAt(selectedRow, 5).toString());
            view.TFStok.setText(tmodel.getValueAt(selectedRow, 6).toString());
            String comboSub = tmodel.getValueAt(selectedRow, 2).toString();
            for ( int i = 0; i < view.CBJenis.getItemCount(); i++ ){
                if ( view.CBJenis.getItemAt(i).equalsIgnoreCase(comboSub) ) {
                   view.CBJenis.setSelectedIndex(i);
                }
            }
            view.TFPenulis.setText(tmodel.getValueAt(selectedRow, 3).toString());
            view.TFPenerbit.setText(tmodel.getValueAt(selectedRow, 4).toString());
            view.TFJudul.setText(tmodel.getValueAt(selectedRow, 1).toString());
            view.TFHargaPokok.setText(tmodel.getValueAt(selectedRow, 7).toString());
            view.TFHargaJual.setText(tmodel.getValueAt(selectedRow, 8).toString());
        } catch ( Exception e ) {}
    }
    
    public void goToPreviousPage() {
        jmvc.Navigator.view("home");
        view.dispose();
    }
}