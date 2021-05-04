package sem2.pbo.tugas5;

public class KaryawanTetap extends Karyawan {

    private double gaji;

    KaryawanTetap(String id, String nama, String alamat) {
        super(id, nama, alamat);
    }

    public void setGaji(double gaji) {
        this.gaji = gaji;
    }

    public double getGaji() {
        return gaji;
    }

    //implement method override
    @Override
    public double perhitunganGaji() {
        return this.gaji;
    }
}
