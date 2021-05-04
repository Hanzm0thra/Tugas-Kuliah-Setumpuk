package sem1.simpleproses;

import java.util.Scanner;

public class Latihan7 {
    public static void main(String[] args) {
        int z, n, f = 10, b = 11;
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        z = (n > 0)? f : b;
        System.out.println(z);
    }
}

/*
Perhatikan conditional expression diatas, bolehkah sekiranya variabel  f dan b memiliki tipe data yang berbeda?

Tidak boleh, karena pada dasarnya tipe data f dan b berdasarkan tipe data variabel z. Jika tipe data variabel f dan b berbeda
dengan kata lain akan berbeda dengan tipe data dari varaibel z. Oleh karena itu, tipe data f dan b tidak boleh berbeda,
jika ingin berbeda maka harus melakukan konservasi ke tipe data yang sesuai dengan tipe data variabel z
 */


