
package controllers;

import models.Login;
import views.LoginPage;

/**
 *
 * @author Kelompok urut 2
 */
public class LoginController {
    private Login model;
    private LoginPage view;
    
    public LoginController() {
        this.model = new Login();
    }
    
    public void setView(LoginPage view) {
        this.view = view;
        view.setVisible(true);
    }
    
    public void handleLogin() {
        view.textLoginStatus.setVisible(true);
        
        String username = view.inputUsername.getText();
        char[] passwordChars = view.inputPassword.getPassword();
        String password = new String(passwordChars);
        
        if ( model.authenticateUser(username, password) ) {
            routes.Navigator.showHomePage();
            view.setVisible(false);
        } else {
//            javax.swing.JOptionPane.showMessageDialog(this, "AKUN TIDAK DITEMUKAN!");
            view.textLoginStatus.setText("AKUN TIDAK DITEMUKAN!");
            view.inputUsername.setText("");
            view.inputPassword.setText("");
            view.inputUsername.requestFocus();
        }
    }
}
