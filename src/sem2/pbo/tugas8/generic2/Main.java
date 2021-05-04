package sem2.pbo.tugas8.generic2;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Company company = new Company();

        PegawaiHarian pegawaiHarian1 = new PegawaiHarian("Aldi", "12345", "Jalan Merdeka No 1", 2000000);
        System.out.println(pegawaiHarian1);

        PegawaiTetap pH1ToPT = company.pegawaiHarianToPegawaiTetap(pegawaiHarian1);
        company.pegawaiTetapToDirektur(pH1ToPT);

        PegawaiTetap pegawaiTetap1 = new PegawaiTetap("Budi", "54321", "Jalan Malang No 7", 5000000);
        System.out.println(pegawaiTetap1);

        company.pegawaiTetapToPegawaiHarian(pegawaiTetap1);

        System.out.println("Pegawai Tetap: ");
        display(company.getPegawaiTetaps());

        System.out.println("Pegawai Harian: ");
        display(company.getPegawaiHarians());

        System.out.println("Direktur: ");
        display(company.getDirekturs());
    }

    public static void display(List<? extends Pegawai> list) {
        for (Pegawai obj: list) {
            System.out.println(obj.toString());
        }
    }
}
