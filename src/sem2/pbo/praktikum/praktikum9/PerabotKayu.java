package sem2.pbo.praktikum.praktikum9;

@TipeFurnitur(jenis = JenisBarang.KAYU)
public class PerabotKayu extends Barang{

    public PerabotKayu(String kodeBarang, String namaBarang, double beratBarang, int hargabarang) {
        super(kodeBarang, namaBarang, beratBarang, hargabarang);
        this.jenisBarang = PerabotKayu.class.getAnnotation(TipeFurnitur.class).jenis();
    }
}