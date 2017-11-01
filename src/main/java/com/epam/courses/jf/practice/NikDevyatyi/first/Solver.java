package com.epam.courses.jf.practice.NikDevyatyi.first;

import com.epam.courses.jf.practice.common.first.ISolver;

import java.math.BigDecimal;
import java.time.Month;
import java.util.*;
import java.util.stream.IntStream;

import static java.math.BigDecimal.ROUND_HALF_UP;

public class Solver implements ISolver {
    @Override
    public void task1() {
        int N  =0;
        int bigIndex = 0;
        int smallIndex = 0;
        String tempSmall;
        String tempBig;
        Scanner sInt = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        N =  sInt.nextInt();
        String arrStr [] = new String[N];
        arrStr[0] = sc.nextLine();
        tempSmall  = arrStr[1];
        tempBig = arrStr[1];
        for (int i = 2; i<arrStr.length; i++){
            arrStr[i] = sc.nextLine();
            if(arrStr[i].length()<= tempSmall.length()){
                tempSmall = arrStr[i];
                smallIndex = i;
            }
            if(arrStr[i].length()>= tempBig.length()){
                tempBig = arrStr[i];
                bigIndex = i;
            }
        }
        System.out.printf("MIN (%d): \"%s\"%n", arrStr[smallIndex].length(), arrStr[smallIndex]);
        System.out.printf("MAX (%d): \"%s\"%n", arrStr[bigIndex].length(), arrStr[bigIndex]);


    }
    @Override
    public void task2() {
        Scanner sc = new Scanner(System.in);
        String arrStr [] = getStrings(sc);
        Arrays.sort(arrStr,Collections.reverseOrder());

        for(String str: arrStr){
            System.out.printf("(%d): \"%s\"%n", str.length(), str);

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
    private String[] getStrings2(Scanner scanner) {
        int n = Integer.parseInt(scanner.nextLine());

        String[] strings = new String[n];
        strings = scanner.nextLine().split(" ");
        return strings;
    }
    @Override
    public void task3() {
        int summ = 0;
        Scanner sc = new Scanner(System.in);
        String arrStr[] = getStrings(sc);

        for (String str : arrStr) {
            summ+= str.length();
        }
        System.out.printf("AVERAGE (%d)%n", summ/arrStr.length);

        for (String str : arrStr){
            if (str.length() < summ/arrStr.length){
                System.out.println(str);
            }
        }
    }
    @Override
    public  void task4(){
        Scanner sc = new Scanner(System.in);
        //String arrStr[] = getStrings(sc);
        String[] s = getStrings2(sc);
        String result = s[0];
        int checkRepeat = checkLetterRepeat(s[0]);

        for(String word: s){

            if(checkRepeat > checkLetterRepeat(word)  ){
                result = word;
                checkRepeat = checkLetterRepeat(word);
            }

        }
        System.out.println(result);
    }
    private static int checkLetterRepeat(String nameString){
        int result= 0;
        char[] symbols = nameString.toCharArray();
        int maxChar = symbols[0];
        for(char c : symbols) {
            if (maxChar < c) {
                maxChar = c;
            }
        }
        int[] code = new int[maxChar+1];
        Arrays.fill(code, 0);
        for (char m : symbols) {
            //System.out.println("m = " + v+ "maxChar = "+ maxChar);//Character.getNumericValue(m)
            code[m]++;
        }
        for(int item : code){
            if(item > 1){
                result+= item;
            }
        }
        return result;

    }
    @Override
    public  void task5(){
        Scanner sc = new Scanner(System.in);
        String[] arrStr = getStrings2(sc);

        int vowelsInWord = 0;
        int counter =0;
        for(String word: arrStr){
            if(word.length() % 2 == 0 && word.matches("[a-zA-Z]+")){
                for(char c : word.toLowerCase().toCharArray()){
                    if(Character.toString(c).matches("[aeiouy]")){
                        vowelsInWord++;
                    }
                }

                if(word.length()/2 == vowelsInWord){
                    counter++;
                }
                vowelsInWord = 0;
            }
        }
        System.out.println(counter);
    }

    public static  boolean checkTask6(String nameString) {
        int counter= 0;
        String result = "";

        char[] symbols = nameString.toCharArray();
        int pastChar = symbols[0];
        if(symbols.length>1){
            for(char c : Arrays.copyOfRange( symbols, 1,symbols.length -1)) {
                if (pastChar < (int)c) {
                    pastChar = (int)c;
                }else{
                    return false;
                }

            }
        }
        return true;

    }
    @Override
    public void task6(){
        String result = "NOT FOUND";
        Scanner sc = new Scanner(System.in);
        String[] arrStr = getStrings2(sc);
        for(String word :arrStr){
            if(checkTask6(word) == true){
                result = word;
                break;

            }
        }
        System.out.println(result);
    }
    public static  boolean checkTask7(String nameString) {
        char[] symbols = nameString.toCharArray();
        int pastChar = symbols[0];
        char range[] = Arrays.copyOfRange( symbols, 1,symbols.length);
        Arrays.sort(range);
        //System.out.println("length range = "+range.length+ "lenght symbol = "+symbols.length);
        if(symbols.length>1){
            for(char c : range) {
                if (pastChar == (int)c) {
                    return false;
                }
                pastChar = (int)c;
            }
        }
        return true;

    }

    @Override
    public void task7() {
        Scanner sc = new Scanner(System.in);
        int index = 1;
        String[] arrStr = getStrings2(sc);
        String [] result = new String[arrStr.length+1];
        Arrays.fill(result,"");
        Arrays.sort(arrStr);
        for(String word :arrStr){
            System.out.println("word = "+checkTask7(word));
            if(checkTask7(word) == true){
                if(!result[index-1].equals(word)){
                    result[index] = word;
                }

            }
            index++;
        }
        StringBuilder printResult = new StringBuilder();
        for(String item: result){
            if(item!=null){
                printResult.append(item).append(" ");
            }
            else {
                printResult.append("NOT FOUND");
            }
        }
        System.out.println(printResult.toString().trim());

    }
    @Override
    public   void task8(){
        Scanner sc = new Scanner(System.in);
        String[] arrStr = getStrings2(sc);
        ArrayList<Integer> result = new ArrayList<Integer>();

        for(String word: arrStr){
            if(word.matches("[0-9]+")){
                if(word.length()%2 == 0){
                    if(word.substring(0,word.length()/2).equals(reverseIt(word.substring(word.length()/2,word.length())))){
                        //System.out.println("FirstCondidtion");
                        result.add(Integer.parseInt(word));
                    }
                }
                else if(word.length()%2 !=0&&word.length()!=1){
                    if(word.substring(0,word.length()/2).equals(reverseIt(word.substring((word.length()/2)+1,word.length())))){
                        //System.out.println("SecondCondition");
                        result.add(Integer.parseInt(word));
                    }
                }
                else if(word.length() == 1) {
                    //System.out.println("ThirdCondition");
                    result.add(Integer.parseInt(word));
                }
            }

        }
        for (Integer item:result) {
            System.out.println("Print result items");
            System.out.println(item);
        }
    }
    public static String reverseIt(String source) {
        int i, len = source.length();
        StringBuilder dest = new StringBuilder(len);

        for (i = (len - 1); i >= 0; i--){
            dest.append(source.charAt(i));
        }

        return dest.toString();
    }

    @Override
    public void task9() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        StringBuilder row = new StringBuilder();
        for(int i =1; i <= n; i++){
            for(int j =i*n+1-n; j < i*n+1; j++){
                row.append(j);
                row.append('\t');
            }
            System.out.println(row.toString().trim());
            row.setLength(0);
        }
    }

    @Override
    public void task10() {
        Scanner scanner = new Scanner(System.in);
        final int A = scanner.nextInt();
        final int B = scanner.nextInt();
        final int C = scanner.nextInt();
        final double D = B * B - 4 * A * C;
        double x1 =0;
        double x2 = 0;
        StringBuilder result = new StringBuilder();
        if(D > 0){
            x2 = (-B + Math.sqrt(D))/(2*A);
            x1 = (-B - Math.sqrt(D))/(2*A);
            //BigDecimal res = new BigDecimal(x1);
            result.append(new BigDecimal(x1).setScale(1, ROUND_HALF_UP));
            result.append(", ");
            result.append(new BigDecimal(x2).setScale(1, ROUND_HALF_UP));

        }
        else if(D == 0){
            x1 = -(double) B /(2*A);
            result.append(new BigDecimal(x1).setScale(1, ROUND_HALF_UP));

        }else {
            result.append("No solution");

        }
        System.out.println(result.toString());
    }

    @Override
    public void task11() {
        Scanner scanner = new Scanner(System.in);
        try {
            int month = scanner.nextInt();
            if (month<=12&&month>0) {
                //System.out.println(new StringBuilder(Month.of(month).name().toLowerCase()));
                System.out.println(Month.of(month).name().substring(0,1).toUpperCase() + Month.of(month).name().substring(1).toLowerCase());
            }
            else throw new RuntimeException();
        }catch (RuntimeException e){
            System.out.println("INCORRECT INPUT DATA");
        }
    }
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


    @Override
    public void task12() {
        Scanner scanner = new Scanner(System.in);
        int k =  scanner.nextInt();
        Scanner sc = new Scanner(System.in);
        int[][] matrix  = readMatrix(sc);
        Arrays.sort(matrix, Comparator.comparing((int[] arr) -> arr[k]));
        for(int i = 0; i<matrix.length;i++){
            System.out.println(Arrays.toString(matrix[i]).replace("[", "").replace("]", "")  );
        }

    }

    @Override
    public void task13() {
        Scanner scanner = new Scanner(System.in);
        int k =  scanner.nextInt();
        Scanner sc = new Scanner(System.in);
        int[][] matrix  = readMatrix(sc);
        if(k>=0){
            if(Math.abs(k)> matrix[0].length){
                k = k%matrix[0].length;
            }
            System.out.println(matrix[0].length);
            IntStream.range(matrix[0].length-k, matrix[0].length).forEach(
                    n -> {
                        System.out.println(Arrays.toString(matrix[n]).replace("[", "").replace("]", "")  );
                    }
            );
            IntStream.range(0, matrix[0].length-k).forEach(
                    n -> {
                        System.out.println(Arrays.toString(matrix[n]).replace("[", "").replace("]", "")  );
                    }
            );
        }
        if(k<0){
            if(Math.abs(k)> matrix[0].length){
                k = k%matrix[0].length;
            }
            System.out.println(matrix[0].length);
            IntStream.range(-k, matrix[0].length).forEach(
                    n -> {
                        System.out.println(Arrays.toString(matrix[n]).replace("[", "").replace("]", "")  );
                    }
            );
            IntStream.range(0, -k).forEach(
                    n -> {
                        System.out.println(Arrays.toString(matrix[n]).replace("[", "").replace("]", "")  );
                    }
            );
        }
    }

    @Override
    public void task14() {
        int count = 0;
        int max = 0;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i<n;i++){
            arr[i] = scanner.nextInt();
        }
        int first = arr[0];
        int second  = 0;
        for(int i = 1; i< arr.length;i++){
            second = arr[i];
            if(second > first){
                count++;
                if(max<count){
                    max = count;
                }

            }
            else {
                count = 0;
            }
            first = second;
        }
        System.out.println(max+1);
        //2 1 3 3 4 5 6 5
    }
    private int findMiddle(int[] row){
        boolean first =false;
        int index = 0;
        for(int i = 0; i< row.length; i++){
            if(row[i] > 0){
                first = true;
                index = i;
                //System.out.println("First condition work = "+row[index]);
            }
            if(index<row.length-2&&first&&row[index+2] >0){
                //System.out.println("Scond condition work = "+row[index + 1]);
                return row[index + 1];
            }
        }
        return 0;
    }

    @Override
    public void task15() {
        int sum =0;
        Scanner scanner = new Scanner(System.in);
        int[][] matrix  = readMatrix(scanner);
        for(int[] row: matrix){
            sum += findMiddle(row);
        }
        System.out.println(sum);
    }
    public void task16 () {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix  = readMatrix(scanner);
        int width = matrix.length;
        int height = matrix[0].length;

        int[][] matrix_new = new int[height][width];

        for (int x = 0; x <width; x++) {
            //System.out.println(Arrays.toString(matrix[x]));
            for (int y = height-1; y >=0; y--) {
                //System.out.println(matrix[x][y]);
                matrix_new[y][x] = matrix[x][y];
            }
        }
        //System.out.println(width);
        for(int i = width-1; i>=0;i--){
            System.out.println(Arrays.toString(matrix_new[i]).replace("[", "").replace("]", "")  );
        }
    }

    private int[][] getMatrixWithoutRowAndCol(int [][]matrix, int size, int row, int col, int [][]newMatrix) {
        int offsetRow = 0; //Смещение индекса строки в матрице
        int offsetCol = 0; //Смещение индекса столбца в матрице
        for(int i = 0; i < size-1; i++) {
            //Пропустить row-ую строку
            if(i == row) {
                offsetRow = 1; //Как только встретили строку, которую надо пропустить, делаем смещение для исходной матрицы
            }

            offsetCol = 0; //Обнулить смещение столбца
            for(int j = 0; j < size-1; j++) {
                //Пропустить col-ый столбец
                if(j == col) {
                    offsetCol = 1; //Встретили нужный столбец, проускаем его смещением
                }

                newMatrix[i][j] = matrix[i + offsetRow][j + offsetCol];
            }

        }
        return newMatrix;
    }

    @Override
    public void task17() {
        Scanner scanner =  new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);
        int size = matrix.length;
        System.out.println(matrixDet(matrix,size));
    }
    //Вычисление определителя матрицы разложение по первой строке
    int matrixDet(int [][]matrix,int size) {
        int det = 0;
        int degree = 1;
        //Scanner scanner =  new Scanner(System.in);
        //int[][] matrix = readMatrix(scanner);
        //int size = matrix.length;
        //Условие выхода из рекурсии
        if(size == 1) {
            return matrix[0][0];
        }
        //Условие выхода из рекурсии
        else if(size == 2) {
            return matrix[0][0]*matrix[1][1] - matrix[0][1]*matrix[1][0];
        }
        else {
            //Матрица без строки и столбца
            int [][]newMatrix = new int[size-1][size-1];
            for(int i = 0; i < size-1; i++) {
                newMatrix[i] = new int[size-1];
            }

            //Раскладываем по 0-ой строке, цикл бежит по столбцам
            for(int j = 0; j < size; j++) {
                //Удалить из матрицы i-ю строку и j-ый столбец
                //Результат в newMatrix
                getMatrixWithoutRowAndCol(matrix, size, 0, j, newMatrix);

                //Рекурсивный вызов
                //По формуле: сумма по j, (-1)^(1+j) * matrix[0][j] * minor_j (это и есть сумма из формулы)
                //где minor_j - дополнительный минор элемента matrix[0][j]
                // (напомню, что минор это определитель матрицы без 0-ой строки и j-го столбца)
                det = det + (degree * matrix[0][j]* matrixDet(newMatrix, size-1));
                //"Накручиваем" степень множителя
                degree = -degree;
            }

            //Чистим память на каждом шаге рекурсии(важно!)
            for(int i = 0; i < size-1; i++) {

            }

        }

        return det;
    }
}
