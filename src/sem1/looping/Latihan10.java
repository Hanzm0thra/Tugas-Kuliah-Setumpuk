package sem1.looping;

import java.util.Scanner;

public class Latihan10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan angka hari: ");
        int day = scanner.nextInt();
        int changeDay = 0;
        int counter = 0;
        do{
            changeDay++;
            if (changeDay == 8)
                changeDay = 1;
            System.out.printf("%d ", changeDay);
            day--;
        }while(day >= 1);
    }
}
