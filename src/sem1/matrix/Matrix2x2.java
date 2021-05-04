package sem1.matrix;

import java.util.Scanner;

public class Matrix2x2 {
    private static final int SIZE_OF_MATRIX = 2;
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int [][] firstMatrix = inputArray();
        int [][] secondMatrix = inputArray();

        outputArray(transpose(firstMatrix, secondMatrix));
    }

    static int[][] inputArray(){
        int [][] matrix = new int[SIZE_OF_MATRIX][SIZE_OF_MATRIX];
        for (int inputRow = 0; inputRow < SIZE_OF_MATRIX; inputRow++) {
            for (int inputColumn = 0; inputColumn < SIZE_OF_MATRIX; inputColumn++) {
                matrix[inputRow][inputColumn] = scanner.nextInt();
            }
        }
        return matrix;
    }

    static void outputArray(int[][] matrix){
        for (int outputRow = 0; outputRow < SIZE_OF_MATRIX; outputRow++) {
            for (int outputColumn = 0; outputColumn < SIZE_OF_MATRIX; outputColumn++) {
                System.out.printf("%d ", matrix[outputRow][outputColumn]);
            }
            System.out.println();
        }
    }

    static int[][] addition(int[][] firstMatrix, int[][] secondMatrix){
        int [][] additionMatrix = new int[SIZE_OF_MATRIX][SIZE_OF_MATRIX];
        for (int row = 0; row < SIZE_OF_MATRIX; row++){
            for (int column = 0; column < SIZE_OF_MATRIX; column++){
                additionMatrix[row][column] = firstMatrix[row][column] + secondMatrix[row][column];
            }
        }
        return additionMatrix;
    }

    static int[][] subtraction(int[][] firstMatrix, int[][] secondMatrix){
        int [][] subtractionMatrix = new int[SIZE_OF_MATRIX][SIZE_OF_MATRIX];
        for (int row = 0; row < SIZE_OF_MATRIX; row++){
            for (int column = 0; column < SIZE_OF_MATRIX; column++){
                subtractionMatrix[row][column] = firstMatrix[row][column] - secondMatrix[row][column];
            }
        }
        return subtractionMatrix;
    }

    static int[][] multiplication(int[][] firstMatrix, int[][] secondMatrix){
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
    
    static int[][] transpose(int[][] firstMatrix, int[][] secondMatrix){
        int[][] transposeMatrix = new int[SIZE_OF_MATRIX][SIZE_OF_MATRIX];
        for (int row = 0; row < SIZE_OF_MATRIX; row++){
            for (int column = 0; column < SIZE_OF_MATRIX; column++){
                transposeMatrix[row][column] = firstMatrix[column][row];
            }
        }
        return transposeMatrix;
    }
}