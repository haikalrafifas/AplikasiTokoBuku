package models;

import com.mysql.cj.protocol.Resultset;

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
            System.out.println(e);
        }

        return "PANJUL";
    }
    
    public Resultset getLaporan(){
        String query = "SELECT * FROM view_laporan";
        database.SQLConnection koneksi = new database.SQLConnection();
        java.sql.ResultSet result = koneksi.doQuery(query);
        try {
            if(result.next()){
                return (Resultset) result;
            }
        }catch (java.sql.SQLException e){
            System.out.println(e);
        }
        return null;
    }
}
