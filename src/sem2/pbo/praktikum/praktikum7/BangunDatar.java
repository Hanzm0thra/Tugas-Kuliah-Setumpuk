package sem2.pbo.praktikum.praktikum7;

public abstract class BangunDatar {
    private String nama;
    static String listBangunDatar[] = new String[10];
    static int index = 0;

    BangunDatar() {}

    BangunDatar(String nama) {
        this.nama = nama;
        listBangunDatar[index] = nama;
        index++;
    }

    public abstract void info();

    public String getNama() {
        return nama;
    }

    public void search(String query) {
        int count = 0;
        int sisi = 0;
        int sudut = 0;
        int result = 0;

        System.out.println("\n................................................");
        System.out.print("Hasil Pencarian \t: ");

        for (int i = 0; i < listBangunDatar.length; i++) {
            if (listBangunDatar[i] == null) {
                break;
            }
            if (listBangunDatar[i].equalsIgnoreCase(query)) {
                count++;
                result = i;
            }
        }

        assert listBangunDatar[result] != null;
        String searchValue = listBangunDatar[result].toLowerCase();
        switch (searchValue) {
            case "segitiga" -> {
                sisi = 3;
                sudut = 3;
            } case "persegi", "trapesium", "layang" -> {
                sisi = 4;
                sudut = 4;
            } case "lingkaran" -> {
                sisi = 1;
                sudut = 0;
            }
        }

        if (count > 0) {
            System.out.println("Bangun Datar " + query + " Ditemukan!");
            System.out.printf("Jumlah %-10s  \t: %d\n", query, count);
            System.out.printf("Jumlah %-10s  \t: %d\n", "sisi", sisi);
            System.out.printf("Jumlah %-10s  \t: %d", "sudut", sudut);
        } else {
            System.out.print("Bangun Datar " + query + " Tidak Detmukan!");
        } System.out.println("\n................................................");
    }

    public static BangunDatar getInstanceBangunDatarOf(Hitung bangun){
        BangunDatar bangunDatar = null;
        if(bangun instanceof Persegi)
            bangunDatar = (Persegi)bangun;
        else if(bangun instanceof Segitiga)
            bangunDatar = (Segitiga) bangun;
        else if(bangun instanceof Lingkaran)
            bangunDatar = (Lingkaran) bangun;
        else if(bangun instanceof Trapesium)
            bangunDatar = (Trapesium) bangun;
        else if(bangun instanceof Layang)
            bangunDatar = (Layang)bangun;
        return bangunDatar;
    }
}
