package sem2.pbo.tugas5;

public abstract class Karyawan {

    private String id;
    private String nama;
    private String alamat;

    Karyawan(String id, String nama, String alamat) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
    }

    public abstract double perhitunganGaji();

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getId() {
        return id;
    }
}
