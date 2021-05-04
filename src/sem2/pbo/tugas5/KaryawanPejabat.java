package sem2.pbo.tugas5;

public class KaryawanPejabat extends KaryawanTetap {

    private final double TAMBAHAN_GAJI = 0.2;
    private String jabatan;

    KaryawanPejabat(String id, String nama, String alamat) {
        super(id, nama, alamat);
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getJabatan() {
        return jabatan;
    }

    //implement method override
    @Override
    public double perhitunganGaji() {
        return getGaji() + (getGaji() * TAMBAHAN_GAJI);
    }
}
