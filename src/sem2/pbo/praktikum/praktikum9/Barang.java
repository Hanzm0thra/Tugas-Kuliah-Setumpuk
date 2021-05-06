package sem2.pbo.praktikum.praktikum9;

public class Barang {
    private String kodeBarang;
    private String namaBarang;
    private double beratBarang;
    JenisBarang jenisBarang;
    private int hargabarang;

    public Barang(String kodeBarang, String namaBarang, double beratBarang, int hargabarang) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.beratBarang = beratBarang;
        this.hargabarang = hargabarang;
    }

    public String getKodeBarang() {
        return kodeBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public double getBeratBarang() {
        return beratBarang;
    }

    public JenisBarang getJenisBarang() {
        return jenisBarang;
    }

    public int getHargabarang() {
        return hargabarang;
    }

    public static String currencyFormatting(int harga) {
        String result = "";
        char[] separated = String.valueOf(harga).toCharArray();
        int index = separated.length - 1;
        int counter = 1;

        do {
            result = String.format("%s%s", separated[index], result);
            if (counter % 3 == 0 && index != 0)
                result = String.format("%s%s", ".", result);
            index--;
            counter++;
        } while (index != -1);

        return result;
    }
}
