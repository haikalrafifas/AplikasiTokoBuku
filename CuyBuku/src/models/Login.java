package models;

/**
 *
 * @author Kelompok urut 2
 */
public class Login {
    public String getUserAuthenticationStatus(String username, String password) {
        String query = "SELECT id FROM login WHERE username = ? AND password = ?";
        
        try {
            database.SQLConnection koneksi = new database.SQLConnection();
            java.sql.ResultSet result = koneksi.doPreparedQuery(query, username, password);
            
            if ( result.next() ) {
                database.Session.setUserId(result.getInt("id"));
                database.Session.setValidStatus(true);
                return "found";
            } else {
                return "notFound";
            }
        } catch ( java.sql.SQLException | NullPointerException e ) {
            return "connectionError";
        }
    }
}
