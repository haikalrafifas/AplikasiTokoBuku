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
    private Pelanggan model;
    private PelangganPage view;
    
    public PelangganController() {
        this.model = new Pelanggan();
    }
    
    public void setView(PelangganPage view) {
        this.view = view;
        view.setVisible(true);
    }
    
    public java.sql.ResultSet getPelangganData() {
        return model.getPelangganData();
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
        } else {
            message = "DATA GAGAL DITAMBAH!";
        }
        
        javax.swing.JOptionPane.showMessageDialog(view, message);
    }
    
    public void handleDeleteData(String kd_pelanggan){
        int choice = javax.swing.JOptionPane.showConfirmDialog(null, "Konfirmasi Hapus", "KOnfirmasi", javax.swing.JOptionPane.YES_NO_OPTION);
        if(choice == javax.swing.JOptionPane.YES_OPTION){
            boolean isSuccessDelete = model.deletePelangganData(kd_pelanggan);
            String message;
            if ( isSuccessDelete ) {
                message = "DATA BERHASIL DIHAPUS!";
            } else {
                message = "DATA GAGAL DIHAPUS!";
            }

            javax.swing.JOptionPane.showMessageDialog(view, message);
            jmvc.Navigator.view("pelanggan");
            view.setVisible(false);
        } 
    }
    
    public boolean handleUpdateData(String kd_pelanggan){
        String gender = "P";
        if(view.RL.isSelected()){
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
        } else {
            message = "DATA GAGAL DIUBAH!";
        }
        
        javax.swing.JOptionPane.showMessageDialog(view, message); 
        
        return isSuccessUpdate;
    }
    
    public void handleSearchData(String s){
        DefaultTableModel ob = (DefaultTableModel) view.TPelanggan.getModel();
        TableRowSorter<DefaultTableModel> obj = new TableRowSorter<>(ob);
        view.TPelanggan.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(s));
        java.sql.ResultSet dataPelanggan = model.searchPelangganData(s);
    }
}