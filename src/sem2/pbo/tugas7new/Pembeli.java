package sem2.pbo.tugas7new;

import sem2.pbo.tugas7new.Barang;
import sem2.pbo.tugas7new.Pembayaran;

import java.util.ArrayList;

class Pembeli implements Pembayaran {

    private String id;
    private String nama;
    private int jumlahBarang;
    ArrayList<Barang> semuaBarang = new ArrayList<>();
    ArrayList<Barang> barangDiskon = new ArrayList<>();

    public Pembeli(String id, String nama, int jumlahBarang) {
        this.id = id;
        this.nama = nama;
        this.jumlahBarang = jumlahBarang;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public int getJumlahBarang() {
        return jumlahBarang;
    }

    public void masukkanBarang(Barang barang) {
        this.semuaBarang.add(barang);
    }

    public void masukkanBarangDiskon(Barang barang) {

    }

    @Override
    public double bayar() {
        double totalBelanja = 0;
        for (Barang obj: semuaBarang) {
            totalBelanja = totalBelanja + (obj.harga() * jumlahBarang);
        }
        return totalBelanja;
    }

    @Override
    public double bayarDiskon() {
        return 0;
    }


}
