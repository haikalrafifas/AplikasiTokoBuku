
package controllers;

import models.Login;
import views.LoginPage;

/**
 *
 * @author Kelompok urut 2
 */
public class LoginController {
    public static LoginController controller;
    public static Login model;
    public static LoginPage view;
    
    public void initialize() {
        if ( database.Session.getValidStatus() ) {
            view.textLoginStatus.setText("ANDA TELAH LOGOUT!");
            database.Session.setValidStatus(false);
        } else {
            view.textLoginStatus.setVisible(false);
        }
    }
    
    public void handleLogin() {
        String username = view.inputUsername.getText();
        char[] passwordChars = view.inputPassword.getPassword();
        String password = new String(passwordChars);

        String authenticationStatus = model.getUserAuthenticationStatus(username, password);
        switch ( authenticationStatus ) {
            case "found" -> { 
                jmvc.Navigator.view("home");
                view.dispose();
            }
            case "notFound" -> view.textLoginStatus.setText("AKUN TIDAK DITEMUKAN!");
            case "connectionError" -> view.textLoginStatus.setText("KESALAHAN PADA KONEKSI DATABASE!");
            default -> view.textLoginStatus.setText("TERJADI KESALAHAN PADA APLIKASI!");
        }

        view.textLoginStatus.setVisible(true);
        view.inputUsername.setText("");
        view.inputPassword.setText("");
        view.inputUsername.requestFocus();
    }
}
