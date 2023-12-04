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
    
    public void handleDeleteData(String kd_buku){
        int choice = javax.swing.JOptionPane.showConfirmDialog(null, "Konfirmasi Hapus", "KOnfirmasi", javax.swing.JOptionPane.YES_NO_OPTION);
        if(choice == javax.swing.JOptionPane.YES_OPTION){
            boolean isSuccessDelete = model.deleteBookData(kd_buku);
            String message;
            if ( isSuccessDelete ) {
                message = "DATA BERHASIL DIHAPUS!";
            } else {
                message = "DATA GAGAL DIHAPUS!";
            }

            javax.swing.JOptionPane.showMessageDialog(view, message);
            jmvc.Navigator.view("buku");
            view.setVisible(false);
        } 
    }
    
    public boolean handleUpdateData(String kd_buku){
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
        } else {
            message = "DATA GAGAL DIUBAH!";
        }
        
        javax.swing.JOptionPane.showMessageDialog(view, message); 
        
        return isSuccessUpdate;
    }
    
    public void handleSearchData(String s){
        DefaultTableModel ob = (DefaultTableModel) view.TData.getModel();
        TableRowSorter<DefaultTableModel> obj = new TableRowSorter<>(ob);
        view.TData.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(s));
        java.sql.ResultSet dataBuku = model.searchBookData(s);
    }
}