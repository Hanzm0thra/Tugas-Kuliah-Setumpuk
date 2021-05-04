package sem2.pbo.praktikum.praktikum7.pascal;

import java.text.DecimalFormat;

abstract class BangunDatar {
    private String nama;
    static String[] listBangunDatar = new String[10];
    abstract public void info();
    static int counter = 0;

    public BangunDatar(){ }

    public BangunDatar(String nama) {
        this.nama = nama;
        listBangunDatar[counter] = nama;
        counter++;

    }

    public void tampil(){
        info();
    }

    public String getNama() {
        return nama;
    }

    public String[] getListBangunDatar() {
        return listBangunDatar;
    }

    public void setListBangunDatar(String[] listBangunDatar) {
        BangunDatar.listBangunDatar = listBangunDatar;
    }

    public void search(String input){
        int counter = 0;
        int sisi = 0;
        int sudut = 0;
        int tujuan = 0;

        System.out.println("\n................................................");
        System.out.print("Hasil Pencarian \t\t: ");

        for (int i = 0; i < listBangunDatar.length; i++) {
            if (listBangunDatar[i] == null) {
                break;
            } if (listBangunDatar[i].equalsIgnoreCase(input)) {
                counter++;
                tujuan = i;
            }
        }

        assert listBangunDatar[tujuan] != null;
        String yangDicari = listBangunDatar[tujuan].toLowerCase();
        switch (yangDicari) {
            case "segitiga" -> {
                sisi = 3;
                sudut = 3;
            } case "persegi" -> {
                sisi = 4;
                sudut = 4;
            } case "lingkaran" -> {
                sisi = 1;
                sudut = 0;
            } case "trapesium" -> {
                sisi = 4;
                sudut = 4;
            } case "layang" -> {
                sisi = 4;
                sudut = 4;
            }
        }

        if (counter > 0) {
            System.out.println("Bangun Datar " + input + " Ditemukan!");
            System.out.println("Jumlah " + input + "    \t: " + counter);
            System.out.println("Jumlah Sisi         \t: " + sisi);
            System.out.print("Jumlah Sudut        \t: " + sudut);
        } else {
            System.out.print("Bangun Datar " + input + " Tidak Detmukan!");
        } System.out.println("\n................................................");
    }

    public static BangunDatar getInstanceBangunDatarOf(Hitung bangun){
        BangunDatar bangunDatar = null;
        if(bangun instanceof Persegi)
            bangunDatar = (Persegi)bangun;
        else if(bangun instanceof Segitiga)
            bangunDatar = (Segitiga) bangun;
        else if(bangun instanceof Lingkaran)
            bangunDatar = (Lingkaran) bangun;
        else if(bangun instanceof Trapesium)
            bangunDatar = (Trapesium) bangun;
        else if(bangun instanceof LayangLayang)
            bangunDatar = (LayangLayang)bangun;
        return bangunDatar;
    }

}

class fungsiBangunDatar extends BangunDatar{

    public fungsiBangunDatar() {}

    @Override
    public void info() {
        System.out.println("---------------Informasi Bangun Datar---------------");
        for (int i = 0; i < listBangunDatar.length; i++) {
            if (listBangunDatar[i] == null) {
                break;
            } else {
                System.out.println((i+1) + ". " + listBangunDatar[i]);
            }
        }
    }
}



//============================== SEGITIGA ==============================

class Segitiga extends BangunDatar implements Hitung {
    private double alas;
    private double tinggi;

    public Segitiga(String nama, double alas, double tinggi) {
        super(nama);
        this.alas = alas;
        this.tinggi = tinggi;
    }

    @Override
    public double hitungLuas() {
        return alas * tinggi * 0.5;
    }

    @Override
    public double hitungKeliling() {
        double alasPitagoras = 0.5 * alas;
        double sisiMiring = Math.sqrt((alasPitagoras * alasPitagoras) + (tinggi * tinggi));
        return sisiMiring + sisiMiring + alas;
    }

    @Override
    public double hitungSpesial() {  // Segitiga selain siku-siku   ⃤   ◺
        double alasPitagoras = 0.5 * alas;
        return Math.sqrt((alasPitagoras * alasPitagoras) + (tinggi * tinggi));
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
}

//============================== PERSEGI ==============================

class Persegi extends BangunDatar implements Hitung {
    private double panjangSisi;

    public Persegi(String nama, double panjangSisi) {
        super(nama);
        this.panjangSisi = panjangSisi;
    }

    @Override
    public double hitungLuas() {
        return panjangSisi * panjangSisi;
    }

    @Override
    public double hitungKeliling() {
        return 4 * panjangSisi;
    }

    @Override
    public double hitungSpesial() {
        return Math.sqrt((panjangSisi * panjangSisi) + (panjangSisi * panjangSisi));
    }

    @Override
    public void info() {
        DecimalFormat output = new DecimalFormat("#.##");
        System.out.println("=================================================");
        System.out.println("Nama Bangun Datar  \t\t: " + super.getNama());
        System.out.println("Panjang Sisi       \t\t: " + this.panjangSisi);
        System.out.println("Nilai Luas         \t\t: " + output.format(hitungLuas()));
        System.out.println("Nilai Keliling     \t\t: " + output.format(hitungKeliling()));
        System.out.println("Nilai Spesial      \t\t: " + output.format(hitungSpesial()));
    }
}

//============================== LINGKARAN ==============================

class Lingkaran extends BangunDatar implements Hitung {
    private double jariJari;
    private static final double pi = 3.14;

    public Lingkaran(String nama, double jariJari) {
        super(nama);
        this.jariJari = jariJari;
    }

    @Override
    public double hitungLuas() {
        return pi * jariJari * jariJari;
    }

    @Override
    public double hitungKeliling() {
        return pi * (jariJari * 2);
    }

    @Override
    public double hitungSpesial() {
        double θ = 90;
        double tembereng = θ/360 * pi * jariJari * jariJari;
        double luasSegitiga = 0.5 * jariJari * jariJari * Math.sin(θ);
        return tembereng - luasSegitiga;
    }

    @Override
    public void info() {
        DecimalFormat output = new DecimalFormat("#.##");
        System.out.println("=================================================");
        System.out.println("Nama Bangun Datar  \t\t: " + super.getNama());
        System.out.println("Panjang Jari-jari  \t\t: " + this.jariJari);
        System.out.println("Nilai Luas         \t\t: " + output.format(hitungLuas()));
        System.out.println("Nilai Keliling     \t\t: " + output.format(hitungKeliling()));
        System.out.println("Nilai Spesial      \t\t: " + output.format(hitungSpesial()));
    }
}

//============================== TRAPESIUM ==============================

class Trapesium extends BangunDatar implements Hitung {
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
    public double hitungLuas() {
        return (alasAtas + alasBawah) * 0.5 * tinggi;
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
}

//============================== LAYANG-LAYANG ==============================

class LayangLayang extends BangunDatar implements Hitung {
    private double diagonal1;
    private double diagonal2;
    private double sisiMiring1;
    private double sisiMiring2;

    public LayangLayang(String nama, double diagonal1, double diagonal2, double sisiMiring1, double sisiMiring2) {
        super(nama);
        this.diagonal1 = diagonal1;
        this.diagonal2 = diagonal2;
        this.sisiMiring1 = sisiMiring1;
        this.sisiMiring2 = sisiMiring2;
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
}

//============================== HITUNG ==============================

interface Hitung {
    public double hitungLuas();
    public double hitungKeliling();
    public double hitungSpesial();
}

class AplikasiBangunDatar {
    public static void main(String[] args) {

//        Persegi persegi = new Persegi("Persegi", 5);
//        persegi.info();
//
//        Segitiga segitiga = new Segitiga("Segitiga Sama Kaki", 56, 67);
//        segitiga.info();
//
//        Lingkaran lingkaran = new Lingkaran("Lingkaran", 10);
//        lingkaran.info();
//
//        Trapesium trapesium = new Trapesium("Terapesiyum", 30, 40, 10);
//        trapesium.info();
//
//        LayangLayang layangLayang = new LayangLayang("Layang-layang", 6, 20, 5, 5);
//        layangLayang.info();

        BangunDatar bd[] = new BangunDatar[7];
        bd[0] = new Lingkaran("Lingkaran", 25);
        bd[1] = new Trapesium("Trapesium", 23, 67, 34);
        bd[2] = new Trapesium("Trapesium", 31, 17, 12);
        bd[3] = new Persegi("Persegi", 19);
        bd[4] = new Segitiga("Segitiga", 19, 45);
        bd[5] = new LayangLayang("Layang", 30, 15, 12, 22);
        bd[6] = new LayangLayang("Layang", 24, 40, 37, 13);

        BangunDatar b = new fungsiBangunDatar();
        b.info();
        for(int i = 0; i < bd.length; i++) {
            System.out.printf("================ Bangun Datar %d ====================\n", i+1);
            bd[i].info();
        }

        b.search("layang");
        b.search("LinGkarAn");
        b.search("perSEGi");
    }

}


