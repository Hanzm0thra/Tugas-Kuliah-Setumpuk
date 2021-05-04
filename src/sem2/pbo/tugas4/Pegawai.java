package sem2.pbo.tugas4;

public class Pegawai {
    private String alamat;
    private String nama;
    private String unitKerja;

    Pegawai(String alamat, String nama, String unitKerja) {
        this.alamat = alamat;
        this.nama = nama;
        this.unitKerja = unitKerja;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setUnitKerja(String unitKerja) {
        this.unitKerja = unitKerja;
    }
}

class PegawaiPNS extends Pegawai {
    private int gajiPokok;
    private int honorLembur;
    private int uangMakan;

    PegawaiPNS(String alamat, String nama, String unitKerja) {
        super(alamat, nama, unitKerja);
    }

    public void buatLaporanKerja(int target, int realisasi) {
        System.out.println("" +
                "Target Capaian Tahunan " + getClass().getSimpleName() +
                "\nTarget: " + target + "%" +
                "\nRealisasi: " + realisasi + "%"
        );
    }

    public void setGajiPokok(int gajiPokok) {
        this.gajiPokok = gajiPokok;
    }

    public void setHonorLembur(int honorLembur) {
        this.honorLembur = honorLembur;
    }

    public void setUangMakan(int uangMakan) {
        this.uangMakan = uangMakan;
    }
}

class PegawaiKontrak extends Pegawai{
    private int honorHarian;

    PegawaiKontrak(String alamat, String nama, String unitKerja) {
        super(alamat, nama, unitKerja);
    }

    public void setHonorHarian(int honorHarian) {
        this.honorHarian = honorHarian;
    }
}

class PejabatDinas extends PegawaiPNS {
    private int MasaJabatan;
    private String namaJabatan;
    private int tunjanganJabatan;

    PejabatDinas(String alamat, String nama, String unitKerja) {
        super(alamat, nama, unitKerja);
    }

    @Override
    public void buatLaporanKerja(int target, int realisasi) {
        super.buatLaporanKerja(target, realisasi);
        System.out.println("" +
                "Target Capaian Dinas "  +
                "\nTarget: " + target + "%" +
                "\nRealisasi: " + (realisasi ) + "%"
        );
    }

    public void setTunjanganJabatan(int tunjanganJabatan) {
        this.tunjanganJabatan = tunjanganJabatan;
    }
}