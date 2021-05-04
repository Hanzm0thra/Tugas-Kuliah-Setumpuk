package sem1.triangle;

import java.util.Scanner;

public class Triangle3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        for (int count = num; count >= 1 ; count--){
            for (int stars = count; stars >= 1; stars--)
                System.out.print("*");
            System.out.println();
        }
    }
}
