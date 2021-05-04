package sem2.pbo.praktikum.praktikum4;

public class Manager extends Pekerja {
    private int lamaKerja;

    public Manager(String nama, String NIK, boolean jenisKelamin, boolean menikah) {
        super(nama, NIK, jenisKelamin, menikah);
    }

    public void setLamaKerja(int lamaKerja) {
        this.lamaKerja = lamaKerja;
    }

    public int getLamaKerja() {
        return lamaKerja;
    }

    @Override
    public double getBonus() {
        return super.getBonus() + (0.35 * super.getBonus());
    }

    @Override
    public double getGaji() {
        return super.getGaji();
    }

    @Override
    public double getTunjangan() {
        return super.getTunjangan() + 15;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nLama Kerja: " + getLamaKerja() + " tahun";
    }
}
