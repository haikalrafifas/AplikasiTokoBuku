package views;

import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

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
        jScrollPane1 = new javax.swing.JScrollPane();
        javax.swing.JTable tablePelanggan = new javax.swing.JTable();

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

        tablePelanggan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String[] {
                "ID Pelanggan", "Nama", "Gender"
            })
        );
        String[] columns = {"kd_pelanggan", "nama_pelanggan", "jenis_kelamin"};

        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);

        try {
            while ( dataPelanggan.next() ) {
                String id = "" + dataPelanggan.getInt("kd_pelanggan");
                String nama = dataPelanggan.getString("nama_pelanggan");
                String gender = dataPelanggan.getString("jenis_kelamin");

                String[] data = { id, nama, gender };

                tableModel.addRow(data);
            }
        } catch ( java.sql.SQLException e ) {
            System.out.println(e);
        }

        tablePelanggan.setModel(tableModel);
        jScrollPane1.setViewportView(tablePelanggan);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonBackHome, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(464, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonBackHome, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(433, 433, 433))
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonBackHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBackHomeActionPerformed
        // TODO add your handling code here:
//        homePage.setVisible(true);
        routes.Navigator.showHomePage();
        this.setVisible(false);
    }//GEN-LAST:event_buttonBackHomeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBackHome;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
