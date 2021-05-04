package sem2.pbo.praktikum.praktikum5;

public class MataKuliah {

    private String kodeMatkul;
    private String namaMatkul;
    private int sks;
    private Dosen dosen;


    public MataKuliah(String kodeMatkul, String namaMatkul, int sks, Dosen dosen) {
        this.kodeMatkul = kodeMatkul;
        this.namaMatkul = namaMatkul;
        this.sks = sks;
        this.dosen = dosen;
    }

    public String getKodeMatkul() {
        return kodeMatkul;
    }

    public String getNamaMatkul() {
        return namaMatkul;
    }

    public int getSks() {
        return sks;
    }

    public Dosen getDosen() {
        return dosen;
    }
}