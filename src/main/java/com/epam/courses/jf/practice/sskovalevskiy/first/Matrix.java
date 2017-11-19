package com.epam.courses.jf.practice.sskovalevskiy.first;

import java.util.Scanner;

/**
 * Created by asus on 19.11.2017.
 */
public class Matrix {

    public static Integer[][] readMatrix(Scanner scanner) {
        final int DIMENSION = scanner.nextInt();
        Integer[][] matrix = new Integer[DIMENSION][DIMENSION];
        for (int row = 0; row < DIMENSION; ++row) {
            for (int col = 0; col < DIMENSION; ++col) {
                matrix[row][col] = scanner.nextInt();
            }
        }
        return matrix;
    }

    public static void printMatrix(Integer[][] matrix) {
        System.out.println(matrix.length);

        for (int row = 0; row < matrix.length; ++row) {
            for (int col = 0; col < matrix.length; ++col) {
                System.out.print(matrix[row][col] + "\t");
            }
        }
        System.out.println();
    }


}
