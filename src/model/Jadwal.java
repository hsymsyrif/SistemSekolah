package model;

public class Jadwal {

    private int id;
    private String hari;
    private String jam;
    private String mapel;
    private String guru;

    public Jadwal() {

    }

    public Jadwal(int id, String hari, String jam,
                  String mapel, String guru) {
        this.id = id;
        this.hari = hari;
        this.jam = jam;
        this.mapel = mapel;
        this.guru = guru;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public String getMapel() {
        return mapel;
    }

    public void setMapel(String mapel) {
        this.mapel = mapel;
    }

    public String getGuru() {
        return guru;
    }

    public void setGuru(String guru) {
        this.guru = guru;
    }
}