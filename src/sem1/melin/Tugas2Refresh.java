package sem1.melin;

import java.util.Scanner;

public class Tugas2Refresh {
    public static void main(String[] args) {
        int expectedNum, realNum = 36;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Guess a number between 1 and 100! ");
        expectedNum = scanner.nextInt();
        for (;expectedNum != realNum;){
            if (expectedNum > realNum){
                System.out.print("Too high! ");
                expectedNum = scanner.nextInt();
            } else {
                System.out.print("Too low! ");
                expectedNum = scanner.nextInt();
            }
        }
        System.out.println("Correct!");
    }
}
