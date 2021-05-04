package sem2.asd.uts.no1;

public class Karyawan {
    private String NIK;
    private String nama;
    private String alamat;
    private String jabatan;

    public Karyawan(String NIK, String nama, String alamat, String jabatan) {
        this.NIK = NIK;
        this.nama = nama;
        this.alamat = alamat;
        this.jabatan = jabatan;
    }

    public String getNIK() {
        return NIK;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getJabatan() {
        return jabatan;
    }
}
