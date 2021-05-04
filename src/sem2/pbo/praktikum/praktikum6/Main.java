package sem2.pbo.praktikum.praktikum6;

public class Main {

    public static void main(String[] args) {

        Pegawai[] pegawai = new Pegawai[9];

        //Object for PegawaiTetap
        pegawai[0] = new PegawaiTetap("Aldi", "12345678901", 2000000);
        pegawai[1] = new PegawaiTetap("Budi", "12345678911", 3500000);
        pegawai[2] = new PegawaiTetap("Caca", "12345678921", 4000000);

        //Object for PegawaiHarian
        pegawai[3] = new PegawaiHarian("Doni", "12345678932", 6000, 35);
        pegawai[4] = new PegawaiHarian("Eko", "12345678942", 7000, 40);
        pegawai[5] = new PegawaiHarian("Fahmi", "12345678952", 9500, 60);

        //Object for Sales
        pegawai[6] = new Sales("Gapi", "12345678963", 30, 25000);
        pegawai[7] = new Sales("Hani", "12345678973", 55, 20000);
        pegawai[8] = new Sales("Indah", "12345678983", 75, 35000);

        output(pegawai);
    }

    private static void output(Pegawai[] pegawai) {
        for (Pegawai obj: pegawai) {
            System.out.println(obj.toString());
        }
    }
}
