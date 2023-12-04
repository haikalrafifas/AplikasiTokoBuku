-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 04 Des 2023 pada 06.27
-- Versi server: 10.4.28-MariaDB
-- Versi PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_javabuku`
--
create database db_javabuku;
use db_javabuku;
-- --------------------------------------------------------

--
-- Struktur dari tabel `buku`
--

CREATE TABLE `buku` (
  `kd_buku` varchar(6) NOT NULL,
  `judul` varchar(50) NOT NULL,
  `jenis` varchar(50) NOT NULL,
  `penulis` varchar(50) NOT NULL,
  `penerbit` varchar(50) NOT NULL,
  `tahun` char(4) NOT NULL,
  `stok` int(4) NOT NULL,
  `harga_pokok` int(8) NOT NULL,
  `harga_jual` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `buku`
--

INSERT INTO `buku` (`kd_buku`, `judul`, `jenis`, `penulis`, `penerbit`, `tahun`, `stok`, `harga_pokok`, `harga_jual`) VALUES
('K0001', 'Dragon Ball', 'Komik', 'Akira Toriyama', 'Gramedia', '2006', 14, 40000, 60000),
('K0002', 'Naruto Shippuden', 'Komik', 'Masashi Kishimoto', 'Gunung Agung', '2000', 30, 50000, 70000),
('K0003', 'One Piece', 'Komik', 'Echiro Oda', 'Gramedia', '2001', 35, 45000, 60000),
('K0004', 'Spy X Family', 'Komik', 'Endo Tatsuya', 'T. Harapan', '2018', 26, 45000, 55000),
('K0005', 'Jojo’s Bizarre Adventure', 'Komik', 'Hirohiko Araki', 'Flyer', '1999', 23, 70000, 90000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `distributor`
--

CREATE TABLE `distributor` (
  `kd_distributor` varchar(6) NOT NULL,
  `nama_distributor` varchar(50) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `telepon` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `distributor`
--

INSERT INTO `distributor` (`kd_distributor`, `nama_distributor`, `alamat`, `telepon`) VALUES
('D0001', 'PT. Gramedia', 'Jalan Kaki menuju tak terbatas NO. 20 Jakarta Barat', '081234123456'),
('D0002', 'PT. Erlangga', 'Jalan Mangga Tiga No 12 Jakarta Selatan', '081234123455'),
('D0003', 'PT. Gunung Agung', 'JL. jalan yang jauh No. 23 Jakarta Pusat', '081234123454');

-- --------------------------------------------------------

--
-- Struktur dari tabel `laporan`
--

CREATE TABLE `laporan` (
  `kd_transaksi` varchar(8) NOT NULL,
  `kd_pelanggan` varchar(6) NOT NULL,
  `kd_buku` varchar(6) NOT NULL,
  `jumlah` int(4) NOT NULL,
  `total` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `laporan`
--

INSERT INTO `laporan` (`kd_transaksi`, `kd_pelanggan`, `kd_buku`, `jumlah`, `total`) VALUES
('TR0001', 'PL001', 'K0004', 2, 110000),
('TR0002', 'PL002', 'K0005', 1, 90000);

--
-- Trigger `laporan`
--
DELIMITER $$
CREATE TRIGGER `checkout` AFTER INSERT ON `laporan` FOR EACH ROW BEGIN
    DECLARE kd_transaksi_temp VARCHAR(8);
    
    SET kd_transaksi_temp = NEW.kd_transaksi;

    DELETE FROM penjualan WHERE kd_transaksi = kd_transaksi_temp;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `login`
--

CREATE TABLE `login` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--

INSERT INTO `login` (`id`, `username`, `password`, `nama`) VALUES
(1, 'admin1', 'admin1', 'Haikal');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pelanggan`
--

CREATE TABLE `pelanggan` (
  `kd_pelanggan` varchar(6) NOT NULL,
  `nama_pelanggan` varchar(50) NOT NULL,
  `jenis_kelamin` char(2) NOT NULL,
  `alamat` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `pelanggan`
--

INSERT INTO `pelanggan` (`kd_pelanggan`, `nama_pelanggan`, `jenis_kelamin`, `alamat`) VALUES
('PL001', 'Samuel Sihombing', 'L', 'Jalan Dukuh Depok'),
('PL002', 'Naufal Muhammad', 'L', 'Jalan Mangga Tangerang'),
('PL003', 'Kevin Rasendriya', 'L', 'Jalan jalan Bekasi'),
('PL004', 'Damar Nurfadhil', 'L', 'Jalan Sapi Jakarta utara');

-- --------------------------------------------------------

--
-- Struktur dari tabel `penjualan`
--

CREATE TABLE `penjualan` (
  `kd_pretransaksi` varchar(8) NOT NULL,
  `kd_transaksi` varchar(8) NOT NULL,
  `kd_pelanggan` varchar(6) NOT NULL,
  `kd_buku` varchar(6) NOT NULL,
  `jumlah` int(4) NOT NULL,
  `sub_total` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `penjualan`
--

INSERT INTO `penjualan` (`kd_pretransaksi`, `kd_transaksi`, `kd_pelanggan`, `kd_buku`, `jumlah`, `sub_total`) VALUES
('PS0001', 'TR0001', 'PL001', 'K0004', 2, 110000),
('PS0002', 'TR0001', 'PL001', 'K0004', 4, 220000),
('PS0003', 'TR0001', 'PL001', 'K0003', 2, 120000),
('PS0004', 'TR0002', 'PL002', 'K0005', 1, 90000);

--
-- Trigger `penjualan`
--
DELIMITER $$
CREATE TRIGGER `update_stok` AFTER INSERT ON `penjualan` FOR EACH ROW BEGIN
    DECLARE id_buku_temp VARCHAR(6);
DECLARE jumlah_beli_temp INT;
   
SELECT kd_buku, jumlah INTO id_buku_temp, jumlah_beli_temp
FROM penjualan
WHERE kd_pretransaksi = NEW.kd_pretransaksi;
    
UPDATE buku
SET stok = stok - jumlah_beli_temp
WHERE kd_buku = id_buku_temp;

END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `view_laporan`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `view_laporan` (
`kd_transaksi` varchar(8)
,`nama_pelanggan` varchar(50)
,`judul` varchar(50)
,`jumlah` int(4)
,`total` int(8)
);

-- --------------------------------------------------------

--
-- Struktur untuk view `view_laporan`
--
DROP TABLE IF EXISTS `view_laporan`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_laporan`  AS SELECT `l`.`kd_transaksi` AS `kd_transaksi`, `p`.`nama_pelanggan` AS `nama_pelanggan`, `b`.`judul` AS `judul`, `l`.`jumlah` AS `jumlah`, `l`.`total` AS `total` FROM ((`laporan` `l` join `pelanggan` `p` on(`l`.`kd_pelanggan` = `p`.`kd_pelanggan`)) join `buku` `b` on(`l`.`kd_buku` = `b`.`kd_buku`)) ;

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `buku`
--
ALTER TABLE `buku`
  ADD PRIMARY KEY (`kd_buku`);

--
-- Indeks untuk tabel `distributor`
--
ALTER TABLE `distributor`
  ADD PRIMARY KEY (`kd_distributor`);

--
-- Indeks untuk tabel `laporan`
--
ALTER TABLE `laporan`
  ADD PRIMARY KEY (`kd_transaksi`),
  ADD KEY `kd_pelanggan` (`kd_pelanggan`),
  ADD KEY `kd_buku` (`kd_buku`);

--
-- Indeks untuk tabel `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`kd_pelanggan`);

--
-- Indeks untuk tabel `penjualan`
--
ALTER TABLE `penjualan`
  ADD PRIMARY KEY (`kd_pretransaksi`),
  ADD KEY `kd_pelanggan` (`kd_pelanggan`),
  ADD KEY `kd_transaksi` (`kd_transaksi`),
  ADD KEY `kd_buku` (`kd_buku`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `login`
--
ALTER TABLE `login`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `laporan`
--
ALTER TABLE `laporan`
  ADD CONSTRAINT `laporan_ibfk_1` FOREIGN KEY (`kd_pelanggan`) REFERENCES `pelanggan` (`kd_pelanggan`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `laporan_ibfk_2` FOREIGN KEY (`kd_buku`) REFERENCES `buku` (`kd_buku`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Ketidakleluasaan untuk tabel `penjualan`
--
ALTER TABLE `penjualan`
  ADD CONSTRAINT `penjualan_ibfk_1` FOREIGN KEY (`kd_buku`) REFERENCES `buku` (`kd_buku`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `penjualan_ibfk_2` FOREIGN KEY (`kd_pelanggan`) REFERENCES `pelanggan` (`kd_pelanggan`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
