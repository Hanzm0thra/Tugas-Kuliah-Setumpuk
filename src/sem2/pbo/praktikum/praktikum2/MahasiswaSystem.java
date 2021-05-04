package sem2.pbo.praktikum.praktikum2;

public class MahasiswaSystem {
    public static int getJumlahTotalMahasiswa() {
        return DatabaseMahasiswa.size;
    }

    public static String kelulusan(int nilaiAkhir) {
        if (nilaiAkhir >= DatabaseMahasiswa.KKM) {
            return "LULUS";
        } else {
            return "MENGULANG";
        }
    }
}
