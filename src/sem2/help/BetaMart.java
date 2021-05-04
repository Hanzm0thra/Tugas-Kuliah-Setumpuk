package sem2.help;

/*
public class BetaMart {

    ArrayList<Barang> listBarang = new ArrayList<>();
    ArrayList<Barang> listBarangDiskon = new ArrayList<>();

    public void listSemuaBarang(Barang[] listBarang, Barang[] listBarangDiskon) {
        this.listBarang.addAll(Arrays.asList(listBarang));
        this.listBarangDiskon.addAll(Arrays.asList(listBarangDiskon));

        System.out.println("=====================================================================\nBARANG YANG DIJUAL\n=====================================================================");
        System.out.printf("%-25s %-20s %-15s %-8s\n", "Nama Barang", "Merk", "Harga", "Stok");
        for (Barang brg : listBarang) {
            System.out.printf("%-25s %-20s %-15s %-8s\n", brg.nama, brg.merk, brg.harga, brg.stok);
        }
        for (Barang brg : listBarangDiskon) {
            System.out.printf("%-25s %-20s %-15s %-8s\n", brg.nama, brg.merk, brg.harga, brg.stok);
        }
        System.out.println("=====================================================================");
    }

    public void Bayar(TambahBarang tambahBarang, Pembeli pembeli) {
        switch (tambahBarang) {
            case TAMBAH -> TransaksiDiskon(pembeli);
            case TIDAKTAMBAH -> Transaksi(pembeli);
        }
    }

    public void TransaksiDiskon(Pembeli pembeli) {
        System.out.println("=====================================================================\nPencatatan BetaMart\n=====================================================================");
        System.out.println("Nama Pembeli    : " + pembeli.nama +
                "\nBudget        : " + pembeli.budget);
        System.out.printf("%-25s %-20s %-12s %-15s %-15s \n", "Nama Barang", "Merk", "Jumlah Barang", "Harga", "Total Harga" );
        if (pembeli.TotalHarga() >= 100000) {
            ArrayList<Barang> temp = new ArrayList<>(pembeli.barang);

            */
/*for (Barang brg : temp) {
                pembeli.tambahBarang(brg);
            }*//*


            for (int i = 0; i < listBarang.size(); i++) {
                listBarang.set(i, new Barang(
                        listBarang.get(i).nama,
                        listBarang.get(i).merk,
                        listBarang.get(i).harga,
                        listBarang.get(i).stok - pembeli.getJumlahBarang()));
            }
            for (Barang brg : listBarangDiskon) {
                pembeli.tambahBarangDiskon(brg);
            }
            for (int index = 0; index < listBarangDiskon.size(); index++) {
                listBarangDiskon.set(index, new Barang(
                        listBarangDiskon.get(index).nama,
                        listBarangDiskon.get(index).merk,
                        listBarangDiskon.get(index).harga,
                        listBarangDiskon.get(index).stok - pembeli.getJumlahBarang()));
            }
        }
        for (Barang brg : pembeli.barang) {
            System.out.printf("%-25s %-20s %-12s %-15s %-15s \n",
                    brg.nama, brg.merk, pembeli.getJumlahBarang(), brg.harga, brg.harga * pembeli.getJumlahBarang());
        }
        for (Barang brg: pembeli.barangDiskon) {
            System.out.printf("%-25s %-20s %-12s %-15s %-15s(Diskon 10%%) \n",
                    brg.nama, brg.merk, pembeli.getJumlahBarang(), brg.harga, (brg.harga * pembeli.getJumlahBarang() * 0.9));
        }
        System.out.printf("%-76s %s\n", "Total Belanja: ", pembeli.TotalHarga() + pembeli.TotalHargaDiskon());
        System.out.println("=====================================================================");
        System.out.println(listBarang.get(0).stok);
        System.out.println(listBarang.get(0).nama);
    }
    public void Transaksi(Pembeli pembeli) {
        System.out.println("=====================================================================\nPencatatan BetaMart\n=====================================================================");
        System.out.println("Nama Pembeli    : " + pembeli.nama +
                "\nBudget        : " + pembeli.budget);
        System.out.printf("%-25s %-20s %-12s %-15s %-15s \n", "Nama Barang", "Merk", "Jumlah Barang", "Harga", "Total Harga" );
        if (pembeli.TotalHarga() > 0) {
            ArrayList<Barang> temp = new ArrayList<>(pembeli.barang);

            for (Barang brg : temp) {
                pembeli.tambahBarang(brg);
            }
            for (int i = 0; i < listBarang.size(); i++) {
                listBarang.set(i, new Barang(
                        listBarang.get(i).nama,
                        listBarang.get(i).merk,
                        listBarang.get(i).harga,
                        listBarang.get(i).stok - pembeli.getJumlahBarang()));
            }
        }
        for (Barang brg : pembeli.barang) {
            System.out.printf("%-25s %-20s %-12s %-15s %-15s \n",
                    brg.nama, brg.merk, pembeli.getJumlahBarang(), brg.harga, brg.harga * pembeli.getJumlahBarang());
        }
        System.out.printf("%-76s %s\n", "Total Belanja: ", pembeli.TotalHarga());
        System.out.println("=====================================================================");
    }
}
*/
