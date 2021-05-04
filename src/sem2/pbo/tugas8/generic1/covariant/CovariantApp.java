package sem2.pbo.tugas8.generic1.covariant;

import sem2.pbo.tugas8.generic1.genericclass.Nilai;

public class CovariantApp {
    public static void main(String[] args) {
        Nilai<String> stringNilai = new Nilai<>("vape");
        proses(stringNilai);
        Nilai<? extends Object> objectNilai = stringNilai;
        proses(objectNilai);
    }

    public static void proses (Nilai<? extends Object> merkDagang) {

        //read only
        //merkDagang.setData(34);
        System.out.println(merkDagang.getData());
    }
}
