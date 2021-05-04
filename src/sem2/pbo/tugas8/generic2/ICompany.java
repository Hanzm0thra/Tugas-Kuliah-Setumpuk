package sem2.pbo.tugas8.generic2;

public interface ICompany {

    PegawaiTetap pegawaiHarianToPegawaiTetap(PegawaiHarian pegawaiHarian);
    Direktur pegawaiTetapToDirektur(PegawaiTetap pegawaiTetap);
    PegawaiHarian pegawaiTetapToPegawaiHarian(PegawaiTetap pegawaiTetap);
}
