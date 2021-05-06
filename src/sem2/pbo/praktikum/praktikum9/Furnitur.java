package sem2.pbo.praktikum.praktikum9;


public class Furnitur<T extends Barang> {

    T data;

    public Furnitur(T data) {
        this.data = data;
    }

    public double getBeratBarang() {
        return data.getBeratBarang();
    }

    public int getHargaBarang() {
        return data.getHargabarang();
    }

    public void rekapitulasi() {
        System.out.printf("| %-7s | %-25s | %-15s | %-18s | %-13s |\n",
                data.getKodeBarang(), data.getNamaBarang(), data.getBeratBarang() + " kg", data.getJenisBarang().label, "Rp " + Barang.currencyFormatting(data.getHargabarang())
        );
    }

    public void info() {
        System.out.printf(
                "%-18s %s %s\n" +
                "%-18s %s %s\n" +
                "%-18s %s %s\n" +
                "%-18s %s %s %s\n" + "\n",

                "Nama Barang", ":", data.getNamaBarang(),
                "Kode", ":", data.getKodeBarang(),
                "Jenis Barang", ":", data.getJenisBarang().label,
                "Harga", ":", "Rp", Barang.currencyFormatting(data.getHargabarang())
        );
    }
}
