package sem2.pbo.praktikum.praktikum7;

import java.text.DecimalFormat;

public class Segitiga extends BangunDatar implements Hitung{

    private double alas;
    private double tinggi;

    Segitiga(String nama, double alas, double tinggi) {
        super(nama);
        this.alas = alas;
        this.tinggi = tinggi;
    }


    @Override
    public void info() {
        DecimalFormat output = new DecimalFormat("#.##");
        System.out.println("=================================================");
        System.out.println("Nama Bangun Datar  \t\t: " + super.getNama());
        System.out.println("Panjang Alas       \t\t: " + this.alas);
        System.out.println("Panjang Tingggi    \t\t: " + this.tinggi);
        System.out.println("Nilai Luas         \t\t: " + output.format(hitungLuas()));
        System.out.println("Nilai Keliling     \t\t: " + output.format(hitungKeliling()));
        System.out.println("Nilai Spesial      \t\t: " + output.format(hitungSpesial()));
    }

    @Override
    public double hitungLuas() {
        return 0.5 * alas * tinggi;
    }

    @Override
    public double hitungKeliling() {
        double alasPitagoras = 0.5 * alas;
        double sisiMiring = Math.sqrt((alasPitagoras * alasPitagoras) + (tinggi * tinggi));
        return sisiMiring + sisiMiring + alas;
    }

    @Override
    public double hitungSpesial() {
        double alasPitagoras = 0.5 * alas;
        return Math.sqrt((alasPitagoras * alasPitagoras) + (tinggi * tinggi));
    }
}
