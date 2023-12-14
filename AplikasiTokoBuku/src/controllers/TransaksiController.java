package controllers;

import models.Transaksi;
import views.TransaksiPage;

import java.util.HashMap;

public class TransaksiController {
    public static TransaksiController controller;
    public static Transaksi model;
    public static TransaksiPage view;
    
    private final HashMap<String, String> cartData = new HashMap();
    private static boolean isLockedPengguna = false;
    
    public void initialize() {
        // isi tabel pelanggan dan buku
        populateDataPelanggan();
        populateDataBuku();
        
        // inisialisasi kode transaksi
        initTrxId();
        
        // inisialisasi state kolom
        initFieldsState();
        
        // event listener jumlah-harga
        view.tjum.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            public void changedUpdate(javax.swing.event.DocumentEvent e) { setEstimatedBookPrice(); }
            public void insertUpdate(javax.swing.event.DocumentEvent e) { setEstimatedBookPrice(); }
            public void removeUpdate(javax.swing.event.DocumentEvent e) { setEstimatedBookPrice(); }
        });
    }
    
    public void populateDataPelanggan() {
        view.TPelanggan.setModel(PelangganController.getDataPelanggan());
    }
    
    public void populateDataBuku() {
        view.TBuku.setModel(BukuController.getDataBuku("minimized"));
    }
    
    public void initTrxId() {
        String currentTrxId = getLatestTrxId();
        view.tktrans.setText(currentTrxId);
    }
    
    public void initFieldsState() {
        isLockedPengguna = false;
        String currentOrderId = getLatestOrderId();
        
        view.tkpes.setText(currentOrderId);
        
        view.tkbuk.setText("");
        view.tjum.setText("");
        view.tjum.setEnabled(false);
        view.thar.setText("");
        view.ttharga.setText("");
        view.tnpem.setText("");
        
        view.tkpes.setEditable(false);
        view.tktrans.setEditable(false);
        view.thar.setEditable(false);
        view.bsel.setEnabled(false);
        view.btranssel.setEnabled(false);
        view.bAddToCart.setEnabled(false);
    }
    
    public void setEstimatedBookPrice() {
        try {
            int unitPrice = Integer.parseInt(view.thar.getText());
            int amount = Integer.parseInt(view.tjum.getText());
            view.thar.setText(Integer.toString(unitPrice * amount));
        } catch (Exception e) {}
    }
    
    public void populateDataCart() {
        String[] columns = {"ID Pesanan", "ID Transaksi", "Nama Pelanggan", "Jumlah", "Sub Total"};

        javax.swing.table.DefaultTableModel tableModel = new javax.swing.table.DefaultTableModel(columns, 0);

        java.sql.ResultSet dataCart = getAllCartDataByTrxId(
                                            view.tktrans.getText(),
                                            view.tkpel.getText()
                                        );

        try {
            while ( dataCart.next() ) {
                String[] data = {
                    dataCart.getString("kd_pretransaksi"),
                    dataCart.getString("kd_transaksi"),
                    dataCart.getString("nama_pelanggan"),
                    Integer.toString(dataCart.getInt("jumlah")),
                    Integer.toString(dataCart.getInt("sub_total"))
                };

                tableModel.addRow(data);
            }
        } catch ( java.sql.SQLException e ) { System.err.println(e); }

        view.tabker.setModel(tableModel);
    }
    
    public void handleAddToCartButtonVisibility() {
        boolean isReadyToAdd = view.tkpel.getText() != null && view.tkbuk.getText() != null;
        if ( isReadyToAdd ) {
            view.bAddToCart.setEnabled(true);
            view.tjum.setEnabled(true);
            view.tjum.setText("1");
        }
    }
    
    public void handleAddCartData() {
        cartData.put("kd_pretransaksi", view.tkpes.getText());
        cartData.put("kd_transaksi", view.tktrans.getText());
        cartData.put("kd_pelanggan", view.tkpel.getText());
        cartData.put("kd_buku", view.tkbuk.getText());
        cartData.put("jumlah", view.tjum.getText());
        cartData.put("sub_total", view.thar.getText());
        
        boolean isSuccessInsert = model.addCartData(cartData);
        
        String message;
        if ( isSuccessInsert ) {
            message = "DATA BARU BERHASIL DIMASUKKAN!";
            populateDataCart();
            populateDataBuku();
            initFieldsState();
            isLockedPengguna = true;
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
            populateDataCart();
            populateDataPelanggan();
            populateDataBuku();
            initFieldsState();
            view.tkpel.setText("");
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
        String trxId = model.getLatestTrxId();
        trxId = String.format("%s%04d", "TR", Integer.parseInt(trxId.replaceAll("\\D", "")) + 1);
        return trxId;
    }
    
    public void handleCheckout() {
        view.btranssel.setEnabled(true);
        
        String kd_transaksi = view.tktrans.getText();
        String kd_pelanggan = view.tkpel.getText();
        java.sql.ResultSet c = model.getCheckoutData(kd_transaksi, kd_pelanggan);
        
        try {
            int jumlah_summed = c.getInt("jumlah");
            int total = c.getInt("total");
            
            view.ttharga.setText(Integer.toString(total));
            view.tnpem.setText(c.getString("nama_pelanggan"));
            view.btranssel.setEnabled(true);
            cartData.put("jumlah_summed", Integer.toString(jumlah_summed));
            cartData.put("total", Integer.toString(total));
        } catch (Exception e) {}
        
    }
    
    public void handleFinishTransaction() {
        boolean isSuccessInsert = model.addTransactionData(cartData);
        boolean isSuccessUpdate = model.updateStockAfterDoneTransaction(cartData);
        
        String message;
        if ( isSuccessInsert && isSuccessUpdate ) {
            message = "PESANAN BERHASIL DISELESAIKAN!";
            initTrxId();
            populateDataCart();
            populateDataPelanggan();
            populateDataBuku();
            initFieldsState();
            view.tkpel.setText("");
        } else {
            message = "PESANAN GAGAL DISELESAIKAN!";
        }
        
        javax.swing.JOptionPane.showMessageDialog(view, message);
    }
    
    public void handleSelectedRowPelanggan() {
        if ( !isLockedPengguna ) {
            javax.swing.table.DefaultTableModel tmodel = (javax.swing.table.DefaultTableModel)
            view.TPelanggan.getModel();
            int selectedRow = view.TPelanggan.getSelectedRow();
            String chosenKdPelanggan = tmodel.getValueAt(selectedRow, 0).toString();

            view.tkpel.setText(chosenKdPelanggan);
            handleAddToCartButtonVisibility();
        }
    }
    
    public void handleSelectedRowBuku() {
        javax.swing.table.DefaultTableModel tmodel = (javax.swing.table.DefaultTableModel)
                view.TBuku.getModel();
        int selectedRow = view.TBuku.getSelectedRow();
        String chosenKdBuku = tmodel.getValueAt(selectedRow, 0).toString();
        int chosenBookPrice = Integer.parseInt(tmodel.getValueAt(selectedRow, 6).toString());

        view.tkbuk.setText(chosenKdBuku);
        view.thar.setText(Integer.toString(chosenBookPrice));
        handleAddToCartButtonVisibility();
    }
    
    public void goToPreviousPage() {
        jmvc.Navigator.view("home");
        view.dispose();
    }
}
