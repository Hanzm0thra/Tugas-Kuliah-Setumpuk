package sem2.pbo.praktikum.praktikum1;

public class Main {
    public static void main(String[] args) {

        Mobil mobil = new Mobil("A 1234 BC", 2015, "putih", 120000000);
        System.out.println(mobil.toString());
        System.out.println();

        Sopir sopir = new Sopir("Budi",  "987654321", "jalan merdeka no. 7, Kota X", 200000);
        System.out.println(sopir.toString());
        System.out.println();

        Pelanggan pelanggan = new Pelanggan("1928374655", "Adi" , "jalan merdeka no. 59, Kota Y");
        System.out.println(pelanggan.toString());
        System.out.println();
    }
}

class Mobil {

    public String nomorPolisi;
    public int tahun;
    public String warna;
    public int harga;

    Mobil(String nomorPolisi, int tahun, String warna, int harga) {
        this.nomorPolisi = nomorPolisi;
        this.tahun = tahun;
        this.warna = warna;
        this.harga = harga;
    }

    public String getNomorPolisi() {
        return nomorPolisi;
    }

    public int getTahun() {
        return tahun;
    }

    public String getWarna() {
        return warna;
    }

    public int getHarga() {
        return harga;
    }

    public String toString()  {
        return "Spesifikasi mobil: " +
                "\nNomor polisi: " + getNomorPolisi() +
                "\nTahun: " + getTahun() +
                "\nWarna: " + getWarna() +
                "\nharga: " + getHarga();
    }
}

class Sopir {
    public String nama;
    public String sim;
    public String alamat;
    public int gajiHarian;

    Sopir(String nama, String sim, String alamat, int gajiHarian) {
        this.nama = nama;
        this.sim = sim;
        this.alamat = alamat;
        this.gajiHarian = gajiHarian;
    }

    public String getNama() {
        return nama;
    }

    public String getSIM() {
        return sim;
    }

    public String getAlamat() {
        return alamat;
    }

    public int getGajiHarian() {
        return gajiHarian;
    }

    public String toString() {
        return "Sopir mobil bernama " + getNama() +
                " dengan nomor sim " + getSIM() +
                " tinggal di " + getAlamat() +
                " serta berpenghasilan sekitar " + getGajiHarian() + " perharinya";
   }
}

class Pelanggan {

    public String nomorKTP;
    public String nama;
    public String alamat;

    Pelanggan(String nomorKTP, String nama, String alamat) {
        this.nomorKTP = nomorKTP;
        this.nama = nama;
        this.alamat = alamat;
    }

    public String getNomorKTP() {
        return nomorKTP;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public String toString() {
        return "Pelanggan bernama " + getNama() +
                " dengan nomor KTP " + getNomorKTP() +
                " tinggal di " + getAlamat();
    }
}