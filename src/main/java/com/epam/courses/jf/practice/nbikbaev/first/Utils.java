package com.epam.courses.jf.practice.nbikbaev.first;


import java.io.PrintStream;
import java.util.Scanner;

/**
 *
 */
public class Utils {

    /**
     * Reads a matrix from input stream using {@link Scanner} interface.
     *
     * @param scanner   Scanner
     * @param dimension Matrix dimension
     * @return Matrix scanned from input stream
     */
    public static int[][] readIntMatrix(Scanner scanner, int dimension) {
        int[][] matrix = new int[dimension][dimension];
        for (int row = 0; row < dimension; ++row) {
            for (int col = 0; col < dimension; ++col) {
                matrix[row][col] = scanner.nextInt();
            }
        }
        return matrix;
    }

    /**
     * Prints a matrix to the output stream
     *
     * @param matrix      Matrix to be printed
     * @param dimension   Matrix dimension
     * @param printStream The output stream to which matrix will be printed
     */
    public static void printIntMatrix(int[][] matrix, int dimension, PrintStream printStream) {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                printStream.print(matrix[i][j]);
                if (j == dimension - 1) {
                    printStream.print("\n");
                } else {
                    printStream.print(" ");
                }
            }
        }

    }

    /**
     * Swaps the rows at the specified positions in the specified matrix.
     *
     * @param matrix    Target matrix
     * @param rowIndex1 The index of one row to be swapped.
     * @param rowIndex2 The index of the other row to be swapped.
     */
    public static void swapMatrixRows(int[][] matrix, int rowIndex1, int rowIndex2) {
        int[] tempRow = matrix[rowIndex1];
        matrix[rowIndex1] = matrix[rowIndex2];
        matrix[rowIndex2] = tempRow;
    }


    public static void matrixDownShift(int[][] matrix, int shift, int dimension) {
        for (int i = 0; i < shift; i++) {
            for (int j = dimension - 1; j > 0; j--) {
                Utils.swapMatrixRows(matrix, j, j - 1);
            }
        }
    }

    public static void matrixUpShift(int[][] matrix, int shift, int dimension) {
        for (int i = 0; i < shift; i++) {
            for (int j = 0; j < dimension - 1; j++) {
                Utils.swapMatrixRows(matrix, j, j + 1);
            }
        }
    }

    /**
     * Returns sum of the array elements between first and second positive element
     *
     * @param array Input array
     * @return Sum of the found elements
     */
    public static int findSumBetweenPositives(int[] array) {
        int sum = 0;
        boolean flag = false;
        for (int anArray : array) {
            if (!flag) {
                if (anArray > 0) {
                    flag = true;
                }
            } else {
                if (anArray <= 0) {
                    sum += anArray;
                } else {
                    break;
                }
            }
        }
        return sum;
    }

    /**
     * Returns transposed matrix
     *
     * @param matrix Matrix to be transposed
     * @return Transposed matrix
     */
    public static int[][] transposeMatrix(int[][] matrix) {
        int[][] transposedMatrix = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                transposedMatrix[j][i] = matrix[i][j];
        return transposedMatrix;
    }


}
