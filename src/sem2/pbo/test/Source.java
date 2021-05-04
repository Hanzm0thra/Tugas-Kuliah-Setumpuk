package sem2.pbo.test;

import java.util.ArrayList;

public class Source {

    static String  nama;

    public static void setNama(String nama) {
        Source.nama = nama;
    }

    public static String getNama() {
        return Source.nama;
    }

    static ArrayList<Integer> number = new ArrayList<>();

    public static void main(String[] args) {
        number.add(1);
        number.add(2);
        number.add(3);
        number.set(0, 4);

        System.out.println(number);
    }
}
