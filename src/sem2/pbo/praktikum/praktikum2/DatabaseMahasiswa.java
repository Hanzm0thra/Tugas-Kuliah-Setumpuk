package sem2.pbo.praktikum.praktikum2;

public class DatabaseMahasiswa {
    private String nama;
    private String nim;
    private String alamat;
    private String prodi;
    private int nilaiAkhir;

    public static final int KKM = 80;
    public static int size = 0;

    DatabaseMahasiswa() {
        size++;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNim() {
        return nim;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
    }

    public String getProdi() {
        return prodi;
    }

    public void setNilaiAkhir(int nilaiAkhir) {
        this.nilaiAkhir = nilaiAkhir;
    }

    public int getNilaiAkhir() {
        return nilaiAkhir;
    }
}
