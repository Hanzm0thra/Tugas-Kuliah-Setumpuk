package sem2.pbo.praktikum.praktikum3;

import java.util.Scanner;

public class PinjamanOnline {
    private static double saldoSistem = 5_000_000.00;
    private double nominalPeminjaman = 0;
    public String nama;
    private int lamaPeminjaman = 0;

    PinjamanOnline(String nama) {
        this.nama = nama;
    }

    public double getSaldoSistem() {
        return saldoSistem;
    }

    public double setSaldoSistem(double saldoSistem) {
        return saldoSistem;
    }

    public double setNominal(double nominal) {
        return nominal;
    }

    public double getNominalPeminjaman() {
        return nominalPeminjaman;
    }

    public int setJangkaWaktu(int jangkaWaktu) {
        return jangkaWaktu;
    }

    public int getLamaPeminjaman() {
        return lamaPeminjaman;
    }

    public void pinjam() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("" +
                "\nSelamat datang, Sdr. " + nama +
                "\nMasukkan nominal yang ingin anda pinjam: "
        );
        double tempPinjaman = setNominal(scanner.nextDouble());
        System.out.println("Masukkan lama peminjaman: ");
        int tempLamaPeminjaman = setJangkaWaktu(scanner.nextInt());

        if (lamaPeminjaman != 0) {
            System.out.println("Anda perlu untuk melunasi peminjaman anda sebelumnya");
        } else if (saldoSistem < tempPinjaman) {
            System.out.println("Mohon maaf, saldo di sistem kami tidak mencukupi untuk melakukan peminjaman kepada anda ");
        } else {
            nominalPeminjaman = tempPinjaman;
            lamaPeminjaman = tempLamaPeminjaman;
            saldoSistem = saldoSistem - nominalPeminjaman;
            System.out.println("Selamat, peminjaman anda berhasil");
        }
    }

    public void kembalikan() {
        Scanner scanner = new Scanner(System.in);
        int tempKeterlambatanHari;
        int denda;
        System.out.println("" +
                "\nSelamat datang, Sdr. " + nama +
                "\nMasukkan nominal yang ingin anda kembalikan: "
        );

        double nominalKembalikan = setNominal(scanner.nextDouble());
        System.out.println("Masukkan lama pengembalian: ");
        int waktuLamaPengembalian = setJangkaWaktu(scanner.nextInt());

        //pengembalian berhasil
        if(lamaPeminjaman != 0 && waktuLamaPengembalian <= lamaPeminjaman) {
            if (nominalKembalikan == nominalPeminjaman) {
                nominalPeminjaman = 0;
                lamaPeminjaman = 0;
                saldoSistem = saldoSistem + nominalKembalikan;
                System.out.println("Terima kasih telah melunasi pinjaman");
            } else {
                nominalPeminjaman = nominalPeminjaman - nominalKembalikan;
                saldoSistem = saldoSistem + nominalKembalikan;
                System.out.println("Terima kasih telah mencicil pembayaran");
            }
        } else if (lamaPeminjaman != 0) {
            tempKeterlambatanHari = waktuLamaPengembalian - lamaPeminjaman;
            denda = 15000 * tempKeterlambatanHari;
            nominalPeminjaman = nominalPeminjaman + denda;
            if (nominalKembalikan > denda) {
                if (nominalKembalikan == nominalPeminjaman) {
                    nominalPeminjaman = 0;
                    lamaPeminjaman = 0;
                    saldoSistem = saldoSistem + nominalKembalikan;
                    System.out.println("Terima kasih telah melunasi pinjaman");
                } else {
                    nominalPeminjaman = nominalPeminjaman - nominalKembalikan;
                    saldoSistem = saldoSistem + nominalKembalikan;
                    System.out.println("Terima kasih telah mencicil pembayaran");
                }
            }
        }
    }
}