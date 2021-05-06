package sem2.pbo.praktikum.praktikum9;

@FurniturType(jenis = JenisBarang.ELEKTRONIK)
public class Elektronik extends Barang{

    public Elektronik(String kodeBarang, String namaBarang, double beratBarang, int hargabarang) {
        super(kodeBarang, namaBarang, beratBarang, hargabarang);
        this.jenisBarang = Elektronik.class.getAnnotation(FurniturType.class).jenis();
    }
}
