package sem2.pbo.praktikum.praktikum9;

@TipeFurnitur(jenis = JenisBarang.ELEKTRONIK)
public class Elektronik extends Barang{

    public Elektronik(String kodeBarang, String namaBarang, double beratBarang, int hargabarang) {
        super(kodeBarang, namaBarang, beratBarang, hargabarang);
        this.jenisBarang = Elektronik.class.getAnnotation(TipeFurnitur.class).jenis();
    }
}
