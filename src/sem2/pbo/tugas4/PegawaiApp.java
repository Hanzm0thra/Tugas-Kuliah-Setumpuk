package sem2.pbo.tugas4;

public class PegawaiApp {
    public static void main(String[] args) {
        //create the object from PegawaiPNS, PegawaiKontrak, dan PejabatDinas
        PegawaiPNS pegawaiPNS = new PegawaiPNS("jalan sekar no. 4", "adi", "Bagian Keuangan");
        pegawaiPNS.setGajiPokok(5000000);
        pegawaiPNS.setHonorLembur(300000);
        pegawaiPNS.setUangMakan(100000);
        pegawaiPNS.buatLaporanKerja(100, 98);
        System.out.println();

        PegawaiKontrak pegawaiKontrak = new PegawaiKontrak("jalan merdeka no. 7", "budi", "Bagian Keuangan");
        pegawaiKontrak.setHonorHarian(100000);

        PejabatDinas pejabatDinas = new PejabatDinas("jalan kenanga no. 11", "umar", "Bagian Keuangan");
        pejabatDinas.buatLaporanKerja(100, 85);
        pejabatDinas.setTunjanganJabatan(10000000);

        //create object from Pegawai
        Pegawai pegawai = new Pegawai("jalan sekar no. 4", "adi", "Bagian Keuangan");
        pegawai.setAlamat("jalan sekar no. 4");
        pegawai.setNama("adi");
        pegawai.setUnitKerja("Bagian Keuangan");
        //implement polymorphism
        pegawai = new PejabatDinas("jalan sekar no. 4", "adi", "Bagian Keuangan");
    }
}
