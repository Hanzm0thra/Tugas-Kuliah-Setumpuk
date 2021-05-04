package sem2.pbo.tugas8.generic2;

import java.util.ArrayList;
import java.util.List;

public class Company implements ICompany{

    private List<PegawaiTetap> pegawaiTetaps = new ArrayList<>();
    private List<PegawaiHarian> pegawaiHarians = new ArrayList<>();
    private List<Direktur> direkturs = new ArrayList<>();


    @Override
    public PegawaiTetap pegawaiHarianToPegawaiTetap(PegawaiHarian pegawaiHarian) {
        Change<PegawaiHarian, PegawaiTetap> result = new Change<>() {
            @Override
            PegawaiTetap changes(PegawaiHarian pegawaiHarian) {
                return new PegawaiTetap(
                        pegawaiHarian.getNama(),
                        pegawaiHarian.getNoKTP(),
                        pegawaiHarian.getAlamat(),
                        pegawaiHarian.getGaji() + 2000000
                );
            }
        };

        pegawaiTetaps.add(result.changes(pegawaiHarian));
        return result.changes(pegawaiHarian);
    }

    @Override
    public Direktur pegawaiTetapToDirektur(PegawaiTetap pegawaiTetap) {
        Change<PegawaiTetap, Direktur> result = new Change<>() {
            @Override
            Direktur changes(PegawaiTetap pegawaiTetap) {
                return new Direktur(
                        pegawaiTetap.getNama(),
                        pegawaiTetap.getNoKTP(),
                        pegawaiTetap.getAlamat(),
                        pegawaiTetap.getGaji() + 7000000
                );
            }
        };

        direkturs.add(result.changes(pegawaiTetap));
        return result.changes(pegawaiTetap);
    }

    @Override
    public PegawaiHarian pegawaiTetapToPegawaiHarian(PegawaiTetap pegawaiTetap) {
        Change<PegawaiTetap, PegawaiHarian> result = new Change<>() {
            @Override
            PegawaiHarian changes(PegawaiTetap pegawaiTetap) {
                return new PegawaiHarian(
                        pegawaiTetap.getNama(),
                        pegawaiTetap.getNoKTP(),
                        pegawaiTetap.getAlamat(),
                        pegawaiTetap.getGaji() - 1500000
                );
            }
        };

        pegawaiHarians.add(result.changes(pegawaiTetap));
        return result.changes(pegawaiTetap);
    }

    public List<PegawaiTetap> getPegawaiTetaps() {
        return pegawaiTetaps;
    }

    public List<Direktur> getDirekturs() {
        return direkturs;
    }

    public List<PegawaiHarian> getPegawaiHarians() {
        return pegawaiHarians;
    }
}
