package routes;

import controllers.*;
import views.*;

/**
 *
 * @author Kelompok urut 2
 */
public class Navigator {
    public static void showLoginPage() {
        LoginController login = new LoginController();
        login.setView(new LoginPage(login));
    }
    
    public static void showHomePage() {
        HomeController home = new HomeController();
        home.setView(new HomePage(home));
    }
    
    public static void showPelangganPage() {
        PelangganController pelanggan = new PelangganController();
        pelanggan.setView(new PelangganPage(pelanggan));
    }
    
    public static void showBukuPage() {
        BukuController buku = new BukuController();
        buku.setView(new BukuPage(buku));
    }
}
