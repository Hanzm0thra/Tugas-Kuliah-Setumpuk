package sem2.pbo.utp;


public class Perpustakaan {

    Buku[] listBuku = new Buku[100];
    public Pegawai pegawaiPerpus;
    Pelanggan[] listPelanggan = new Pelanggan[20];

    Perpustakaan(Pegawai pegawai) {
        this.pegawaiPerpus = pegawai;
        this.listBuku = pegawaiPerpus.getListBuku();
        this.listPelanggan = pegawaiPerpus.getListPelanggan();
    }

    public Buku cariBuku(String judulBuku) {
        Buku buku = null;
        int index = 0;
        while (listBuku[index] != null) {
            if (listBuku[index].getJudul().equals(judulBuku)){
                buku = listBuku[index];
                break;
            }
            index++;
        }
        return buku;
    }

    public void pinjam(String namaPelanggan, String judulBuku) {
        if (cariBuku(judulBuku) != null) {
            for (Pelanggan obj: pegawaiPerpus.getListPelanggan()) {
                if (obj.getNama().equals(namaPelanggan)) {
                    obj.tambahBuku(cariBuku(judulBuku));
                    break;
                }
            }
        }
    }

    public void tampilkanInfoPerpustakaan() {
        pegawaiPerpus.tampilkanInfoPegawai();

        for (Pelanggan obj: listPelanggan) {
            obj.tampilkanInfoPelanggan();
        }

        for (Buku obj: listBuku) {
            obj.tampilkanInfoBuku();
        }
    }
}
