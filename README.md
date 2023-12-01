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
3. Ubah konfigurasi kredensial database di `src/database/Config.java` sesuai dengan database yang ada. Disarankan menggunakan `MySQL` yang umum nya satu bundle dengan `XAMPP`. Pastikan server database nya sudah berjalan.
4. Lakukan perubahan, namun disarankan untuk menggunakan IDE `Apache Netbeans` untuk mengubah dan testing kode sumber

Aplikasi ini menerapkan framework MVC, sehingga penataan file menjadi lebih sesuai peruntukannya. Berikut adalah penjelasan masing-masing direktori di dalam `src/`:

|Nama Direktori|Deskripsi|
|-|-|
|**assets**|Tempat untuk semua asset yang digunakan pada aplikasi seperti icon, gif, gambar, dll.|
|**controllers**|Tempat menyimpan file controller pada framework MVC.|
|**database**|Tempat untuk file terkait penyimpanan data dan koneksi dengan database SQL|
|**libraries**|Tempat untuk simpan library eksternal, seperti custom library, atau library lainnya yang tidak terdapat dalam Java SE.|
|**models**|Tempat menyimpan file model pada framework MVC.|
|**views**|Tempat menyimpan file view pada framework MVC.|

Disarankan juga untuk mengikuti konvensi penamaan file dan struktur kode sumber yang konsisten semasa tahap pengembangan.

### MVC Pattern

Aplikasi ini menggunakan custom library dengan nama `jframe-mvc` dengan nama package `jmvc.*`, Library ini berguna untuk keperluan aplikasi MVC JFrame seperti navigasi antar halaman `jmvc.Navigator`, dan utility untuk meng-generate file MVC `jmvc.MVCFactory`. Berikut cara untuk generate file MVC menggunakan library ini:

1. Buka terminal/console di tempat kode sumber ini
2. Jalankan perintah dibawah:
   ```
   java -cp ./build/classes jmvc.MVCFactory createMVC <Nama>
   ```
   variabel `<Nama>` bisa anda ganti dengan nama untuk generate file nya (selama huruf kapital di awal), seperti contoh: App, Login, Test, dan lainnya.
3. Jika berhasil, maka akan ada beberapa file baru di folder `src` seperti `src/controllers/<Nama>Controller.java`, `src/models/<Nama>.java`, dan `src/views/<Nama>Page.java`.
4. Perlu diingat bahwa jika Anda sebelum nya sudah membuat sebuah class JFrame di folder `views`, jangan sampai nama file nya bersamaan dengan nama file MVC yang akan di generate, karena akan ada kemungkinan Anda kehilangan progress GUI Anda di page tersebut.
