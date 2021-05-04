package sem2.pbo.tugas8.generic1.contravariant;

import sem2.pbo.tugas8.generic1.genericclass.Nilai;

public class ContravariantApp {

    public static void main(String[] args) {
        Nilai<Object> objectNilai = new Nilai<>("Innova");
        objectNilai.setData(1000);

        Nilai<? super String> stringNilai = objectNilai;
        System.out.println(stringNilai.getData());

        proses(stringNilai);
        System.out.println(stringNilai.getData());
    }

    public static void proses(Nilai<? super String> strNilai) {
        Object value = strNilai.getData();
        System.out.println("hasil dari strnilai adalah : " + value);

        strNilai.setData("Toyota Innova");
    }
}
