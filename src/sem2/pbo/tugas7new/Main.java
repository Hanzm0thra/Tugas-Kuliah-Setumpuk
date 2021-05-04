package sem2.pbo.tugas7new;

public class Main {
    public static void main(String[] args) {

        Betamart betamart = new Betamart();

        Barang[] listBarang = new Barang[] {
                new Barang("0001", "Biskuit Kaleng", 120000, 99),
                new Barang("0002", "Susu Cap Kaki Tiga", 45000, 99),
                new Barang("0003", "Kacang Dua Gajah", 20000, 99),
                new Barang("0004", "Sirup Anggur Hijau", 54000, 99),
                new Barang("0005", "Kurma Padang Gurun", 72000, 99)
        };

        Barang[] listBarangDiskon = new Barang[] {
                new Barang("10001", "Sosis So Bad", 4000, 99),
                new Barang("10002", "Sirup Anggur Merah", 60000, 99),
                new Barang("10003", "Secret Stuff", 180000, 99)
        };

        betamart.control(Pencatatan.MASUK, listBarang, listBarangDiskon, null);

        Pembeli pembeli1 = new Pembeli("10001", "Aldi", 5);
        pembeli1.masukkanBarang(listBarang[0]);
        pembeli1.masukkanBarang(listBarang[1]);

        Pembeli pembeli2 = new Pembeli("20002", "Budi", 1);
        pembeli2.masukkanBarang(listBarang[1]);
        pembeli2.masukkanBarang(listBarang[2]);

        betamart.control(Pencatatan.KELUAR, null, null, pembeli1);
        betamart.control(Pencatatan.KELUAR, null, null, pembeli2);
    }
}
