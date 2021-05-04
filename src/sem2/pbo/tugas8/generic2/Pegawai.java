package sem2.pbo.tugas8.generic2;

public class Pegawai {

    private String nama;
    private String noKTP;
    private String alamat;
    private double gaji;


    public Pegawai(String nama, String noKTP, String alamat, double gaji) {
        this.nama = nama;
        this.noKTP = noKTP;
        this.alamat = alamat;
        this.gaji = gaji;
    }

    public String getNama() {
        return nama;
    }

    public String getNoKTP() {
        return noKTP;
    }

    public String getAlamat() {
        return alamat;
    }

    public double getGaji() {
        return gaji;
    }

    @Override
    public String toString() {
        return "Nama: " + getNama() + "\n" +
                "No KTP: " + getNoKTP() + "\n" +
                "Alamat: " + getAlamat() + "\n" +
                "Gaji: " + getGaji() + "\n";
    }
}
