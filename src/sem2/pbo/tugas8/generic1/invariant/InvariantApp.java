package sem2.pbo.tugas8.generic1.invariant;

import sem2.pbo.tugas8.generic1.genericclass.Nilai;

public class InvariantApp {

    public static void main(String[] args) {
        Nilai<String> stringNilai = new Nilai<>("Makmur");
        //Nilai<Object> objectNilai = stringNilai;

        Nilai<Object> objectNilai = new Nilai<>(1000);
        //Nilai<Integer> integerNilai = objectNilai;

        //it's ok
        rekam(objectNilai);

        //it's not ok
        //rekam(stringNilai);
    }

    public static void rekam(Nilai<Object> objectNameNilai) {

    }
}
