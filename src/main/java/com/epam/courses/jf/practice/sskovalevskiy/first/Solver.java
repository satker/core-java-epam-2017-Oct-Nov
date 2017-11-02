package com.epam.courses.jf.practice.sskovalevskiy.first;

import com.epam.courses.jf.practice.common.first.ISolver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by asus on 17.10.2017.
 */
public class Solver implements ISolver {
    @Override
//    TODO: #1 Done!
    public void task1() {

        int minLength = Integer.MAX_VALUE;
        int maxLength = Integer.MIN_VALUE;
        String minString = null;
        String maxString = null;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(reader.readLine());

            for (int i = 0; i < N; i++) {
                String s = reader.readLine();

                if (minLength >= s.length()) {
                    minLength = s.length();
                    minString = s;
                }

                if (maxLength <= s.length()) {
                    maxLength = s.length();
                    maxString = s;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.printf("MIN (%d): \"%s\"%n", minLength, minString);
        System.out.printf("MAX (%d): \"%s\"%n", maxLength, maxString);
    }

    @Override
//    TODO: #2 Done!
    public void task2() {


        ArrayList<String> strings = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int N = Integer.parseInt(reader.readLine());

            for (int i = 0; i < N; i++) {
                String s = reader.readLine();
                strings.add(s);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                } else {
                    return o1.length() - o2.length();
                }
            }
        };

        strings.sort(comparator);

        for (String string : strings) {
            System.out.printf("(%d): \"%s\"%n", string.length(), string);
        }
    }

    @Override
//    TODO: #3 Done!
    public void task3() {

        ArrayList<String> strings = new ArrayList<>();
        int allStringsLength = 0;
        int averageLength = 0;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int N = Integer.parseInt(reader.readLine());

            for (int i = 0; i < N; i++) {
                String s = reader.readLine();
                strings.add(s);
                allStringsLength += s.length();
            }

            averageLength = allStringsLength / N;

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.printf("AVERAGE (%d)%n", averageLength);

        for (String string : strings) {
            if (string.length() < averageLength) System.out.printf("(%d): \"%s\"%n", string.length(), string);
        }
    }

    @Override
    public void task4() {

//    TODO: #4 Done!
        Scanner reader = new Scanner(System.in);
        int N = reader.nextInt();

        String word = null;
        HashSet<Character> wordLetters = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String s = reader.next();

            HashSet<Character> characters = new HashSet();
            for (int j = 0; j < s.length(); j++) {
                characters.add(s.charAt(j));
            }

            if ((word == null) || (wordLetters.size() > characters.size())) {
                word = s;
                wordLetters = characters;
            }
        }

        System.out.println(word);
    }

    @Override
//    TODO: #5 Done!
    public void task5() {

        Scanner reader = new Scanner(System.in);
        int N = reader.nextInt();

        ArrayList<String> englishWords = new ArrayList<>();
        for (int i = 0; i < N; i++) {

            String word = reader.next();
            if (word.matches("[A-Za-z]+")) {

                Pattern vocals = Pattern.compile("(?iu)[aeiouy]");
                Matcher m = vocals.matcher(word);

                int vocalCounter = 0;
                while (m.find()) {
                    vocalCounter++;
                }

                if (vocalCounter == word.length() / 2.0) englishWords.add(word);
            }
        }

        System.out.println(englishWords.size());
    }

    @Override
//    TODO: #6 Done!
    public void task6() {

        Scanner reader = new Scanner(System.in);
        int N = reader.nextInt();

        ArrayList<String> words = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            words.add(reader.next());
        }

        int amountOfCorrectWords = 0;
        for (String word : words) {
            boolean isWordCorrect = true;

            if (word.length() != 1) {
                for (int i = 1; i < word.length(); i++) {

                    int length = word.length();
                    if ((word.charAt(i - 1) >= word.charAt(i))) {
                        isWordCorrect = false;
                        break;
                    }
                }
            } else isWordCorrect = false;

            if (isWordCorrect) {
                System.out.println(word);
                amountOfCorrectWords++;
                break;
            }
        }
        if (amountOfCorrectWords == 0) {
            System.out.println("NOT FOUND");
        }
    }

    @Override
//    TODO: #7 Done!
//    The Java programming language is a general-purpose, concurrent, class-based, object-oriented language
    public void task7() {

        Scanner reader = new Scanner(System.in);
        int N = reader.nextInt();

        Set<String> words = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String s = reader.next();

            HashSet<Character> characters = new HashSet();
            for (int j = 0; j < s.length(); j++) {
                characters.add(s.charAt(j));
            }

            if (characters.size() == s.length()) {
                words.add(s);
            }
        }

        if (words.isEmpty()) {
            System.out.println("NOT FOUND");
        } else {
            for (String word : words) {
                System.out.print(word + (words.iterator().hasNext() ? " " : ""));
            }
        }
    }

    @Override
//    TODO: #8 Done!
    public void task8() {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(reader.readLine());

            ArrayList<String> words = new ArrayList<>(Arrays.asList(reader.readLine().split(" ")));
            long palindrom = -1;
            int amountOfNumberPalindroms = 0;
            for (String s : words) {
                if (s.matches("\\d+") &&
                        ((s.length() == 1) || (new StringBuilder(s).reverse().toString().equals(s)))) {

                    palindrom = Long.parseLong(s);
                    amountOfNumberPalindroms++;

                } else continue;

                if (amountOfNumberPalindroms == 2) {
                    System.out.println(palindrom);
                    break;
                }
            }

            if (amountOfNumberPalindroms == 1) {
                System.out.println(palindrom);
            } else if (amountOfNumberPalindroms == 0) {
                System.out.println("NOT FOUND");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
//    TODO: #9 Done!
    public void task9() {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(reader.readLine());

            for (int i = 0; i < N; i++) {
                for (int j = 1; j <= N; j++) {
                    System.out.print(i * N + j + (j != N ? "\t" : "\n"));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
//    TODO: #10 Done!
    public void task10() {

        Scanner reader = new Scanner(System.in);

        int A = reader.nextInt();
        int B = reader.nextInt();
        int C = reader.nextInt();

        int D = B * B - 4 * A * C;
        double resultOne;
        double resultTwo;
        if (D < 0) {
            System.out.println("No solution");
        } else if (D == 0) {
            resultOne = -(double) B / (2 * A);

            System.out.printf("One solution: %s",
                    new BigDecimal(resultOne).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
        } else {
            resultOne = (-B - Math.sqrt((double) D)) / (2 * A);
            resultTwo = (-B + Math.sqrt((double) D)) / (2 * A);
            System.out.printf("Two solutions: %s, %s",
                    new BigDecimal(resultOne).setScale(2, BigDecimal.ROUND_HALF_UP).toString(),
                    new BigDecimal(resultTwo).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
        }
    }

    @Override
//    TODO: #11 Done!
    public void task11() {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int number = Integer.parseInt(reader.readLine());
            switch (number) {
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
            }
        } catch (IOException | NumberFormatException ex) {
            System.out.println("INCORRECT INPUT DATA");
        }

    }

    @Override
//    TODO: #12 Done!
    public void task12() {

        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int N = scanner.nextInt();

        Integer[][] matrix = new Integer[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        Arrays.sort(matrix, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[k] - o2[k];
            }
        });

        System.out.println(N);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    @Override
//    TODO: #13 Done!
    public void task13() {

        Scanner scanner = new Scanner(System.in);
        final int k = scanner.nextInt();

        final int DIMENSION = scanner.nextInt();
        int[][] matrix = new int[DIMENSION][DIMENSION];
        for (int row = 0; row < DIMENSION; ++row) {
            for (int col = 0; col < DIMENSION; ++col) {
                matrix[row][col] = scanner.nextInt();
            }
        }
//          [0 | 1 | 2] -> [2 | 0 | 1] -> [1 | 2 | 0] -> [0 | 1 | 2]
//          Если при вычитании из индекса количества смещений получается отрицательное число - добавляем matrix.length-1
//          [0 | 1 | 2 | 3] -> [3 | 0 | 1 | 2] -> [2 | 3 | 0 | 1] -> [1 | 2 | 3 | 0]

        for (int i = 0; i < Math.abs(k); i++) {
//            В цикле каждый раз элементы массива смещаются вниз на 1 позицию при k > 0,
//            либо поднимаются вверх на 1 позицию при k < 0.
            if (k > 0) {
                int[] temp = matrix[matrix.length - 1];
                for (int j = matrix.length - 1; j > 0; j--) {
                    matrix[j] = matrix[j - 1];
                }
                matrix[0] = temp;
            } else {
                int[] temp = matrix[0];
                for (int j = 0; j < matrix.length - 1; j++) {
                    matrix[j] = matrix[j + 1];
                }
                matrix[matrix.length - 1] = temp;
            }
        }


        System.out.println(DIMENSION);
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                System.out.print(matrix[i][j] + ((j == (DIMENSION - 1)) ? "\n" : "\t"));
            }
        }
    }

    @Override
//    TODO: #14 Done!
    public void task14() {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> numbers = new ArrayList<>();
        final int N = scanner.nextInt();

        int maxLength = 1;
        int currentLength = 1;
        for (int i = 0; i < N; i++) {
            int currentNumber = scanner.nextInt();
            numbers.add(currentNumber);
            if (i > 0 && currentNumber > numbers.get(i - 1)) {
                currentLength++;
            } else {
                currentLength = 1;
            }
            if (maxLength < currentLength) maxLength = currentLength;
        }

        System.out.println(maxLength);

    }

    @Override
//    TODO: #15 Done!
    public void task15() {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[][] A = new int[N][N];

        int sum = 0;
        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                A[i][j] = scanner.nextInt();
                if (A[i][j] > 0) {
                    count++;
                }
                if (count == 1 && A[i][j] < 0) {
                    sum += A[i][j];
                }
            }
        }

        System.out.println(sum);
    }

    @Override
//    TODO: #16 Done!
    public void task16() {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[][] A = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                A[i][j] = scanner.nextInt();
            }
        }

//        00 01 02
//        10 11 12
//        20 21 22

//        02 12 22
//        01 11 21
//        00 10 20

        int[][] B = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                B[i][j] = A[j][N - 1 - i];
            }
        }

        System.out.println(N);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(B[i][j] + ((j == (N - 1)) ? "\n" : "\t"));
            }
        }
    }

    @Override
//    TODO: #17
//    Вычисляем только определитель для матрицы 3×3 или любого размера?
    public void task17() {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[][] A = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                A[i][j] = scanner.nextInt();
            }
        }
//        ∆ = a11·a22·a33 + a12·a23·a31 + a13·a21·a32 - a13·a22·a31 - a11·a23·a32 - a12·a21·a33
        int detA = A[0][0] * A[1][1] * A[2][2]
                + A[0][1] * A[1][2] * A[2][0]
                + A[0][2] * A[1][0] * A[2][1]
                - A[0][2] * A[1][1] * A[2][0]
                - A[0][0] * A[1][2] * A[2][1]
                - A[0][1] * A[1][0] * A[2][2];

        System.out.println(detA);
    }

    @Override
//    TODO: #18 Done!
//    Вводимая матрица будет квадратная, как в примерах задания(вводится одно число - размер матрицы и сама матрица),
//    или как в условии N*M? И что значат одиночные числа в выходных данных в примерах?
    public void task18() {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[][] A = new int[N][N];

        int maxElement = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                A[i][j] = scanner.nextInt();
                if (maxElement < A[i][j]) maxElement = A[i][j];
            }
        }
        HashSet<Integer> linesToDelete = new HashSet<>();
        HashSet<Integer> columnToDelete = new HashSet<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (maxElement == A[i][j]) {
                    linesToDelete.add(i);
                    columnToDelete.add(j);
                }
            }
        }

        System.out.println(N - linesToDelete.size());
        System.out.println(N - columnToDelete.size());

        for (Integer i = 0; i < N; i++) {
            if (linesToDelete.contains(i)) continue;
            for (Integer j = 0; j < N; j++) {
                if (columnToDelete.contains(j)) continue;
                System.out.print(A[i][j] + (j.equals(Integer.valueOf(N - 1)) ? "\n" : "\t"));
            }
        }


    }

    @Override
//    TODO: #19 Done!
    public void task19() {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[][] A = new int[N][N];

        HashSet<Integer> linesToDelete = new HashSet<>();
        for (int i = 0; i < N; i++) {
            boolean deleteLine = true;
            for (int j = 0; j < N; j++) {
                A[i][j] = scanner.nextInt();
                if (A[i][j] != 0) {
                    deleteLine = false;
                }
            }
            if (deleteLine) linesToDelete.add(i);
        }

        HashSet<Integer> columnToDelete = new HashSet<>();
        for (int j = 0; j < N; j++) {
            boolean deleteColumn = true;
            for (int i = 0; i < N; i++) {
                if (A[i][j] != 0) {
                    deleteColumn = false;
                }
            }
            if (deleteColumn) columnToDelete.add(j);
        }

        System.out.println(N - linesToDelete.size());
        System.out.println(N - columnToDelete.size());
        for (Integer i = 0; i < N; i++) {
            if (linesToDelete.contains(i)) continue;
            for (Integer j = 0; j < N; j++) {
                if (columnToDelete.contains(j)) continue;
                System.out.print(A[i][j] + (j.equals(Integer.valueOf(N - 1)) ? "\n" : "\t"));
            }
        }
    }

    @Override
//    TODO: #20 Done!
    public void task20() {
        Scanner scanner = new Scanner(System.in);
        int X = scanner.nextInt();
        int Y = scanner.nextInt();
        int N = scanner.nextInt();

        int[][] A = new int[N][N];

        int minElement = Integer.MAX_VALUE;
        int minElementX = -1;
        int minElementY = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                A[i][j] = scanner.nextInt();
                if (minElement > A[i][j]) {
                    minElement = A[i][j];
                    minElementX = i;
                    minElementY = j;
                }
            }
        }

//        меняем строки местами
        int[] temp = A[X];
        A[X] = A[minElementX];
        A[minElementX] = temp;

//        меняем местами значения в столбцах
        for (int i = 0; i < N; i++) {
            int tmp = A[i][Y];
            A[i][Y] = A[i][minElementY];
            A[i][minElementY] = tmp;
        }

        System.out.println(N);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(A[i][j] + ((j == (N - 1)) ? "\n" : "\t"));
            }
        }
    }

    @Override
//    TODO: #21 Done!
    public void task21() {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[][] A = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                A[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                if (A[i][j] == 0) {
                    A[i][j] = A[i][j + 1];
                    A[i][j + 1] = 0;
                }
            }
        }

        System.out.println(N);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(A[i][j] + ((j == (N - 1)) ? "\n" : "\t"));
            }
        }
    }

    @Override
//    TODO: #22 Done!
    public void task22() {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        double[][] A = new double[N][N];

//        2,42   1,0   -2,99
//        0,54    0,0   3,0
//        -1,5    1,89 2,0

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                A[i][j] = scanner.nextDouble();
            }
        }

        System.out.println(N);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(Math.round(A[i][j]) + ((j == (N - 1)) ? "\n" : "\t"));
            }
        }
    }

    @Override
//    TODO: #23 Done!
    public void task23() {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[][] A = new int[N][N];

        HashMap<Integer, Integer> coordinates = new HashMap<>();

//        Пробежим в цикле считаем элементы матрицы, заодно найдем в каждой строке минимальный элемент
//        и кинем его координаты в HashMap, где ключ - номер строки, значение - номер столбца.
//        Если в этой строке уже был минимальный элемент - он будет заменён новым значением.
//        Если такое значение уже находили - значит элемент не минимальный, следовательно - удаляем координаты из Map по ключу i
        for (int i = 0; i < N; i++) {
            int minElementInLine = Integer.MAX_VALUE;
            for (int j = 0; j < N; j++) {
                A[i][j] = scanner.nextInt();

                if (minElementInLine > A[i][j]) {
                    minElementInLine = A[i][j];
                    coordinates.put(i, j);
                } else if (minElementInLine == A[i][j]) {
                    coordinates.remove(i);
                }
            }
        }

//        Теперь пробежим по Map, дернем из нее координаты, и во внутреннем цикле проверим, 
//        является ли указанный элемент максимальным в столбце
        int numberOfSaddlePoints = 0;
        for (Map.Entry<Integer, Integer> entry : coordinates.entrySet()) {
            int maxElement = A[entry.getKey()][entry.getValue()];
            boolean isMaxElement = true;
            int j = entry.getValue();

            for (int i = 0; i < N; i++) {
                if (entry.getKey().equals(i)) {
//                  Чтобы не сравнивать с самим собой
                    continue;
                }

                if (maxElement <= A[i][j]) {
                    isMaxElement = false;
                }
            }

            if (isMaxElement) {
                numberOfSaddlePoints++;
            }
        }

        System.out.println(numberOfSaddlePoints);
    }

    @Override
//    TODO: #24 Done!
    public void task24() {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        Integer[][] A = new Integer[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                A[i][j] = scanner.nextInt();
            }
        }

        Arrays.sort(A, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                int sum1 = 0;
                int sum2 = 0;
                for (int i = 0; i < N; i++) {
                    sum1 += o1[i];
                    sum2 += o2[i];
                }
                return sum1 - sum2;
            }
        });

        System.out.println(N);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(A[i][j] + ((j == (N - 1)) ? "\n" : "\t"));
            }
        }
    }

    @Override
//    TODO: #25 Done!
    public void task25() {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[][] A = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                A[i][j] = scanner.nextInt();
            }
        }

        int numberOfLocalMins = 0;

//        A[i-1][j-1] A[i-1][j] A[i-1][j+1]
//        A[ i ][j-1] A[ i ][j] A[ i ][j+1]
//        A[i+1][j-1] A[i+1][j] A[i+1][j+1]

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                boolean isLocalMinimum =
                        ((i == 0 || ((j == 0 || A[i][j] < A[i - 1][j - 1]) &&
                                (A[i][j] < A[i - 1][j]) &&
                                (j == N - 1 || A[i][j] < A[i - 1][j + 1]))) &&
                                ((j == 0 || A[i][j] < A[i][j - 1]) && (j == N - 1 || A[i][j] < A[i][j + 1])) &&
                                (i == N - 1 || ((j == 0 || A[i][j] < A[i + 1][j - 1]) &&
                                        (A[i][j] < A[i + 1][j]) &&
                                        (j == N - 1 || A[i][j] < A[i + 1][j + 1]))));

                if (isLocalMinimum) numberOfLocalMins++;

            }
        }

        System.out.println(numberOfLocalMins);
    }

    @Override
//    TODO: #26 Done!
    public void task26() {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[][] A = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                A[i][j] = scanner.nextInt();
            }
        }

        ArrayList<Integer> localMaxumums = new ArrayList<>();

//        A[i-1][j-1] A[i-1][j] A[i-1][j+1]
//        A[ i ][j-1] A[ i ][j] A[ i ][j+1]
//        A[i+1][j-1] A[i+1][j] A[i+1][j+1]

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                boolean isLocalMaximum =
                        ((i == 0 || ((j == 0 || A[i][j] > A[i - 1][j - 1]) &&
                                (A[i][j] > A[i - 1][j]) &&
                                (j == N - 1 || A[i][j] > A[i - 1][j + 1]))) &&
                                ((j == 0 || A[i][j] > A[i][j - 1]) && (j == N - 1 || A[i][j] > A[i][j + 1])) &&
                                (i == N - 1 || ((j == 0 || A[i][j] > A[i + 1][j - 1]) &&
                                        (A[i][j] > A[i + 1][j]) &&
                                        (j == N - 1 || A[i][j] > A[i + 1][j + 1]))));

                if (isLocalMaximum) {
                    localMaxumums.add(A[i][j]);
                }
            }
        }

        if (localMaxumums.size() == 0) {
            System.out.println("NOT FOUND");
        } else {
            System.out.println(Collections.max(localMaxumums));
        }

    }

    @Override
//    TODO: #27 Done!
    public void task27() {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        Integer[][] A = new Integer[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                A[j][i] = scanner.nextInt();
            }
        }

        Arrays.sort(A, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                int sum1 = 0;
                int sum2 = 0;
                for (int i = 0; i < N; i++) {
                    sum1 += Math.abs(o1[i]);
                    sum2 += Math.abs(o2[i]);
                }
                return sum2 - sum1;
            }
        });

        System.out.println(N);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(A[j][i] + ((j == (N - 1)) ? "\n" : "\t"));
            }
        }
    }

    public static void main(String[] args) {

        new Solver().task5();
    }
}
