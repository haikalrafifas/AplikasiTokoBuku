package database;

import java.sql.ResultSet;

/**
 *
 * @author Kelompok urut 2
 */
public class Session {
    private static int userId;
    private static boolean isValid = false;
    private static ResultSet appdata;
    
    private Session() {}
    
    public static int getUserId() {
        return userId;
    }
    
    public static void setUserId(int userId) {
        Session.userId = userId;
    }
    
    public static boolean getValidStatus() {
        return isValid;
    }
    
    public static void setValidStatus(boolean status) {
        Session.isValid = status;
    }
    
    public static ResultSet getAppdata() {
        return appdata;
    }
    
    public static void setAppdata(ResultSet data) {
        Session.appdata = data;
    }
}
