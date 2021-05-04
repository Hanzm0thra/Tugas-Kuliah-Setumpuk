package sem2.pbo.praktikum.praktikum4;

public class Mahasiswa extends Manusia {
    private String NIM;
    private double IPK;

    public Mahasiswa(String nama, String NIK, boolean jenisKelamin, boolean menikah) {
        super(nama, NIK, jenisKelamin, menikah);
    }

    public void setNIM(String NIM) {
        this.NIM = NIM;
    }

    public String getNIM() {
        return NIM;
    }

    public void setIPK(double IPK) {
        this.IPK = IPK;
    }

    public double getIPK() {
        return IPK;
    }

    public String getStatus() {
        String _prodi = NIM.substring(6, 7);
        String prodi = null;
        String angkatan = NIM.substring(0, 2);

        switch (_prodi) {
            case "2":
                prodi = "Teknik Meniup Gelembung";
                break;
            case "3":
                prodi = "Teknik Berburu Ubur Ubur";
                break;
            case "4":
                prodi = "Sistem Perhamburgeran";
                break;
            case "6":
                prodi = "Pendidikan Chum Bucket";
                break;
            case "7":
                prodi = "Teknologi Telepon Kerang";
                break;
        }

        return prodi + ", " + "20" + angkatan;
    }

    public double getBeasiswa() {
        double beasiswa;
        if (IPK > 3.0 && IPK <= 3.5)
            beasiswa = 50;
        else if (IPK > 3.5 && IPK <= 4.0)
            beasiswa = 75;
        else
            beasiswa = 0;
        return beasiswa;
    }

    @Override
    public double getPendapatan() {
        return super.getPendapatan() + getBeasiswa();
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nBeasiswa: " + getBeasiswa() + "$"
                + "\nNIM: " + getNIM()
                + "\nIPK: " + getIPK()
                + "\nStatus: " + getStatus();

    }
}
