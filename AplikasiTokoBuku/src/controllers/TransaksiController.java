package controllers;

import models.Transaksi;
import models.Pelanggan;
import models.Buku;
import views.TransaksiPage;

public class TransaksiController {
    private Transaksi model;
    private TransaksiPage view;
    private Pelanggan modelPelanggan;
    private Buku modelBuku;

    public TransaksiController() {
        this.model = new Transaksi();
        this.modelPelanggan = new Pelanggan();
        this.modelBuku = new Buku();
    }

    public void setView(TransaksiPage view) {
        this.view = view;
        view.setVisible(true);
    }
    
    public java.sql.ResultSet getPelangganData() {
        return modelPelanggan.getPelangganData();
    }
    
    public java.sql.ResultSet getBukuData() {
        return modelBuku.getAvailableBookData();
    }
    
    public void handleAddCartData() {
        boolean isSuccessInsert = model.addCartData(view.cartData);
        
        String message;
        if ( isSuccessInsert ) {
            message = "DATA BARU BERHASIL DIMASUKKAN!";
            view.initFieldsState();
            view.populateDataCart();
            view.populateDataBuku();
            view.bsel.setEnabled(true);
        } else {
            message = "DATA GAGAL DITAMBAH!";
        }
        
        javax.swing.JOptionPane.showMessageDialog(view, message);
    }
    
    public void handleDeleteCartData() {
        boolean isSuccessDelete = model.deleteCartData(view.tktrans.getText());
        
        String message;
        if ( isSuccessDelete ) {
            message = "KERANJANG BERHASIL DIHAPUS!";
            view.populateDataCart();
            view.populateDataBuku();
        } else {
            message = "KERANJANG GAGAL DIHAPUS!";
        }
        
        javax.swing.JOptionPane.showMessageDialog(view, message);
    }
    
    public java.sql.ResultSet getAllCartDataByTrxId(String kd_transaksi, String kd_pelanggan) {
        return model.getAllCartDataByTrxId(kd_transaksi, kd_pelanggan);
    }
    
    public String getLatestOrderId() {
        String orderId = model.getLatestOrderId();
        orderId = String.format("%s%04d", "PS", Integer.parseInt(orderId.replaceAll("\\D", "")) + 1);
        return orderId;
    }
    
    public String getLatestTrxId() {
//        String orderId = model.getLatestOrderId();
        String trxId = model.getLatestTrxId();
        trxId = String.format("%s%04d", "TR", Integer.parseInt(trxId.replaceAll("\\D", "")) + 1);
        return trxId;
    }
    
    public void handleCheckout() {
        String kd_transaksi = view.tktrans.getText();
        String kd_pelanggan = view.tkpel.getText();
        java.sql.ResultSet c = model.getCheckoutData(kd_transaksi, kd_pelanggan);
        
        try {
            int jumlah_summed = c.getInt("jumlah");
            int total = c.getInt("total");
            
            view.ttharga.setText(Integer.toString(total));
            view.tnpem.setText(c.getString("nama_pelanggan"));
            view.btranssel.setEnabled(true);
            view.cartData.put("jumlah_summed", Integer.toString(jumlah_summed));
            view.cartData.put("total", Integer.toString(total));
            
        } catch (Exception e) {}
        
    }
    
    public void handleFinishTransaction() {
        boolean isSuccessInsert = model.addTransactionData(view.cartData);
        boolean isSuccessUpdate = model.updateStockAfterDoneTransaction(view.cartData);
        
        String message;
        if ( isSuccessInsert && isSuccessUpdate ) {
            message = "PESANAN BERHASIL DISELESAIKAN!";
            view.initTrxId();
            view.populateDataCart();
            view.populateDataBuku();
        } else {
            message = "PESANAN GAGAL DISELESAIKAN!";
        }
        
        javax.swing.JOptionPane.showMessageDialog(view, message);
    }
}
