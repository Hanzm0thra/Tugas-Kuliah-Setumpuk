package sem2.pbo.praktikum.praktikum5;

public class Dosen extends CivitasAkademik {

    private String nidn;

    public Dosen(String nidn, String nama, String prodi, String fakultas) {
        super(nama, prodi, fakultas);
        this.nidn = nidn;
    }

    public String getNidn() {
        return nidn;
    }
}
