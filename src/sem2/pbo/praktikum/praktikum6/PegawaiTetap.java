package sem2.pbo.praktikum.praktikum6;

public class PegawaiTetap extends Pegawai {

    private double upah;

    public PegawaiTetap(String nama, String noKTP, double upah) {
        super(nama, noKTP);
        this.upah = upah;
    }

    public void setUpah(double upah) {
        this.upah = upah;
    }

    public double getUpah() {
        return upah;
    }

    @Override
    public String toString() {
        return super.toString()  +
                "Upah            : " + gaji() + "\n" +
                "Gaji            : " + "Rp " + gaji() + "\n" +
                "Status          : Pegawai Tetap" + "\n" +
                "===============================\n";
    }

    @Override
    public double gaji() {
        return super.gaji() + getUpah();
    }
}
