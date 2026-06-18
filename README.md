# 📚 Sistem Informasi Sekolah

Aplikasi desktop berbasis **JavaFX** dan **MySQL** untuk membantu pengelolaan data sekolah. Sistem ini menyediakan fitur **Absensi Siswa** dan **Jadwal Pelajaran** dengan operasi CRUD (Create, Read, Update, Delete).

---

## ✨ Fitur Utama

### 📋 Manajemen Absensi
- Menambah data absensi siswa
- Menampilkan data absensi
- Mengubah data absensi
- Menghapus data absensi
- Status absensi:
  - Hadir
  - Izin
  - Sakit
  - Alpha

### 📚 Manajemen Jadwal Pelajaran
- Menambah jadwal pelajaran
- Menampilkan jadwal pelajaran
- Mengubah jadwal pelajaran
- Menghapus jadwal pelajaran
- Menampilkan data dalam bentuk tabel

### 🎨 User Interface
- Dibangun menggunakan JavaFX
- Desain modern dengan tema biru muda
- Responsive TableView
- Form input yang mudah digunakan

---

## 🛠️ Teknologi yang Digunakan

| Teknologi | Keterangan |
|------------|------------|
| Java 17 | Bahasa Pemrograman |
| JavaFX 17 | GUI Framework |
| MySQL | Database |
| JDBC | Koneksi Database |
| VS Code | IDE |
| Scene Builder (Opsional) | Desain FXML |

---

## 📁 Struktur Project

```text
SistemSekolah/
│
├── src/
│   ├── controller/
│   │   ├── AbsensiController.java
│   │   └── JadwalController.java
│   │
│   ├── dao/
│   │   ├── AbsensiDAO.java
│   │   └── JadwalDAO.java
│   │
│   ├── model/
│   │   ├── Absensi.java
│   │   └── Jadwal.java
│   │
│   ├── util/
│   │   └── DatabaseConnection.java
│   │
│   ├── view/
│   │   ├── absensi.fxml
│   │   ├── jadwal.fxml
│   │   └── style.css
│   │
│   └── Main.java
│
├── lib/
│   ├── mysql-connector-j.jar
│   └── javafx-sdk/
│
└── README.md
```

---

## 🗄️ Database

### Tabel Absensi

```sql
CREATE TABLE absensi (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nis VARCHAR(20),
    nama_siswa VARCHAR(100),
    tanggal DATE,
    status VARCHAR(20)
);
```

### Tabel Jadwal

```sql
CREATE TABLE jadwal (
    id INT AUTO_INCREMENT PRIMARY KEY,
    hari VARCHAR(20),
    jam VARCHAR(20),
    mapel VARCHAR(100),
    guru VARCHAR(100)
);
```

---

## ⚙️ Konfigurasi Database

Buka file:

```java
DatabaseConnection.java
```

Sesuaikan konfigurasi berikut:

```java
private static final String URL =
        "jdbc:mysql://localhost:3306/sistem_sekolah";

private static final String USER = "root";

private static final String PASSWORD = "";
```

---

## ▶️ Cara Menjalankan Project

### 1. Clone Repository

```bash
git clone https://github.com/username/sistem-sekolah.git
```

### 2. Import Project ke VS Code

Buka folder project menggunakan VS Code.

### 3. Tambahkan Dependency

- JavaFX SDK 17
- MySQL Connector/J

Tambahkan ke Referenced Libraries.

### 4. Jalankan Database MySQL

Pastikan XAMPP/MySQL Service aktif.

### 5. Jalankan Main.java

```java
public static void main(String[] args) {
    launch(args);
}
```

---

## 📸 Tampilan Aplikasi

### Absensi Siswa

- Input data siswa
- Status absensi
- CRUD data absensi
- TableView data siswa

### Jadwal Pelajaran

- Input jadwal
- CRUD jadwal
- TableView jadwal pelajaran

---

## 👨‍💻 Pengembang

**Muhammad Hisyam Syarif**

- Information Systems Student
- Java Developer Enthusiast
- System Analyst Enthusiast

---

## 📄 Lisensi

Project ini dibuat untuk keperluan pembelajaran dan tugas akademik.