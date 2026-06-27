# Student Swing Game - Tic Tac Toe Java Swing dengan MySQL

## Informasi Mahasiswa

**Nama:** Muhammad Farhan Firdaus

**NRP:** 5026251211

**Kelas:** E

---

# Deskripsi Project

Student Swing Game merupakan aplikasi permainan Tic Tac Toe berbasis desktop yang dibuat menggunakan Java Swing dengan database MySQL.

Aplikasi ini memiliki fitur login dan register sehingga setiap pemain memiliki akun masing-masing. Setelah berhasil login, pemain dapat memainkan Tic Tac Toe melawan bot (komputer). Setiap permainan yang selesai akan memperbarui statistik pemain secara otomatis ke dalam database, meliputi jumlah kemenangan, kekalahan, seri, dan total skor. Selain itu, aplikasi juga menyediakan fitur untuk melihat statistik pribadi serta peringkat Top 5 pemain dengan skor tertinggi.

---

# Fitur Aplikasi

- Login menggunakan database MySQL
- Register akun baru
- Bermain Tic Tac Toe melawan Bot
- Menentukan pemenang secara otomatis
- Menampilkan statistik pemain
- Menyimpan statistik ke database
- Menampilkan Top 5 pemain berdasarkan skor
- Logout dari aplikasi

---

# Database yang Digunakan

Database yang digunakan adalah **MySQL** dengan koneksi **JDBC**.

Nama Database:

```text
game_project
```

Nama Tabel:

```text
players
```

Struktur tabel:

- id
- username
- password
- wins
- losses
- draws
- score

---

# Cara Membuat Database

1. Jalankan MySQL melalui XAMPP atau Bitnami.
2. Buka phpMyAdmin.
3. Buat database baru dengan nama:

```sql
game_project
```

4. Import file berikut:

```text
database/schema.sql
```

5. Setelah berhasil di-import, akan terbentuk tabel **players** beserta data awal.

---

# Cara Menjalankan Program

1. Download atau clone repository ini.
2. Buka project menggunakan IntelliJ IDEA.
3. Tambahkan library MySQL Connector (JDBC Driver).
4. Pastikan MySQL sudah berjalan.
5. Sesuaikan konfigurasi database pada file:

```text
DatabaseManager.java
```

Contoh:

```java
private static final String URL =
"jdbc:mysql://localhost:3306/game_project";

private static final String USER = "root";

private static final String PASSWORD = "";
```

6. Jalankan file:

```text
Main.java
```

7. Login menggunakan akun yang sudah ada atau lakukan Register terlebih dahulu.

# Penjelasan Class

## Main.java

Merupakan titik awal (entry point) dari aplikasi yang menjalankan halaman Login.

## DatabaseManager.java

Berfungsi untuk membuat koneksi antara aplikasi Java dengan database MySQL menggunakan JDBC.

## Player.java

Merupakan class model yang menyimpan data pemain seperti:

- id
- username
- password
- wins
- losses
- draws
- score

## PlayerService.java

Berfungsi untuk seluruh proses yang berhubungan dengan database, seperti:

- Login akun
- Register akun
- Update statistik pemain
- Mengambil data Top 5 pemain

## GameLogic.java

Berisi seluruh logika permainan Tic Tac Toe, seperti:

- Membuat papan permainan
- Pergerakan pemain
- Pergerakan bot
- Mengecek pemenang
- Mengecek seri
- Reset permainan

## LoginFrame.java

Merupakan tampilan awal aplikasi yang digunakan untuk Login dan Register akun.

## MainMenuFrame.java

Merupakan halaman utama setelah login yang berisi menu:

- Play Game
- Statistics
- Top 5 Players
- Logout

## GameFrame.java

Merupakan tampilan permainan Tic Tac Toe. Class ini menampilkan papan permainan, menerima input pemain, menjalankan giliran bot, serta memperbarui statistik setelah permainan selesai.

## StatisticsFrame.java

Menampilkan statistik pemain yang sedang login, yaitu:

- Username
- Wins
- Losses
- Draws
- Score

## TopScorersFrame.java

Menampilkan 5 pemain dengan skor tertinggi yang diambil dari database.

# Screenshot Tampilan Aplikasi

## Login

![Login](screenshots/login.png)

## Main Menu

![Main Menu](screenshots/mainmenu.png)

## Halaman Permainan

![Game](screenshots/game.png)

## Statistik Pemain

![Statistik](screenshots/statistik.png)

## Top 5 Players

![Top Player](screenshots/topplayer.png)

# Repository GitHub

https://github.com/farhanfirdaus0712-bit/StudentSwingGame

# Link Video Demonstrasi YouTube

[https://youtube.com/ISI_LINK_VIDEO_KAMU](https://youtu.be/sIfQlDo7Vdk)
