package controllers;

import models.Home;
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
}
