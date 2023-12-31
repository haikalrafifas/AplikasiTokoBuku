package views;

/**
 *
 * @author Kelompok urutan 2
 */
public class HomePage extends javax.swing.JFrame {
    private controllers.HomeController controller = controllers.HomeController.controller;
    
    public HomePage() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        textWelcome = new javax.swing.JLabel();
        buttonTransaksi = new javax.swing.JButton();
        buttonBuku = new javax.swing.JButton();
        buttonLaporan = new javax.swing.JButton();
        buttonPelanggan = new javax.swing.JButton();
        buttonLogout = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        textWelcome.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        textWelcome.setForeground(new java.awt.Color(153, 51, 255));
        textWelcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textWelcome.setText("Halo, Nama !");
        textWelcome.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        buttonTransaksi.setBackground(new java.awt.Color(252, 252, 252));
        buttonTransaksi.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        buttonTransaksi.setForeground(new java.awt.Color(153, 204, 255));
        buttonTransaksi.setText("Transaksi");
        buttonTransaksi.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        buttonTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTransaksiActionPerformed(evt);
            }
        });

        buttonBuku.setBackground(new java.awt.Color(252, 252, 252));
        buttonBuku.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        buttonBuku.setForeground(new java.awt.Color(153, 204, 255));
        buttonBuku.setText("Data Buku");
        buttonBuku.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 102), 1, true));
        buttonBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBukuActionPerformed(evt);
            }
        });

        buttonLaporan.setBackground(new java.awt.Color(252, 252, 252));
        buttonLaporan.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        buttonLaporan.setForeground(new java.awt.Color(153, 204, 255));
        buttonLaporan.setText("Laporan Penjualan Buku");
        buttonLaporan.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 102), 1, true));
        buttonLaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLaporanActionPerformed(evt);
            }
        });

        buttonPelanggan.setBackground(new java.awt.Color(252, 252, 252));
        buttonPelanggan.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        buttonPelanggan.setForeground(new java.awt.Color(153, 204, 255));
        buttonPelanggan.setText("Pelanggan");
        buttonPelanggan.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 102), 1, true));
        buttonPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPelangganActionPerformed(evt);
            }
        });

        buttonLogout.setBackground(new java.awt.Color(252, 252, 252));
        buttonLogout.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        buttonLogout.setText("Log Out");
        buttonLogout.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 102), 1, true));
        buttonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLogoutActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/default-avatar.png"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(153, 51, 255));
        jPanel2.setForeground(new java.awt.Color(153, 51, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 81, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(115, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(buttonLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(buttonBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(94, 94, 94)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonLaporan, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(121, 121, 121))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(textWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(textWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonPelanggan, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                    .addComponent(buttonLaporan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(51, 51, 51)
                .addComponent(buttonLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBukuActionPerformed
        controller.goToPageBuku();
    }//GEN-LAST:event_buttonBukuActionPerformed

    private void buttonPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPelangganActionPerformed
        controller.goToPagePelanggan();
    }//GEN-LAST:event_buttonPelangganActionPerformed

    private void buttonTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTransaksiActionPerformed
        controller.goToPageTransaksi();
    }//GEN-LAST:event_buttonTransaksiActionPerformed

    private void buttonLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLogoutActionPerformed
        controller.handleLogout();
    }//GEN-LAST:event_buttonLogoutActionPerformed

    private void buttonLaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLaporanActionPerformed
        controller.handleLaporan();
    }//GEN-LAST:event_buttonLaporanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBuku;
    private javax.swing.JButton buttonLaporan;
    private javax.swing.JButton buttonLogout;
    private javax.swing.JButton buttonPelanggan;
    private javax.swing.JButton buttonTransaksi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JLabel textWelcome;
    // End of variables declaration//GEN-END:variables
}
