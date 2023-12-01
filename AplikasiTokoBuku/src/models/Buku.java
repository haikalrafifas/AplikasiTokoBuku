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
    
    public ResultSet getBookData() {
        
        String query = "SELECT * FROM buku";
        
        database.SQLConnection koneksi = new database.SQLConnection();
        
        return koneksi.doQuery(query);
        
    }
}
