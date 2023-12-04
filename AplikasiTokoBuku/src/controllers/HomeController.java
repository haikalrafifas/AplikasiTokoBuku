package controllers;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.JOptionPane;
import models.Home;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import views.HomePage;

/**
 *
 * @author Kelompok urut 2
 */
public class HomeController {
    private Home model;
    private HomePage view;
    
    public HomeController() {
        this.model = new Home();
    }
    
    public void setView(HomePage view) {
        this.view = view;
        view.setVisible(true);
    }
    
    public String getUserName() {
        return model.getUserName();
    }
public void handleLaporan() throws JRException {
        java.sql.ResultSet dataLaporan = (java.sql.ResultSet) model.getLaporan();
        File reportFile = new File(".");
        
        try {
            String dirr = reportFile.getCanonicalPath() + "/src/report/";
            JasperDesign design = JRXmlLoader.load(dirr + "report1.jrxml");
            
            JasperReport jr = JasperCompileManager.compileReport(design);
            
            JRResultSetDataSource rsDataSource = new JRResultSetDataSource(dataLaporan);
            JasperPrint jp = JasperFillManager.fillReport(jr, new HashMap(), rsDataSource);
            System.out.println("hadhaf");
            JasperViewer.viewReport(jp);
            } catch (IOException | JRException ex) {
    JOptionPane.showMessageDialog(null, "\ngagal mencetak\n" + ex, "Kesalahan", JOptionPane.ERROR_MESSAGE);
}}}
