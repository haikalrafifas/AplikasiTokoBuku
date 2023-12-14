package controllers;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.JOptionPane;
import models.Home;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import views.HomePage;

/**
 *
 * @author Kelompok urut 2
 */
public class HomeController {
    public static HomeController controller;
    public static Home model;
    public static HomePage view;
    
    public void initialize() {
        String nama = model.getUserName();
        view.textWelcome.setText("Halo, " + nama + " !");
    }
    
    public void handleLaporan() {
        java.sql.ResultSet dataLaporan = model.getLaporan();
        File reportFile = new File(".");
        
        if ( dataLaporan == null ) {
            JOptionPane.showMessageDialog(null,
                "Gagal mencetak akibat kesalahan koneksi dengan database!\n",
                "Kesalahan Mencetak",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        try {
            String reportDir = reportFile.getCanonicalPath() + "/src/reports/";
            JasperDesign reportDesign = JRXmlLoader.load(reportDir + "penjualan.jrxml");

            JasperReport report = JasperCompileManager.compileReport(reportDesign);

            JRResultSetDataSource rsDataSource = new JRResultSetDataSource(dataLaporan);
            JasperPrint reportPrint = JasperFillManager.fillReport(report, new HashMap(), rsDataSource);
            
            JasperViewer reportView = new JasperViewer(reportPrint, false);
            
            reportView.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
            
            view.setVisible(true);
            reportView.setVisible(true);
        } catch ( IOException | JRException e ) {
            JOptionPane.showMessageDialog(null,
                "Gagal mencetak\n" + e,
                "Kesalahan Mencetak",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    public void handleLogout() {
        database.Session.setUserId(0);
        jmvc.Navigator.view("login");
        view.dispose();
    }
    
    public void goToPageBuku() {
        jmvc.Navigator.view("buku");
        view.dispose();
    }
    
    public void goToPagePelanggan() {
        jmvc.Navigator.view("pelanggan");
        view.dispose();
    }
    
    public void goToPageTransaksi() {
        jmvc.Navigator.view("transaksi");
        view.dispose();
    }
}
