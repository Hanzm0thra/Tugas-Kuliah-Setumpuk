package sem2.pbo.praktikum.praktikum9;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Furnitur<? extends Barang>[] listFurnitur = new Furnitur[] {
                new Furnitur<>(new PerabotKayu("PK001", ObjekBarang.MEJA.nama, 3, 40000)),
                new Furnitur<>(new PerabotKayu("PK002", ObjekBarang.KURSI.nama, 1.5, 21000)),
                new Furnitur<>(new PerabotKayu("PK003", ObjekBarang.LEMARI.nama, 15, 340000)),
                new Furnitur<>(new PerabotKayu("PK004", ObjekBarang.RAK.nama, 7.65, 145000)),
                new Furnitur<>(new PerabotKayu("PK005", ObjekBarang.KASUR.nama, 20, 420000)),
                new Furnitur<>(new Elektronik("EL001", ObjekBarang.LAMPU.nama, 0.3, 30000)),
                new Furnitur<>(new Elektronik("EL002", ObjekBarang.KIPAS.nama, 2.7, 160000)),
                new Furnitur<>(new Elektronik("EL003", ObjekBarang.TV.nama, 7, 150000)),
                new Furnitur<>(new Elektronik("EL004", ObjekBarang.RADIO.nama, 1.2, 85000))
        };

        rekapitulasi(Arrays.asList(listFurnitur));
        info(Arrays.asList(listFurnitur));
    }

    private static void rekapitulasi(List<Furnitur<? extends Barang>> list) {
        double totalWeight = 0;
        int totalPrice = 0;
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.printf("%68s\n", "REKAPITULASI HASIL PENJUALAN FURNITURE");
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.printf("| %-7s | %-25s | %-15s | %-18s | %-13s |\n", "Kode", "Nama Barang", "Berat Barang", "Jenis Barang", "Harga");
        System.out.println("----------------------------------------------------------------------------------------------");
        for (Furnitur<? extends Barang> obj: list) {
            obj.rekapitulasi();
            totalWeight = totalWeight + obj.getBeratBarang();
            totalPrice = totalPrice + obj.getHargaBarang();
        }
        System.out.printf("\n%-40s%-18s%s\n", "Total", totalWeight + " kg", list.size() + " Barang");
        System.out.printf("Rp %s\n", Barang.currencyFormatting(totalPrice));

        System.out.println("----------------------------------------------------------------------------------------------\n");
    }

    private static void info(List<Furnitur<? extends Barang>> list) {
        for (Furnitur<? extends Barang> obj: list)
            obj.info();
    }
}
