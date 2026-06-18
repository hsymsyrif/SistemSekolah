package model;

import java.sql.Date;

public class Absensi {

    private int id;
    private String nis;
    private String namaSiswa;
    private Date tanggal;
    private String status;

    // Constructor kosong
    public Absensi() {

    }

    // Constructor lengkap
    public Absensi(int id, String nis, String namaSiswa,
                   Date tanggal, String status) {
        this.id = id;
        this.nis = nis;
        this.namaSiswa = namaSiswa;
        this.tanggal = tanggal;
        this.status = status;
    }

    // Getter dan Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public String getNamaSiswa() {
        return namaSiswa;
    }

    public void setNamaSiswa(String namaSiswa) {
        this.namaSiswa = namaSiswa;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}