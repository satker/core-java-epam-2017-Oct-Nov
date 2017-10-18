package com.epam.courses.jf.practice.vkostin.first;

import com.epam.courses.jf.practice.common.first.ISolver;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solver implements ISolver {
    /**
     * {@see <a href="https://bitbucket.org/elefus/summer-java-school-epam-c-2017/wiki/Task%201.1">Задание №1</a>}
     */
    @Override
    public void task1() {
        Scanner input = new Scanner(System.in);

        short minLength, maxLength;
        String minString, maxString;

        byte numberOfStrings = (byte) Integer.parseInt(input.nextLine());
        String stringsArray[] = new String[numberOfStrings];

        stringsArray[0] = input.nextLine();
        minString = stringsArray[0];
        maxString = stringsArray[0];
        minLength = (short) minString.length();
        maxLength = minLength;

        for (int i = 1; i < numberOfStrings; i++) {
            stringsArray[i] = input.nextLine();
            if (stringsArray[i].length() < minLength) {
                minString = stringsArray[i];
                minLength = (short) minString.length();
            } else if (stringsArray[i].length() > maxLength) {
                maxString = stringsArray[i];
                maxLength = (short) maxString.length();
            }
        }

        System.out.printf("MIN (%d): \"%s\"%n", minLength, minString);
        System.out.printf("MAX (%d): \"%s\"%n", maxLength, maxString);
    }

    /**
     * {@see <a href="https://bitbucket.org/elefus/summer-java-school-epam-c-2017/wiki/Task%201.2">Задание №2</a>}
     */
    @Override
    public void task2() {
        Scanner input = new Scanner(System.in);

        byte numberOfStrings = (byte) Integer.parseInt(input.nextLine());
        String stringsArray[] = new String[numberOfStrings];

        for (byte i = 0; i < numberOfStrings; ++i) {
            stringsArray[i] = input.nextLine();
        }

        Arrays.sort(stringsArray, Comparator.comparingInt(String::length)
                .thenComparing(String::compareToIgnoreCase));

        for (String string : stringsArray) {
            System.out.printf("(%d): \"%s\"%n", string.length(), string);
        }

    }

    /**
     * {@see <a href="https://bitbucket.org/elefus/summer-java-school-epam-c-2017/wiki/Task%201.3">Задание №3</a>}
     */
    @Override
    public void task3() {
        Scanner input = new Scanner(System.in);

        short averageLength = 0;
        int numberOfStrings = Integer.parseInt(input.nextLine());
        String stringsArray[] = new String[numberOfStrings];

        for (int i = 0; i < numberOfStrings; ++i) {
            stringsArray[i] = input.nextLine();
            averageLength += stringsArray[i].length();
        }
        averageLength /= numberOfStrings;

        System.out.printf("AVERAGE (%d)%n", averageLength);
        for (String string : stringsArray) {
            if (string.length() < averageLength) {
                System.out.printf("(%d): \"%s\"%n", string.length(), string);
            }
        }
    }

    /**
     * {@see <a href="https://bitbucket.org/elefus/summer-java-school-epam-c-2017/wiki/Task%201.4">Задание №4</a>}
     */
    @Override
    public void task4() {
        // not done
    }

    /**
     * {@see <a href="https://bitbucket.org/elefus/summer-java-school-epam-c-2017/wiki/Task%201.5">Задание №5</a>}
     */
    @Override
    public void task5() {
        /*
        1<<10: 10000000000    mask
        A - z: 1000001 -- 1111010
        A - я: 10000010000 -- 10001001111
         */
        Scanner input = new Scanner(System.in);

        int numberOfWords = Integer.parseInt(input.nextLine());
        int wordsConsistingOfLatinChars = 0;
        String string = input.nextLine();
        String words[] = string.split(" ");

        for (String word : words) {
            System.out.println(word);
        }

    }

    /**
     * {@see <a href="https://bitbucket.org/elefus/summer-java-school-epam-c-2017/wiki/Task%201.6">Задание №6</a>}
     */
    @Override
    public void task6() {

    }

    /**
     * {@see <a href="https://bitbucket.org/elefus/summer-java-school-epam-c-2017/wiki/Task%201.7">Задание №7</a>}
     */
    @Override
    public void task7() {

    }

    /**
     * {@see <a href="https://bitbucket.org/elefus/summer-java-school-epam-c-2017/wiki/Task%201.8">Задание №8</a>}
     */
    @Override
    public void task8() {

    }

    /**
     * {@see <a href="https://bitbucket.org/elefus/summer-java-school-epam-c-2017/wiki/Task%201.9">Задание №9</a>}
     */
    @Override
    public void task9() {

    }

    /**
     * {@see <a href="https://bitbucket.org/elefus/summer-java-school-epam-c-2017/wiki/Task%201.10">Задание №10</a>}
     */
    @Override
    public void task10() {

    }

    /**
     * {@see <a href="https://bitbucket.org/elefus/summer-java-school-epam-c-2017/wiki/Task%201.11">Задание №11</a>}
     */
    @Override
    public void task11() {
        Scanner input = new Scanner(System.in);

        byte month = input.nextByte();

        switch (month) {
            case 1:
                System.out.println("January");
                break;
            case 2:
                System.out.println("February");
                break;
            case 3:
                System.out.println("March");
                break;
            case 4:
                System.out.println("April");
                break;
            case 5:
                System.out.println("May");
                break;
            case 6:
                System.out.println("June");
                break;
            case 7:
                System.out.println("July");
                break;
            case 8:
                System.out.println("August");
                break;
            case 9:
                System.out.println("September");
                break;
            case 10:
                System.out.println("October");
                break;
            case 11:
                System.out.println("November");
                break;
            case 12:
                System.out.println("December");
                break;
            default:
                System.out.println("INCORRECT INPUT DATA");
                break;
        }
    }

    /*
    THE MATRIX PART
     */

    /** A simple method that allows you to read the matrix from the console.
     *
     * @param scanner Scanner class
     * @return square matrix
     */
    private int[][] readMatrix(Scanner scanner) {
        final int DIMENSION = scanner.nextInt();
        int[][] matrix = new int[DIMENSION][DIMENSION];

        for (int row = 0; row < DIMENSION; ++row) {
            for (int col = 0; col < DIMENSION; ++col) {
                matrix[row][col] = scanner.nextInt();
            }
        }

        return matrix;
    }

    /** A simple method that allows you to display the matrix on the console.
     *
     * @param matrix Square matrix
     */
    private void printMatrix(int matrix[][]) {
        for (int i = 0; i < matrix[0].length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * {@see <a href="https://bitbucket.org/elefus/summer-java-school-epam-c-2017/wiki/Task%201.12">Задание №12</a>}
     */
    @Override
    public void task12() {

    }

    /**
     * {@see <a href="https://bitbucket.org/elefus/summer-java-school-epam-c-2017/wiki/Task%201.13">Задание №13</a>}
     */
    @Override
    public void task13() {

    }

    /**
     * {@see <a href="https://bitbucket.org/elefus/summer-java-school-epam-c-2017/wiki/Task%201.14">Задание №14</a>}
     */
    @Override
    public void task14() {
        Scanner input = new Scanner(System.in);

        final short AMOUNT_OF_ELEMENTS = input.nextShort();
        short rows[] = new short[AMOUNT_OF_ELEMENTS];
        short elems = 1;
        short maxSeriesOfIncreasingElems = 0;

        for (short i = 0; i < AMOUNT_OF_ELEMENTS; ++i) {
            rows[i] = input.nextShort();
            if (i != 0) {
                if (rows[i-1] < rows[i]) {
                    elems++;
                    if (elems > maxSeriesOfIncreasingElems) {
                        maxSeriesOfIncreasingElems = elems;
                    }
                } else {
                    elems = 1;
                }
            }
        }

        System.out.println(maxSeriesOfIncreasingElems);
    }

    /**
     * {@see <a href="https://bitbucket.org/elefus/summer-java-school-epam-c-2017/wiki/Task%201.15">Задание №15</a>}
     */
    @Override
    public void task15() {
        int matrix[][] = readMatrix(new Scanner(System.in));

        boolean firstPositiveElem;
        int sumPositiveNumbers = 0;
        int possibleRowSum;

        for (int i = 0; i < matrix[0].length; ++i) {
            firstPositiveElem = false;
            possibleRowSum = 0;
            for (int j = 0; j < matrix[0].length; ++j) {
                if ((matrix[i][j] > 0) && !firstPositiveElem) {
                    firstPositiveElem = true;
                } else if ((matrix[i][j] <= 0) && firstPositiveElem) {
                    possibleRowSum += matrix[i][j];
                } else if ((matrix[i][j] > 0) && firstPositiveElem) {
                    sumPositiveNumbers += possibleRowSum;
                    break;
                }
            }
        }

        System.out.println(sumPositiveNumbers);
    }

    /**
     * {@see <a href="https://bitbucket.org/elefus/summer-java-school-epam-c-2017/wiki/Task%201.16">Задание №16</a>}
     */
    @Override
    public void task16() {
        int matrix[][] = readMatrix(new Scanner(System.in));
        int matrixRotated[][] = new int[matrix[0].length][matrix[0].length];

        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix[0].length; ++j) {
                matrixRotated[matrix[0].length - i - 1][j] = matrix[j][i];
            }
        }

        System.out.println(matrixRotated[0].length);
        printMatrix(matrixRotated);
    }

    /** A simple method allows recursively to calculate the determinant of the matrix.
     *
     * @param matrix Square matrix
     * @return determinant of the matrix
     */
    private int getDeterminant(int matrix[][]) {
        if (matrix[0].length == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        int determinant = 0;
        int newMatrix[][] = new int[matrix[0].length - 1][matrix[0].length - 1];

        // pass through the zero-row columns
        for (int i = 0; i < matrix[0].length; ++i) {
            for (int j = 1; j < matrix[0].length; ++j) {
                for (int k = 0; k < matrix[0].length - 1; ++k) {
                    if (k >= i) {
                        newMatrix[j - 1][k] = matrix[j][k + 1];
                    } else {
                        newMatrix[j - 1][k] = matrix[j][k];
                    }
                }
            }

            if (matrix[0][i] != 0) {
                if (((i + 1) & 1) != 0) {
                    determinant += matrix[0][i] * getDeterminant(newMatrix);
                } else {
                    determinant -= matrix[0][i] * getDeterminant(newMatrix);
                }
            }
        }
        return determinant;
    }

    /**
     * {@see <a href="https://bitbucket.org/elefus/summer-java-school-epam-c-2017/wiki/Task%201.17">Задание №17</a>}
     */
    @Override
    public void task17() {
//        int matrix[][] = readMatrix(new Scanner(System.in));
        int matrix[][] = {
                {0, 3, -1, 2, 6},
                {2, 1, 0, 0, 3},
                {-2, -1, 0, 2, 5},
                {-5, 7, 1, 1, 1},
                {2, 0, 2, -2, 1}};
//        int matrix[][] = { {0,1,3,-2}, {-1,3,-5,1}, {1,1,-2,-3}, {3,-4,-2,1} };
//        int matrix[][] = { {-2,1,2}, {0,-1,0}, {1,-2,3} };
        System.out.println(getDeterminant(matrix));
    }

    /**
     * {@see <a href="https://bitbucket.org/elefus/summer-java-school-epam-c-2017/wiki/Task%201.18">Задание №18</a>}
     */
    @Override
    public void task18() {

    }

    /**
     * {@see <a href="https://bitbucket.org/elefus/summer-java-school-epam-c-2017/wiki/Task%201.19">Задание №19</a>}
     */
    @Override
    public void task19() {

    }

    /**
     * {@see <a href="https://bitbucket.org/elefus/summer-java-school-epam-c-2017/wiki/Task%201.20">Задание №20</a>}
     */
    @Override
    public void task20() {

    }

    /**
     * {@see <a href="https://bitbucket.org/elefus/summer-java-school-epam-c-2017/wiki/Task%201.21">Задание №21</a>}
     */
    @Override
    public void task21() {

    }

    /**
     * {@see <a href="https://bitbucket.org/elefus/summer-java-school-epam-c-2017/wiki/Task%201.22">Задание №22</a>}
     */
    @Override
    public void task22() {

    }

    /**
     * {@see <a href="https://bitbucket.org/elefus/summer-java-school-epam-c-2017/wiki/Task%201.23">Задание №23</a>}
     */
    @Override
    public void task23() {

    }

    /**
     * {@see <a href="https://bitbucket.org/elefus/summer-java-school-epam-c-2017/wiki/Task%201.24">Задание №24</a>}
     */
    @Override
    public void task24() {

    }

    /**
     * {@see <a href="https://bitbucket.org/elefus/summer-java-school-epam-c-2017/wiki/Task%201.25">Задание №25</a>}
     */
    @Override
    public void task25() {

    }

    /**
     * {@see <a href="https://bitbucket.org/elefus/summer-java-school-epam-c-2017/wiki/Task%201.26">Задание №26</a>}
     */
    @Override
    public void task26() {

    }

    /**
     * {@see <a href="https://bitbucket.org/elefus/summer-java-school-epam-c-2017/wiki/Task%201.27">Задание №27</a>}
     */
    @Override
    public void task27() {

    }
}
