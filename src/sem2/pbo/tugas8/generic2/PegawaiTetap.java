package sem2.pbo.tugas8.generic2;

public class PegawaiTetap extends Pegawai {

    public PegawaiTetap(String nama, String noKTP, String alamat, double gaji) {
        super(nama, noKTP, alamat, gaji);
    }

    @Override
    public String getNama() {
        return super.getNama();
    }

    @Override
    public String getNoKTP() {
        return super.getNoKTP();
    }

    @Override
    public String getAlamat() {
        return super.getAlamat();
    }

    @Override
    public double getGaji() {
        return super.getGaji();
    }

    @Override
    public String toString() {
        return super.toString() +
                "Jabatan: Pegawai Tetap" + "\n";
    }
}
