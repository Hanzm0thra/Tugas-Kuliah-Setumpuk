package sem2.pbo.praktikum.praktikum4;

public class Pekerja extends Manusia{
    private double gaji;
    private double bonus;
    private int jamKerja;
    private int hariKerja;
    private String NIP;

    public Pekerja(String nama, String NIK, boolean jenisKelamin, boolean menikah) {
        super(nama, NIK, jenisKelamin, menikah);
    }

    public void setJamKerja(int jamKerja) {
        this.jamKerja = jamKerja;
    }

    public void setHariKerja(int hariKerja) {
        this.hariKerja = hariKerja;
    }

    public void setNIP(String NIP) {
        this.NIP = NIP;
    }

    public double getGaji(){

        int jumlahMinggu;
        int tempJumlahMinggu;
        int jumlahHariKerja;

        if (hariKerja % 7 == 0) {
            jumlahMinggu = (hariKerja / 7) - 1;
        } else {
            jumlahMinggu = hariKerja / 7;
        }

        tempJumlahMinggu = jumlahMinggu * 5;
        if (hariKerja % 7 == 0 || hariKerja % 7 == 6) {
            jumlahHariKerja = tempJumlahMinggu + 5;
        } else {
            jumlahHariKerja = tempJumlahMinggu + (hariKerja % 7);
        }

        if (jamKerja > 7) {
            gaji = (70 * jumlahHariKerja);
        } else {
            gaji = 10 * jamKerja * jumlahHariKerja;
        }

        return gaji;
    }

    public double getBonus() {

        int jumlahMinggu;
        int jumlahHariLibur;
        int jumlahHariKerja;

        if (hariKerja % 7 == 0) {
            jumlahMinggu = (hariKerja / 7) - 1;
        } else {
            jumlahMinggu = hariKerja / 7;
        }

        if (hariKerja % 7 == 6) {
            jumlahHariLibur = (jumlahMinggu * 2) + 1;
            jumlahHariKerja = (jumlahMinggu * 5) + 5;
        } else if (hariKerja % 7 == 0) {
            jumlahHariLibur = (jumlahMinggu * 2) + 2;
            jumlahHariKerja = (jumlahMinggu * 5) + 5;
        } else {
            jumlahHariLibur = jumlahMinggu * 2;
            jumlahHariKerja = (jumlahMinggu * 5) + (hariKerja % 7);
        }

        if (jamKerja > 7) {
            int jamLembur = jamKerja - 7;
            double gajiLemburHariLibur = jamLembur * 35;
            double gajiLemburHariKerja = jamLembur * 15;
            bonus = (210 * jumlahHariLibur) + (gajiLemburHariLibur * jumlahHariLibur) + (gajiLemburHariKerja * jumlahHariKerja);
        } else {
            bonus = 30 * jamKerja * jumlahHariLibur;
        }

        return bonus;
    }

    public String getStatus() {
        String _kantorCabang = NIP.substring(0, 1);
        String cabang = NIP.substring(2, 3);
        String _departemen = NIP.substring(6, 7);

        String kantorCabang = null;
        String departemen = null;

        switch (_kantorCabang) {
            case "1":
                kantorCabang = "Mondstadt";
                break;
            case "2":
                kantorCabang = "Liyue";
                break;
            case "3":
                kantorCabang = "Inazuma";
                break;
            case "4":
                kantorCabang = "Sumeru";
                break;
            case "5":
                kantorCabang = "Fontaine";
                break;
            case "6":
                kantorCabang = "Natlan";
                break;
            case "7":
                kantorCabang = "Snezhnaya";
                break;
        }

        switch (_departemen) {
            case "1":
                departemen = "Pemasaran";
                break;
            case "2":
                departemen = "Humas";
                break;
            case "3":
                departemen = "Riset";
                break;
            case "4":
                departemen = "Teknologi";
                break;
            case "5":
                departemen = "Personalia";
                break;
            case "6":
                departemen = "Akademik";
                break;
            case "7":
                departemen = "Administrasi";
                break;
            case "8":
                departemen = "Operasional";
                break;
            case "9":
                departemen = "Pembangunan";
                break;
        }

        return departemen + ", " + kantorCabang + " cabang " + cabang;
    }

    @Override
    public double getPendapatan() {
        return super.getPendapatan() + getGaji() + getBonus();
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nGaji: " + getGaji() + "$"
                + "\nBonus: " + getBonus() + "$"
                + "\nStatus: " + getStatus();
    }
}
