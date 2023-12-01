package models;

import java.sql.ResultSet;

/**
 *
 * @author Kelompok urut 2
 */
public class Pelanggan {
    public ResultSet getPelangganData() {
        String query = "SELECT kd_pelanggan, nama_pelanggan, jenis_kelamin FROM pelanggan";
        
        database.SQLConnection koneksi = new database.SQLConnection();
        
        return koneksi.doQuery(query);
    }
}
