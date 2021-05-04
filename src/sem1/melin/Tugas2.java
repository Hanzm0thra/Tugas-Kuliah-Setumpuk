package sem1.melin;

import java.util.Scanner;

public class Tugas2 {
    public static void main(String[] args) {
        int realNum = 36, expectedNum;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Guess a number between 1 and 100! ");
        expectedNum = scanner.nextInt();
        do {
            if (expectedNum > realNum){
                System.out.print("Too high! ");
                expectedNum = scanner.nextInt();
            } else if (expectedNum < realNum){
                System.out.print("Too low! ");
                expectedNum = scanner.nextInt();
            } else{
                break;
            }
        }while (expectedNum != realNum);
        System.out.println("Correct!");
    }
}
