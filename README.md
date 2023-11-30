# Aplikasi Toko Buku
---

Sebuah aplikasi GUI toko buku berbasis Java. Aplikasi ini menggunakan module Swing untuk tampilan GUI, dan database MySQL untuk menyimpan data.

Aplikasi ini ditujukan untuk tugas akhir mata kuliah **Pemrograman Berorientasi Objek**.

<br><br>

# Untuk Kontributor
---

Cara untuk berkontribusi untuk aplikasi ini:

1. Hubungi repository owner/kontributor aktif agar diberi akses tulis
2. Buat branch tersendiri dengan nama selain main, development, dan feat/*
3. Lakukan perubahan, namun disarankan untuk menggunakan IDE `Apache Netbeans` untuk mengubah dan testing kode sumber

Aplikasi ini menerapkan framework MVC, sehingga penataan file menjadi lebih sesuai peruntukannya. Berikut adalah penjelasan masing-masing direktori di dalam `src/`:

|Nama Direktori|Deskripsi|
|-|-|
|**assets**|Tempat untuk semua asset yang digunakan pada aplikasi seperti icon, gif, gambar, dll.|
|**controllers**|Tempat menyimpan file controller pada framework MVC.|
|**database**|Tempat untuk file terkait penyimpanan data dan koneksi dengan database SQL|
|**libraries**|Tempat untuk simpan library lokal, seperti custom library, atau library lainnya yang tidak terdapat dalam Java SE.|
|**models**|Tempat menyimpan file model pada framework MVC.|
|**routes**|Tempat menyimpan aksi rute halaman. Untuk saat ini, hanya di simpan di satu file bernama `Navigator.java`. Silakan modifikasi sesuai kebutuhan.|
|**views**|Tempat menyimpan file view pada framework MVC. View berupa User Interface yang biasanya sudah di modifikasi oleh file controller, lalu di tampilkan ke pengguna.|

Disarankan juga untuk mengikuti konvensi penamaan file dan struktur kode sumber yang konsisten semasa tahap pengembangan.
