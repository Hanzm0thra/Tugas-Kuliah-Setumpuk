package sem2.pbo.tugas7new;


public class PembeliDiskon extends Pembeli {

    public PembeliDiskon(String id, String nama, int jumlahBarang) {
        super(id, nama, jumlahBarang);
    }

    @Override
    public void masukkanBarang(Barang barang) {
        super.masukkanBarang(barang);
    }

    @Override
    public void masukkanBarangDiskon(Barang barang) {
        barangDiskon.add(barang);
    }

    @Override
    public double bayar() {
        return super.bayar();
    }

    @Override
    public double bayarDiskon() {
        double totalBelanja = 0;
        for (Barang obj: barangDiskon) {
            totalBelanja = totalBelanja + (obj.harga() * 0.9 * getJumlahBarang());
        }
        return super.bayarDiskon() + totalBelanja;
    }


}
