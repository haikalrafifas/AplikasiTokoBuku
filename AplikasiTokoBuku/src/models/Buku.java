package models;

import java.sql.ResultSet;

/**
 *
 * @author Samuel
 */
public class Buku {
    public boolean addBookData(String kode, String judul, String jenis, String penulis, String penerbit, String tahun, int stok, int hargaPokok, int hargaJual) {
        
        String query = "INSERT INTO buku VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        database.SQLConnection koneksi = new database.SQLConnection();
        
        boolean isSuccessInsert = koneksi.doPreparedUpdate(query,
            kode, judul, jenis, penulis, penerbit, tahun, stok, hargaPokok, hargaJual
        );
        
        return isSuccessInsert;
        
    }
    
    public static ResultSet getBookData() {
        
        String query = "SELECT * FROM buku";
        
        database.SQLConnection koneksi = new database.SQLConnection();
        
        return koneksi.doQuery(query);
        
    }
    
    public boolean deleteBookData(String kd_buku){
        String query = "DELETE FROM buku WHERE kd_buku = ?";
        
        database.SQLConnection koneksi = new database.SQLConnection();
        
        boolean isSuccessDelete = koneksi.doPreparedUpdate(query,
            kd_buku
        );
        
        return isSuccessDelete;
    }
    
    public boolean updateBookData(String kode, String judul, String jenis, String penulis, String penerbit, String tahun, int stok, int hargaPokok, int hargaJual) {
        
        String query = "UPDATE buku SET kd_buku = ?, judul = ? , jenis = ?, penulis = ?, penerbit = ?, tahun = ?, stok = ?, harga_pokok = ?, harga_jual = ? WHERE kd_buku = ?";
        
        database.SQLConnection koneksi = new database.SQLConnection();
        
        boolean isSuccessUpdate = koneksi.doPreparedUpdate(query,
            kode, judul, jenis, penulis, penerbit, tahun, stok, hargaPokok, hargaJual, kode
        );
        
        return isSuccessUpdate;
        
    }
    
    public ResultSet searchBookData(String s) {
        String query = "SELECT * FROM buku WHERE kd_buku LIKE %?% OR judul LIKE %?% OR penerbit LIKE %?% OR penulis LIKE %?% OR tahun %?% OR jenis LIKE %?%";
        
        database.SQLConnection koneksi = new database.SQLConnection();
        
        ResultSet hasilPencarian = koneksi.doPreparedQuery(query, s,s,s,s,s,s);
        
        return hasilPencarian;
    }
    
    public String getLatestId() {
        String id = "K0000";
        
        String query = "SELECT kd_buku FROM buku ORDER BY kd_buku DESC";
        database.SQLConnection koneksi = new database.SQLConnection();
        java.sql.ResultSet result = koneksi.doQuery(query);
        
        try {
            if (result.next()) {
                id = result.getString("kd_buku");
            }
        } catch (Exception e) {}
        
        return id;
    }
}