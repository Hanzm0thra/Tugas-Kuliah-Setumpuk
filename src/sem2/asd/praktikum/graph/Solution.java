package sem2.asd.praktikum.graph;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] numbers = input.split(" ", -1);

        int p = Integer.parseInt(numbers[0]);
        int l = Integer.parseInt(numbers[1]);
        int k = Integer.parseInt(numbers[2]);
        int line = 1;

        for (int i = 1; i <= p; i++) {
            if (p - line < k) {
                for (int j = 1; j <= l; j++) {
                    System.out.print("U");
                }
            } else {
                for (int j = 1; j <= l; j++) {
                    if (j <= k || j > l - k) {
                        System.out.print("U");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            line++;
            System.out.println();
        }
    }
}
