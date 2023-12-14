package models;

/**
 *
 * @author Kelompok urut 2
 */
public class Home {
    public String getUserName() {
        String query = "SELECT nama FROM login WHERE id = ?";
        
        database.SQLConnection koneksi = new database.SQLConnection();
        java.sql.ResultSet result = koneksi.doPreparedQuery(query, database.Session.getUserId());
        
        try {
            if ( result.next() ) {
                return result.getString("nama");
            }
        } catch ( java.sql.SQLException e ) {
            System.err.println(e);
        }

        return "PANJUL";
    }
    
    public java.sql.ResultSet getLaporan(){
        String query = "SELECT * FROM view_laporan";
        
        try {
            database.SQLConnection koneksi = new database.SQLConnection();
            java.sql.ResultSet result = koneksi.doQuery(query);
            if ( result.next() ){
                result.beforeFirst();
                return result;
            }
        } catch ( java.sql.SQLException | NullPointerException e ){
            return null;
        }
        return null;
    }
}
