package sem1.triangle;

import java.util.Scanner;

public class Triangle1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        for (int count = 1; count <= num; count++){
            for (int stars = 1; stars <= count; stars++)
                System.out.print("*");
            System.out.println();
        }
    }
}
