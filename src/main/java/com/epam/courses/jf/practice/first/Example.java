package com.epam.courses.jf.practice.first;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

/**
 * Реализация первого блока заданий.
 */
public class Example {

    public static void main(String[] args) {
        Example example = new Example();
        example.task14();
    }

    /**
     * Ввод масива поэлементно
     *
     * @return массив типа double
     */
    private static double[][] readDoubleMatrix() {
        Scanner scanner = new Scanner(System.in);
        int matrixSize = (int) scanner.nextDouble();

        double[][] matrix = new double[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }

        return matrix;
    }

    /**
     * Ввод масива поэлементно
     *
     * @return массив типа int
     */
    private static int[][] readIntMatrix() {
        Scanner scanner = new Scanner(System.in);
        int matrixSize = scanner.nextInt();

        int[][] matrix = new int[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        return matrix;
    }

    /**
     * Вывод матрицы на экран
     *
     * @param matrix матрица типа int
     */
    private static void printIntMatrix(int[][] matrix) {
        System.out.println(matrix.length);
        for (int[] aMatrix : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                if (j == matrix.length - 1) {
                    System.out.print(aMatrix[j]);
                } else {
                    System.out.print(aMatrix[j] + "\t");
                }
            }
            System.out.println();
        }
    }

    /**
     * Ввести N строк, найти самую короткую и самую длинную строки.
     * Вывести найденные строки и их длину. Если строк, удовлетворяющих условию,
     * более одной - вывести последнюю из них.
     * <p>
     * N (целое число, 0 < N < 100) - количество доступных для чтения строк
     * N строк
     */

    public void task1() {
        Scanner scanner = new Scanner(System.in);
        String[] strings = getStrings(scanner);

        int minLength = strings[0].length();
        int maxLength = strings[0].length();

        String minString = null;
        String maxString = null;

        for (String string : strings) {
            if (minLength >= string.length()) {
                minLength = string.length();
                minString = string;
            }
            if (maxLength <= string.length()) {
                maxLength = string.length();
                maxString = string;
            }
        }

        System.out.printf("MIN (%d): \"%s\"%n", minLength, minString);
        System.out.printf("MAX (%d): \"%s\"%n", maxLength, maxString);
    }

    /**
     * Ввести N строк. Упорядочить и вывести строки в порядке возрастания значений их длины.
     * В случае, если длины строк совпадают - упорядочить их в лексикографическом порядке.
     */

    public void task2() {
        Scanner scanner = new Scanner(System.in);
        String[] strings = getStrings(scanner);

        Arrays.sort(strings, Comparator.comparingInt(String::length)
                                       .thenComparing(String::compareTo));

        for (String string : strings) {
            System.out.printf("(%d): \"%s\"%n", string.length(), string);
        }
    }

    private String[] getStrings(Scanner scanner) {
        int n = Integer.parseInt(scanner.nextLine());

        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = scanner.nextLine();
        }
        return strings;
    }

    /**
     * Ввести N строк. Вывести те строки, длина которых меньше средней.
     * Под 'средней' подразумевается среднеарифметическая величина длины
     * всех строк, округленная до целого в меньшую сторону.
     */

    public void task3() {
        Scanner scanner = new Scanner(System.in);
        String[] input = getStrings(scanner);

        int sum = 0;
        for (String anInput : input) {
            sum += anInput.length();
        }
        int average = sum / input.length;
        System.out.printf("AVERAGE (%d)%n", average);

        for (String anInput : input) {
            if (anInput.length() < average) {
                System.out.printf("(%d): \"%s\"%n", anInput.length(), anInput);
            }
        }
    }

    /**
     * Ввести N слов, состоящих из символов английского алфавита. Найти слово, в котором
     * число различных символов минимально. Символы верхнего и нижнего регистра считать
     * различными. Если таких слов несколько, найти первое из них.
     */

    public void task4() {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] input = scanner.nextLine().split("\\s+", n);

        int[] unique = new int[input.length];

        for (int wordNumber = 0; wordNumber < input.length; wordNumber++) {
            int count = 0;
            char[] word = input[wordNumber].toCharArray();
            for (int i = 0; i < word.length - 1; i++) {
                for (int j = i + 1; j < word.length; j++) {
                    if (word[i] == word[j]) {
                        count++;
                    }
                }
            }
            if (!input[wordNumber].contains(" ")) { // Игнорируем слова с пробелами
                unique[wordNumber] = input[wordNumber].length() - count;
            }
        }

        int min = unique[0];
        int position = 0;
        for (int i = 1; i < unique.length; i++) {
            if (unique[i] == 0) {
                continue;
            }
            if (min > unique[i]) {
                min = unique[i];
                position = i;
            }
            if (min == 1) {
                break;
            }
        }

        System.out.println(input[position]);
    }

    /**
     * Ввести N слов. Найти количество слов, содержащих только символы латинского алфавита,
     * а среди них – количество слов с равным числом гласных и согласных букв.
     */
    public void task5() {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String string = scanner.nextLine();
        String[] words = string.split(" ");

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        char[] abc = alphabet.toCharArray();
        char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u', 'y'};
        int numberOfLatinWords = 0;

        boolean isLatin = false;
        for (String singleWord : words) {
            char[] word = singleWord.toLowerCase().toCharArray();

            for (char symbol : word) {
                if (symbol >= 'a' && symbol <= 'z' ) {
                    isLatin = true;
                }
                isLatin = false;

                for (char letter : abc) {
                    if (symbol == letter) {
                        isLatin = true;
                    }
                }
                if (!isLatin) {
                    break;
                }
            }

            if (isLatin) {
                if (singleWord.length() % 2 == 0) {
                    int count = 0;

                    for (char symbol : word) {
                        for (char vowel : vowels) {
                            if (symbol == vowel) {
                                count++;
                            }
                        }
                    }

                    if (count == word.length / 2) {
                        numberOfLatinWords++;
                    }
                }
            }
        }

        System.out.println(numberOfLatinWords);
    }

    /**
     * Ввести N слов. Найти слово, символы в котором идут в строгом порядке возрастания их кодов.
     * Если таких слов несколько, найти первое из них.
     */

    public void task6() {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String sentence = scanner.nextLine();
        String[] words = sentence.split(" ");

        ArrayList<String> strings = new ArrayList<>();
        for (String word : words) {
            try {
                if (word.length() > 1) {
                    byte[] numbers = word.getBytes("UTF-8");

                    for (int j = 0; j < numbers.length - 1; j++) {
                        if (numbers[j + 1] > numbers[j]) {
                            if (j == numbers.length - 2) {
                                strings.add(word);
                            }
                        } else {
                            break;
                        }
                    }
                }

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        if (!strings.isEmpty()) {
            System.out.println(strings.get(0));
        } else {
            System.out.println("NOT FOUND");
        }
    }

    /**
     * Ввести N слов. Найти слова, состоящие только из различных символов.
     * В случае, если слово встречается более одного раза - вывести его единожды.
     */

    public void task7() {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String string = scanner.nextLine();

        String[] words = string.split(" ");
        LinkedHashSet<String> uniqueWords = new LinkedHashSet<>();

        for (String word : words) {
            HashSet<Character> uniqueSymbols = new HashSet<>();
            boolean isUnique = true;
            char[] symbols = word.toCharArray();

            for (char symbol : symbols) {
                if (uniqueSymbols.contains(symbol)) {
                    isUnique = false;
                    break;
                } else {
                    uniqueSymbols.add(symbol);
                }
            }

            if (isUnique) {
                uniqueWords.add(word.trim());
            }
        }

        StringBuilder result = new StringBuilder();
        if (!uniqueWords.isEmpty()) {
            for (Object uniqueWord : uniqueWords) {
                result.append(uniqueWord).append(" ");
            }
            System.out.println(result.toString().trim());
        } else {
            System.out.println("NOT FOUND");
        }
    }

    /**
     * Ввести N слов. Помимо обычных слов, во входной последовательности могут встречаться
     * целые числа. Среди них необходимо найти число-палиндром (одинаково читающееся в обоих
     * направлениях). Если таких чисел больше одного, найти второе из них. Ограничения на
     * размер числа нет. Одна цифра является палиндромом.
     */

    public void task8() {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] words = scanner.nextLine().split(" ");

        ArrayList<BigInteger> numbers = new ArrayList<>();
        for (String word : words) {
            try {
                BigInteger bignumber = new BigInteger(word);
                numbers.add(bignumber);
            } catch (NumberFormatException ignored) {

            }
        }

        ArrayList<BigInteger> polindroms = new ArrayList<>();
        for (Object number : numbers) {
            String s = number.toString();
            String reverse = new StringBuilder(s).reverse().toString();

            if (s.equals(reverse)) {
                polindroms.add((BigInteger) number);
            }
        }

        if (!polindroms.isEmpty()) {
            if (polindroms.size() > 1) {
                System.out.println(polindroms.get(1));
            } else {
                System.out.println(polindroms.get(0));
            }
        } else {
            System.out.println("NOT FOUND");
        }
    }

    /**
     * Написать программу, которая выводит числа от 1 до N^2 в виде матрицы NxN
     * слева направо и сверху вниз.
     */

    public void task9() {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int count = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == n - 1) {
                    System.out.print(count++);
                } else {
                    System.out.print(count++ + "\t");
                }
            }
            System.out.println();
        }
    }

    /**
     * Написать программу, позволяющую корректно находить корни квадратного уравнения.
     * Параметры уравнения должны задаваться из стандартного входа.
     */

    public void task10() {
        Scanner in = new Scanner(System.in);
        double a = in.nextInt();
        double b = in.nextInt();
        double c = in.nextInt();

        double d = Math.pow(b, 2) - 4 * a * c;
        if (d < 0)
            System.out.println("No solution");
        else if (d == 0) {
            BigDecimal x = BigDecimal.valueOf((-b) / (2 * a));
            x = x.setScale(2, BigDecimal.ROUND_HALF_UP);
            System.out.println("One solution: " + x);
        } else {
            BigDecimal x1 = BigDecimal.valueOf((-b + Math.sqrt(d)) / (2 * a));
            BigDecimal x2 = BigDecimal.valueOf((-b - Math.sqrt(d)) / (2 * a));

            x1 = x1.setScale(2, BigDecimal.ROUND_HALF_UP);
            x2 = x2.setScale(2, BigDecimal.ROUND_HALF_UP);

            System.out.println("Two solutions: " + x2 + ", " + x1);
        }
    }

    /**
     * Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу.
     * При реализации использовать оператор switch. Осуществить проверку корректности ввода числа.
     */

    public void task11() {
        Scanner scanner = new Scanner(System.in);
        boolean isError = false;
        int month = -1;
        try {
            month = scanner.nextInt();
        } catch (InputMismatchException ignored) {
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
        }
    }

    /**
     * Упорядочить строки матрицы размерности N в порядке возрастания
     * значений элементов k-го столбца.
     */

    public void task12() {
        Scanner scanner = new Scanner(System.in);
        int columnNumber = scanner.nextInt();
        final int matrixSize = scanner.nextInt();

        int[][] matrix = new int[matrixSize][matrixSize];
        int[] columnNumbers = new int[matrixSize];
        for (int line = 0; line < matrixSize; line++) {
            for (int column = 0; column < matrixSize; column++) {
                matrix[line][column] = scanner.nextInt();
                if (column == columnNumber) {
                    columnNumbers[line] = matrix[line][column];
                }
            }
        }

        Arrays.sort(columnNumbers);
        System.out.println(matrixSize);
        for (int number : columnNumbers) {
            for (int[] matrixElement : matrix) {
                if (matrixElement[columnNumber] == number) {
                    for (int i = 0; i < matrix.length; i++) {
                        if (i == matrix.length - 1) {
                            System.out.print(matrixElement[i]);
                        } else {
                            System.out.print(matrixElement[i] + "\t");
                        }
                    }
                }
            }
            System.out.println();
        }
    }

    /**
     * Сдвигает индексы на заданное кол-во позиций
     *
     * @param numberOfShifts - количество сдвигов и их направление
     *                       > 0 - сдвиг вправо
     *                       < 0 - сдвиг влево
     *                       == 0 - без изменений
     * @param matrixSize     - размер матрицы
     * @return сдвинутые индексы
     */
    private static int[] shift(int numberOfShifts, int matrixSize) {
        int[] indexes = new int[matrixSize];
        int[] newIndexes = new int[indexes.length];

        for (int i = 0; i < indexes.length; i++) {
            indexes[i] = i;
        }

        int counter = Math.abs(numberOfShifts);
        do {
            if (numberOfShifts > 0) {
                for (int i = 0; i < newIndexes.length; i++) {
                    if (i - 1 < 0) {
                        newIndexes[i] = indexes[newIndexes.length - 1];
                    } else {
                        newIndexes[i] = indexes[i - 1];
                    }
                }
            } else if (numberOfShifts < 0) {
                for (int i = 0; i < newIndexes.length; i++) {
                    if (i + 1 >= newIndexes.length) {
                        newIndexes[i] = indexes[0];
                    } else {
                        newIndexes[i] = indexes[i + 1];
                    }
                }
            }
            indexes = Arrays.copyOf(newIndexes, newIndexes.length);
        } while (--counter > 0);

        return newIndexes;
    }

    /**
     * Выполнить циклический сдвиг матрицы размерности N на k позиций вниз.
     */

    public void task13() {
        Scanner scanner = new Scanner(System.in);
        int numberOfShifts = scanner.nextInt();
        int matrixSize = scanner.nextInt();

        int[][] matrix = new int[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int[] newIndexes = shift(numberOfShifts, matrix.length);

        if (numberOfShifts == 0) {
            printIntMatrix(matrix);
        } else {
            System.out.println(matrix.length);
            for (int newIndex : newIndexes) {
                for (int i = 0; i < newIndexes.length; i++) {
                    if (i == newIndexes.length - 1) {
                        System.out.print(matrix[newIndex][i]);
                    } else {
                        System.out.print(matrix[newIndex][i] + "\t");
                    }
                }
                System.out.println();
            }
        }
    }

    /**
     * Найти наибольшее число строго возрастающих элементов последовательности, идущих подряд.
     * Оператор отношения можно определить на множестве, включающем более одного элемента.
     */

    public void task14() {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] symbols = scanner.nextLine().split(" ");

        if (n >= 2) {
            int[] numbers = new int[symbols.length];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = Integer.parseInt(symbols[i]);
            }

            ArrayList<Integer> result = new ArrayList<>();
            HashSet<Integer> r = new HashSet<>();
            boolean isCreate = false;

            for (int i = 0; i < numbers.length - 1; i++) {
                if (isCreate) {
                    r = new HashSet<>();
                }
                isCreate = false;

                if (numbers[i + 1] > numbers[i]) {
                    r.add(numbers[i]);
                } else {
                    isCreate = true;
                    if (r.size() == 0) {
                        result.add(r.size());
                    } else {
                        result.add(r.size() + 1);
                    }
                }

                if (i == numbers.length - 2) {
                    if (r.size() == 0) {
                        result.add(r.size());
                    } else {
                        result.add(r.size() + 1);
                    }
                }

            }
            if (!result.isEmpty()) {
                System.out.println(Collections.max(result));
            } else {
                System.out.println(0);
            }
        } else {
            System.out.println(0);
        }
    }

    /**
     * Найти сумму элементов матрицы, расположенных между первым и
     * вторым положительными элементами каждой строки.
     * <p>
     * Если в строке нет двух положительных элементов - сумма от этой строки равной нулю.
     * Сумма между двумя рядом расположенными элементами равна нулю.
     */

    public void task15() {
        int[][] matrix = readIntMatrix();
        int[] sum = new int[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            boolean isPositive = false;
            for (int j = 0; j < matrix.length; j++) {

                if (matrix[i][j] > 0) {
                    if (isPositive) {
                        break;
                    }
                    isPositive = true;
                } else {
                    if (isPositive) {
                        sum[i] += matrix[i][j];
                    }
                }

                if (j == matrix.length - 1 && isPositive) {
                    sum[i] = 0;
                }
            }
        }

        int result = 0;
        for (int elements : sum) {
            result += elements;
        }
        System.out.println(result);
    }

    /**
     * Повернуть матрицу на 90 градусов против часовой стрелки.
     */

    public void task16() {
        Scanner scanner = new Scanner(System.in);
        final int matrixSize = scanner.nextInt();
        int[][] matrix = new int[matrixSize][matrixSize];
        for (int row = 0; row < matrixSize; ++row) {
            for (int col = 0; col < matrixSize; ++col) {
                matrix[row][col] = scanner.nextInt();
            }
        }

        int[][] newMatrix = new int[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                newMatrix[i][j] = matrix[j][matrixSize - i - 1];
            }
        }

        printIntMatrix(newMatrix);
    }

    /**
     * Найти максимальный элемент(ы) в матрице и удалить из матрицы все строки и столбцы,
     * его содержащие.
     */

    public void task18() {
        int[][] matrix = readIntMatrix();

        HashSet<Integer> row = new HashSet<>();
        HashSet<Integer> col = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            row.add(i);
            col.add(i);
        }

        int max = matrix[0][0];
        for (int[] element : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                if (max < element[j]) {
                    max = element[j];
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == max) {
                    row.remove(i);
                    col.remove(j);
                }
            }
        }

        System.out.println(row.size());
        System.out.println(col.size());

        for (Integer r : row) {
            for (Integer c : col) {
                System.out.printf("%d\t", matrix[r][c]);
            }
            System.out.println();
        }
    }

    /**
     * В матрице найти минимальный элемент и переместить его на место заданного элемента
     * путем перестановки строк и столбцов. Гарантируется, что минимальный элемент в матрице
     * встречается ровно один раз.
     */

    public void task20() {
        Scanner scanner = new Scanner(System.in);
        int newPosX = scanner.nextInt(); //Номер строки
        int newPosY = scanner.nextInt(); //Номер столбца

        int matrixSize = scanner.nextInt();
        int[][] matrix = new int[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int min = matrix[0][0];
        int posY = 0;
        int posX = 0;
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                if (min > matrix[i][j]) {
                    min = matrix[i][j];
                    posY = j;
                    posX = i;
                }
            }
        }

        int[] indexesX = new int[matrixSize];
        int[] indexesY = new int[matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            indexesX[i] = i;
            indexesY[i] = i;
        }

        int temp = indexesX[posX];
        indexesX[posX] = indexesX[newPosX];
        indexesX[newPosX] = temp;

        temp = indexesY[posY];
        indexesY[posY] = indexesY[newPosY];
        indexesY[newPosY] = temp;

        System.out.println(matrixSize);
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                if (j == matrixSize - 1) {
                    System.out.print(matrix[indexesX[i]][indexesY[j]]);
                } else {
                    System.out.print(matrix[indexesX[i]][indexesY[j]] + "\t");
                }
            }
            System.out.println();
        }
    }

    /**
     * Преобразовать строки матрицы таким образом, чтобы элементы, равные нулю,
     * располагались после всех остальных.
     */

    public void task21() {
        Scanner scanner = new Scanner(System.in);
        final int matrixSize = scanner.nextInt();

        int[][] matrix = new int[matrixSize][matrixSize];
        int[][] dublicate = new int[matrixSize][matrixSize];

        for (int row = 0; row < matrixSize; ++row) {
            for (int col = 0; col < matrixSize; ++col) {
                matrix[row][col] = scanner.nextInt();
                dublicate[row][col] = 0;
            }
        }

        for (int i = 0; i < matrixSize; i++) {
            int counter = 0;
            for (int j = 0; j < matrixSize; j++) {
                if (matrix[i][j] != 0) {
                    dublicate[i][counter++] = matrix[i][j];
                }
            }
        }

        printIntMatrix(dublicate);
    }


    public void task22() {
        double[][] matrix = readDoubleMatrix();
        int[][] newMatrix = new int[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                newMatrix[i][j] = (int) Math.round(matrix[i][j]);
            }
        }

        printIntMatrix(newMatrix);
    }

    /**
     * Найти количество всех седловых точек матрицы. Матрица А имеет седловую точку (i, j),
     * если А[i, j] является минимальным элементом в i-й строке и максимальным в j-м столбце.
     */

    public void task23() {

    }

    /**
     * Перестроить матрицу, переставляя в ней строки так, чтобы сумма элементов в строках
     * полученной матрицы возрастала.
     */

    public void task24() {
        int[][] matrix = readIntMatrix();
        int[] sum = new int[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                sum[i] += matrix[i][j];
            }
        }

        int[] indexes = new int[matrix.length];
        for (int i = 0; i < indexes.length; i++) {
            indexes[i] = i;
        }

        for (int i = sum.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (sum[j] > sum[j + 1]) {
                    int t = sum[j];
                    sum[j] = sum[j + 1];
                    sum[j + 1] = t;

                    int temp = indexes[j];
                    indexes[j] = indexes[j + 1];
                    indexes[j + 1] = temp;
                }
            }
        }

        System.out.println(matrix.length);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (j == matrix.length - 1) {
                    System.out.print(matrix[indexes[i]][j]);
                } else {
                    System.out.print(matrix[indexes[i]][j] + "\t");
                }
            }
            System.out.println();
        }
    }

    /**
     * Найти число локальных минимумов. Соседями элемента матрицы назовем элементы,
     * имеющие с ним общую сторону или угол. Элемент матрицы называется локальным минимумом,
     * если он строго меньше всех своих соседей.
     */

    public void task25() {
        int matrix[][] = readIntMatrix();
        ArrayList<Integer> localMax = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {

                boolean plusY = j + 1 < matrix.length;
                boolean minusY = j - 1 >= 0;
                boolean plusX = i + 1 < matrix.length;
                boolean minusX = i - 1 >= 0;

                boolean a4 = true;
                boolean a6 = true;
                boolean a8 = true;
                boolean a2 = true;
                boolean a7 = true;
                boolean a9 = true;
                boolean a1 = true;
                boolean a3 = true;

                if (minusX) {
                    a4 = matrix[j][i] < matrix[j][i - 1];
                }
                if (plusX) {
                    a6 = matrix[j][i] < matrix[j][i + 1];
                }
                if (minusY) {
                    a8 = matrix[j][i] < matrix[j - 1][i];
                }
                if (plusY) {
                    a2 = matrix[j][i] < matrix[j + 1][i];
                }
                if (minusY && minusX) {
                    a7 = matrix[j][i] < matrix[j - 1][i - 1];
                }
                if (minusY && plusX) {
                    a9 = matrix[j][i] < matrix[j - 1][i + 1];
                }
                if (plusY && minusX) {
                    a1 = matrix[j][i] < matrix[j + 1][i - 1];
                }
                if (plusY && plusX) {
                    a3 = matrix[j][i] < matrix[j + 1][i + 1];
                }

                boolean result = a1 && a2 && a3 && a4 && a6 && a7 && a8 && a9;
                if (result) {
                    localMax.add(matrix[j][i]);
                }
            }
        }

        if (!localMax.isEmpty()) {
            System.out.println(localMax.size());
        } else {
            System.out.println(0);
        }
    }

    /**
     * Найти наибольший среди локальных максимумов. Соседями элемента матрицы назовем элементы,
     * имеющие с ним общую сторону или угол. Элемент матрицы называется локальным максимумом,
     * если он строго больше всех своих соседей.
     */

    public void task26() {
        int matrix[][] = readIntMatrix();

        int max = Integer.MIN_VALUE;
        for (int[] element : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                if (element[j] > max) {
                    max = element[j];
                }
            }
        }

        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> y = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == max) {
                    x.add(j);
                    y.add(i);
                }
            }
        }

        ArrayList<Integer> localMax = new ArrayList<>();
        for (int i = 0; i < x.size(); i++) {
            int posX = x.get(i);
            int posY = y.get(i);

            boolean plusY = posY + 1 < matrix.length;
            boolean minusY = posY - 1 >= 0;
            boolean plusX = posX + 1 < matrix.length;
            boolean minusX = posX - 1 >= 0;

            boolean a4 = true;
            boolean a6 = true;
            boolean a8 = true;
            boolean a2 = true;
            boolean a7 = true;
            boolean a9 = true;
            boolean a1 = true;
            boolean a3 = true;

            if (minusX) {
                a4 = matrix[posY][posX] > matrix[posY][posX - 1];
            }
            if (plusX) {
                a6 = matrix[posY][posX] > matrix[posY][posX + 1];
            }
            if (minusY) {
                a8 = matrix[posY][posX] > matrix[posY - 1][posX];
            }
            if (plusY) {
                a2 = matrix[posY][posX] > matrix[posY + 1][posX];
            }
            if (minusY && minusX) {
                a7 = matrix[posY][posX] > matrix[posY - 1][posX - 1];
            }
            if (minusY && plusX) {
                a9 = matrix[posY][posX] > matrix[posY - 1][posX + 1];
            }
            if (plusY && minusX) {
                a1 = matrix[posY][posX] > matrix[posY + 1][posX - 1];
            }
            if (plusY && plusX) {
                a3 = matrix[posY][posX] > matrix[posY + 1][posX + 1];
            }

            boolean result = a1 && a2 && a3 && a4 && a6 && a7 && a8 && a9;
            if (result) {
                localMax.add(matrix[posY][posX]);
            }
        }

        if (!localMax.isEmpty()) {
            System.out.println(localMax.get(0));
        } else {
            System.out.println("NOT FOUND");
        }
    }

    /**
     * Перестроить заданную матрицу, переставляя в ней столбцы так, чтобы значения
     * их характеристик убывали.
     * Характеристикой столбца прямоугольной матрицы называется сумма модулей его элементов.
     * Если значения характеристики совпадают - столбцы должны следовать в том же порядке,
     * что и в исходной матрице.
     */

    public void task27() {
        int[][] matrix = readIntMatrix();

        int[] sum = new int[matrix.length];

        int[] indexes = new int[matrix.length];
        for (int i = 0; i < indexes.length; i++) {
            indexes[i] = i;
        }

        for (int[] element : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                sum[j] += Math.abs(element[j]);
            }
        }

        for (int a = 1; a < sum.length; a++) {
            for (int b = sum.length - 1; b >= a; b--) {
                if (sum[b - 1] < sum[b]) {
                    int temp = sum[b - 1];
                    sum[b - 1] = sum[b];
                    sum[b] = temp;

                    temp = indexes[b - 1];
                    indexes[b - 1] = indexes[b];
                    indexes[b] = temp;
                }
            }
        }

        System.out.println(matrix.length);
        for (int[] element : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                if (j == matrix.length - 1) {
                    System.out.print(element[indexes[j]]);
                } else {
                    System.out.print(element[indexes[j]] + "\t");
                }
            }
            System.out.println();
        }
    }
}
