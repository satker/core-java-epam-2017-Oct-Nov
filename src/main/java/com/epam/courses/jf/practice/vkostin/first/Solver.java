package com.epam.courses.jf.practice.vkostin.first;

import com.epam.courses.jf.practice.common.first.ISolver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
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
            if (stringsArray[i].length() <= minLength) {
                minString = stringsArray[i];
                minLength = (short) minString.length();
            }
            if (stringsArray[i].length() >= maxLength) {
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
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                System.out.print((i * N + j + 1) + "\t");
            }
            System.out.println();
        }
    }

    /**
     * {@see <a href="https://bitbucket.org/elefus/summer-java-school-epam-c-2017/wiki/Task%201.10">Задание №10</a>}
     */
    @Override
    public void task10() {
        Scanner input = new Scanner(System.in);
        int coefA = input.nextInt();
        int coefB = input.nextInt();
        int coefC = input.nextInt();

        int discriminant = coefB * coefB - 4 * coefA * coefC;

        if (discriminant > 0) {
            BigDecimal bigDecimalRoot1 = new BigDecimal(
                    ((-coefB - Math.sqrt(discriminant)) / 2d / coefA))
                    .setScale(2, BigDecimal.ROUND_HALF_UP);
            BigDecimal bigDecimalRoot2 = new BigDecimal(
                    (-coefB + Math.sqrt(discriminant)) / 2d / coefA)
                    .setScale(2, BigDecimal.ROUND_HALF_UP);
            System.out.println("Two solutions: "
                    + bigDecimalRoot1 + ", " + bigDecimalRoot2);
        } else if (discriminant == 0) {
            BigDecimal bigDecimalRoot = new BigDecimal((-coefB / 2d / coefA))
                    .setScale(2, BigDecimal.ROUND_HALF_UP);
            System.out.println("One solution: " + bigDecimalRoot);
        } else {
            System.out.println("No solution");
        }
    }

    /**
     * {@see <a href="https://bitbucket.org/elefus/summer-java-school-epam-c-2017/wiki/Task%201.11">Задание №11</a>}
     */
    @Override
    public void task11() {

        int month = 0;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            month = Integer.parseInt(reader.readLine());
            if (month > 12 || month < 1)
                throw new IOException();
        } catch (Exception e){
            System.out.println("INCORRECT INPUT DATA");
        }

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

    // test matrices
    final private int[][] MATRIX_3x3 = { {2,1,-3}, {-2,3,2}, {-1,0,0} };
    final private int[][] MATRIX_4x4 = { {0,1,3,-2}, {-1,3,-5,1}, {1,1,-2,-3}, {3,-4,-2,1} };
    final private int[][] MATRIX_5x5 = {
            {0, 3, -1, 2, 6},
            {2, 1, 0, 0, 3},
            {-2, -1, 0, 2, 5},
            {-5, 7, 1, 1, 1},
            {2, 0, 2, -2, 1}
    };

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

    /** A simple method that allows you to read the double matrix from the console.
     *
     * @param scanner Scanner class
     * @return square double matrix
     */
    private double[][] readMatrixD(Scanner scanner) {
        final int DIMENSION = scanner.nextInt();
        double[][] matrix = new double[DIMENSION][DIMENSION];

        for (int row = 0; row < DIMENSION; ++row) {
            for (int col = 0; col < DIMENSION; ++col) {
                matrix[row][col] = scanner.nextDouble();
            }
        }

        return matrix;
    }

    /** A simple method that allows you to display the matrix on the console.
     *
     * @param matrix Square matrix
     */
    private void printMatrix(int matrix[][], boolean printDimension) {
        if (printDimension) {
            System.out.println(matrix.length);
//            if (matrix.length != matrix[0].length) {
                System.out.println(matrix[0].length);
//            }
        }

        for (int[] aMatrix : matrix) {
            for (int j = 0; j < matrix[0].length; ++j) {
                System.out.print(aMatrix[j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * {@see <a href="https://bitbucket.org/elefus/summer-java-school-epam-c-2017/wiki/Task%201.12">Задание №12</a>}
     */
    @Override
    public void task12() {
        Scanner input = new Scanner(System.in);
        int columnNumber = input.nextInt();
        int matrix[][] = readMatrix(input);

        for (int i = matrix.length - 1; i > 0; --i) {
            for (int j = 0; j < i; ++j) {
                if (matrix[j][columnNumber] > matrix[j + 1][columnNumber]) {
                    swapTwoRows(matrix[j], matrix[j + 1]);
                }
            }
        }

        printMatrix(matrix, true);
    }

    /**
     * {@see <a href="https://bitbucket.org/elefus/summer-java-school-epam-c-2017/wiki/Task%201.13">Задание №13</a>}
     */
    @Override
    public void task13() {
        Scanner input = new Scanner(System.in);
        int numberOfShits = input.nextInt();
        int matrix[][] = readMatrix(input);

        if ((numberOfShits != 0)
                || (Math.abs(numberOfShits) % matrix.length != 0)) {
            if (Math.abs(numberOfShits) > matrix.length) {
                numberOfShits = numberOfShits % matrix.length;
            }
            if (numberOfShits > 0) {
                for (int i = 0; i < numberOfShits; ++i) {
                    for (int j = matrix.length - 1; j > 0; --j) {
                        if (j == matrix.length - 1) {
                            swapTwoRows(matrix[0], matrix[j]);
                        } else  {
                            swapTwoRows(matrix[j], matrix[j + 1]);
                        }
                    }
                }
            } else {
                for (int i = 0; i < -numberOfShits; ++i) {
                    for (int j = 0; j < matrix.length - 1; ++j) {
                        if (j == 0) {
                            swapTwoRows(matrix[matrix.length - 1], matrix[0]);
                        } else {
                            swapTwoRows(matrix[j], matrix[j - 1]);
                        }
                    }
                }
            }
        }

        printMatrix(matrix, true);
    }

    /**
     * {@see <a href="https://bitbucket.org/elefus/summer-java-school-epam-c-2017/wiki/Task%201.14">Задание №14</a>}
     */
    @Override
    public void task14() {
        Scanner input = new Scanner(System.in);

        final short AMOUNT_OF_ELEMENTS = input.nextShort();
        int rows[] = new int[AMOUNT_OF_ELEMENTS];
        int elems = 1;
        int maxSeriesOfIncreasingElems = 0;

        for (short i = 0; i < AMOUNT_OF_ELEMENTS; ++i) {
            rows[i] = input.nextInt();
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

        printMatrix(matrixRotated, true);
    }

    /** A simple method allows recursively to calculate the determinant of the matrix.
     *
     * @param matrix Square matrix
     * @return determinant of the matrix
     */
    private int getDeterminant(int matrix[][]) {
        if (matrix[0].length == 1) {
            return matrix[0][0];
        }

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
        int matrix[][] = readMatrix(new Scanner(System.in));
        // for example
        // int matrix[][] = MATRIX_5x5;
        System.out.println(getDeterminant(matrix));
    }

    /** The method allows you to compact the matrix by deleting the specified row and column numbers.
     *
     * @param originalMatrix The matrix, which is to be sealed
     * @param limitationRow The row numbers to remove from the "originalMatrix"
     * @param limitationCol The column numbers to remove from the "originalMatrix"
     * @return compact matrix
     */
    private int[][] compactTheMatrix(
            int originalMatrix[][],
            ArrayList<Integer> limitationRow,
            ArrayList<Integer> limitationCol) {

        // Create new matrix without rows and columns witch contains Zero
        int purposeMatrix[][] = new int[originalMatrix.length - limitationRow.size()]
                [originalMatrix[0].length - limitationCol.size()];

        byte rowShift = 0;
        byte colShift;

        for (int i = 0; i < originalMatrix.length; ++i) {
            if (limitationRow.contains(i)) {
                rowShift++;
            } else {
                colShift = 0;
                for (int j = 0; j < originalMatrix[0].length; ++j) {
                    if (limitationCol.contains(j)) {
                        colShift++;
                    } else {
                        purposeMatrix[i-rowShift][j-colShift] = originalMatrix[i][j];
                    }
                }
            }
        }
        return purposeMatrix;
    }

    /** Find elem with extremum value in original matrix.
     *
     * @param matrix original matrix
     * @param type "max" or "min"
     * @return extremumValue
     */
    private int findExtremum(int matrix[][], String type) {
        int extremumValue = matrix[0][0];

        for (int[] aMatrix : matrix) {
            for (int j = 0; j < matrix[0].length; ++j) {
                switch (type) {
                    case "max":
                        if (aMatrix[j] > extremumValue) {
                            extremumValue = aMatrix[j];
                        }
                        break;
                    case "min":
                        if (aMatrix[j] < extremumValue) {
                            extremumValue = aMatrix[j];
                        }
                        break;
                    default:
                        return 0;
                }
            }
        }
        return extremumValue;
    }

    /**
     * {@see <a href="https://bitbucket.org/elefus/summer-java-school-epam-c-2017/wiki/Task%201.18">Задание №18</a>}
     */
    @Override
    public void task18() {
        int matrix[][] = readMatrix(new Scanner(System.in));
        ArrayList<Integer> rowMaxValue = new ArrayList<Integer>();
        ArrayList<Integer> colMaxValue = new ArrayList<Integer>();

        int maxValue = findExtremum(matrix, "max");

        // Find indices of rows and columns witch contains maxValue
        for (int i = 0; i < matrix[0].length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (matrix[i][j] == maxValue) {
                    if (!rowMaxValue.contains(i)) {
                        rowMaxValue.add(i);
                    }
                    if (!colMaxValue.contains(j)) {
                        colMaxValue.add(j);
                    }
                }
            }
        }

        printMatrix(compactTheMatrix(matrix, rowMaxValue, colMaxValue), true);
    }

    /**
     * {@see <a href="https://bitbucket.org/elefus/summer-java-school-epam-c-2017/wiki/Task%201.19">Задание №19</a>}
     */
    @Override
    public void task19() {
        int matrix[][] = readMatrix(new Scanner(System.in));

        ArrayList<Integer> rowContainsZero = new ArrayList<Integer>();
        ArrayList<Integer> colContainsZero = new ArrayList<Integer>();

        // Find indices of rows witch contains Zero
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (matrix[i][j] != 0) {
                    break;
                } else if (j == matrix[0].length - 1) {
                    rowContainsZero.add(i);
                }
            }
        }

        // Find indices of columns witch contains Zero
        for (int j = 0; j < matrix[0].length; ++j) {
            for (int i = 0; i < matrix.length; ++i) {
                if (matrix[i][j] != 0) {
                    break;
                } else if (i == matrix[0].length - 1) {
                    colContainsZero.add(j);
                }
            }
        }

        printMatrix(compactTheMatrix(matrix, rowContainsZero, colContainsZero), true);
    }

    /**
     * {@see <a href="https://bitbucket.org/elefus/summer-java-school-epam-c-2017/wiki/Task%201.20">Задание №20</a>}
     */
    @Override
    public void task20() {
        Scanner input = new Scanner(System.in);

        int goalElemRowIndex = input.nextInt();
        int goalElemColIndex = input.nextInt();
        int minValueRowIndex = 0;
        int minValueColIndex = 0;
        int matrix[][] = readMatrix(input);

        int minValue = findExtremum(matrix, "min");

        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (matrix[i][j] == minValue) {
                    minValueRowIndex = i;
                    minValueColIndex = j;
                }
            }
        }

        if (minValueColIndex != goalElemColIndex) {
            // swap all needed elems by columns
            for (int i = 0; i < matrix.length; ++i) {
                matrix[i][goalElemColIndex] ^= matrix[i][minValueColIndex];
                matrix[i][minValueColIndex] ^= matrix[i][goalElemColIndex];
                matrix[i][goalElemColIndex] ^= matrix[i][minValueColIndex];
            }
        }

        if (minValueRowIndex != goalElemRowIndex) {
            // swap all needed elems by rows
            for (int j = 0; j < matrix[0].length; ++j) {
                matrix[goalElemRowIndex][j] ^= matrix[minValueRowIndex][j];
                matrix[minValueRowIndex][j] ^= matrix[goalElemRowIndex][j];
                matrix[goalElemRowIndex][j] ^= matrix[minValueRowIndex][j];
            }
        }

        System.out.println(matrix.length);
        printMatrix(matrix, false);
    }

    /**
     * {@see <a href="https://bitbucket.org/elefus/summer-java-school-epam-c-2017/wiki/Task%201.21">Задание №21</a>}
     */
    @Override
    public void task21() {
        int matrix[][] = readMatrix(new Scanner(System.in));

        for (int i = 0; i < matrix.length; ++i) {
            for (int k = 0, j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0) {
                    if (k < j) {
                        matrix[i][k] ^= matrix[i][j];
                        matrix[i][j] ^= matrix[i][k];
                        matrix[i][k] ^= matrix[i][j];
                    }
                    k++;
                }
            }

        }

        System.out.println(matrix.length);
        printMatrix(matrix, false);
    }

    /**
     * {@see <a href="https://bitbucket.org/elefus/summer-java-school-epam-c-2017/wiki/Task%201.22">Задание №22</a>}
     */
    @Override
    public void task22() {
        double matrix[][] = readMatrixD(new Scanner(System.in));
        int matrixRound[][] = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                matrixRound[i][j] = (int) Math.round(matrix[i][j]);
            }
        }

        printMatrix(matrixRound, true);
    }

    /**
     * {@see <a href="https://bitbucket.org/elefus/summer-java-school-epam-c-2017/wiki/Task%201.23">Задание №23</a>}
     */
    @Override
    public void task23() {
//        int matrix[][] = readMatrix(new Scanner(System.in));
        int matrix[][] = {
                {2,3,5,2},
                {2,4,6,2},
                {-2,7,2,0},
                {0,0,0,0}
        };
        int numberOfSaddlePoints = 0;

        int minElemInRow;
        int maxElemInCol;

        ArrayList<Integer> minRowX = new ArrayList<Integer>();
        ArrayList<Integer> maxRowY = new ArrayList<Integer>();

        for (int i = 0; i < matrix.length; ++i) {
            minElemInRow = matrix[i][0];
            maxElemInCol = matrix[i][0];
            minRowX.clear();
            maxRowY.clear();
            for (int j = 0; j < matrix[0].length; ++j) {
                if (matrix[i][j] <= minElemInRow) {
                    minElemInRow = matrix[i][j];
                    minRowX.add(j);
                }
            }
            for (int k = 0; k < matrix.length; ++k) {
                if (matrix[k][minRowX.get(0)] >= maxElemInCol) {
                    maxElemInCol = matrix[k][minRowX.get(0)];
                    maxRowY.add(k);
                }
            }
            if (maxRowY.contains(i)) {
                numberOfSaddlePoints++;
            }
        }
/*
2 3 5 2
2 4 6 2
-2 7 2 0
0 0 0 0
 */
        System.out.println(numberOfSaddlePoints);

    }

    /** Swap elements of two different rows.
     *
     * @param row1 first row
     * @param row2 second row
     */
    private void swapTwoRows(int[] row1, int[] row2) {
        for (int i = 0; i < row1.length; ++i) {
            row1[i] ^= row2[i];
            row2[i] ^= row1[i];
            row1[i] ^= row2[i];
        }
    }

    /**
     * {@see <a href="https://bitbucket.org/elefus/summer-java-school-epam-c-2017/wiki/Task%201.24">Задание №24</a>}
     */
    @Override
    public void task24() {
        int matrix[][] = readMatrix(new Scanner(System.in));
        int sumPre;
        int sumPost;

        // Old good sorting bubble...
        for (int i = matrix.length - 1; i > 0; --i) {
            for (int k = 0; k < i; ++k) {
                sumPre = 0;
                sumPost = 0;
                for (int j = 0; j < matrix[0].length; ++j) {
                    sumPre += matrix[k][j];
                    sumPost += matrix[k + 1][j];
                }
                if (sumPost < sumPre) {
                    swapTwoRows(matrix[k], matrix[k + 1]);
                }
            }
        }

        printMatrix(matrix, true);
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
        int matrix[][] = readMatrix(new Scanner(System.in));
        int sumPre;
        int sumPost;

        for (int i = matrix[0].length - 1; i > 0; --i) {
            for (int k = 0; k < i; ++k) {
                sumPre = 0;
                sumPost = 0;
                for (int[] aMatrix : matrix) {
                    sumPre += Math.abs(aMatrix[k]);
                    sumPost += Math.abs(aMatrix[k + 1]);
                }
                if (sumPost > sumPre) {
                    for (int j2 = 0; j2 < matrix.length; ++j2) {
                        matrix[j2][k] ^= matrix[j2][k + 1];
                        matrix[j2][k + 1] ^= matrix[j2][k];
                        matrix[j2][k] ^= matrix[j2][k + 1];
                    }
                }
            }
        }

        printMatrix(matrix, true);
    }
}
