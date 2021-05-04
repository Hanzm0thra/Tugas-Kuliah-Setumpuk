package sem2.pbo.praktikum.praktikum5;

public class Mahasiswa extends CivitasAkademik {

    private String nim;
    private KRS krs;

    public Mahasiswa(String nim, String nama, String prodi, String fakultas) {
        super(nama, prodi, fakultas);
        this.nim = nim;
        krs = new KRS();
    }

    public void tambahMatkul(MataKuliah mataKuliah) {
        krs.tambahMatkulKRS(mataKuliah, this.getNama());
    }

    public void tampilKRSMahasiswa() {
        krs.tampilKRS();
    }

    public void dataMahasiswa() {
        System.out.printf("""
                                                
                        NAMA    \t: %s
                        NIM     \t: %s
                        PRODI   \t: %s
                        FAKULTAS\t: %s
                        """,
                this.getNama(), this.nim, this.getProdi(), this.getFakultas());
    }

    public int sksTerambil() {
        return krs.getCountSKS();
    }

    public KRS getKrs() {
        return krs;
    }
}
