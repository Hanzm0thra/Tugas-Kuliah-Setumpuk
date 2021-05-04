package sem2.pbo.praktikum.praktikum5;

public class No1 {

    public static void main(String[] args) {

        Dosen[] dosen = new Dosen[7];

        dosen[0] = new Dosen("000", "Adi Sucipto", "TIF", "FILKOM");
        dosen[1] = new Dosen("111", "Budi Harsadi", "TIF", "FILKOM");
        dosen[2] = new Dosen("222", "Campaka Cocoki", "TEKKOM" ,"FILKOM");
        dosen[3] = new Dosen("333", "Doni Ananta", "SI", "FILKOM");
        dosen[4] = new Dosen("444", "Erna Sulastri", "SI", "FILKOM");
        dosen[5] = new Dosen("555", "Fara", "TI", "FILKOM");
        dosen[6] = new Dosen("666", "Gina Haryadi", "PTI", "FILKOM");

        MataKuliah[] mataKuliah = new MataKuliah[10];

        mataKuliah[0] = new MataKuliah("MATKUL01", "Pemrograman Dasar", 4, dosen[0]);
        mataKuliah[1] = new MataKuliah("MATKUL02", "Statistika dan Teori Peluang", 3, dosen[1]);
        mataKuliah[2] = new MataKuliah("MATKUL03", "Sistem Operasi", 4, dosen[2]);
        mataKuliah[3] = new MataKuliah("MATKUL04", "Pemrograman Lanjut", 5,dosen[3]);
        mataKuliah[4] = new MataKuliah("MATKUL05", "Bahasa Indonesia", 3, dosen[4]);
        mataKuliah[5] = new MataKuliah("MATKUL06", "Kewirausahaan", 2, dosen[5]);
        mataKuliah[6] = new MataKuliah("MATKUL07", "Bahasa Inggris", 2, dosen[6]);
        mataKuliah[7] = new MataKuliah("MATKUL08", "Algoritma dan Struktur Data", 4, dosen[2]);
        mataKuliah[8] = new MataKuliah("MATKUL09", "Aljabar Linear", 3, dosen[4]);
        mataKuliah[9] = new MataKuliah("MATKUL010", "Kalkulus", 3, dosen[6]);

        Mahasiswa[] mahasiswa = new Mahasiswa[2];

        mahasiswa[0] = new Mahasiswa("205150201111038", "Kylix Eza Saputra", "TIF", "FILKOM");
        mahasiswa[1] = new Mahasiswa("195150627111021", "Fahmi", "TIF", "FILKOM");

        mahasiswa[0].dataMahasiswa();
        mahasiswa[0].tambahMatkul(mataKuliah[0]);
        mahasiswa[0].tambahMatkul(mataKuliah[1]);
        mahasiswa[0].tambahMatkul(mataKuliah[2]);
        mahasiswa[0].tambahMatkul(mataKuliah[3]);
        mahasiswa[0].tambahMatkul(mataKuliah[7]);
        mahasiswa[0].tambahMatkul(mataKuliah[8]);
        mahasiswa[0].tampilKRSMahasiswa();

        mahasiswa[1].dataMahasiswa();
        mahasiswa[1].tambahMatkul(mataKuliah[0]);
        mahasiswa[1].tambahMatkul(mataKuliah[1]);
        mahasiswa[1].tambahMatkul(mataKuliah[2]);
        mahasiswa[1].tambahMatkul(mataKuliah[3]);
        mahasiswa[1].tambahMatkul(mataKuliah[4]);
        mahasiswa[1].tambahMatkul(mataKuliah[5]);
        mahasiswa[1].tambahMatkul(mataKuliah[6]);
        mahasiswa[1].tambahMatkul(mataKuliah[7]);
        mahasiswa[1].tambahMatkul(mataKuliah[8]);
        mahasiswa[1].tambahMatkul(mataKuliah[9]);
        mahasiswa[1].tampilKRSMahasiswa();
    }
}
