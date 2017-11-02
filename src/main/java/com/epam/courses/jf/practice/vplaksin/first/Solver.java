package com.epam.courses.jf.practice.vplaksin.first;

import com.epam.courses.jf.practice.common.first.ISolver;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Pattern;

import static java.lang.Math.min;
import static java.lang.Math.max;
import static java.lang.Math.round;
import static java.lang.Math.sqrt;
import static java.lang.Math.abs;

public class Solver implements ISolver {

    private static String[] readStrings(Scanner scanner) {

        int n = Integer.parseInt(scanner.nextLine());

        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = scanner.nextLine();
        }

        return result;

    }

    @Override
    public void task1() {

        String[] strings = readStrings(new Scanner(System.in));

        String minString = strings[0];
        String maxString = strings[0];
        int minLength = minString.length();
        int maxLength = maxString.length();

        for (String s : strings) {
            if (s.length() <= minLength) {
                minString = s;
                minLength = s.length();
            }

            if (s.length() >= maxLength) {
                maxString = s;
                maxLength = s.length();
            }
        }

        System.out.printf("MIN (%d): \"%s\"%n", minLength, minString);
        System.out.printf("MAX (%d): \"%s\"%n", maxLength, maxString);

    }

    @Override
    public void task2() {

        String[] strings = readStrings(new Scanner(System.in));

        Arrays.sort(strings, Comparator.comparingInt(String::length).thenComparing(String::compareTo));

        for (String s : strings) {
            System.out.printf("(%d): \"%s\"%n", s.length(), s);
        }

    }

    @Override
    public void task3() {

        String[] strings = readStrings(new Scanner(System.in));

        long averageLength = 0L;
        for (String s : strings) {
            averageLength += s.length();
        }
        averageLength /= strings.length;
        System.out.printf("AVERAGE (%d)%n", averageLength);

        for (String s : strings) {
            if (s.length() < averageLength) {
                System.out.printf("(%d): \"%s\"%n", s.length(), s);
            }
        }

    }

    private static String[] readWords(Scanner scanner) {

        int n = Integer.parseInt(scanner.nextLine());
        return scanner.nextLine().split("\\s+");

    }

    @Override
    public void task4() {

        String[] words = readWords(new Scanner(System.in));
        int minDifference = 2 * 26 + 1; //Number of different symbols in english alphabet + 1
        String result = "";

        for (String word : words) {
            char[] chars = word.toCharArray();
            HashSet<Character> set = new HashSet<>();

            for (Character c : chars) {
                set.add(c);
            }

            if (set.size() < minDifference) {
                result = word;
                minDifference = set.size();
            }
        }

        System.out.println(result);

    }

    @Override
    public void task5() {

        String[] words = readWords(new Scanner(System.in));

        final Character[] temp = {'a', 'e', 'i', 'o', 'u', 'y'};
        final List<Character> vowels = Arrays.asList(temp);
        int result = 0;

        for (String word : words) {
            if (!Pattern.matches("[a-zA-Z]+", word)) {
                continue;
            }

            char[] chars = word.toLowerCase().toCharArray();
            int vowelCount = 0;
            int consonantCount = 0;

            for (Character c : chars) {
                if (vowels.contains(c)) {
                    vowelCount++;
                } else {
                    consonantCount++;
                }
            }

            if (consonantCount == vowelCount) {
                result++;
            }
        }

        System.out.println(result);

    }

    @Override
    public void task6() {

        String[] words = readWords(new Scanner(System.in));

        loop:
        for (String word : words) {
            char[] chars = word.toCharArray();

            if (chars.length == 1) {
                continue;
            }

            for (int j = 0; j < chars.length - 1; j++) {
                if (chars[j] >= chars[j + 1]) {
                    continue loop;
                }
            }

            System.out.println(word);
            return;
        }

        System.out.println("NOT FOUND");

    }

    @Override
    public void task7() {

        String[] words = readWords(new Scanner(System.in));
        HashSet<String> wordSet = new HashSet<>();
        StringBuilder builder = new StringBuilder();

        loop:
        for (String word : words) {
            char[] chars = word.toCharArray();
            HashSet<Character> charSet = new HashSet<>();

            for (char c : chars) {
                if (!charSet.add(c)) {
                    continue loop;
                }
            }

            if (wordSet.add(word)) {
                if (builder.length() == 0) {
                    builder.append(word);
                } else {
                    builder.append(" ");
                    builder.append(word);
                }
            }

        }

        if (builder.length() != 0) {
            System.out.println(builder.toString());
        } else {
            System.out.println("NOT FOUND");
        }

    }

    @Override
    public void task8() {

        String[] words = readWords(new Scanner(System.in));
        List<BigInteger> polyndroms = new ArrayList<>();

        for (String word : words) {
            if (!Pattern.matches("\\d+", word)) {
                continue;
            }

            BigInteger number = new BigInteger(word);

            if (word.equals(new StringBuilder(word).reverse().toString())) {
                polyndroms.add(number);
            }
        }

        if (polyndroms.size() == 1) {
            System.out.println(polyndroms.get(0));
        } else if (polyndroms.size() > 1) {
            System.out.println(polyndroms.get(1));
        } else {
            System.out.println("NOT FOUND");
        }

    }

    private static int[][] readMatrix(Scanner scanner) {

        final int DIMENSION = scanner.nextInt();
        int[][] matrix = new int[DIMENSION][DIMENSION];

        for (int row = 0; row < DIMENSION; row++) {
            for (int col = 0; col < DIMENSION; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }

        return matrix;

    }

    private static void printMatrixWithoutSize(int[][] input) {

        for (int[] row : input) {
            for (int i = 0; i < row.length; i++) {
                if (i != row.length - 1) {
                    System.out.print(row[i] + "\t");
                } else {
                    System.out.print(row[i] + "\n");
                }
            }
        }

    }

    private static void printMatrix(int[][] input) {

        System.out.println(input.length);
        printMatrixWithoutSize(input);

    }

    @Override
    public void task9() {

        Scanner scanner = new Scanner(System.in);
        final int n = Integer.parseInt(scanner.nextLine());

        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = i * n + j + 1;
            }
        }

        printMatrixWithoutSize(result);

    }

    @Override
    public void task10() {

        Scanner scanner = new Scanner(System.in);
        final int A = scanner.nextInt();
        final int B = scanner.nextInt();
        final int C = scanner.nextInt();

        if (A == 0) {
            if (B == 0) {
                if (C == 0) {
                    System.out.println("No solution");
                } else {
                    System.out.println("Infinite count of solutions");
                }
            } else {
                System.out.println("One solution: " + (double) C / B);
            }
            return;
        }

        final double D = B * B - 4 * A * C;
        if (D < 0) {
            System.out.println("No solution");
        } else if (D == 0) {
            BigDecimal result = new BigDecimal((double) -B / (2 * A));
            System.out.println("One solution: " + result.setScale(2, RoundingMode.HALF_UP));
        } else {
            BigDecimal result1 = new BigDecimal((-B - sqrt(D)) / (2 * A));
            BigDecimal result2 = new BigDecimal((-B + sqrt(D)) / (2 * A));
            if (result1.compareTo(result2) == 1) {
                BigDecimal swap = result1;
                result1 = result2;
                result2 = swap;
            }
            System.out.println("Two solutions: " + result1.setScale(2, RoundingMode.HALF_UP)
                    + ", " + result2.setScale(2, RoundingMode.HALF_UP));
        }

    }

    @Override
    public void task11() {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (!Pattern.matches("\\d\\d?", input)) {
            System.out.println("INCORRECT INPUT DATA");
            return;
        }

        int monthNumber = Integer.parseInt(input);

        switch (monthNumber) {
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

    @Override
    public void task12() {

        Scanner scanner = new Scanner(System.in);
        int k = Integer.parseInt(scanner.nextLine());
        int[][] matrix = readMatrix(scanner);

        Arrays.sort(matrix, Comparator.comparingInt(arr -> arr[k]));

        printMatrix(matrix);

    }

    @Override
    public void task13() {

        Scanner scanner = new Scanner(System.in);
        int k = Integer.parseInt(scanner.nextLine());
        int[][] matrix = readMatrix(scanner);
        int[][] result = new int[matrix.length][];


        for (int i = 0; i < result.length; i++) {
            int positionInMatrix = (i - k) % result.length;
            positionInMatrix = positionInMatrix < 0 ? positionInMatrix + result.length : positionInMatrix;
            result[i] = matrix[positionInMatrix].clone();
        }

        printMatrix(result);

    }

    @Override
    public void task14() {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        int maxRow = 1;
        int tempRow = 1;
        if (n == 1) {
            System.out.println(n);
            return;
        }

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > numbers[i - 1]) {
                tempRow++;
            } else {
                maxRow = max(maxRow, tempRow);
                tempRow = 1;
            }
        }

        System.out.println(maxRow);

    }

    @Override
    public void task15() {

        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);

        int result = 0;
        for (int[] row : matrix) {
            int sumBetweenPositivs = 0;
            boolean wasPositive = false;

            for (int element : row) {
                if (!wasPositive) {
                    if (element > 0) {
                        wasPositive = true;
                    }
                } else {
                    if (element > 0) {
                        result += sumBetweenPositivs;
                        break;
                    } else {
                        sumBetweenPositivs += element;
                    }
                }
            }
        }

        System.out.println(result);

    }

    @Override
    public void task16() {

        int[][] matrix = readMatrix(new Scanner(System.in));
        int[][] result = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = matrix[j][matrix.length - 1 - i];
            }
        }

        printMatrix(result);

    }

    @Override
    public void task17() {

        int[][] temp = readMatrix(new Scanner(System.in));
        double[][] matrix = new double[temp.length][temp.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = temp[i][j];
            }
        }
        double result = 1.0;

        for (int k = 0; k < matrix.length; k++) {
            if (matrix[k][k] == 0) {
                boolean isMatrixDegenerate = true;
                for (int i = k; i < matrix.length; i++) {
                    if (matrix[i][k] != 0) {
                        isMatrixDegenerate = false;
                        double[] swap = matrix[i];
                        matrix[i] = matrix[k];
                        matrix[k] = swap;
                        result *= -1;
                        break;
                    }
                }
                if (isMatrixDegenerate) {
                    System.out.println(0);
                    return;
                }
            }

            for (int i = k + 1; i < matrix.length; i++) {
                double coefficient = matrix[i][k] / matrix[k][k];
                for (int j = k; j < matrix[0].length; j++) {
                    matrix[i][j] -= coefficient * matrix[k][j];
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            result *= matrix[i][i];
        }

        System.out.println((int) result);

    }

    private void printNonSquareMatrix(int[][] input) {

        System.out.println(input.length);
        System.out.println(input[0].length);

        for (int[] row : input) {
            for (int i = 0; i < row.length; i++) {
                if (i != row.length - 1) {
                    System.out.print(row[i] + "\t");
                } else {
                    System.out.println(row[i]);
                }
            }
        }

    }

    @Override
    public void task18() {

        int[][] matrix = readMatrix(new Scanner(System.in));

        int maxElement = matrix[0][0];
        for (int[] row : matrix) {
            for (int element : row) {
                maxElement = max(maxElement, element);
            }
        }

        HashSet<Integer> rowsToDelete = new HashSet<>();
        HashSet<Integer> columnsToDelete = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == maxElement) {
                    rowsToDelete.add(i);
                    columnsToDelete.add(j);
                }
            }
        }

        int[][] result = new int[matrix.length - rowsToDelete.size()][matrix.length - columnsToDelete.size()];
        int rowNumber = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (rowsToDelete.contains(i)) {
                continue;
            }
            int columnNumber = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                if (columnsToDelete.contains(j)) {
                    continue;
                }
                result[rowNumber][columnNumber] = matrix[i][j];
                columnNumber++;
            }
            rowNumber++;
        }

        printNonSquareMatrix(result);

    }

    @Override
    public void task19() {

        int[][] matrix = readMatrix(new Scanner(System.in));

        ArrayList<Integer> rowsToDelete = new ArrayList<>();
        loop:
        for (int i = 0; i < matrix.length; i++) {
            for (int element : matrix[i]) {
                if (element != 0) {
                    continue loop;
                }
            }
            rowsToDelete.add(i);
        }

        ArrayList<Integer> columnsToDelete = new ArrayList<>();
        loop:
        for (int j = 0; j < matrix.length; j++) {
            for (int[] row : matrix) {
                if (row[j] != 0) {
                    continue loop;
                }
            }
            columnsToDelete.add(j);
        }

        int[][] result = new int[matrix.length - rowsToDelete.size()][matrix.length - columnsToDelete.size()];
        int rowNumber = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (rowsToDelete.contains(i)) {
                continue;
            }
            int columnNumber = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                if (columnsToDelete.contains(j)) {
                    continue;
                }
                result[rowNumber][columnNumber] = matrix[i][j];
                columnNumber++;
            }
            rowNumber++;
        }

        printNonSquareMatrix(result);

    }

    @Override
    public void task20() {

        Scanner scanner = new Scanner(System.in);
        int x = Integer.parseInt(scanner.nextLine());
        int y = Integer.parseInt(scanner.nextLine());
        int[][] matrix = readMatrix(scanner);

        int minX = 0;
        int minY = 0;
        int minElement = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (minElement > matrix[i][j]) {
                    minElement = matrix[i][j];
                    minX = i;
                    minY = j;
                }
            }
        }

        //Rotate rows
        int[] swap = matrix[minX];
        if (x < minX) {
            System.arraycopy(matrix, x, matrix, x + 1, minX - x);
            matrix[x] = swap;
        } else if (x > minX) {
            System.arraycopy(matrix, minX + 1, matrix, minX, x - minX);
            matrix[x] = swap;
        }

        //Rotate columns
        swap = new int[matrix.length];
        for (int j = 0; j < matrix.length; j++) {
            swap[j] = matrix[j][minY];
        }

        if (y < minY) {
            for (int j = minY; j > y; j--) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][j] = matrix[i][j - 1];
                }
            }
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][y] = swap[i];
            }
        } else if (y > minY) {
            for (int j = minY; j < y; j++) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][j] = matrix[i][j + 1];
                }
            }
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][y] = swap[i];
            }
        }

        printMatrix(matrix);

    }

    @Override
    public void task21() {

        int[][] matrix = readMatrix(new Scanner(System.in));
        int[][] result = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            int columnCounter = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0) {
                    result[i][columnCounter] = matrix[i][j];
                    columnCounter++;
                }
            }
            for (int j = columnCounter; j < result[0].length; j++) {
                result[i][j] = 0;
            }
        }

        printMatrix(result);

    }

    private double[][] readDoubleMatrix(Scanner scanner) {

        NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
        final int DIMENSION = scanner.nextInt();
        double[][] matrix = new double[DIMENSION][DIMENSION];

        for (int row = 0; row < DIMENSION; row++) {
            for (int col = 0; col < DIMENSION; col++) {
                try {
                    matrix[row][col] = format.parse(scanner.next()).doubleValue();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }

        return matrix;

    }

    @Override
    public void task22() {

        double[][] matrix = readDoubleMatrix(new Scanner(System.in));
        int[][] result = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result[i][j] = (int) round(matrix[i][j]);
            }
        }

        printMatrix(result);

    }

    @Override
    public void task23() {

        int[][] matrix = readMatrix(new Scanner(System.in));

        int result = 0;
        for (int[] row : matrix) {

            int minInRow = row[0];
            for (int element : row) {
                minInRow = min(minInRow, element);
            }

            loop:
            for (int j = 0; j < row.length; j++) {
                if (row[j] == minInRow) {
                    for (int[] tempRow : matrix) {
                        if (tempRow[j] > minInRow) {
                            continue loop;
                        }
                    }
                    result++;
                }
            }
        }

        System.out.println(result);

    }

    @Override
    public void task24() {

        int[][] matrix = readMatrix(new Scanner(System.in));

        ArrayList<Object[]> tempStructure = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            int sum = 0;
            for (int element : matrix[i]) {
                sum += element;
            }
            tempStructure.add(new Object[]{matrix[i], sum, i});
        }

        tempStructure.sort((o1, o2) -> {
            if ((int) o1[1] == (int) o2[1]) {
                return (int) o1[2] - (int) o2[2];
            } else {
                return (int) o1[1] - (int) o2[1];
            }
        });

        int[][] result = new int[matrix.length][];
        for (int i = 0; i < result.length; i++) {
            result[i] = (int[]) tempStructure.get(i)[0];
        }

        printMatrix(result);

    }

    @Override
    public void task25() {

        int[][] matrix = readMatrix(new Scanner(System.in));
        int result = 0;

        int[][] tempMatrix = new int[matrix.length + 2][matrix.length + 2];
        int max = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                tempMatrix[i + 1][j + 1] = matrix[i][j];
                max = max(max, matrix[i][j]);
            }
        }

        for (int i = 0; i < tempMatrix.length; i++) {
            tempMatrix[i][0] = max;
            tempMatrix[i][tempMatrix.length - 1] = max;
            tempMatrix[0][i] = max;
            tempMatrix[tempMatrix.length - 1][i] = max;
        }


        for (int i = 1; i < matrix.length + 1; i++) {
            for (int j = 1; j < matrix.length + 1; j++) {
                if (tempMatrix[i][j] < tempMatrix[i + 1][j - 1] &&
                        tempMatrix[i][j] < tempMatrix[i + 1][j] &&
                        tempMatrix[i][j] < tempMatrix[i + 1][j + 1] &&
                        tempMatrix[i][j] < tempMatrix[i][j - 1] &&
                        tempMatrix[i][j] < tempMatrix[i][j + 1] &&
                        tempMatrix[i][j] < tempMatrix[i - 1][j - 1] &&
                        tempMatrix[i][j] < tempMatrix[i - 1][j] &&
                        tempMatrix[i][j] < tempMatrix[i - 1][j + 1]) {
                    result++;
                }
            }
        }

        System.out.println(result);

    }

    @Override
    public void task26() {

        int[][] matrix = readMatrix(new Scanner(System.in));
        boolean isLocalMaxExist = false;
        int result = 0;

        int[][] tempMatrix = new int[matrix.length + 2][matrix.length + 2];
        int min = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                tempMatrix[i + 1][j + 1] = matrix[i][j];
                min = max(min, matrix[i][j]);
            }
        }

        for (int i = 0; i < tempMatrix.length; i++) {
            tempMatrix[i][0] = min;
            tempMatrix[i][tempMatrix.length - 1] = min;
            tempMatrix[0][i] = min;
            tempMatrix[tempMatrix.length - 1][i] = min;
        }

        for (int i = 1; i < matrix.length + 1; i++) {
            for (int j = 1; j < matrix.length + 1; j++) {
                if (tempMatrix[i][j] > tempMatrix[i + 1][j - 1] &&
                        tempMatrix[i][j] > tempMatrix[i + 1][j] &&
                        tempMatrix[i][j] > tempMatrix[i + 1][j + 1] &&
                        tempMatrix[i][j] > tempMatrix[i][j - 1] &&
                        tempMatrix[i][j] > tempMatrix[i][j + 1] &&
                        tempMatrix[i][j] > tempMatrix[i - 1][j - 1] &&
                        tempMatrix[i][j] > tempMatrix[i - 1][j] &&
                        tempMatrix[i][j] > tempMatrix[i - 1][j + 1]) {
                    if (!isLocalMaxExist) {
                        result = tempMatrix[i][j];
                        isLocalMaxExist = true;
                    } else {
                        result = max(result, tempMatrix[i][j]);
                    }
                }
            }
        }

        if (isLocalMaxExist) {
            System.out.println(result);
        } else {
            System.out.println("NOT FOUND");
        }

    }

    @Override
    public void task27() {

        int[][] matrix = readMatrix(new Scanner(System.in));

        ArrayList<Object[]> tempStructure = new ArrayList<>();

        for (int j = 0; j < matrix[0].length; j++) {
            int sum = 0;
            int[] column = new int[matrix.length];
            for (int i = 0; i < matrix.length; i++) {
                column[i] = matrix[i][j];
                sum += abs(matrix[i][j]);
            }
            tempStructure.add(new Object[]{column, sum, j});
        }

        tempStructure.sort((o1, o2) -> {
            if ((int) o1[1] == (int) o2[1]) {
                return (int) o1[2] - (int) o2[2];
            } else {
                return (int) o2[1] - (int) o1[1];
            }
        });

        int[][] result = new int[matrix.length][matrix[0].length];
        for (int j = 0; j < result[0].length; j++) {
            int[] column = (int[]) tempStructure.get(j)[0];
            for (int i = 0; i < result.length; i++) {
                result[i][j] = column[i];
            }
        }

        printMatrix(result);


    }

}
