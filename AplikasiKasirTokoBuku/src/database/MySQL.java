package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.QueryResult;

public class MySQL {
    protected static Connection koneksi;
    private static Statement stmt;
    private static ResultSet result;
    
    public MySQL() {
        Config c = new Config();
        try {
            koneksi = DriverManager.getConnection("jdbc:"+c.DB_DRIVER_NAME+"://"+c.DB_HOST+":"+c.DB_PORT+"/"+c.DB_NAME, c.DB_USER, c.DB_PASS);
        } catch ( SQLException e ) {
            System.out.println(e);
        }
    }
    
    public static Connection getConnection() {
        try {
            Class.forName(new Config().DB_DRIVER_LIB);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        return koneksi;
    }
    
    public static ResultSet doQuery(String query) {
        try {
            Connection connection = getConnection();
            
            stmt = connection.createStatement();
            
            result = stmt.executeQuery(query);
            
            return result;
        } catch ( SQLException e ) {
            System.out.println(e);
        }
        return null;
    }
    
    public static ResultSet doPreparedQuery(String query, Object... parameters) {
        try {
            Connection connection = getConnection();
            PreparedStatement pstmt = null;
            
            pstmt = connection.prepareStatement(query);
            for (int i = 0; i < parameters.length; i++) {
                pstmt.setObject(i + 1, parameters[i]);
            }

            result = pstmt.executeQuery();

            return result;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    public static void closeConnection() {
        try {
            result.close();
            stmt.close();
            koneksi.close();
        } catch ( SQLException e ) {
            System.out.println(e);
        }
    }
}
