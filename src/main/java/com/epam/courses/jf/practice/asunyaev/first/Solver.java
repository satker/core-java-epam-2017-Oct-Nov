package com.epam.courses.jf.practice.asunyaev.first;

import com.epam.courses.jf.practice.common.first.ISolver;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solver implements ISolver {

    public static void main(String[] args) {
        Solver solver = new Solver();
        solver.task24();
    }

    @Override
    public void task1() {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int currentLength = 0;
        String currentString;
        int maxLength = 0;
        int minLength = 80;
        String maxString = "";
        String minString = "";

        scan.nextLine();

        for (int i = 0; i < N; i++) {
            currentString = scan.nextLine();
            currentLength = currentString.length();

            if (currentLength >= maxLength) {
                maxLength = currentLength;
                maxString = currentString;
            }

            if (currentLength <= minLength) {
                minLength = currentLength;
                minString = currentString;
            }
        }

        System.out.printf("MIN (%d): \"%s\"%n", minLength, minString);
        System.out.printf("MAX (%d): \"%s\"%n", maxLength, maxString);
    }

    @Override
    public void task2() {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        HashMap<Integer, String> lines = new HashMap<>();
        int[] lengths = new int[N];
        String currentString;

        scan.nextLine();

        for (int i = 0; i < N; i++) {
            currentString = scan.nextLine();
            lengths[i] = currentString.length();
            lines.put(lengths[i], currentString);
        }

        Arrays.sort(lengths);

        for (int i = 0; i < N; i++) {
            lines.get(lengths[i]);
            System.out.printf("(%d): \"%s\"%n", lengths[i], lines.get(lengths[i]));
        }
    }

    @Override
    public void task3() {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int averageLength = 0;
        HashMap<Integer, String> lines = new HashMap<>();
        int[] lengths = new int[N];
        String currentString;

        scan.nextLine();

        for (int i = 0; i < N; i++) {
            currentString  = scan.nextLine();
            lengths[i] = currentString.length();
            lines.put(lengths[i], currentString);
        }

        averageLength = (int) Arrays.stream(lengths).average().getAsDouble();
        System.out.printf("AVERAGE (%d)%n", averageLength);

        for (int i = 0; i < N; i++) {
            if (lengths[i] < averageLength) {
                System.out.printf("(%d): \"%s\"%n", lengths[i], lines.get(lengths[i]));
            }
        }
    }

    @Override
    public void task4() {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        scan.nextLine();
        HashMap<String, HashSet> words = new HashMap<>();
        String currentWord;
        String maxWord = "";
        int maxLength = 80;

        for (int i = 0; i < N; i++) {
            currentWord = scan.next();
            HashSet letters = new HashSet();
            for (int j = 0; j < currentWord.length(); j++) {
                letters.add(currentWord.charAt(j));
            }
            words.put(currentWord, letters);
        }

        for(Map.Entry<String, HashSet> entry : words.entrySet()) {
            int currentLength = entry.getValue().size();
            if (currentLength < maxLength) {
                maxLength = currentLength;
                maxWord = entry.getKey();
            }
        }
        System.out.println(maxWord);
    }

    @Override
    public void task5() {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        scan.nextLine();
        String currentWord;
        int result = 0;
        int currentWordVocals = 0;

        for (int i = 0; i < N; i++) {
            currentWord = scan.next();
            currentWordVocals = countEnglishVocals(currentWord);
            if (currentWord.length() - currentWordVocals == currentWordVocals) {
                result++;
            }
        }
        System.out.println(result);
    }

    @Override
    public void task6() {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        String currentWord;
        int wordsCounter = 0;

        cycle:
        for (int i = 0; i < N; i++) {
            currentWord = scan.next();

            if (currentWord.length() == 1) {
                continue;
            }

            for (int j = 0; j < currentWord.length() - 1; j++) {
                if (currentWord.codePointAt(j+1) < currentWord.codePointAt(j)) {
                    continue cycle;
                }
            }

            wordsCounter++;
            if (wordsCounter == 1) {
                System.out.println();
            }
            System.out.print(currentWord + " ");
        }

        if (wordsCounter == 0) {
            System.out.print("NOT FOUND");
        }
    }

    @Override
    public void task7() {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        String currentWord;
        int wordsCounter = 0;
        scan.nextLine();

        cycle:
        for (int i = 0; i < N; i++) {
            currentWord = scan.next();

            if (currentWord.length() == 1) {
                System.out.print(currentWord + " ");
                continue;
            }

            for (int j = 1; j < currentWord.length(); j++) {
                String subString = currentWord.substring(0, j);
                if (subString.indexOf(currentWord.charAt(j)) != -1) {
                    continue cycle;
                }

            }
            wordsCounter++;
            if (wordsCounter == 1) {
                System.out.println();
            }
            System.out.print(currentWord + " ");
        }

        if (wordsCounter == 0) {
            System.out.print("NOT FOUND");
        }
    }

    @Override
    public void task8() {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        String currentWord;
        ArrayList<Integer> palyndroms = new ArrayList<Integer>();
        scan.nextLine();


        for (int i = 0; i < N; i++) {
            currentWord = scan.next();

            try {
                int number = Integer.parseInt(currentWord);
                if (isPalyndrom(number)) {
                    palyndroms.add(number);
                }
            } catch (NumberFormatException e) {
                continue;
            }
        }

        switch (palyndroms.size()) {
            case 0:
                System.out.println("NOT FOUND");
                break;
            case 1:
                System.out.println(palyndroms.get(0));
                break;
            default:
                System.out.println(palyndroms.get(1));
                break;
        }

    }

    @Override
    public void task9() {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int k = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(k + "\t");
                k++;
            }
            System.out.println();
        }
    }

    @Override
    public void task10() {
        Scanner scan = new Scanner(System.in);
        double a = Double.valueOf(scan.next());
        double b = Double.valueOf(scan.next());
        double c = Double.valueOf(scan.next());
        double d = Math.pow(b, 2) - 4*a*c;

        if (d == 0) {
            BigDecimal solution = new BigDecimal((double) (-b + Math.sqrt(d))/(2*a));
            System.out.println("One solution: " + solution.setScale(2, RoundingMode.HALF_UP ).stripTrailingZeros());
        } else if (d > 0) {
            BigDecimal solution1 = new BigDecimal((double) (-b - Math.sqrt(d))/(2*a));
            BigDecimal solution2 = new BigDecimal( (double) (-b + Math.sqrt(d))/(2*a));
            System.out.println("Two solutions: " + solution1.setScale(2, RoundingMode.HALF_UP ).stripTrailingZeros() + ", " + solution2.setScale(2, RoundingMode.HALF_UP ).stripTrailingZeros());
        } else {
            System.out.println("No solution");
        }
    }

    @Override
    public void task11() {
        Scanner scan = new Scanner(System.in);
        int monthNumber = 0;
        String string = scan.nextLine();

        try {
            monthNumber = Integer.valueOf(string);
            if (monthNumber <= 1 && monthNumber >= 12) {
                System.out.println("INCORRECT INPUT DATA");
            }
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
            }
        } catch(NumberFormatException e) {
            System.out.println("INCORRECT INPUT DATA");
        }
    }

    @Override
    public void task12() {
        Scanner scanner = new Scanner(System.in);
        final int k = scanner.nextInt();
        final int DIMENSION = scanner.nextInt();
        int[][] matrix = readMatrix(scanner, DIMENSION);
        Arrays.sort(matrix, new Comparator<int[]>() {
            @Override
            public int compare(final int[] row1, final int[] row2) {
                final Integer value1 = row1[k];
                final Integer value2 = row2[k];
                return value1.compareTo(value2);
            }
        });
        printMatrix(matrix, DIMENSION);
    }

    @Override
    public void task13() {
        Scanner scanner = new Scanner(System.in);
        final int shift = scanner.nextInt();
        final int DIMENSION = scanner.nextInt();
        int[][] matrix = readMatrix(scanner, DIMENSION);
        int newIndex = 0;
        int[][] shiftedMatrix = new int[DIMENSION][DIMENSION];

        if (shift == 0) {
            printMatrix(matrix, DIMENSION);
        } else {
            for (int index = 0; index < DIMENSION; index++) {
                newIndex = index + shift >= 0
                            ? (index + shift) % DIMENSION
                            : (index + shift) + DIMENSION;
                copyRow(matrix, index, shiftedMatrix, newIndex);
            }
        }

        printMatrix(shiftedMatrix, DIMENSION);

    }

    @Override
    public void task14() {
        Scanner scanner = new Scanner(System.in);
        final int N = scanner.nextInt();
        int maxLength = 1;
        scanner.nextLine();
        int array[] = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = scanner.nextInt();
        }

        for (int i = 0; i < N - 1; i++) {
            int j = i;
            int currentLength = 1;
            while (array[j+1] > array[j]) {
                currentLength++;
                j++;
            }
            if (maxLength < currentLength) {
                maxLength = currentLength;
            }
        }

        System.out.println(maxLength);


    }

    @Override
    public void task15() {
        Scanner scanner = new Scanner(System.in);
        final int DIMENSION = scanner.nextInt();
        int[][] matrix = readMatrix(scanner, DIMENSION);
        int sum = 0;

        for (int i = 0; i < DIMENSION; i++) {
            int[] indexes = {-1, -1};
            int j = 0;
            int s = 0;
            while (((indexes[0] == -1) || (indexes[1] == -1)) && (j < DIMENSION))  {
                if (matrix[i][j] > 0) {
                    indexes[s] = j;
                    s++;
                }
                j++;
            }

            if ((indexes.length < 2) || (indexes[1] == indexes[0] + 1)) {
                continue;
            }

            for (int k = indexes[0] + 1; k < indexes[1]; k++) {
                sum = sum + matrix[i][k];
            }
        }

        System.out.println(sum);
    }

    @Override
    public void task16() {
        Scanner scanner = new Scanner(System.in);
        final int DIMENSION = scanner.nextInt();
        int[][] matrix = readMatrix(scanner, DIMENSION);
        int[][] turnedMatrix = new int[DIMENSION][DIMENSION];

        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                turnedMatrix[i][j] = matrix[j][DIMENSION - i - 1];
            }
        }

        printMatrix(turnedMatrix, DIMENSION);
    }

    @Override
    public void task17() {
        Scanner scanner = new Scanner(System.in);
        final int DIMENSION = scanner.nextInt();
        double[][] matrix = readDoubleMatrix(scanner, DIMENSION);
        System.out.println((int) determinant(matrix, DIMENSION));
    }

    @Override
    public void task18() {
        Scanner scanner = new Scanner(System.in);
        final int DIMENSION = scanner.nextInt();
        int[][] matrix = readMatrix(scanner, DIMENSION);
        int maxElement = 0;
        HashSet<Integer> rowsToDelete = new HashSet<Integer>();
        HashSet<Integer> columnsToDelete = new HashSet<Integer>();
        int[][] modifiedMatrix;
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                if (matrix[i][j] > maxElement) {
                    maxElement = matrix[i][j];
                }
            }
        }
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                if (matrix[i][j] == maxElement) {
                    rowsToDelete.add(i);
                    columnsToDelete.add(j);
                }
            }
        }

        modifiedMatrix = removeRows(matrix, rowsToDelete);
        modifiedMatrix = removeColumns(modifiedMatrix, columnsToDelete);
        System.out.println(modifiedMatrix.length);
        System.out.println(modifiedMatrix[0].length);
        printAnyMatrix(modifiedMatrix);
    }

    @Override
    public void task19() {
        Scanner scanner = new Scanner(System.in);
        final int DIMENSION = scanner.nextInt();
        int[][] matrix = readMatrix(scanner, DIMENSION);
        HashSet<Integer> rowsToDelete = new HashSet<Integer>();
        HashSet<Integer> columnsToDelete = new HashSet<Integer>();
        int[][] modifiedMatrix;
        outer:
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                if (matrix[i][j] != 0) {
                    continue outer;
                }
            }
            rowsToDelete.add(i);
        }

        outer:
        for (int j = 0; j < DIMENSION; j++) {
            for (int i = 0; i < DIMENSION; i++) {
                if (matrix[i][j] != 0) {
                    continue outer;
                }
            }
            columnsToDelete.add(j);
        }

        modifiedMatrix = removeRows(matrix, rowsToDelete);
        modifiedMatrix = removeColumns(modifiedMatrix, columnsToDelete);
        System.out.println(modifiedMatrix.length);
        System.out.println(modifiedMatrix[0].length);
        printAnyMatrix(modifiedMatrix);
    }

    @Override
    public void task20() {
        Scanner scanner = new Scanner(System.in);
        final int newRow = scanner.nextInt();
        final int newColumn = scanner.nextInt();
        final int DIMENSION = scanner.nextInt();
        int[][] matrix = readMatrix(scanner, DIMENSION);
        int[][] modifiedMatrix;
        int minElement = 1000;
        int minElementRow = -1;
        int minElementColumn = -1;
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                if (matrix[i][j] < minElement) {
                    minElement = matrix[i][j];
                    minElementRow = i;
                    minElementColumn = j;
                }
            }
        }

        modifiedMatrix = swapRows(matrix, minElementRow, newRow);
        modifiedMatrix = swapColumns(modifiedMatrix, minElementColumn, newColumn);

        System.out.println(DIMENSION);
        printMatrix(modifiedMatrix, DIMENSION);
    }

    @Override
    public void task21() {
        Scanner scanner = new Scanner(System.in);
        final int DIMENSION = scanner.nextInt();
        int[][] matrix = readMatrix(scanner, DIMENSION);
        Integer[][] modifiedMatrix = new Integer[DIMENSION][DIMENSION];
        for (int i = 0; i < DIMENSION; i++) {
            ArrayList<Integer> rowList = new ArrayList<Integer>(Arrays.asList(Arrays.stream(matrix[i]).boxed().toArray(Integer[]::new)));
            for (int j = 0; j < DIMENSION - 1; j++) {
                rowList.remove((Integer) 0);
                rowList.add(0);
            }
            modifiedMatrix[i] = rowList.toArray(modifiedMatrix[i]);
        }

        System.out.println(DIMENSION);
        printIntegerMatrix(modifiedMatrix, DIMENSION);
    }

    @Override
    public void task22() {
        Scanner scanner = new Scanner(System.in);
        final int DIMENSION = scanner.nextInt();
        double[][] matrix = readDoubleMatrix(scanner, DIMENSION);
        int[][] modifiedMatrix = new int[DIMENSION][DIMENSION];
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                modifiedMatrix[i][j] = (int) Math.round(matrix[i][j]);
            }
        }
        System.out.println(DIMENSION);
        printMatrix(modifiedMatrix, DIMENSION);
    }

    @Override
    public void task23() {
        Scanner scanner = new Scanner(System.in);
        final int DIMENSION = scanner.nextInt();
        int[][] matrix = readMatrix(scanner, DIMENSION);
        int saddlePointCount = 0;
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                int[] column = new int[DIMENSION];
                int[] row = new int[DIMENSION];
                for (int k = 0; k < DIMENSION; k++) {
                    column[k] = matrix[k][j];
                    row[k] = matrix[i][k];
                }
                Arrays.sort(row);
                Arrays.sort(column);
                if ((matrix[i][j] == row[0]) && (matrix[i][j] == column[DIMENSION-1])){
                    saddlePointCount++;
                }
            }
        }

        System.out.println(saddlePointCount);

    }

    @Override
    public void task24() {
        Scanner scanner = new Scanner(System.in);
        final int DIMENSION = scanner.nextInt();
        int[][] matrix = readMatrix(scanner, DIMENSION);
        int[][] modifiedMatrix = new int[DIMENSION][DIMENSION];
        TreeMap<Integer, Integer> sums = new TreeMap<>();
        for (int i = 0; i < DIMENSION; i++) {
            sums.put(Arrays.stream(matrix[i]).sum(), i);
        }
        for (int i = 0; i < DIMENSION; i++) {
            if (!sums.containsValue(i)) {
                modifiedMatrix[i] = matrix[i];
            }
            modifiedMatrix[i] = matrix[(int) (sums.values().toArray()[i])];
        }
        System.out.println(DIMENSION);
        printMatrix(modifiedMatrix, DIMENSION);
    }

    //@Override
    //public void task25() TODO

    //@Override
    //public void task26() TODO

    //@Override
    //public void task27() TODO

    private void copyRow(int[][] fromMatrix, int rowIndex1, int[][] toMatrix, int rowIndex2) {
        for (int i = 0; i < fromMatrix.length; i++) {
            toMatrix[rowIndex2][i] = fromMatrix[rowIndex1][i];
        }
    }

    private int[][] readMatrix(Scanner scanner, int dimension) {
        int[][] matrix = new int[dimension][dimension];
        for (int row = 0; row < dimension; ++row) {
            for (int col = 0; col < dimension; ++col) {
                matrix[row][col] = scanner.nextInt();
            }
        }
        return matrix;
    }

    private void printMatrix(int[][] matrix, int dimension) {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private void printIntegerMatrix(Integer[][] matrix, int dimension) {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private int countEnglishVocals(String string) {
        Pattern vocals = Pattern.compile("(?iu)[aeiou]");
        Matcher m = vocals.matcher(string);
        int vocalCounter = 0;
        while (m.find()) {
            vocalCounter++;
        }
        return vocalCounter;
    }

    private boolean isPalyndrom(int number) {
        String stringNumber = String.valueOf(number);
        if (stringNumber.length() == 1) {
            return true;
        }
        return stringNumber.equals(new StringBuilder(stringNumber).reverse().toString());
    }

    private double determinant(double A[][], int N) {
        double det = 0;
        if (N == 1) {
            det = A[0][0];
        }
        else if (N == 2) {
            det = A[0][0]*A[1][1] - A[1][0]*A[0][1];
        }
        else {
            det = 0;
            for(int j1 = 0; j1 < N; j1++) {
                double[][] m = new double[N-1][];
                for(int k = 0; k < N-1; k++) {
                    m[k] = new double[N-1];
                }
                for(int i = 1; i < N; i++) {
                    int j2 = 0;
                    for(int j = 0; j < N; j++) {
                        if (j == j1) {
                            continue;
                        }
                        m[i-1][j2] = A[i][j];
                        j2++;
                    }
                }
                det += Math.pow(-1.0, 1.0 + j1 + 1.0)* A[0][j1] * determinant(m,N-1);
            }
        }
        return det;
    }

    private double[][] readDoubleMatrix(Scanner scanner, int dimension) {
        double[][] matrix = new double[dimension][dimension];
        for (int row = 0; row < dimension; ++row) {
            for (int col = 0; col < dimension; ++col) {
                matrix[row][col] = scanner.nextDouble();
            }
        }
        return matrix;
    }

    private int[][] removeRows (int[][] matrix, HashSet<Integer> indexes) {
        int[][] modifiedMatrix = new int[matrix.length - indexes.size()][matrix[0].length];
        int k = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (!indexes.contains(i)) {
                for (int j = 0; j < matrix[0].length; j++) {
                    modifiedMatrix[k][j] = matrix[i][j];
                }
                k++;
            }
        }
        return modifiedMatrix;
    }

    private int[][] removeColumns (int[][] matrix, HashSet<Integer> indexes) {
        int[][] modifiedMatrix = new int[matrix.length][matrix[0].length - indexes.size()];
        int k = 0;
        for(int i = 0; i < matrix[0].length; i++) {
            if (!indexes.contains(i)) {
                for (int j = 0; j < matrix.length; j++) {
                    modifiedMatrix[j][k] = matrix[j][i];
                }
                k++;
            }
        }
        return modifiedMatrix;
    }

    private void printAnyMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private int[][] swapRows (int[][] matrix, int index1, int index2) {
        int[] row1 = new int[matrix.length];
        int[] row2 = new int[matrix.length];
        for (int j = 0; j < matrix.length; j++) {
            row1[j] = matrix[index1][j];
            row2[j] = matrix[index2][j];
        }

        for (int j = 0; j < matrix.length; j++) {
            matrix[index2][j] = row1[j];
            matrix[index1][j] = row2[j];
        }

        return matrix;
    }

    private int[][] swapColumns (int[][] matrix, int index1, int index2) {
        int[] row1 = new int[matrix.length];
        int[] row2 = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            row1[i] = matrix[i][index1];
            row2[i] = matrix[i][index2];
        }

        for (int i = 0; i < matrix.length; i++) {
            matrix[i][index2] = row1[i];
            matrix[i][index1] = row2[i];
        }

        return matrix;
    }

}
