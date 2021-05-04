package sem2.pbo.praktikum.praktikum7;

import java.text.DecimalFormat;

public class Trapesium extends BangunDatar implements Hitung{
    private double alasAtas;
    private double alasBawah;
    private double tinggi;

    public Trapesium(String nama, double alasAtas, double alasBawah, double tinggi) {
        super(nama);
        this.alasAtas = alasAtas;
        this.alasBawah = alasBawah;
        this.tinggi = tinggi;
    }

    @Override
    public void info() {
        DecimalFormat output = new DecimalFormat("#.##");
        System.out.println("=================================================");
        System.out.println("Nama Bangun Datar  \t\t: " + super.getNama());
        System.out.println("Panjang Alas Atas  \t\t: " + this.alasAtas);
        System.out.println("Panjang Alas Bawah \t\t: " + this.alasBawah);
        System.out.println("Panjang Tinggi     \t\t: " + this.tinggi);
        System.out.println("Nilai Luas         \t\t: " + output.format(hitungLuas()));
        System.out.println("Nilai Keliling     \t\t: " + output.format(hitungKeliling()));
        System.out.println("Nilai Spesial      \t\t: " + output.format(hitungSpesial()));
    }

    @Override
    public double hitungLuas() {
        return  (alasAtas + alasBawah) * 0.5 * tinggi;
    }

    @Override
    public double hitungKeliling() {
        double alas = alasBawah - alasAtas;
        double sisiMiring = Math.sqrt((alas * alas) + (tinggi * tinggi));
        return alasAtas + alasBawah + (sisiMiring * 2);
    }

    @Override
    public double hitungSpesial() {
        return (alasAtas * tinggi);
    }
}
