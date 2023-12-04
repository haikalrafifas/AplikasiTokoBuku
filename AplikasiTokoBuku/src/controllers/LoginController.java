
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
    String username = view.inputUsername.getText();
    char[] passwordChars = view.inputPassword.getPassword();
    String password = new String(passwordChars);

    String authenticationStatus = model.getUserAuthenticationStatus(username, password);

    if ("found".equals(authenticationStatus)) {
        jmvc.Navigator.view("home");
        view.setVisible(false);
    } else if ("notFound".equals(authenticationStatus)) {
        // javax.swing.JOptionPane.showMessageDialog(view, "AKUN TIDAK DITEMUKAN!");
        view.textLoginStatus.setText("AKUN TIDAK DITEMUKAN!");
    } else if ("connectionError".equals(authenticationStatus)) {
        view.textLoginStatus.setText("TERJADI KESALAHAN PADA KONEKSI DATABASE!");
    } else {
        view.textLoginStatus.setText("TERJADI KESALAHAN PADA APLIKASI!");
    }

    view.textLoginStatus.setVisible(true);
    view.inputUsername.setText("");
    view.inputPassword.setText("");
    view.inputUsername.requestFocus();
}
}
