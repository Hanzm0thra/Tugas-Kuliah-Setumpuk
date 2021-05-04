package sem1.matrix;

import java.util.Scanner;

public class Matrix3x3 {
    private final static int SIZE_OF_MATRIX = 3;
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int [][] firstMatrix = inputArray();
        int [][] secondMatrix = inputArray();

        outputArray(multiplication(firstMatrix, secondMatrix));
    }

    private static int[][] inputArray(){
        int [][] matrix = new int[SIZE_OF_MATRIX][SIZE_OF_MATRIX];
        for (int inputRow = 0; inputRow < SIZE_OF_MATRIX; inputRow++) {
            for (int inputColumn = 0; inputColumn < SIZE_OF_MATRIX; inputColumn++) {
                matrix[inputRow][inputColumn] = scanner.nextInt();
            }
        }
        return matrix;
    }

    private static void outputArray(int[][] matrix){
        for (int outputRow = 0; outputRow < SIZE_OF_MATRIX; outputRow++) {
            for (int outputColumn = 0; outputColumn < SIZE_OF_MATRIX; outputColumn++) {
                System.out.printf("%d ", matrix[outputRow][outputColumn]);
            }
            System.out.println();
        }
    }

    private static int[][] multiplication(int[][] firstMatrix, int[][] secondMatrix){
        int[][] multiplicationMatrix = new int[SIZE_OF_MATRIX][SIZE_OF_MATRIX];
        for (int firstRow = 0; firstRow < SIZE_OF_MATRIX; firstRow++){
            for (int secondColumn = 0; secondColumn < SIZE_OF_MATRIX; secondColumn++){
                for (int secondRow = 0; secondRow < SIZE_OF_MATRIX; secondRow++)
                    multiplicationMatrix[firstRow][secondColumn] +=
                            firstMatrix[firstRow][secondRow] * secondMatrix[secondRow][secondColumn];
            }
        }
        return multiplicationMatrix;
    }
}
