package sem2.pbo.utp;

public class Pelanggan {
    private String nama;
    private String nomorPelanggan;
    private Buku[] bukuPinjam = new Buku[3];
    private int index = 0;

    public Pelanggan(String nama, String nomorPelanggan) {
        this.nama = nama;
        this.nomorPelanggan = nomorPelanggan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNomorPelanggan() {
        return nomorPelanggan;
    }

    public void setNomorPelanggan(String nomorPelanggan) {
        this.nomorPelanggan = nomorPelanggan;
    }

    public Buku[] getBukuPinjam() {
        return bukuPinjam;
    }

    public void setBukuPinjam(Buku[] bukuPinjam) {
        this.bukuPinjam = bukuPinjam;
    }

    public void tambahBuku(Buku bukuPinjam) {
        if (bukuPinjam.getJumlah() > 0) {
            this.bukuPinjam[index] = bukuPinjam;
            index++;
        }
    }

    public void tampilkanInfoPelanggan() {
        int index = 0;
        System.out.printf("Nama           : %s\n", nama);
        System.out.printf("Nomor Pelanggan: %s\n", nomorPelanggan);
        System.out.println("Buku yang dipinajam :");
        while(bukuPinjam[index] != null) {
            System.out.println(bukuPinjam[index].getJudul());
            index++;
        }
        System.out.println();
    }
}
