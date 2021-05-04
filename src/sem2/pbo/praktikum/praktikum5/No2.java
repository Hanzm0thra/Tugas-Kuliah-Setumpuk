package sem2.pbo.praktikum.praktikum5;

import java.util.Arrays;
import java.util.Scanner;

public class No2 {
    public static void main(String[] args) {
        tampilDaftarMataKuliah();

        Mahasiswa mahasiswa1 = inputDataMahasiswa(daftarMatkul());
        dataMahasiswa(mahasiswa1);
    }

    private static void tampilDaftarMataKuliah() {
        System.out.println("""
                ===============================
                DAFTAR MATA KULIAH YANG TERSEDIA:
                """);

        for (MataKuliah matkul: daftarMatkul()) {
            System.out.printf("" +
                    "Kode Matkul\t: %s\n" +
                    "Nama Matkul\t: %s\n" +
                    "Jumlah SKS \t: %d\n\n",
                    matkul.getKodeMatkul(), matkul.getNamaMatkul(), matkul.getSks());
        }
        System.out.println("===============================");
    }

    private static MataKuliah[] daftarMatkul() {
        Dosen[] dosen = new Dosen[7];

        dosen[0] = new Dosen("000", "Adi Sucipto", "TIF", "FILKOM");
        dosen[1] = new Dosen("111", "Budi Harsadi", "TIF", "FILKOM");
        dosen[2] = new Dosen("222", "Campaka Cocoki", "TEKKOM" ,"FILKOM");
        dosen[3] = new Dosen("333", "Doni Ananta", "SI", "FILKOM");
        dosen[4] = new Dosen("444", "Erna Sulastri", "SI", "FILKOM");
        dosen[5] = new Dosen("555", "Fara", "TI", "FILKOM");
        dosen[6] = new Dosen("666", "Gina Haryadi", "PTI", "FILKOM");

        MataKuliah[] mataKuliah = new MataKuliah[10];

        mataKuliah[0] = new MataKuliah("MATKUL01", "Pemrograman Dasar", 4, dosen[0]);
        mataKuliah[1] = new MataKuliah("MATKUL02", "Statistika dan Teori Peluang", 3, dosen[1]);
        mataKuliah[2] = new MataKuliah("MATKUL03", "Sistem Operasi", 4, dosen[2]);
        mataKuliah[3] = new MataKuliah("MATKUL04", "Pemrograman Lanjut", 5,dosen[3]);
        mataKuliah[4] = new MataKuliah("MATKUL05", "Bahasa Indonesia", 3, dosen[4]);
        mataKuliah[5] = new MataKuliah("MATKUL06", "Kewirausahaan", 2, dosen[5]);
        mataKuliah[6] = new MataKuliah("MATKUL07", "Bahasa Inggris", 2, dosen[6]);
        mataKuliah[7] = new MataKuliah("MATKUL08", "Algoritma dan Struktur Data", 4, dosen[2]);
        mataKuliah[8] = new MataKuliah("MATKUL09", "Aljabar Linear", 2, dosen[4]);
        mataKuliah[9] = new MataKuliah("MATKUL010", "Kalkulus", 3, dosen[6]);

        return mataKuliah;
    }

    private static Mahasiswa inputDataMahasiswa(MataKuliah[] mataKuliah) {
        Scanner scanner = new Scanner(System.in);
        boolean isKRSRepeat = false;
        int index = 0;

        System.out.println("===============================");
        System.out.println("Pengisian data mahasiswa\n");
        System.out.print("Nama    \t: ");
        String nama = scanner.nextLine();
        System.out.print("NIM     \t: ");
        String nim = scanner.nextLine();
        System.out.print("Prodi   \t: ");
        String prodi = scanner.nextLine();
        System.out.print("Fakultas\t: ");
        String fakultas = scanner.nextLine();
        Mahasiswa mahasiswa = new Mahasiswa(nim, nama, prodi, fakultas);

        System.out.println("Silahkan memprogram untuk KRS anda, daftar mata kuliah dapat anda lihat di atas");


        do {
            System.out.print("\nMasukkan kode mata Kuliah: ");
            String kodeMatkul = scanner.nextLine();

            //pengecekan apakah kode matkul benar
            boolean isContain = isMatkulExist(mataKuliah, kodeMatkul);

            //pengecekan apakah matkul sudah dipilih atau belum
            boolean isAdded = isMatkulAdded(kodeMatkul, mahasiswa);

            //proses penambahan matkul
            if (isAdded) {
                System.out.println("Matkul yang anda pilih sudah anda pilih sebelumnya");
            } else {
                if (isContain) {
                    for (MataKuliah matkul: mataKuliah) {
                        if (matkul.getKodeMatkul().equals(kodeMatkul)) {
                            mahasiswa.tambahMatkul(matkul);
                            System.out.println("SKS yang telah terambil: " + mahasiswa.sksTerambil());
                        }
                    }
                } else {
                    System.out.println("Kode matkul yang anda minta tidak ditemukan");
                }
            }



            System.out.print("Ingin mengambil mata kuliah lain? (Y/N): ");
            String decision = scanner.nextLine();
            isKRSRepeat = decision.equals("Y") || decision.equals("y");
        } while (isKRSRepeat);
        System.out.println("===============================");

        return mahasiswa;
    }

    private static boolean isMatkulExist(MataKuliah[] mataKuliah, String kodeMatkul) {
        boolean isContain = false;
        for (MataKuliah matkul: mataKuliah) {
            if (matkul.getKodeMatkul().equals(kodeMatkul)) {
                isContain = true;
                break;
            }
        }

        return isContain;
    }

    private static boolean isMatkulAdded(String kodeMatkul, Mahasiswa mahasiswa) {
        boolean isAdded = false;
        for (int index = 0; index < mahasiswa.getKrs().getMatkul().length; index++) {
            if (mahasiswa.getKrs().getMatkul()[index] != null) {
                if (mahasiswa.getKrs().getMatkul()[index].getKodeMatkul().equals(kodeMatkul))
                    isAdded = true;
            }
        }

        return isAdded;
    }

    private static void dataMahasiswa(Mahasiswa mahasiswa) {
        System.out.println();
        mahasiswa.dataMahasiswa();
        mahasiswa.tampilKRSMahasiswa();
    }
}
