package sem1.praktikum1;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Baris Pertama
        String firstRow = scanner.nextLine();
        char first = firstRow.charAt(0);
        char second = firstRow.charAt(2);
        char third = firstRow.charAt(4);
        //Baris Kedua
        String secondRow = scanner.nextLine();
        char fourth = secondRow.charAt(0);
        char fifth = secondRow.charAt(2);
        char sixth = secondRow.charAt(4);
        //Baris Ketiga
        String thirdRow = scanner.nextLine();
        char seventh = thirdRow.charAt(0);
        char eight = thirdRow.charAt(2);
        char ninth = thirdRow.charAt(4);

        //ASCII O = 79 & X = 88
        //All Case
        int firstVertical = first + fourth + seventh;
        int secondVertical = second + fifth + eight;
        int thirdVertical = third + sixth + ninth;
        int firstHorizontal = first + second + third;
        int secondHorizontal = fourth + fifth + sixth;
        int thirdHorizontal = seventh + eight + ninth;
        int diagonalLeftToRight = first + fifth + ninth;
        int diagonalRightToLeft = third + fifth + seventh;

        if (firstVertical == 264
                || secondVertical == 264
                || thirdVertical == 264
                || firstHorizontal == 264
                || secondHorizontal == 264
                || thirdHorizontal == 264
                || diagonalLeftToRight == 264
                || diagonalRightToLeft == 264)
            System.out.println("X menang");
        else if (firstVertical == 237
                || secondVertical == 237
                || thirdVertical == 237
                || firstHorizontal == 237
                || secondHorizontal == 237
                || thirdHorizontal == 237
                || diagonalLeftToRight == 237
                || diagonalRightToLeft == 237)
            System.out.println("O menang");
        else
            System.out.println("Draw");
    }
}