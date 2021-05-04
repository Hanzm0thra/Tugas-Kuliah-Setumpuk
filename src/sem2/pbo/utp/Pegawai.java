package sem2.pbo.utp;

public class Pegawai {
    private String nama;
    private String nomorPegawai;
    private Buku[] listBuku = new Buku[100];
    private Pelanggan[] listPelanggan = new Pelanggan[20];
    private static int indexBuku = 0;
    private static int indexPelanggan = 0;

    public Pegawai(String nama, String nomorPegawai) {
        this.nama = nama;
        this.nomorPegawai = nomorPegawai;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNomorPegawai() {
        return nomorPegawai;
    }

    public void setNomorPegawai(String nomorPegawai) {
        this.nomorPegawai = nomorPegawai;
    }

    public void tampilkanInfoPegawai() {
        System.out.println("============Informasi Pegawai Perpustakaan============");
        System.out.printf("Nama          : %s\n", nama);
        System.out.printf("Nomor Pegawai : %s\n\n", nomorPegawai);
    }

    public void menambahPelanggan(String nama, String nomorPelanggan) {

    }

    public void menambahkanPelanggan(String nama, String nomorPelanggan) {
        if (indexPelanggan < 20) {
            this.listPelanggan[indexPelanggan] = new Pelanggan(nama, nomorPelanggan);
            indexPelanggan++;
        }
    }

    public void menambahBuku(String judul, String penulis, int jumlah) {

    }

    public void menambahkanBuku(String judul, String penulis, int jumlah) {
        if (indexBuku < 100) {
            this.listBuku[indexBuku] = new Buku(judul, penulis, jumlah);
            indexBuku++;
        }
    }

    public Buku[] getListBuku() {
        return listBuku;
    }

    public Pelanggan[] getListPelanggan() {
        return listPelanggan;
    }
}
