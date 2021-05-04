package sem2.pbo.tugas5;

import java.util.Scanner;

 public class KaryawanMain {

    static KaryawanTetap karyawanTetap;
    static KaryawanTidakTetap karyawanTidakTetap;
    static KaryawanPejabat karyawanPejabat;

    public static void main(String[] args) {
        karyawanTetap = new KaryawanTetap("123456", "Adi", "Jalan Mawar No. 17");
        karyawanTidakTetap = new KaryawanTidakTetap("987654321", "Tono", "Jalan Merdeka No.21");
        karyawanPejabat = new KaryawanPejabat("123456789", "Budi", "Jalan Malang No.9");
        setterValue(karyawanTetap);
        calculate(karyawanTetap);

        setterValue(karyawanTidakTetap);
        calculate(karyawanTidakTetap);

        setterValue(karyawanPejabat);
        calculate(karyawanPejabat);
    }

    private static void setterValue(KaryawanTetap obj) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=====================================");
        System.out.println(obj.getNama() + " - " + obj.getId());
        System.out.println("Masukkan gaji karyawan tetap: ");
        double gaji = scanner.nextDouble();
        obj.setGaji(gaji);
    }

    private static void setterValue(KaryawanTidakTetap obj) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=====================================");
        System.out.println(obj.getNama() + " - " + obj.getId());
        System.out.println("Masukkan jam kerja karyawan tidak tetap: ");
        int jamKerja = scanner.nextInt();
        obj.setJamKerja(jamKerja);
        System.out.println("Masukkan gaji setiap jam dari karyawan tidak tetap: ");
        double gajiJam = scanner.nextDouble();
        obj.setGajiPerJam(gajiJam);
    }

    private static void setterValue(KaryawanPejabat obj) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=====================================");
        System.out.println(obj.getNama() + " - " + obj.getId());
        System.out.println("Masukkan gaji karyawan pejabat: ");
        double gaji = scanner.nextDouble();
        scanner.nextLine();
        obj.setGaji(gaji);
        System.out.println("Masukkan jabatan dari karyawan pejabat: ");
        String jabatan = scanner.nextLine();
        obj.setJabatan(jabatan);
    }


    private static void calculate(Karyawan obj) {
        if (obj == karyawanPejabat) {
            System.out.println("Gaji " + obj.getClass().getSimpleName()
                    + " dengan jabatan " + ((KaryawanPejabat) obj).getJabatan() + " adalah " + obj.perhitunganGaji()
            );
        } else {
            System.out.println("Gaji " + obj.getClass().getSimpleName() + " adalah " + obj.perhitunganGaji());
        }
        System.out.println("=====================================\n");
    }
}
