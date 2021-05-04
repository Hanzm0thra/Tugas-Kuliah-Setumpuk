package sem2.pbo.praktikum.praktikum4;

public class Manusia {
    
    private String nama;
    private String NIK;
    private boolean jenisKelamin;
    private boolean menikah;

    public Manusia(String nama, String NIK, boolean jenisKelamin, boolean menikah) {
        this.nama = nama;
        this.NIK = NIK;
        this.jenisKelamin = jenisKelamin;
        this.menikah = menikah;
    }

    public String getNama() {
        return nama;
    }

    public String getNIK() {
        return NIK;
    }

    public String getJenisKelamin() {
        String convertJenisKelamin;
        if (jenisKelamin)
            convertJenisKelamin = "Laki - Laki";
        else
            convertJenisKelamin = "Perempuan";
        return convertJenisKelamin;
    }

    public String getMenikah() {
        String convertMenikah;
        if (menikah) {
            convertMenikah = "Sudah Menikah";
        } else{
            convertMenikah = "Belum Menikah";
        }
        return convertMenikah;
    }

    public double getTunjangan() {
        double tunjangan = 0;
        if (!menikah) {
            tunjangan = 15;
        } else {
            if (jenisKelamin) {
                tunjangan = 25;
            } else {
                tunjangan = 20;
            }
        }
        return tunjangan;
    }

    public double getPendapatan() {
        return getTunjangan();
    }

    @Override
    public String toString() {
        return "Nama: " + getNama()
                + "\nNIK: " + getNIK()
                + "\nJenis Kelamin: " + getJenisKelamin()
                + "\nStatus Pernikahan: " + getMenikah()
                + "\nPendapatan: " + getPendapatan() + "$"
                + "\nTunjangan: " + getTunjangan() + "$";
    }
}
