package sem2.pbo.praktikum.praktikum7;

import java.text.DecimalFormat;

public class Persegi extends BangunDatar implements Hitung{
    private double panjangSisi;

    public Persegi(String nama, double panjangSisi) {
        super(nama);
        this.panjangSisi = panjangSisi;
    }

    @Override
    public void info() {
        DecimalFormat output = new DecimalFormat("#.##");
        System.out.println("=================================================");
        System.out.println("Nama Bangun Datar  \t\t: " + super.getNama());
        System.out.println("Panjang Sisi       \t\t: " + panjangSisi);
        System.out.println("Nilai Luas         \t\t: " + output.format(hitungLuas()));
        System.out.println("Nilai Keliling     \t\t: " + output.format(hitungKeliling()));
        System.out.println("Nilai Spesial      \t\t: " + output.format(hitungSpesial()));
    }

    @Override
    public double hitungLuas() {
        return Math.pow(panjangSisi, 2);
    }

    @Override
    public double hitungKeliling() {
        return 4 * panjangSisi;
    }

    @Override
    public double hitungSpesial() {
        return Math.sqrt((panjangSisi * panjangSisi) + (panjangSisi * panjangSisi));
    }
}
