package sem2.pbo.utp;

public class Buku {

    private String judul;
    private String penulis;
    private int jumlah;

    public Buku(String judul, String penulis, int jumlah) {
        this.judul = judul;
        this.penulis = penulis;
        this.jumlah = jumlah;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public void tampilkanInfoBuku() {
        System.out.printf("Judul Buku: %s", getJudul());
        System.out.printf("Penlis    : %s", getPenulis());
        System.out.printf("Jumlah   : %d", getJumlah());
    }

}
