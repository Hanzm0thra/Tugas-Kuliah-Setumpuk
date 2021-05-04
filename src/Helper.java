public class Helper {

}

class PelangganTravel {
    String NoKTP;
    String Nama;
    String Alamat;

    public PelangganTravel (String NoKTP, String Nama, String Alamat) {
        this.NoKTP = NoKTP;
        this.Nama = Nama;
        this.Alamat = Alamat;
    }

    public String toString() {
        return "Nama: " + Nama +
                "\nNoKTP: " + NoKTP +
                "\nAlamat: " + Alamat;
    }
}

class Sopir {
    String Nama;
    String SIM;
    String Alamat;
    String GajiHarian;

    public Sopir (String Nama, String SIM, String Alamat, String GajiHarian) {
        this.Nama = Nama;
        this.SIM = SIM;
        this.Alamat = Alamat;
        this.GajiHarian = GajiHarian;
    }
}

class Mobil {
    String NoPol;
    String Tahun;
    String Warna;
    String HargaSewa;

    public Mobil(String NoPol, String Tahun, String Warna, String HargaSewa) {
        this.NoPol = NoPol;
        this.Tahun = Tahun;
        this.Warna = Warna;
        this.HargaSewa = HargaSewa;
    }
}

class TravelApp {
    public static void main(String[] args) {
        var PelangganTravel1 = new PelangganTravel("123456", "Evan", "Jl.Malang");
        System.out.println("PELANGGAN TRAVEL");
        System.out.println(PelangganTravel1.toString());
        System.out.println("============");

        var Sopir1 = new Sopir("Juned", "234567", "Jl.Surabaya","Rp1.000.000");
        System.out.println("SOPIR");
        System.out.println("============");

        var Mobil1 = new Mobil("N123x", "2021", "Putih", "Rp200.000");
        System.out.println("MOBIL");
        System.out.println("============");
    }
}