package com.epam.courses.jf.practice.vakhonin.first;

import com.epam.courses.jf.practice.common.first.ISolver;

import java.math.BigDecimal;
import java.util.*;


/**
 * Created by igorvahonin on 03.11.17.
 */
public class Solver implements ISolver {
    public void task1() {
        Scanner in;
        int numberOfStrings, length, minLength, maxLength;
        int numberOfShortestString = 0;
        int numberOfLongestString = 0;
        String s, minString, maxString;
        String[] strings;

        in = new Scanner(System.in);
        numberOfStrings = Integer.valueOf(in.nextLine());
        strings = new String[numberOfStrings];

        for (int j = 0; j < numberOfStrings; j++) {
            strings[j] = in.nextLine();
        }

        numberOfShortestString = 0;
        numberOfLongestString = 0;
        minLength = strings[0].length();
        maxLength = minLength;
        for (int j = 1; j < numberOfStrings; j++) {
            s = strings[j];
            length = s.length();
            if (length <= minLength) {
                minLength = length;
                numberOfShortestString = j;
            }
            if (length >= maxLength) {
                maxLength = length;
                numberOfLongestString = j;
            }
        }
        minString = strings[numberOfShortestString];
        maxString = strings[numberOfLongestString];
        System.out.printf("MIN (%d): \"%s\"%n", minLength, minString);
        System.out.printf("MAX (%d): \"%s\"%n", maxLength, maxString);
    }   // DOING!

    public void task2() {
        int numberOfStrings, length;
        Map<Integer, ArrayList<String>> stringsMap;
        Scanner in;

        in = new Scanner(System.in);
        numberOfStrings = Integer.valueOf(in.nextLine());
        String[] strings = new String[numberOfStrings];
//        in = new Scanner(System.in);
        for (int j = 0; j < numberOfStrings; j++) {
            strings[j] = in.nextLine();
        }
        stringsMap = new TreeMap();
        for (String string : strings) {
            length = string.length();
            if (!stringsMap.containsKey(length)) {
                stringsMap.put(length, new ArrayList());
            }
            stringsMap.get(length).add(string);
        }

        for (Map.Entry<Integer, ArrayList<String>> entry : stringsMap.entrySet()) {
            List<String> stringListWithSameLength = entry.getValue();
            stringListWithSameLength.sort(String::compareToIgnoreCase);
            for (String s : stringListWithSameLength) {
                System.out.printf("(%d): \"%s\"%n", entry.getKey(), s);
            }
        }
    }   // DOING!
//
    public void task3() {
        Scanner in;
        int length, numberOfStrings, averageLength, sumLength = 0;
        Object[][] stringsWithLength;
        String string;

        in = new Scanner(System.in);
        numberOfStrings = Integer.valueOf(in.nextLine());
        stringsWithLength = new Object[numberOfStrings][2];
//        in = new Scanner(System.in);

        for (int j = 0; j < numberOfStrings; j++) {
            string = in.nextLine();
            length = string.length();
            stringsWithLength[j][0] = length;
            stringsWithLength[j][1] = string;
            sumLength += length;
        }

        averageLength = sumLength / numberOfStrings;
        System.out.printf("AVERAGE (%d)%n", averageLength);

        for (int j = 0; j < numberOfStrings; j++) {
            length = (int) stringsWithLength[j][0];
            string = (String) stringsWithLength[j][1];

            if (length < averageLength) {
                System.out.printf("(%d): \"%s\"%n", length, string);
            }
        }
    }   // DOING!
//
    public void task4() {
        Scanner in = new Scanner(System.in);
        int n = Integer.valueOf(in.nextLine());
//        in = new Scanner(System.in);
        List<String> stringList = new ArrayList<String>();
        for (int j = 0; j < n; j++) {
            stringList.add(in.next());
        }
        Set<Character> characterSet = new HashSet<Character>();
        Set<Character> tempSet;
        int tempSize;
        int counter = 0;
        int number = 0;
        int size = stringList.get(0).length();
        for (String s : stringList) {
            tempSet = new HashSet<Character>();
            for (Character ch : s.toCharArray()) {
                tempSet.add(ch);
            }
            tempSize = tempSet.size();
            if (size > tempSize) {
                size = tempSize;
                characterSet = tempSet;
                number = counter;
            }

            counter++;
        }
        System.out.println(stringList.get(number));
    }   // DOING!
//
    public void task5() {
        Scanner in = new Scanner(System.in);
        int n = Integer.valueOf(in.nextLine());
//        in = new Scanner(System.in);
        List<String> stringList = new ArrayList<String>();
        for (int j = 0; j < n; j++) {
            stringList.add(in.next());
        }


        int length;
        int countOfVowels, countOfWords;
        countOfWords = 0;
        for (String s : stringList) {
            length = s.length();
            if (((length % 2) == 0) && (s.matches("^[a-zA-Z]+$"))) {
                countOfVowels = 0;
                for (Character ch : s.toCharArray()) {
                    if ((ch.toString()).matches("(?i:[aeiouy])")) {
                        countOfVowels++;
                    }
                }


                if (countOfVowels * 2 == length) {
                    countOfWords++;
                }

            }
        }

        System.out.println(countOfWords);

    }   // DOING!
//
    public void task6() {
        Scanner in = new Scanner(System.in);
        int numberOfStrings, last, it;
        String result;

//        in = new Scanner(System.in);
        numberOfStrings = Integer.valueOf(in.next());

        String[] strings = new String[numberOfStrings];
//        in = new Scanner(System.in);
        for (int j = 0; j < numberOfStrings; j++) {
            strings[j] = in.next();
        }

        result = "";
        last = -1;

        for (String string : strings) {

            for (Character ch : string.toCharArray()) {
                if (string.length() == 1) {
                    break;
                }
//
                it = (int) ch;
                if (it > last) {
                    last = it;
                } else {
                    last = -1;
                    break;
                }
            }
            if (last != -1) {
                result = string;
                break;
            }
        }

        if (result.equals("")) {
            System.out.printf("%s%n", "NOT FOUND");
        } else {
            System.out.printf("%s%n", result);
        }
    }   // DOING!
//
    public void task7() {
        Scanner in;
        int numberOfStrings, wordsSize;

        in = new Scanner(System.in);
        numberOfStrings = Integer.valueOf(in.nextLine());

        String[] strings = new String[numberOfStrings];
        for (int j = 0; j < numberOfStrings; j++) {
            strings[j] = in.next();
        }

        int length;
        Set<Character> charSet;

        StringBuilder result;
        result = new StringBuilder("");
        Set<String> words = new LinkedHashSet<>();

        for (String string : strings) {

            charSet = new LinkedHashSet();
            length = string.length();
            for (Character ch : string.toCharArray()) {
                charSet.add(ch);
            }

            if (length == charSet.size()) {
                words.add(string);
            }
        }

        wordsSize = words.size();

        if (wordsSize == 0) {
            result.append("NOT FOUND");
        } else {
            for (String s: words){
                result.append(s);
                result.append(" ");
            }
            result.deleteCharAt(result.length() - 1);
        }
        System.out.println(result.toString());
    }   // DOING!


//
    public void task8() {
        Scanner in = new Scanner(System.in);
        int n = Integer.valueOf(in.nextLine());

        List<String> stringList = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            stringList.add(in.next());
        }
        int counter = 0;
        String result = "NOT FOUND";
        StringBuffer strBuf;
        for(String str: stringList){
            if(str.matches("^\\d+$")){
                strBuf = new StringBuffer(str);
                strBuf.reverse();
                if(strBuf.toString().equals(str)){
                    result = str;
                    counter++;
                    if(counter == 2){
                        break;
                    }
                }

            }


        }

        System.out.printf("%s%n", result);
    }   // DOING!
//
    public void task9() {
        Scanner in;
        int n, length;
        int[][] matrix;
        StringBuilder stringMatrix;

        in = new Scanner(System.in);
        n = in.nextInt();
        matrix = new int[n][n];
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                matrix[j][k] = j * n + k + 1;
            }
        }

        stringMatrix = new StringBuilder();
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                stringMatrix.append(matrix[j][k] + "\t");
            }
            length = stringMatrix.length();
            stringMatrix.setLength(length - 1);
            stringMatrix.append("\n");
        }

        length = stringMatrix.length();
        stringMatrix.setLength(length - 1);

        System.out.println(stringMatrix);
    }   // DOING!
//
    public void task10() {
        Scanner in;
        String result;
        double a, b, c, d;
        BigDecimal x1, x2;

        in = new Scanner(System.in);
        a = in.nextDouble();
        b = in.nextDouble();
        c = in.nextDouble();

        result = new String();

        if (a == 0) {
            if (b == 0) {
                result = "No solution";
            } else {
                x1 = (new BigDecimal(-c / b)).setScale(2, BigDecimal.ROUND_HALF_UP);
                result = "One solution: " + x1;
            }
        } else {
            d = b * b - 4 * a * c;
            if (d > 0) {
                x1 = (new BigDecimal((-b + Math.sqrt(d)) / (2 * a))).setScale(2, BigDecimal.ROUND_HALF_UP);
                x2 = (new BigDecimal((-b - Math.sqrt(d)) / (2 * a))).setScale(2, BigDecimal.ROUND_HALF_UP);
                result = "Two solutions: " + x1 + ", " + x2;
            }
            if (d == 0) {
                x1 = (new BigDecimal(-b / (2 * a))).setScale(2, BigDecimal.ROUND_HALF_UP);
                result = "One solution: " + x1;
            }
            if (d < 0) {
                result = "No solution";
            }
        }
        System.out.println(result);
    }   // DOING!
//
    public void task11() {
        Scanner in;
        String month, data, result;
        int numberOfMonth;

        in = new Scanner(System.in);
        data = in.nextLine();
        result = "";
        month = "";

        if (data.matches("([1][0-2])|([1-9])")) {
            numberOfMonth = Integer.valueOf(data);
            switch (numberOfMonth) {
                case 1:
                    month = "January";
                    break;
                case 2:
                    month = "February";
                    break;
                case 3:
                    month = "March";
                    break;
                case 4:
                    month = "April";
                    break;
                case 5:
                    month = "May";
                    break;
                case 6:
                    month = "June";
                    break;
                case 7:
                    month = "July";
                    break;
                case 8:
                    month = "August";
                    break;
                case 9:
                    month = "September";
                    break;
                case 10:
                    month = "October";
                    break;
                case 11:
                    month = "November";
                    break;
                case 12:
                    month = "December";
                    break;
                default:
                    break;
            }
            result += month;
        } else {
            result += "INCORRECT INPUT DATA";
        }
        System.out.println(result);
    }   // DOING!
//
    public void task12() {
        Scanner in = new Scanner(System.in);
        int numberOfColumn = in.nextInt();
        Integer[][] matrix = enterMatrixInteger(in);
        Arrays.sort(matrix, new Comparator<Integer[]>() {
            public int compare(Integer[] row1, Integer[] row2) {
                return row1[numberOfColumn] - row2[numberOfColumn];
            }
        });
        System.out.println(matrix.length);

        printMatrixInteger(matrix);
    }   // DOING!
//
    public void task13() {
        Scanner in;
        int n, k, length, shift;
        Integer[][] matrix;
        StringBuilder stringMatrix;

        in = new Scanner(System.in);


        //        System.out.println("Enter displacement quantity:");
        k = in.nextInt();


        matrix = enterMatrixInteger(in);

        n = matrix.length;

        Integer[][] newMatrix = new Integer[n][n];

        shift = -(n + k % n) % n + n;

//        stringMatrix = new StringBuilder();

        for (int j = 0; j < n; j++) {
            for (int q = 0; q < n; q++) {
                newMatrix[j][q] = matrix[(j + shift) % n][q];
//                stringMatrix.append(matrix[(j + shift) % n][q] + "\t");
            }
        }

        System.out.println(n);

        printMatrixInteger(newMatrix);
    }   // DOING!

//
    public void task14() {
        Scanner in;
        int n, count, max, result;
        int[] seq;

        in = new Scanner(System.in);
        n = Integer.valueOf(in.nextLine());
        seq = new int[n];
        for (int j = 0; j < n; j++) {
            seq[j] = in.nextInt();
        }

        count = 1;
        max = 1;

        for (int j = 1; j < n; j++) {
            if (seq[j] > seq[j - 1]) {
                count++;
            } else {
                max = count;
                count = 1;
            }
        }

        if (count > max) {
            max = count;
        }
        if (max == 1){
            result = 0;
        }
        else{
            result = max;
        }

        System.out.println(result);
    }   // DOING!
//
    public void task15() {
        Scanner in;
        int n, sumIn, sumOut;
        Integer[][] matrix;

        in = new Scanner(System.in);
        System.out.println("Enter matrix dimension:");
        n = Integer.valueOf(in.nextLine());
        matrix = new Integer[n][n];

        matrix = enterMatrixInteger(in);

        sumOut = 0;

        for (int k = 0; k < n; k++) {

            int counter = 0;
            int index1 = -1;
            int index2 = -1;
            for (int j = 0; !((counter == 2) || (j == n)); j++) {
                if (matrix[k][j] > 0) {
                    counter++;
                    if (index1 > -1) {
                        index2 = j;
                    } else {
                        index1 = j;
                    }
                }
            }

            sumIn = 0;

            if ((counter == 2) && ((index2 - index1) > 1)) {
                for (int j = index1 + 1; j < index2; j++) {
                    sumIn += matrix[k][j];
                }
            }
            sumOut += sumIn;
        }
        System.out.println(sumOut);
    }
//
//    //TODO: где-то нужно еще какие то размерности выводить...
//    //TODO: compareToIgnoreCase
//    //TODO: корни уравнения, разобрать все случаи
//    //TODO: седловые точки в 23. что делать, если минимальный элемент в нескольких экзамеплярах ?
//    public void task16() {
//        Scanner in;
//        int n, length;
//        int[][] matrix, matrixNew;
//        StringBuilder stringMatrix;
//
//        in = new Scanner(System.in);
//        System.out.println("Enter matrix dimension:");
//        n = in.nextInt();
//        matrix = new int[n][n];
//        matrixNew = new int[n][n];
//        System.out.println("Enter matrix of " + n + "x" + n + ":");
//        for (int j = 0; j < n; j++) {
//            for (int q = 0; q < n; q++) {
//                matrix[j][q] = in.nextInt();
//                matrixNew[n - q - 1][j] = matrix[j][q];
//            }
//        }
//
//        stringMatrix = new StringBuilder();
//
//        for (int j = 0; j < n; j++) {
//            for (int q = 0; q < n; q++) {
//                stringMatrix.append(matrixNew[j][q] + "\t");
//            }
//            length = stringMatrix.length();
//            stringMatrix.setLength(length - 1);
//            stringMatrix.append("\n");
//        }
//
//        length = stringMatrix.length();
//        stringMatrix.setLength(length - 1);
//        System.out.println(stringMatrix);
//    }
//
//    public void task17() {
//        Integer[][] matrix;
//        matrix = enterMatrixInteger();
//
//        Integer element;
//        int det = 1;
//        int length = matrix.length;
//        for (int j = 0; j < length; j++) {
//
//            for (int k = j; k < length; k++) {
//                element = matrix[j][k];
//                if (!element.equals(0)) {
//                    swapRows(matrix, j, k);
//                    break;
//                }
//                det = 0;
//                break;
//            }
//
//            if (det != 0) {
//                for (int k = j + 1; k < length; k++) {
//                    for (int i = length - 1; i >= j; i--) {
//                        matrix[k][i] = matrix[j][j] * matrix[k][i] - matrix[k][j] * matrix[j][i];
//                    }
//                }
//            }
//        }
//
//
//        if (det != 0) {
//            printMatrixInteger(matrix);
//            det = matrix[length - 1][length - 1];
//            for (int j = 0; j < length; j++) {
//                for (int k = 0; k < (length - j - 2); k++) {
//                    det /= matrix[j][j];
//                }
//            }
//        }
//        System.out.println(det);
//    }
//
//    public void task18() {
//        int n, max, k, i;
//        int[][] matrix, matrixNew;
//        Set<Integer> rows, columns;
//        matrix = enterMatrix();
//        n = matrix.length;
//
//        rows = new HashSet();
//        columns = new HashSet();
//
//        max = matrix[0][0];
//
//        for (int j = 0; j < n; j++) {
//            for (int q = 0; q < n; q++) {
//                if (matrix[j][q] >= max) {
//                    if (matrix[j][q] == max) {
//                        rows.add(j);
//                        columns.add(q);
//                    } else {
//                        rows = new HashSet();
//                        columns = new HashSet();
//                        rows.add(j);
//                        columns.add(q);
//                        max = matrix[j][q];
//                    }
//                }
//
//            }
//        }
//
//        matrixNew = new int[n - rows.size()][n - columns.size()];
//
//        k = 0;
//        for (int j = 0; j < n; j++) {
//            if (!rows.contains(j)) {
//                i = 0;
//                for (int q = 0; q < n; q++) {
//                    if (!columns.contains(q)) {
//                        matrixNew[k][i] = matrix[j][q];
//                        i++;
//                    }
//                }
//                k++;
//            }
//        }
//        printMatrix(matrixNew);
//    }
//
//    public void task19() {
//        int n, i, k, numberOfZeros;
//        int[][] matrix, matrixNew;
//        Set<Integer> rows, columns;
//        matrix = enterMatrix();
//        n = matrix.length;
//
//        rows = new HashSet();
//        columns = new HashSet();
//
//        for (int j = 0; j < n; j++) {
//            numberOfZeros = 0;
//            for (int q = 0; q < n; q++) {
//                if (matrix[j][q] != 0) {
//                    break;
//                }
//                numberOfZeros++;
//            }
//            if (numberOfZeros == n) {
//                rows.add(j);
//            }
//        }
//
//        for (int j = 0; j < n; j++) {
//            numberOfZeros = 0;
//            for (int q = 0; q < n; q++) {
//                if (matrix[q][j] != 0) {
//                    break;
//                }
//                numberOfZeros++;
//            }
//            if (numberOfZeros == n) {
//                columns.add(j);
//            }
//        }
//
//        matrixNew = new int[n - rows.size()][n - columns.size()];
//
//        k = 0;
//        for (int j = 0; j < n; j++) {
//            if (!rows.contains(j)) {
//                i = 0;
//                for (int q = 0; q < n; q++) {
//                    if (!columns.contains(q)) {
//                        matrixNew[k][i] = matrix[j][q];
//                        i++;
//                    }
//                }
//                k++;
//            }
//        }
//        printMatrix(matrixNew);
//    }
//
//    public void task20() {
//
//        Scanner in;
//
//        int n, min, row, column, targetRow, targetColumn;
//        int[][] matrix, matrixT, matrixNew;
//        int[] temp;
//
//        in = new Scanner(System.in);
//
//        System.out.println("Enter target row: ");
//        targetRow = in.nextInt();
//        System.out.println("Enter target column: ");
//        targetColumn = in.nextInt();
//
//        matrix = enterMatrix();
//        n = matrix.length;
//        matrixNew = new int[n][n];
//        row = 0;
//        column = 0;
//        min = matrix[0][0];
//
//        for (int j = 0; j < n; j++) {
//            for (int k = 0; k < n; k++) {
//                if (matrix[j][k] <= min) {
//                    min = matrix[j][k];
//                    row = j;
//                    column = k;
//                }
//            }
//        }
//
//        temp = matrix[targetRow].clone();
//        matrix[targetRow] = matrix[row].clone();
//        matrix[row] = temp.clone();
//
//        matrixT = transposeMatrix(matrix);
//
//        temp = matrixT[targetColumn].clone();
//        matrixT[targetColumn] = matrixT[column].clone();
//        matrixT[column] = temp.clone();
//
//        matrix = transposeMatrix(matrixT);
//
//        printMatrix(matrix);
//    }
//
//
//    //    TODO: to do universe method: enterMatrix
//    public void task21() {
//
////        int length;
//        Integer[][] matrix = enterMatrixInteger();
////        length = matrix.length;
//
//        for (Integer[] arr : matrix) {
//            Arrays.sort(arr, new Comparator<Integer>() {
//                public int compare(Integer r1, Integer r2) {
//                    int result = 0;
//
//                    if (r1 == 0 && r2 != 0) {
//                        result = 1;
//                    }
//                    if (r1 != 0 && r2 == 0) {
//                        result = -1;
//                    }
//                    //TODO: это можно убрать, наверное, так как резалт уже задан как 0
//                    if (r1 == r2) {
//                        result = 0;
//                    }
//                    return result;
//                }
//            });
//        }
//        printMatrixInteger(matrix);
//    }
//
//    public void task22() {
//        Double[][] matrix = enterMatrixDouble();
//        Integer[][] matrixNew;
//
//        int length = matrix.length;
//        matrixNew = new Integer[length][length];
//        for (int j = 0; j < length; j++) {
//            for (int k = 0; k < length; k++) {
//                matrixNew[j][k] = (int) Math.round(matrix[j][k]);
//            }
//
//        }
//        printMatrixInteger(matrixNew);
//    }
//
//    public void task24() {
//
//        Integer[][] matrix = enterMatrixInteger();
//        Arrays.sort(matrix, new Comparator<Integer[]>() {
//            public int compare(Integer[] arr1, Integer[] arr2) {
//
//                int result = 0;
//                int sum1, sum2;
//                sum1 = sum(arr1);
//                sum2 = sum(arr2);
//                if (sum2 > sum1) {
//                    result = -1;
//                }
//                if (sum2 < sum1) {
//                    result = 1;
//                }
//
//                return result;
//            }
//        });
//
//
//        printMatrixInteger(matrix);
//    }
//
//    public void task25() {
//
//
//        //TODO: to do INF on the sides
//    }
//
//    public void task26() { //TODO: оформить код!!!!
//
//        Scanner in;
//        int n;
//        Integer[][] matrix;
//
//        in = new Scanner(System.in);
//        System.out.println("Enter matrix dimension:");
//        n = in.nextInt();
//        matrix = new Integer[n + 2][n + 2];
//        System.out.println("Enter matrix of " + n + "x" + n + ":");
//
//
//        for (int q = 1; q < n + 1; q++) {
//            for (int j = 1; j < n + 1; j++) {
//                matrix[j][q] = in.nextInt();
//            }
//        }
//        for (int j = 0; j < n + 2; j++) {
//            matrix[j][0] = Integer.MIN_VALUE;
//            matrix[j][n + 1] = Integer.MIN_VALUE;
//            matrix[0][j] = Integer.MIN_VALUE;
//            matrix[n + 1][j] = Integer.MIN_VALUE;
//
//        }
//
//
//        int length = matrix.length;
//        Integer maximum = Integer.MIN_VALUE;
//
//        for (int j = 1; j < n + 1; j++) {
//            for (int k = 1; k < n + 1; k++) {
//                if ((matrix[j][k] > maximum) && ((matrix[j][k] > matrix[j - 1][k]) && (matrix[j][k] > matrix[j - 1][k - 1]) && (matrix[j][k] > matrix[j][k - 1]) && (matrix[j][k] > matrix[j + 1][k - 1]) && (matrix[j][k] > matrix[j + 1][k + 1]) && (matrix[j][k] > matrix[j + 1][k]) && (matrix[j][k] > matrix[j][k + 1]) && (matrix[j][k] > matrix[j - 1][k + 1]))) {
//                    maximum = matrix[j][k];
//                }
//            }
//        }
//        String result;
//
//        if (maximum.equals(Integer.MIN_VALUE)) {
//            result = "NOT FOUND";
//        } else {
//            result = "" + maximum;
//        }
//        System.out.println(result);
//    }
//
//    public void task27() {
//        Integer[][] matrix = transposeMatrixInteger(enterMatrixInteger());
//
//        Arrays.sort(matrix, new Comparator<Integer[]>() {
//            public int compare(Integer[] line1, Integer[] line2) {
//                return characteristic(line2) - characteristic(line1);
//            }
//        });
//
//        Integer[][] matrixNew = transposeMatrixInteger(matrix);
//        printMatrixInteger(matrixNew);
//    }

//
//    HashMap<Integer, Integer> task2_6_addPolynomials(HashMap<Integer, Integer> first, HashMap<Integer, Integer> second) {
//        HashMap<Integer, Integer> result = second;
//        Integer temp;
//        Integer key;
//        Integer value;
//        Integer sum;
//        for (Map.Entry<Integer, Integer> entry : first.entrySet()) {
//            key = entry.getKey();
//            value = entry.getValue();
//            temp = result.put(key, value);
//            if(temp == null){
//                temp = 0;
//            }
//            sum = temp + value;
//            if (sum == 0) {
//                result.remove(key);
//            } else {
//                result.put(key, sum);
//            }
//        }
//        return result;
//    }
//
//    List<Integer> task2_7_multiplyPolynomials(List<Integer> first, List<Integer> second){
//
//        List<Integer> result = new ArrayList<>();
//
//        int size1 = first.size();
//        int size2 = second.size();
//        int val1, val2;
//
//        while(first.get(size1-1) == 0){
//            size1--;
//        }
//
//        while(second.get(size2-1) == 0){
//            size2--;
//        }
//
//
//
//
//        for(int j = 0; j < (size1 + size2 - 1); j++){
//            result.add(0);
//        }
//
//
//        for(int j = 0; j < size1; j++){
//            for(int k = 0; k < size2; k++){
//                val1 = first.get(j);
//                val2 = second.get(k);
//                System.out.println(j+k);
//                result.set(j+k, val1*val2 + result.get(j+k));
//                System.out.println(result + "");
//            }
//        }
//        return result;
//    }
//
//    //    TODO: найти задание, где нужно было найти второе. Там возможно и первое подойдет
//    void task1_8(){
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        in = new Scanner(System.in);
//        List<String> stringList = new ArrayList<>();
//        for (int j = 0; j < n; j++) {
//            stringList.add(in.next());
//        }
//        int counter = 0;
//        String result = "NOT FOUND"; // TODO: применить такое везде, сразу нот фаунд
//        StringBuffer strBuf;
//        for(String str: stringList){
//            if(str.matches("^\\d+$")){
//                strBuf = new StringBuffer(str);
//                strBuf.reverse();
//                if(strBuf.toString().equals(str)){
//                    result = str;
//                    counter++;
//                    if(counter == 2){
//                        break;
//                    }
//                }
//
//            }
//
//
//        }
//
//        System.out.println(result);
//    }
//
//    Set<Integer> intersection(Set<Integer> first, Set<Integer> second){
//        Set<Integer> intersectionSet = new HashSet<>();
//        for(Integer j: first){
//            if(second.contains(j)){
//                intersectionSet.add(j);
//            }
//        }
//        return intersectionSet;
//    }
//
//    Set<Integer> union(Set<Integer> first, Set<Integer> second){
//        Set<Integer> unionSet = new HashSet<>();
//        for(Integer j: first){
//            for(Integer k: second){
//                unionSet.add(j);
//                unionSet.add(k);
//            }
//        }
//        return unionSet;
//    }
//
//
//    String emulate(ArrayList<String> peoples){
//
//        int size = peoples.size();
//        int j = 0;
//        int nextIndex = 0;
//        while(size!=1){
//            peoples.remove(nextIndex % size);
//            j++;
//            nextIndex = j % size;
//            size--;
//        }
//
//        return peoples.get(0);
//    }
//
//    String emulate(LinkedList<String> peoples){
//
//        int size = peoples.size();
//        int j = 0;
//        int nextIndex = 0;
//        while(size!=1){
//            peoples.remove(nextIndex % size);
//            j++;
//            nextIndex = j % size;
//            size--;
//        }
//        return peoples.get(0);
//    }
//
//
//    List<Integer> transform(List<Integer> integers, int value){
//        for(int j = integers.size()-1; j > 0; j--) {
//            if(integers.get(j) <= value) {
//                integers.set(j, integers.get(j) ^ integers.get(0));
//                integers.set(0, integers.get(j) ^ integers.get(0));
//                integers.set(j, integers.get(j) ^ integers.get(0));
//            }
//        }
//
////        integers.sort(Comparator.naturalOrder()); // Maybe this method (in one line) also fits to do this task... :-)
//
//        return integers;
//    }
//
//    HashMap<String, Integer> countNumberWords(String[] strArr){
//        HashMap<String, Integer> result = new HashMap<>();
//        Integer countNow;
//        for(String s: strArr){
//            s.toLowerCase();
//            if(result.containsKey(s)){
//                countNow = result.get(s);
//                result.put(s, ++countNow);
//            }
//            else{
//                result.put(s, 1);
//            }
//        }
//
//        return result;
//    } //    TODO: to do File as argument






//
//
//    public Integer characteristic(Integer[] line) {
//        int length = line.length;
//        Integer result;
//        result = 0;
//        for (int j : line) {
//            result += Math.abs(j);
//        }
//        return result;
//    }
//
//    public int sum(Integer[] arr) {
//        int sum = 0;
//        for (int j : arr) {
//            sum += j;
//        }
//        return sum;
//    }
//
//    public int[][] enterMatrix() {
//        Scanner in;
//        int n;
//        int[][] matrix;
//
//        in = new Scanner(System.in);
//        System.out.println("Enter matrix dimension:");
//        n = in.nextInt();
//        matrix = new int[n][n];
//        System.out.println("Enter matrix of " + n + "x" + n + ":");
//        for (int j = 0; j < n; j++) {
//            for (int q = 0; q < n; q++) {
//                matrix[j][q] = in.nextInt();
//            }
//        }
//        return matrix;
//    }
//
//    public void swapRows(Integer[][] matrix, int j, int k) {
//        Integer[] temp;
//        temp = matrix[j];
//        matrix[j] = matrix[k];
//        matrix[k] = temp;
//    }
//
    public Integer[][] enterMatrixInteger(Scanner in) {

        int n;
        Integer[][] matrix;

        n = in.nextInt();
        matrix = new Integer[n][n];


        for (int j = 0; j < n; j++) {
            for (int q = 0; q < n; q++) {
                matrix[j][q] = in.nextInt();
            }
        }
        return matrix;
    }
//
//    public Double[][] enterMatrixDouble() {
//        Scanner in;
//        int n;
//        Double[][] matrix;
//
//        in = new Scanner(System.in);
//        System.out.println("Enter matrix dimension:");
//        n = in.nextInt();
//        matrix = new Double[n][n];
//        System.out.println("Enter matrix of " + n + "x" + n + ":");
//        for (int j = 0; j < n; j++) {
//            for (int q = 0; q < n; q++) {
//                matrix[j][q] = in.nextDouble();
//            }
//        }
//        return matrix;
//    }
//
//
//    public void printMatrix(int[][] matrix) {
//
//        StringBuilder stringMatrix = new StringBuilder();
//        int length, n, m;
//
//        n = matrix.length;
//        m = matrix[0].length;
//
//        for (int j = 0; j < n; j++) {
//            for (int q = 0; q < m; q++) {
//                stringMatrix.append(matrix[j][q] + "\t");
//            }
//            length = stringMatrix.length();
//            stringMatrix.setLength(length - 1);
//            stringMatrix.append("\n");
//        }
//
//        length = stringMatrix.length();
//        stringMatrix.setLength(length - 1);
//        System.out.println(stringMatrix);
//    }
//
    private void printMatrixInteger(Integer[][] matrix){

        StringBuilder stringMatrix = new StringBuilder();
        int length, n, m;

        n = matrix.length;
        m = matrix[0].length;

        for (int j = 0; j < n; j++) {
            for (int q = 0; q < m; q++) {
                stringMatrix.append(matrix[j][q] + "\t");
            }
            length = stringMatrix.length();
            stringMatrix.setLength(length - 1);
            stringMatrix.append("\n");
        }

        length = stringMatrix.length();
        stringMatrix.setLength(length - 1);
        System.out.println(stringMatrix);
    }
//
//    public int[][] transposeMatrix(int[][] matrix) {
//        int n, m;
//        int[][] matrixNew;
//        n = matrix.length;
//        m = matrix[0].length;
//
//        matrixNew = new int[m][n];
//
//        for (int j = 0; j < n; j++) {
//            for (int k = 0; k < m; k++) {
//                matrixNew[k][j] = matrix[j][k];
//            }
//        }
//
//        return matrixNew;
//    }
//
//    public Integer[][] transposeMatrixInteger(Integer[][] matrix) {
//        int n, m;
//        Integer[][] matrixNew;
//        n = matrix.length;
//        m = matrix[0].length;
//
//        matrixNew = new Integer[m][n];
//
//        for (int j = 0; j < n; j++) {
//            for (int k = 0; k < m; k++) {
//                matrixNew[k][j] = matrix[j][k];
//            }
//        }
//
//        return matrixNew;
//    }
}
