package models;

import java.sql.ResultSet;

/**
 *
 * @author Kelompok urut 2
 */
public class Pelanggan {
    public ResultSet getPelangganData() {
        String query = "SELECT * FROM pelanggan";
        
        database.SQLConnection koneksi = new database.SQLConnection();
        
        return koneksi.doQuery(query);
    }
    
    public boolean addPelangganData(String kode, String nama, String alamat, boolean genderlaki) {
        String gender = "P";
        if(genderlaki){
            gender = "L";
        }
        String query = "INSERT INTO pelanggan VALUES (?, ?, ?, ?)";
        
        database.SQLConnection koneksi = new database.SQLConnection();
        
        boolean isSuccessInsert = koneksi.doPreparedUpdate(query,
            kode, nama, gender, alamat
        );
        
        return isSuccessInsert;
        
    }
    
    public boolean deletePelangganData(String kd_pelanggan){
        String query = "DELETE FROM pelanggan WHERE kd_pelanggan = ?";
        
        database.SQLConnection koneksi = new database.SQLConnection();
        
        boolean isSuccessDelete = koneksi.doPreparedUpdate(query,
            kd_pelanggan
        );
        
        return isSuccessDelete;
    }
}
