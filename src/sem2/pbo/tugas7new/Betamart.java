package sem2.pbo.tugas7new;

import java.util.ArrayList;
import java.util.Arrays;

public class Betamart {

    private ArrayList<Barang> listBarang = new ArrayList<>();
    private ArrayList<Barang> listBarangDiskon = new ArrayList<>();

    public void control(Pencatatan pencatatan, Barang[] listBarang, Barang[] listBarangDiskon, Pembeli pembeli) {
        switch (pencatatan) {
            case MASUK -> pemasukkanBarang(listBarang, listBarangDiskon);
            case KELUAR -> pengeluaranBarang(pembeli);
        }
    }

    private void pemasukkanBarang(Barang[] listBarang, Barang[] listBarangDiskon) {
        this.listBarang.addAll(Arrays.asList(listBarang));
        this.listBarangDiskon.addAll(Arrays.asList(listBarangDiskon));

        System.out.println("==============================BARANG YANG TERSEDIA===========================");
        System.out.printf("%-6s %-40s %-15s %-8s\n", "id", "nama barang", "harga", "stok");
        for (Barang barang: listBarang) {
            System.out.printf("%-6s %-40s %-15s %-8s\n", barang.id(), barang.nama(), barang.harga(), barang.stok());
        }
        System.out.println("==============================================================================");
    }

    private void pengeluaranBarang(Pembeli pembeli) {

        System.out.println("================================================Struk Belanja================================================\n");
        System.out.println("Nama Pembeli : " +  pembeli.getNama() + "\n");
        System.out.printf("%-6s %-40s %-12s %-15s %-15s \n", "id", "nama barang", "kuantitas", "harga satuan", "total harga" );

        if (pembeli.bayar() >= 100000) {
            ArrayList<Barang> temp = new ArrayList<>(pembeli.semuaBarang);

            pembeli = new PembeliDiskon(pembeli.getId(), pembeli.getNama(), pembeli.getJumlahBarang());

            for (Barang obj: temp) {
                pembeli.masukkanBarang(obj);
            }

            for (int index = 0; index < listBarang.size(); index++) {
                listBarang.set(index, new Barang(
                        listBarang.get(index).id(),
                        listBarang.get(index).nama(),
                        listBarang.get(index).harga(),
                        listBarang.get(index).stok() - pembeli.getJumlahBarang()
                ));
            }

            for (Barang obj: listBarangDiskon) {
                pembeli.masukkanBarangDiskon(obj);
            }

            for (int index = 0; index < listBarangDiskon.size(); index++) {
                listBarangDiskon.set(index, new Barang(
                        listBarangDiskon.get(index).id(),
                        listBarangDiskon.get(index).nama(),
                        listBarangDiskon.get(index).harga(),
                        listBarangDiskon.get(index).stok() - pembeli.getJumlahBarang()
                ));
            }

            for (Barang obj: pembeli.semuaBarang) {
                System.out.printf("%-6s %-40s %-12s %-15s %-15s \n",
                        obj.id(), obj.nama(), pembeli.getJumlahBarang(), obj.harga(), obj.harga() * pembeli.getJumlahBarang());
            }

            for (Barang obj: pembeli.barangDiskon) {
                System.out.printf("%-6s %-40s %-12s %-15s %-15s(Diskon 10%%) \n",
                        obj.id(), obj.nama(), pembeli.getJumlahBarang(), obj.harga(), (obj.harga() * pembeli.getJumlahBarang() * 0.9));
            }

            System.out.printf("%-76s %s\n", "Total Belanja : ", pembeli.bayar() + pembeli.bayarDiskon());
        } else {
            for (Barang obj: pembeli.semuaBarang) {
                System.out.printf("%-6s %-40s %-12s %-15s %-15s \n",
                        obj.id(), obj.nama(), pembeli.getJumlahBarang(), obj.harga(), obj.harga() * pembeli.getJumlahBarang());
            }

            System.out.printf("%-76s %s\n", "Total Belanja : ", pembeli.bayar());
        }

        System.out.println("================================================Struk Belanja================================================\n");
    }
}
