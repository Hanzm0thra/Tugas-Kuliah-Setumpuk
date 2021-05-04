package sem2.asd.praktikum.array;

import java.util.Arrays;
import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = scanner.nextInt();
        int rangeOfJump = scanner.nextInt();

        int result = 0;
        int temp = 0;
        int[] arena = new int[length];

       for (int count = 1; count <= length; count++) {
           temp = (temp + rangeOfJump) % length;
           if (arena[temp] != 0) break;
           arena[temp] = count;
       }

      for (int eachValue: arena) {
          result = result + eachValue;
      }

      System.out.println(result);
    }
}
