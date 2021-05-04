package sem2.pbo.tugas8.generic1.genericmethod;

public class ArrayCounterApp {

    public static void main(String[] args) {
        String[] nama = {"ana", "ani", "ano"};
        Integer[] nomor = {1, 2, 3, 4, 5, 6 ,7, 8, 9};

        System.out.println(ArrayCounter.count(nama));
        System.out.println(ArrayCounter.count(nomor));
    }
}
