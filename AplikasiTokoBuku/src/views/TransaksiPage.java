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
        jBkembali = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 51, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TRANSAKSI");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(547, 45, -1, -1));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 102));
        jLabel2.setText("Data Pelanggan");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 119, -1, -1));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 102));
        jLabel3.setText("Data Buku");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(547, 119, -1, -1));

        tabdatpel.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 144, 311, 154));

        tabdatbuk.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
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

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 144, -1, 154));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel4.setText("Kode Pesan");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 349, -1, -1));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel5.setText("Kode Transaksi");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 349, -1, -1));

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel6.setText("Kode Pelanggan");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 415, -1, -1));

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel7.setText("Kode Buku");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 415, -1, -1));

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel8.setText("Jumlah");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 485, -1, -1));

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel9.setText("Harga");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 485, -1, -1));

        tkpes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tkpesActionPerformed(evt);
            }
        });
        getContentPane().add(tkpes, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 371, 105, -1));
        getContentPane().add(thar, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 507, 105, -1));
        getContentPane().add(tkpel, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 451, 105, -1));
        getContentPane().add(tktrans, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 371, 105, -1));

        tjum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tjumActionPerformed(evt);
            }
        });
        getContentPane().add(tjum, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 507, 105, -1));
        getContentPane().add(tkbuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 451, 105, -1));

        tabker.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
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

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(854, 144, 425, 154));

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 51, 102));
        jLabel10.setText("Keranjang");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1038, 119, -1, -1));

        bsel.setBackground(new java.awt.Color(0, 51, 102));
        bsel.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        bsel.setForeground(new java.awt.Color(249, 249, 249));
        bsel.setText("Selesai");
        bsel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bselActionPerformed(evt);
            }
        });
        getContentPane().add(bsel, new org.netbeans.lib.awtextra.AbsoluteConstraints(857, 341, 91, 37));

        bbat.setBackground(new java.awt.Color(0, 51, 102));
        bbat.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        bbat.setForeground(new java.awt.Color(249, 249, 249));
        bbat.setText("Batal");
        bbat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbatActionPerformed(evt);
            }
        });
        getContentPane().add(bbat, new org.netbeans.lib.awtextra.AbsoluteConstraints(1019, 341, 104, 37));
        getContentPane().add(ttharga, new org.netbeans.lib.awtextra.AbsoluteConstraints(857, 444, 140, -1));
        getContentPane().add(tnpem, new org.netbeans.lib.awtextra.AbsoluteConstraints(1062, 444, 140, -1));

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel13.setText("Total Harga");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(857, 410, -1, -1));

        jLabel14.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel14.setText("Nama Pembeli");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1062, 410, -1, -1));

        btranssel.setBackground(new java.awt.Color(153, 51, 255));
        btranssel.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btranssel.setForeground(new java.awt.Color(249, 249, 249));
        btranssel.setText("Transaksi Selesai");
        btranssel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btransselActionPerformed(evt);
            }
        });
        getContentPane().add(btranssel, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 515, 170, 37));

        bAddToCart.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        bAddToCart.setText("Tambah ke Keranjang");
        bAddToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddToCartActionPerformed(evt);
            }
        });
        getContentPane().add(bAddToCart, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 552, -1, -1));

        jBkembali.setBackground(new java.awt.Color(153, 51, 255));
        jBkembali.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jBkembali.setForeground(new java.awt.Color(249, 249, 249));
        jBkembali.setText("Kembali");
        jBkembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBkembaliActionPerformed(evt);
            }
        });
        getContentPane().add(jBkembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 552, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1330, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1330, 640));

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

    private void jBkembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBkembaliActionPerformed
        // TODO add your handling code here:
        jmvc.Navigator.view("home");
        this.setVisible(false);
    }//GEN-LAST:event_jBkembaliActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAddToCart;
    private javax.swing.JButton bbat;
    public javax.swing.JButton bsel;
    public javax.swing.JButton btranssel;
    private javax.swing.JButton jBkembali;
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
    private javax.swing.JPanel jPanel1;
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
