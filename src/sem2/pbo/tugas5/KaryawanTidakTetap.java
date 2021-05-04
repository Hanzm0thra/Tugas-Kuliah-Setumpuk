package sem2.pbo.tugas5;

public class KaryawanTidakTetap extends Karyawan {

    private int jamKerja;
    private double gajiPerJam;
    private double gajiHarian;
    private double gajiLembur;

    KaryawanTidakTetap(String id, String nama, String alamat) {
        super(id, nama, alamat);
    }

    public void setJamKerja(int jamKerja) {
        this.jamKerja = jamKerja;
    }

    public int getJamKerja() {
        return jamKerja;
    }

    public void setGajiPerJam(double gajiPerJam) {
        this.gajiPerJam = gajiPerJam;
    }

    public double getGajiPerJam() {
        return gajiPerJam;
    }

    private double gajiHarian() {
        gajiHarian = jamKerja * gajiPerJam;
        return gajiHarian;
    }

    private double gajiLembur() {
        if (jamKerja > 40) {
            gajiLembur = 2 * gajiHarian;
        } else {
            gajiLembur = 0;
        }
        return gajiLembur;
    }

    //implement method override
    @Override
    public double perhitunganGaji() {
        return gajiHarian() + gajiLembur();
    }
}
