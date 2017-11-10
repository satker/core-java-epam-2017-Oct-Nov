package com.epam.courses.jf.practice.nbikbaev.first;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Utils {

    public static int[][] readMatrix(Scanner scanner, int dimension) {
        int[][] matrix = new int[dimension][dimension];
        for (int row = 0; row < dimension; ++row) {
            for (int col = 0; col < dimension; ++col) {
                matrix[row][col] = scanner.nextInt();
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix, int dimension, PrintStream printStream) {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                printStream.print(matrix[i][j]);
                if (j == 4) {
                    printStream.print("\n");
                } else {
                    printStream.print(" ");
                }
            }
        }

    }
}
