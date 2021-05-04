package sem2.pbo.praktikum.praktikum6;

public class PegawaiHarian extends Pegawai{

    private double upahPerJam;
    private int totalJam;

    public PegawaiHarian(String nama, String noKTP, double upahPerJam, int totalJam) {
        super(nama, noKTP);
        this.upahPerJam = upahPerJam;
        this.totalJam = totalJam;
    }

    public double getUpahPerJam() {
        return upahPerJam;
    }

    public int getTotalJam() {
        return totalJam;
    }

    public void setUpahPerJam(double upahPerJam) {
        this.upahPerJam = upahPerJam;
    }

    public void setTotalJam(int totalJam) {
        this.totalJam = totalJam;
    }

    @Override
    public String toString() {
        return super.toString()  +
                "Upah Per Jam    : " + "Rp " + getUpahPerJam() + "\n" +
                "Jam Kerja       : " + getTotalJam() + "\n" +
                "Gaji            : " + "Rp " + gaji() + "\n" +
                "Status          : Pegawai Harian" + "\n" +
                "===============================\n";
    }

    @Override
    public double gaji() {
        double upahPerJam = getUpahPerJam();
        int totalJam = getTotalJam();
        double gaji;

        if (totalJam <= 40) {
            gaji = upahPerJam * totalJam;
        } else {
            double gajiNormal = upahPerJam * totalJam;
            int jamTambahan = totalJam - 40;
            gaji = gajiNormal + (jamTambahan * upahPerJam * 1.5);
        }

        return super.gaji() + gaji;
    }
}
