package com.epam.courses.jf.practice.sskovalevskiy.first;

import java.util.Scanner;

/**
 * Created by asus on 19.11.2017.
 */
public class Matrix {

    /**
     * @param scanner - принимает на вход Scanner
     * @return Integer[][] matrix - возвращает прочитанную с консоли матрицу
     */
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

    /**
     * @param matrix метод принимает на вход матрицу Integer[][] matrix
     * выводит в консоль размерность матрицы и её саму
     */
    public static void printMatrix(Integer[][] matrix) {

        System.out.println(matrix.length);

        for (int row = 0; row < matrix.length; ++row) {
            for (int col = 0; col < matrix.length; ++col) {
                System.out.print(matrix[row][col] + "\t");
            }
        }
        System.out.println();
    }

    /**
     * @param matrix метод принимает на вход матрицу int[][] matrix
     * выводит в консоль размерность матрицы и её саму
     */
    public static void printMatrix(int[][] matrix) {

        System.out.println(matrix.length);

        for (int row = 0; row < matrix.length; ++row) {
            for (int col = 0; col < matrix.length; ++col) {
                System.out.print(matrix[row][col] + "\t");
            }
        }
        System.out.println();
    }


}
