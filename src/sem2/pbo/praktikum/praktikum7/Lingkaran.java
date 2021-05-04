package sem2.pbo.praktikum.praktikum7;

import java.text.DecimalFormat;

public class Lingkaran extends BangunDatar implements Hitung {
    private double jari;
    private static final double pi = Math.PI;

    public Lingkaran(String nama, double jari) {
        super(nama);
        this.jari = jari;
    }

    @Override
    public void info() {
        DecimalFormat output = new DecimalFormat("#.##");
        System.out.println("=================================================");
        System.out.println("Nama Bangun Datar  \t\t: " + super.getNama());
        System.out.println("Panjang Jari-jari  \t\t: " + this.jari);
        System.out.println("Nilai Luas         \t\t: " + output.format(hitungLuas()));
        System.out.println("Nilai Keliling     \t\t: " + output.format(hitungKeliling()));
        System.out.println("Nilai Spesial      \t\t: " + output.format(hitungSpesial()));
    }

    @Override
    public double hitungLuas() {
        return pi * jari * jari;
    }

    @Override
    public double hitungKeliling() {
        return pi * (jari * 2);
    }

    @Override
    public double hitungSpesial() {
        double degree = 90;
        double tembereng = degree/360 * pi * jari * jari;
        double luasSegitiga = 0.5 * jari * jari * Math.sin(degree);
        return tembereng - luasSegitiga;
    }
}
