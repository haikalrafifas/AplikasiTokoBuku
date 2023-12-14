package models;

public class Transaksi {
    public boolean addCartData(java.util.HashMap c) {
        database.SQLConnection koneksi = new database.SQLConnection();
        java.sql.ResultSet result;
        String query = "";
        
        query = "SELECT stok FROM buku WHERE kd_buku = ?";
        result = koneksi.doPreparedQuery(query, c.get("kd_buku"));
        
        try {
            if ( result.next() ) {
                if ( result.getInt("stok") < Integer.parseInt(c.get("jumlah").toString()) ) {
                    return false;
                }
            }
        } catch (Exception e) {}
        
        query = "INSERT INTO penjualan VALUES (?, ?, ?, ?, ?, ?)";
        
        boolean isSuccessInsert = koneksi.doPreparedUpdate(query,
            c.get("kd_pretransaksi"),
            c.get("kd_transaksi"),
            c.get("kd_pelanggan"),
            c.get("kd_buku"),
            Integer.parseInt(c.get("jumlah").toString()),
            Integer.parseInt(c.get("sub_total").toString())
        );
        
        return isSuccessInsert;
    }

    public boolean deleteCartData(String kd_transaksi) {
        String query = "DELETE FROM penjualan WHERE kd_transaksi = ?";
        
        database.SQLConnection koneksi = new database.SQLConnection();
        
        boolean isSuccessDelete = koneksi.doPreparedUpdate(query, kd_transaksi);
        
        return isSuccessDelete;
    }
    
    public java.sql.ResultSet getAllCartDataByTrxId(String kd_transaksi, String kd_pelanggan) {
        String query = "SELECT c.kd_pretransaksi as kd_pretransaksi, " +
                "c.kd_transaksi as kd_transaksi, p.nama_pelanggan as nama_pelanggan, " +
                "c.jumlah as jumlah, c.sub_total as sub_total FROM penjualan c JOIN " +
                "pelanggan p ON c.kd_pelanggan = p.kd_pelanggan WHERE c.kd_transaksi = ? " +
                "AND c.kd_pelanggan = ?";
        
        database.SQLConnection koneksi = new database.SQLConnection();
        
        return koneksi.doPreparedQuery(query, kd_transaksi, kd_pelanggan);
    }
    
    public String getLatestOrderId() {
        String orderId = "PS0000";
        
        String query = "SELECT kd_pretransaksi FROM penjualan ORDER BY kd_pretransaksi DESC";
        database.SQLConnection koneksi = new database.SQLConnection();
        java.sql.ResultSet result = koneksi.doQuery(query);
        
        try {
            if (result.next()) {
                orderId = result.getString("kd_pretransaksi");
            }
        } catch (Exception e) {}
        
        return orderId;
    }
    
    public String getLatestTrxId() {
        String trxId = "TR0000";
        
        String query = "SELECT kd_transaksi FROM laporan ORDER BY kd_transaksi DESC";
        database.SQLConnection koneksi = new database.SQLConnection();
        java.sql.ResultSet result = koneksi.doQuery(query);
        
        try {
            if (result.next()) {
                trxId = result.getString("kd_transaksi");
            }
        } catch (Exception e) {}
        
        return trxId;
    }
    
    public java.sql.ResultSet getCheckoutData(String kd_transaksi, String kd_pelanggan) {
        String query = "";
        database.SQLConnection koneksi = new database.SQLConnection();
        java.sql.ResultSet result;
        
        query = "SELECT SUM(c.jumlah) as jumlah, SUM(c.sub_total) as total, c.kd_transaksi as kd_transaksi, " +
                " c.kd_pelanggan as kd_pelanggan, c.jumlah as jumlah, p.nama_pelanggan as nama_pelanggan FROM " +
                "penjualan c JOIN pelanggan p ON c.kd_pelanggan = p.kd_pelanggan WHERE c.kd_transaksi = ?" +
                "AND c.kd_pelanggan = ?";
        result = koneksi.doPreparedQuery(query, kd_transaksi, kd_pelanggan);
        
        try {
            if ( result.next() ) {
                return result;
            }
        } catch (Exception e) {}
        
        return null;
    }
    
    public boolean addTransactionData(java.util.HashMap c) {
        database.SQLConnection koneksi = new database.SQLConnection();
        java.sql.ResultSet result;
        String query = "INSERT INTO laporan VALUES (?, ?, ?, ?, ?)";
        
        boolean isSuccessInsert = koneksi.doPreparedUpdate(query,
            c.get("kd_transaksi"),
            c.get("kd_pelanggan"),
            c.get("kd_buku"),
            Integer.parseInt(c.get("jumlah_summed").toString()),
            Integer.parseInt(c.get("total").toString())
        );
        
        return isSuccessInsert;
    }
    
    public boolean updateStockAfterDoneTransaction(java.util.HashMap c) {
        String query = "UPDATE buku SET stok = stok - ? WHERE kd_buku = ?";
        database.SQLConnection koneksi = new database.SQLConnection();
        
        boolean isSuccessUpdate = koneksi.doPreparedUpdate(
                query, Integer.parseInt(c.get("jumlah_summed").toString()), c.get("kd_buku")
        );
        
        return isSuccessUpdate;
    }
}
