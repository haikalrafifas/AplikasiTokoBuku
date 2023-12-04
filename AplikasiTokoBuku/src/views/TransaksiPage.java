package views;

import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kevin
 */
public class TransaksiPage extends javax.swing.JFrame {
    
    private final controllers.TransaksiController transaksiController;
    private java.sql.ResultSet dataPelanggan;
    private java.sql.ResultSet dataBuku;
    private String chosenKdPelanggan;
    private String chosenKdBuku;
    private int chosenBookPrice;
    
    public HashMap<String, String> cartData = new HashMap();

    /**
     * Creates new form TransaksiPage
     * @param transaksiController
     */
    public TransaksiPage(controllers.TransaksiController transaksiController) {
        this.transaksiController = transaksiController;
        initComponents();
        
        
        populateDataPelanggan();
        populateDataBuku();
        
        // inisialisasi kode transaksi
        initTrxId();
        
        // inisialisasi state kolom
        initFieldsState();
        
        tjum.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            public void changedUpdate(javax.swing.event.DocumentEvent e) { setEstimatedBookPrice(); }
            public void insertUpdate(javax.swing.event.DocumentEvent e) { setEstimatedBookPrice(); }
            public void removeUpdate(javax.swing.event.DocumentEvent e) { setEstimatedBookPrice(); }
        });
    }
    
    public void initTrxId() {
        String currentTrxId = transaksiController.getLatestTrxId();
        tktrans.setText(currentTrxId);
    }
    
    private void setEstimatedBookPrice() {
        try {
            int unitPrice = chosenBookPrice;
            int amount = Integer.parseInt(tjum.getText());
            thar.setText(Integer.toString(unitPrice * amount));
        } catch (Exception e) {}
        
    }
    
    private void populateDataPelanggan() {
        String[] columns = {"ID", "Nama", "Gender", "Alamat"};

        javax.swing.table.DefaultTableModel tableModel = new javax.swing.table.DefaultTableModel(columns, 0);
        
        dataPelanggan = transaksiController.getPelangganData();

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
        } catch ( java.sql.SQLException e ) { System.out.println(e); }

        tabdatpel.setModel(tableModel);
    }
    
    public void populateDataBuku() {
        String[] columns = {"ID", "Judul", "Penulis", "Penerbit", "Tahun", "Stok", "Harga"};

        javax.swing.table.DefaultTableModel tableModel = new javax.swing.table.DefaultTableModel(columns, 0);
        
        dataBuku = transaksiController.getBukuData();

        try {
            while ( dataBuku.next() ) {
                String[] data = {
                    dataBuku.getString("kd_buku"),
                    dataBuku.getString("judul"),
                    dataBuku.getString("penulis"),
                    dataBuku.getString("penerbit"),
                    dataBuku.getString("tahun"),
                    Integer.toString(dataBuku.getInt("stok")),
                    Integer.toString(dataBuku.getInt("harga_jual"))
                };

                tableModel.addRow(data);
            }
        } catch ( java.sql.SQLException e ) { System.out.println(e); }

        tabdatbuk.setModel(tableModel);
    }
    
    public void populateDataCart() {
        String[] columns = {"ID Pesanan", "ID Transaksi", "Nama Pelanggan", "Jumlah", "Sub Total"};

        javax.swing.table.DefaultTableModel tableModel = new javax.swing.table.DefaultTableModel(columns, 0);
//        DefaultTableModel tableModel = (DefaultTableModel) TData.getModel();
        
//        javax.swing.table.DefaultTableModel tableModel = (javax.swing.table.DefaultTableModel) tabdat.getModel();
        
        java.sql.ResultSet dataCart = transaksiController.getAllCartDataByTrxId(
                                            tktrans.getText(),
                                            tkpel.getText()
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
        } catch ( java.sql.SQLException e ) { System.out.println(e); }

        tabker.setModel(tableModel);
    }
    
    public void initFieldsState() {
        String currentOrderId = transaksiController.getLatestOrderId();
        
        tkpes.setText(currentOrderId);
        
        tkpes.setEditable(false);
        tktrans.setEditable(false);
        thar.setEditable(false);
        bsel.setEnabled(false);
        btranssel.setEnabled(false);
        bAddToCart.setEnabled(false);
    }

    private void handleAddToCartButtonVisibility() {
        boolean isReadyToAdd = chosenKdPelanggan != null && chosenKdBuku != null;
        if ( isReadyToAdd ) {
            bAddToCart.setEnabled(true);
            tjum.setEnabled(true);
            tjum.setText("1");
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabdatpel = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabdatbuk = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tkpes = new javax.swing.JTextField();
        thar = new javax.swing.JTextField();
        tkpel = new javax.swing.JTextField();
        tktrans = new javax.swing.JTextField();
        tjum = new javax.swing.JTextField();
        tkbuk = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabker = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        bsel = new javax.swing.JButton();
        bbat = new javax.swing.JButton();
        ttharga = new javax.swing.JTextField();
        tnpem = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btranssel = new javax.swing.JButton();
        bAddToCart = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("FORM TRANSAKSI");

        jLabel2.setText("Data Pelanggan");

        jLabel3.setText("Data Buku");

        tabdatpel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nama", "Gender", "Alamat"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabdatpel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabdatpelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabdatpel);

        tabdatbuk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Judul", "Penulis", "Penerbit", "Tahun", "Stok", "Harga"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabdatbuk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabdatbukMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabdatbuk);

        jLabel4.setText("Kode Pesan");

        jLabel5.setText("Kode Transaksi");

        jLabel6.setText("Kode Pelanggan");

        jLabel7.setText("Kode Buku");

        jLabel8.setText("Jumlah");

        jLabel9.setText("Harga");

        tkpes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tkpesActionPerformed(evt);
            }
        });

        tjum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tjumActionPerformed(evt);
            }
        });

        tabker.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Pesanan", "ID Transaksi", "Nama Pelanggan", "Jumlah", "Sub Total"
            }
        ));
        jScrollPane3.setViewportView(tabker);

        jLabel10.setText("Keranjang");

        bsel.setText("Selesai");
        bsel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bselActionPerformed(evt);
            }
        });

        bbat.setText("Batal");
        bbat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbatActionPerformed(evt);
            }
        });

        jLabel13.setText("Total Harga");

        jLabel14.setText("Nama Pembeli");

        btranssel.setText("Transaksi Selesai");
        btranssel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btransselActionPerformed(evt);
            }
        });

        bAddToCart.setText("Tambah ke Keranjang");
        bAddToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddToCartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(456, 456, 456)
                        .addComponent(jLabel10)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(565, 565, 565))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jLabel6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(182, 182, 182)
                                .addComponent(jLabel7))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(173, 173, 173)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tkbuk, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tktrans, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(thar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(129, 129, 129)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(tkpes, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tkpel, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tjum, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(356, 356, 356))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(181, 181, 181)
                                        .addComponent(jLabel5)
                                        .addGap(96, 96, 96))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(147, 147, 147)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9)
                                .addGap(123, 123, 123)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel13)
                                .addGap(131, 131, 131)
                                .addComponent(jLabel14))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(bsel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(ttharga, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(bbat, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(65, 65, 65)
                                        .addComponent(tnpem, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(14, 14, 14))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(bAddToCart)
                        .addGap(366, 366, 366)
                        .addComponent(btranssel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tkpes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tktrans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tkpel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tkbuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tjum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(thar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(74, 74, 74))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ttharga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tnpem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(80, 80, 80)
                                .addComponent(btranssel)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bbat, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bsel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(175, 175, 175)
                        .addComponent(bAddToCart)
                        .addGap(33, 33, 33))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tkpesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tkpesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tkpesActionPerformed

    private void tjumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tjumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tjumActionPerformed

    private void tabdatpelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabdatpelMouseClicked
        DefaultTableModel model = (DefaultTableModel) tabdatpel.getModel();
        int selectedRow = tabdatpel.getSelectedRow();
        chosenKdPelanggan = model.getValueAt(selectedRow, 0).toString();

        tkpel.setText(chosenKdPelanggan);
        handleAddToCartButtonVisibility();
    }//GEN-LAST:event_tabdatpelMouseClicked

    private void bbatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbatActionPerformed
        chosenKdPelanggan = null;
        chosenKdBuku = null;
        
        tkpel.setText("");
        tkbuk.setText("");
        tjum.setText("");
        tjum.setEnabled(false);
        thar.setText("");
        ttharga.setText("");
        tnpem.setText("");
        
        bsel.setEnabled(false);
        bAddToCart.setEnabled(false);
        
        transaksiController.handleDeleteCartData();
    }//GEN-LAST:event_bbatActionPerformed

    private void tabdatbukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabdatbukMouseClicked
        DefaultTableModel model = (DefaultTableModel) tabdatbuk.getModel();
        int selectedRow = tabdatbuk.getSelectedRow();
        chosenKdBuku = model.getValueAt(selectedRow, 0).toString();
        chosenBookPrice = Integer.parseInt(model.getValueAt(selectedRow, 6).toString());

        tkbuk.setText(chosenKdBuku);
        thar.setText(Integer.toString(chosenBookPrice));
        handleAddToCartButtonVisibility();
    }//GEN-LAST:event_tabdatbukMouseClicked

    private void bAddToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddToCartActionPerformed
        cartData.put("kd_pretransaksi", tkpes.getText());
        cartData.put("kd_transaksi", tktrans.getText());
        cartData.put("kd_pelanggan", tkpel.getText());
        cartData.put("kd_buku", tkbuk.getText());
        cartData.put("jumlah", tjum.getText());
        cartData.put("sub_total", thar.getText());
        
        // add to cart
        transaksiController.handleAddCartData();
        
    }//GEN-LAST:event_bAddToCartActionPerformed

    private void bselActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bselActionPerformed
        transaksiController.handleCheckout();
    }//GEN-LAST:event_bselActionPerformed

    private void btransselActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btransselActionPerformed
        transaksiController.handleFinishTransaction();
    }//GEN-LAST:event_btransselActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAddToCart;
    private javax.swing.JButton bbat;
    public javax.swing.JButton bsel;
    public javax.swing.JButton btranssel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabdatbuk;
    private javax.swing.JTable tabdatpel;
    private javax.swing.JTable tabker;
    private javax.swing.JTextField thar;
    private javax.swing.JTextField tjum;
    private javax.swing.JTextField tkbuk;
    public javax.swing.JTextField tkpel;
    private javax.swing.JTextField tkpes;
    public javax.swing.JTextField tktrans;
    public javax.swing.JTextField tnpem;
    public javax.swing.JTextField ttharga;
    // End of variables declaration//GEN-END:variables
}
