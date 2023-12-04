package views;

import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Kelompok urut 2
 */
public class PelangganPage extends javax.swing.JFrame {
    
    private controllers.PelangganController pelangganController;
    private ResultSet dataPelanggan;

    /**
     * Creates new form AnggotaPage
     */
    public PelangganPage(controllers.PelangganController pelangganController) {
        this.pelangganController = pelangganController;
        
        dataPelanggan = pelangganController.getPelangganData();
        
//        database.SQLConnection koneksi = new database.SQLConnection();
//        String query = "SELECT id, nama, gender FROM pelanggan";
//        dataPelanggan = koneksi.doQuery(query);
        
        initComponents();
        
        BHapus.setEnabled(false);
        BUbah.setEnabled(false);
        generatedDataPelanggan();
        reset();
    }
    
    void reset(){
        BHapus.setEnabled(false);
        BUbah.setEnabled(false);
        TFKode.setText("");
        TFNama.setText("");
        TAalamat.setText("");
        RL.setSelected(false);
        RP.setSelected(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonBackHome = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TFKode = new javax.swing.JTextField();
        TFNama = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TAalamat = new javax.swing.JTextArea();
        RL = new javax.swing.JRadioButton();
        RP = new javax.swing.JRadioButton();
        BTambah = new javax.swing.JButton();
        BHapus = new javax.swing.JButton();
        BUbah = new javax.swing.JButton();
        BReset = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        TPelanggan = new javax.swing.JTable();
        TFSearch = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 500));

        buttonBackHome.setText("Kembali");
        buttonBackHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBackHomeActionPerformed(evt);
            }
        });

        jLabel1.setText("Kode Pelanggan");

        jLabel2.setText("Nama");

        jLabel3.setText("Jenis Kelamin");

        jLabel4.setText("Alamat");

        TFKode.setText("jTextField1");

        TFNama.setText("jTextField2");

        TAalamat.setColumns(20);
        TAalamat.setRows(5);
        jScrollPane2.setViewportView(TAalamat);

        RL.setText("Laki-Laki");

        RP.setText("Perempuan");

        BTambah.setText("Tambah");
        BTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTambahActionPerformed(evt);
            }
        });

        BHapus.setText("Hapus");
        BHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BHapusActionPerformed(evt);
            }
        });

        BUbah.setText("Ubah");
        BUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUbahActionPerformed(evt);
            }
        });

        BReset.setText("Reset");
        BReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BResetActionPerformed(evt);
            }
        });

        TPelanggan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Kode Pelanggan", "Nama", "Jenis Kelamin", "Alamat"
            }
        ));
        TPelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TPelangganMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TPelanggan);

        TFSearch.setText("jTextField1");
        TFSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TFSearchKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TFNama, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TFKode, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(RL)
                        .addGap(18, 18, 18)
                        .addComponent(RP)))
                .addGap(538, 538, 538))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonBackHome, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(143, 143, 143)
                .addComponent(TFSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(273, 273, 273)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BUbah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BReset))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BTambah)
                        .addGap(79, 79, 79)
                        .addComponent(BHapus)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 175, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonBackHome, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TFSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(TFKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(TFNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(RL)
                            .addComponent(RP))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BTambah)
                            .addComponent(BHapus))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BUbah)
                            .addComponent(BReset))
                        .addGap(98, 98, 98))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void generatedDataPelanggan(){
    String[] columns = {"Kode Pelanggan", "Nama", "Jenis Kelamin", "Alamat"};

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

    TPelanggan.setModel(tableModel);
    }
    
    private void buttonBackHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBackHomeActionPerformed
        // TODO add your handling code here:
//        homePage.setVisible(true);
        jmvc.Navigator.view("home");
        this.setVisible(false);
    }//GEN-LAST:event_buttonBackHomeActionPerformed

    private void BResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BResetActionPerformed
        // TODO add your handling code here:
        BTambah.setEnabled(true);
        reset();
    }//GEN-LAST:event_BResetActionPerformed

    private void BTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTambahActionPerformed
        // TODO add your handling code here:
        pelangganController.handleAddData();
        jmvc.Navigator.view("pelanggan");
        this.setVisible(false);
    }//GEN-LAST:event_BTambahActionPerformed

    private void BHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BHapusActionPerformed
        // TODO add your handling code here:
        pelangganController.handleDeleteData(TFKode.getText());
    }//GEN-LAST:event_BHapusActionPerformed

    private void BUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUbahActionPerformed
        // TODO add your handling code here:
        if ( pelangganController.handleUpdateData(TFKode.getText()) ) {
            jmvc.Navigator.view("pelanggan");
        }
    }//GEN-LAST:event_BUbahActionPerformed

    private void TPelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TPelangganMouseClicked
        // TODO add your handling code here:
        BTambah.setEnabled(false);
        BHapus.setEnabled(true);
        BUbah.setEnabled(true);
        int i = TPelanggan.getSelectedRow();
        TableModel model = TPelanggan.getModel();
        TFKode.setText(model.getValueAt(i, 0).toString());
        TFNama.setText(model.getValueAt(i, 1).toString());
        TAalamat.setText(model.getValueAt(i, 3).toString());
        String sex = model.getValueAt(i, 2).toString();
            if(sex.equals("L")){
                RL.setSelected(true);
            }else{
                RP.setSelected(true);
            }
    }//GEN-LAST:event_TPelangganMouseClicked

    private void TFSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFSearchKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER){
            String s = TFSearch.getText();
            
            pelangganController.handleSearchData(s);
        }
    }//GEN-LAST:event_TFSearchKeyPressed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BHapus;
    private javax.swing.JButton BReset;
    private javax.swing.JButton BTambah;
    private javax.swing.JButton BUbah;
    public javax.swing.JRadioButton RL;
    public javax.swing.JRadioButton RP;
    public javax.swing.JTextArea TAalamat;
    public javax.swing.JTextField TFKode;
    public javax.swing.JTextField TFNama;
    private javax.swing.JTextField TFSearch;
    public javax.swing.JTable TPelanggan;
    private javax.swing.JButton buttonBackHome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
