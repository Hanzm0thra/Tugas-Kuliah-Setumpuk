package sem2.pbo.praktikum.praktikum7;

import java.text.DecimalFormat;

public class Layang extends BangunDatar implements Hitung{
    private double diagonal1;
    private double diagonal2;
    private double sisiMiring1;
    private double sisiMiring2;

    public Layang(String nama, double diagonal1, double diagonal2, double sisiMiring1, double sisiMiring2) {
        super(nama);
        this.diagonal1 = diagonal1;
        this.diagonal2 = diagonal2;
        this.sisiMiring1 = sisiMiring1;
        this.sisiMiring2 = sisiMiring2;
    }

    @Override
    public void info() {
        DecimalFormat output = new DecimalFormat("#.##");
        System.out.println("=================================================");
        System.out.println("Nama Bangun Datar  \t\t: " + super.getNama());
        System.out.println("Panjang Diagonal 1 \t\t: " + this.diagonal1);
        System.out.println("Panjang Diagonal 2 \t\t: " + this.diagonal2);
        System.out.println("Panjang S. Miring 1\t\t: " + this.sisiMiring1);
        System.out.println("Panjang S. Miring 2\t\t: " + this.sisiMiring2);
        System.out.println("Nilai Luas         \t\t: " + output.format(hitungLuas()));
        System.out.println("Nilai Keliling     \t\t: " + output.format(hitungKeliling()));
        System.out.println("Nilai Spesial      \t\t: " + output.format(hitungSpesial()));
    }

    @Override
    public double hitungLuas() {
        return 0.5 * diagonal1 * diagonal2;
    }

    @Override
    public double hitungKeliling() {
        return 2 * (sisiMiring1 + sisiMiring2);
    }

    @Override
    public double hitungSpesial() {
        double alas = 0;
        double tinggi = 0;
        if (this.diagonal1 < this.diagonal2) {
            alas = this.diagonal1 / 2;
            if (this.sisiMiring1 < this.sisiMiring2) {
                tinggi = Math.sqrt((this.sisiMiring1 * this.sisiMiring1) - (alas * alas));
            } else {
                tinggi = Math.sqrt((this.sisiMiring2 * this.sisiMiring2) - (alas * alas));
            } return this.diagonal1 * tinggi / 2;
        } else if (this.diagonal2 < this.diagonal1) {
            alas = this.diagonal2 / 2;
            if (this.sisiMiring1 < this.sisiMiring2) {
                tinggi = Math.sqrt((this.sisiMiring1 * this.sisiMiring1) - (alas * alas));
            } else {
                tinggi = Math.sqrt((this.sisiMiring2 * this.sisiMiring2) - (alas * alas));
            } return this.diagonal2 * tinggi / 2;
        } else {
            return 0;
        }
    }
}
