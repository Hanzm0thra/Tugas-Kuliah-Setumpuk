package sem2.pbo.utp;

public class Main {
    public static void main(String[] args) {
        Pegawai pegawaiPerpus = new Pegawai("TIA", "111111");

        pegawaiPerpus.menambahkanBuku("Tutorial Java", "Gratia", 2);
        pegawaiPerpus.menambahkanBuku("Tutorial Python", "Safir", 2);

        pegawaiPerpus.menambahkanPelanggan("Wilda", "1");
        pegawaiPerpus.menambahkanPelanggan("Adin", "3");

        Perpustakaan perpustakaan = new Perpustakaan(pegawaiPerpus);

        perpustakaan.pinjam("Wilda", "Tutorial Java");
        perpustakaan.pinjam("Adin", "Tutorial Python");

        perpustakaan.tampilkanInfoPerpustakaan();
    }

}
