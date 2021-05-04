package sem2.pbo.praktikum.praktikum6;

public class Sales extends Pegawai{

    private int penjualan;
    private double komisi;

    public Sales(String nama, String noKTP, int penjualan, double komisi) {
        super(nama, noKTP);
        this.penjualan = penjualan;
        this.komisi = komisi;
    }

    public int getPenjualan() {
        return penjualan;
    }

    public double getKomisi() {
        return komisi;
    }

    public void setPenjualan(int penjualan) {
        this.penjualan = penjualan;
    }

    public void setKomisi(double komisi) {
        this.komisi = komisi;
    }

    @Override
    public String toString() {
        return super.toString()  +
                "Total Penjualan : " + getPenjualan() + "\n" +
                "Komisi          : " + "Rp " + getKomisi() + "\n" +
                "Gaji            : " + "Rp " + gaji() + "\n" +
                "Status          : Sales" + "\n" +
                "===============================\n";
    }

    @Override
    public double gaji() {
        int penjualan = getPenjualan();
        double komisi = getKomisi();
        double gaji = penjualan * komisi;

        return super.gaji() + gaji;
    }
}
