package models;

import java.sql.ResultSet;

/**
 *
 * @author Kelompok urut 2
 */
public class Pelanggan {
    public static ResultSet getPelangganData() {
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
    
    public boolean updatePelangganData(String kode, String nama, String jenis, String alamat) {
        
        String query = "UPDATE pelanggan SET kd_pelanggan = ?, nama_pelanggan = ? , jenis_kelamin = ?, alamat = ? WHERE kd_pelanggan = ?";
        
        database.SQLConnection koneksi = new database.SQLConnection();
        
        boolean isSuccessUpdate = koneksi.doPreparedUpdate(query,
            kode, nama, jenis, alamat, kode
        );
        
        return isSuccessUpdate;
    }
    
    public ResultSet searchPelangganData(String s) {
        String query = "SELECT * FROM pelanggan WHERE kd_pelanggan LIKE %?% OR nama_pelanggan LIKE %?% OR jenis_kelamin LIKE %?% OR alamat LIKE %?%";
        
        database.SQLConnection koneksi = new database.SQLConnection();
        
        ResultSet hasilPencarian = koneksi.doPreparedQuery(query, s,s,s,s, s);
        
        return hasilPencarian;
    }
    
    public String getLatestId() {
        String id = "PL000";
        
        String query = "SELECT kd_pelanggan FROM pelanggan ORDER BY kd_pelanggan DESC";
        database.SQLConnection koneksi = new database.SQLConnection();
        java.sql.ResultSet result = koneksi.doQuery(query);
        
        try {
            if (result.next()) {
                id = result.getString("kd_pelanggan");
            }
        } catch (Exception e) {}
        
        return id;
    }
}