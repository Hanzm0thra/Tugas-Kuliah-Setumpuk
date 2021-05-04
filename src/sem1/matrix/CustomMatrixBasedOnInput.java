package sem1.matrix;

import java.util.Scanner;

public class CustomMatrixBasedOnInput {
    private final static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int totalRow = scanner.nextInt();
        int totalColumn = scanner.nextInt();
        int[][] matrix = new int[totalRow][totalColumn];

        //input
        for (int inputRow = 0; inputRow < totalRow; inputRow++){
            for (int inputColumn = 0; inputColumn < totalColumn; inputColumn++)
                matrix[inputRow][inputColumn] = scanner.nextInt();
        }

        //output
        for (int outputRow = 0; outputRow < totalRow; outputRow++){
            for (int outputColumn = 0; outputColumn < totalColumn; outputColumn++)
                System.out.printf("%d ", matrix[outputRow][outputColumn]);
            System.out.println();
        }

    }
}
