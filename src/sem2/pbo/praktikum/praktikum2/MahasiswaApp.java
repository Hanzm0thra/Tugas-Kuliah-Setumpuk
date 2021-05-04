package sem2.pbo.praktikum.praktikum2;

public class MahasiswaApp {
    public static void main(String[] args) {

        DatabaseMahasiswa mahasiswa1 = new DatabaseMahasiswa();
        setMahasiswa(mahasiswa1, "Budi", "205150200111xxx", "Jalan Mawar No. 7", "Teknik Informatika", 92);
        getDataMahasiswa(mahasiswa1);

        DatabaseMahasiswa mahasiswa2 = new DatabaseMahasiswa();
        setMahasiswa(mahasiswa2, "Andi", "205150201111xxx", "Jalan Merdeka No. 54", "Teknik Informatika", 78);
        getDataMahasiswa(mahasiswa2);

        DatabaseMahasiswa mahasiswa3 = new DatabaseMahasiswa();
        setMahasiswa(mahasiswa3, "Ayu", "205150201111xxx", "Jalan Surabaya No. 32", "Teknik Informatika", 88);
        getDataMahasiswa(mahasiswa3);

        System.out.println("Jumlah mahasiswa terdaftar: " + MahasiswaSystem.getJumlahTotalMahasiswa());
    }

    private static void setMahasiswa(DatabaseMahasiswa mahasiswa, String nama, String nim, String alamat, String prodi, int nilaiAkhir) {
        mahasiswa.setNama(nama);
        mahasiswa.setNim(nim);
        mahasiswa.setAlamat(alamat);
        mahasiswa.setProdi(prodi);
        mahasiswa.setNilaiAkhir(nilaiAkhir);
    }

    private static void getDataMahasiswa(DatabaseMahasiswa mahasiswa) {
        System.out.println("========================================================");
        System.out.println(
                "Mahasiswa dengan identitas sebagai berikut: "
                        + "\nNama: " + mahasiswa.getNama()
                        + "\nNim: " + mahasiswa.getNim()
                        + "\nAlamat: " + mahasiswa.getAlamat()
                        + "\nProdi: " + mahasiswa.getProdi()
                        + "\nDINYATAKAN " + MahasiswaSystem.kelulusan(mahasiswa.getNilaiAkhir())
        );
        System.out.println("========================================================");
    }
}