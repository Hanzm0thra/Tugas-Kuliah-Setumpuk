package sem2.pbo.praktikum.praktikum6;

public class Pegawai {
    private String nama;
    private String noKTP;

    public Pegawai(String nama, String noKTP) {
        this.nama = nama;
        this.noKTP = noKTP;
    }

    public String getNama() {
        return nama;
    }

    public String getNoKTP() {
        return noKTP;
    }

    @Override
    public String toString() {
        return "===============================\n" +
                "Nama            : " + getNama() + '\n' +
                "No KTP          : " + getNoKTP() + '\n';
    }

    public double gaji() {
        return 0;
    }
}
