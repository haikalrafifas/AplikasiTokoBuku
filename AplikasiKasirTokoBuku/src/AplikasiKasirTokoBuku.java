

/**
 *
 * @author Kelompok urutan 2
 */
public class AplikasiKasirTokoBuku {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        database.MySQL koneksi = new database.MySQL();
//        java.sql.ResultSet result;
//        String query;
//        
//        query = "SELECT * FROM pelanggan";
//        result = koneksi.doQuery(query);
//
//        try {
//            while ( result.next() ) {
//                System.out.println(
//                result.getString("nama")
//                );
//            }
//        } catch ( java.sql.SQLException e ) {
//            System.out.println(e);
//        }
//        
//        String username = "a";
//        String password = "ax";
//        query = "SELECT COUNT(*) FROM user WHERE username = ? AND password = ?";
//        result = koneksi.doPreparedQuery(query, username, password);
//        
//        try {
//            System.out.println(result);
//            if ( result.next() ) {
//                System.out.println("FOUND");
//            } else {
//                System.out.println("NOT");
//            }
//        } catch ( java.sql.SQLException e ) {
//            System.out.println(e);
//        }
        
//        koneksi.closeConnection();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new views.LoginPage().setVisible(true);
            }
        });
    }
}
