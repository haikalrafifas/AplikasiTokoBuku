package controllers;

import models.Buku;
import views.BukuPage;

/**
 *
 * @author Samuel
 */
public class BukuController {
    
    
    private Buku model;
    private BukuPage view;
    
    public BukuController() {
        this.model = new Buku();
    }
    
    public void setView(BukuPage view) {
        this.view = view;
        view.setVisible(true);
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
        } else {
            message = "DATA GAGAL DITAMBAH!";
        }
        
        javax.swing.JOptionPane.showMessageDialog(view, message);
    }
    
    public java.sql.ResultSet getBookData() {
        return model.getBookData();
    }
}
