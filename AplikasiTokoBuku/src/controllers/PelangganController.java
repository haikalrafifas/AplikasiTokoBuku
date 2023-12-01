package controllers;

import models.Pelanggan;
import views.PelangganPage;

/**
 *
 * @author Kelompok urut 2
 */
public class PelangganController {
    private Pelanggan model;
    private PelangganPage view;
    
    public PelangganController() {
        this.model = new Pelanggan();
    }
    
    public void setView(PelangganPage view) {
        this.view = view;
        view.setVisible(true);
    }
    
    public java.sql.ResultSet getPelangganData() {
        return model.getPelangganData();
    }
}
