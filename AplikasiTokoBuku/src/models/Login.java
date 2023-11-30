package models;

/**
 *
 * @author Kelompok urut 2
 */
public class Login {
    public static boolean authenticateUser(String username, String password) {
        String query = "SELECT id FROM login WHERE username = ? AND password = ?";
        
        database.SQLConnection koneksi = new database.SQLConnection();
        java.sql.ResultSet result = koneksi.doPreparedQuery(query, username, password);
        
        try {
            if ( result.next() ) {
                database.Session.setUserId(result.getInt("id"));
                database.Session.setValidStatus(true);
                return true;
            }
        } catch ( java.sql.SQLException e ) {
            System.out.println(e);
        }

        return false;
    }
}
