package sem2.pbo.uap;

import java.util.ArrayList;
import java.util.Scanner;

public class Data {
    public static ArrayList<Tanaman> tanamans = new ArrayList<>();
    public static ArrayList<Integer> lokasi = new ArrayList<>();
    public static Scanner in = new Scanner(System.in);

    public static void mulai() {
        System.out.print("Masa tanam (bulan) : ");
        String _masaTanam = in.nextLine();
        int masaTanam = Integer.parseInt(_masaTanam);
        int convertMasaTanam = masaTanam * 30;

        menanam();
        menanam();
        menanam();

        System.out.println("===================");
        System.out.println("PROSES PERKEMBANGAN");
        System.out.println("===================\n");

        int hari = 1;

        do {

            if (hari == 1) {
                for (Tanaman tanaman: tanamans) {
                    tanaman.setProsesBerbuah(tanaman.getBerbuah() * tanaman.getPerkembangan());
                }
            } else {
                for (int i = 0; i < tanamans.size(); i++) {
                    if (tanamans.get(i).status().equals("Hidup")) {
                        tanamans.get(i).berkembang();
                        tanamans.get(i).setLamaHidup(hari);
                    } else if (tanamans.get(i).status().equals("Mati") && !lokasi.contains(i)) {
                        System.out.println("Tanaman " + tanamans.get(i).getClass().getSimpleName() + " telah mati");
                        lokasi.add(i);
                        menanam();
                    }
                }
            }

            if (hari % 90 == 0) {
                System.out.println("=====================");
                System.out.println("PERAWATAN GASSS KANNN");
                System.out.println("=====================\n");
                for (Tanaman tanaman: tanamans) {
                    new Perawatan() {
                        @Override
                        public void treatment() {
                            if (tanaman instanceof Tomat || tanaman instanceof Stroberi)
                                tanaman.setPerkembangan(tanaman.getPerkembangan() + 0.05);
                            else
                                tanaman.setPerkembangan(tanaman.getPerkembangan() + 0.025);
                        }
                    };
                }
            }

            hari++;
            convertMasaTanam--;
        } while (convertMasaTanam != 0);
    }

    public static void menanam() {

            System.out.println("Mau menananm apa ?");
            System.out.println("1. Tomat");
            System.out.println("2. Stroberi");
            System.out.println("3. Persik");
            String _choice = in.nextLine();
            int choice = Integer.parseInt(_choice);

            switch (choice) {
                case 1 -> {
                    tanamans.add(new Tomat());
                    System.out.println("Tomat berhasil ditanam");
                }
                case 2 -> {
                    tanamans.add(new Stroberi());
                    System.out.println("Stroberi berhasil ditanam");
                }
                case 3 -> {
                    tanamans.add(new Persik());
                    System.out.println("Persik berhasil ditanam");
                }
            }

        System.out.println();
    }

    public static void info() {
        System.out.println("\n------------------Hasil Menananm------------------");
        for (int index = 0; index < tanamans.size(); index++) {
            System.out.println();
            System.out.println("Tanaman buah ke-" + (index + 1));
            System.out.print(tanamans.get(index).toString());
        }
    }
}
