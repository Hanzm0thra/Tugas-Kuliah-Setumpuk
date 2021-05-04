package sem1.praktikum1;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int jumlahAngka = input.nextInt();
        int jumlahTambah = input.nextInt();
        for (int i = 1; i <= jumlahAngka; i++){
            int angka = input.nextInt();
            System.out.println(angka + jumlahTambah);
        }
    }
}
