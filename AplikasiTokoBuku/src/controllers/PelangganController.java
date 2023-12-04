package controllers;

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
}


