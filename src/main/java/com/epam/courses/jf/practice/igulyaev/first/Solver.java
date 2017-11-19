package com.epam.courses.jf.practice.igulyaev.first;

import com.epam.courses.jf.practice.common.first.ISolver;
import com.epam.courses.jf.practice.common.first.Reader;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Solver implements ISolver {
    //private Reader reader;
    /*public Solver(){

    }*/
    @Override
    public void task1() {
        final Reader reader = new Reader(System.in);
        int n = Integer.parseInt(reader.readLine());
        String maxString = reader.readLine();
        String minString = maxString;
        for(int i = 1; i < n; ++i){
            String str = reader.readLine();
            if(str.length() >= maxString.length()){
                maxString = str;
            }
            if(str.length() <= minString.length()){
                minString = str;
            }
        }
        System.out.printf("MIN (%d): \"%s\"%n", minString.length(), minString);
        System.out.printf("MAX (%d): \"%s\"%n", maxString.length(), maxString);
    }

    @Override
    public void task2(){
        final Reader reader = new Reader(System.in);
        Set<String> stringSet = new TreeSet<>((s1,s2) ->
                s1.length() < s2.length() ? -1 : (s1.length() > s2.length() ? 1 : s1.compareTo(s2))
        );

        int n = Integer.parseInt(reader.readLine());

        for(int i = 0; i < n; ++i){
            stringSet.add(reader.readLine());
        }

        stringSet.forEach(s -> System.out.printf("(%d): \"%s\"%n", s.length(), s));
    }

    @Override
    public void task3(){
        final Reader reader = new Reader(System.in);
        List<String> stringList = new LinkedList<>();
        int n = Integer.parseInt(reader.readLine());
        long sizeSum = 0;
        for(int i = 0; i < n; ++i){
            String str = reader.readLine();
            sizeSum += str.length();
            stringList.add(str);
        }
        final long averageLength = sizeSum / n;
        System.out.printf("AVERAGE (%d)%n", averageLength);
        stringList.stream()
                .filter(s -> s.length() < averageLength)
                .forEach(s -> System.out.printf("(%d): \"%s\"%n", s.length(), s));
    }

    @Override
    public void task4(){
        final Reader reader = new Reader(System.in);
        int n = Integer.parseInt(reader.readLine());
        Arrays.stream(reader.readLine().split(" ", n))
                .filter(s -> s.matches("^\\p{Alpha}+$"))
                .reduce((first, second) ->
                        first.chars().distinct().count() <= second.chars().distinct().count() ? first : second)
                .ifPresent(System.out::println);
    }

    @Override
    public void task5(){
        final Reader reader = new Reader(System.in);
        int n = Integer.parseInt(reader.readLine());
        System.out.println(
                Arrays.stream(reader.readLine().split(" ", n))
                        .filter(s -> s.matches("^\\p{Alpha}+$"))
                        .filter(s ->
                                ((s.split("[aeiouy]", -1).length - 1) * 2) == s.length()
                        ).count()
        );
    }

    @Override
    public void task6(){
        final Reader reader = new Reader(System.in);
        int n = Integer.parseInt(reader.readLine());
        System.out.println(
                Arrays.stream(reader.readLine().split(" ", n))
                        .filter(s -> s.length() > 1)
                        .filter(s -> {
                            char buffer = 0;
                            for (char c : s.toCharArray() ) {
                                if(c <= buffer){
                                    return false;
                                }
                                buffer = c;
                            }
                            return true;
                        }).findFirst().orElse("NOT FOUND")
        );
    }

    @Override
    public void task7(){
        final Reader reader = new Reader(System.in);
        int n = Integer.parseInt(reader.readLine());
        List<String> stringList = Arrays.stream(reader.readLine().split(" ", n))
                .distinct()
                .filter(s -> s.chars().distinct().count() == s.length())
                .collect(Collectors.toList());
        if(stringList.isEmpty()){
            System.out.println("NOT FOUND");
        } else {
            stringList.forEach(s -> System.out.printf("%s ", s));
        }
    }

    @Override
    public void task8(){
        final Reader reader = new Reader(System.in);
        int n = Integer.parseInt(reader.readLine());
        System.out.println(Arrays.stream(reader.readLine().split(" ", n))
                .filter(s -> s.matches("^\\d+$"))
                .filter(s ->{
                    char[] chars = s.toCharArray();
                    Stack<Character> stack = new Stack<>();
                    for(int i = 0; i < chars.length / 2; ++i){
                        stack.push(chars[i]);
                    }
                    for(int i = chars.length / 2 + chars.length % 2; i < chars.length; ++i){
                        char с = stack.pop();
                        if(с != chars[i]){
                            stack.push(с);
                        }
                    }
                    return stack.empty();
                }).limit(2).reduce((first, second) -> second).orElse("NOT FOUND")
        );
    }

    @Override
    public void task9(){
        final Reader reader = new Reader(System.in);
        int n = Integer.parseInt(reader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 1; i <= n*n; ++i){
            stringBuilder.append(i);
            stringBuilder.append(i % n == 0 ? "\n" :"\t");
        }
        System.out.print(stringBuilder);
    }
    @Override
    public void task10(){
        final Scanner scanner = new Scanner(System.in);
        final DecimalFormat df = new DecimalFormat("#0.##");
        final DecimalFormatSymbols dfs = df.getDecimalFormatSymbols();
        dfs.setDecimalSeparator('.');
        df.setDecimalFormatSymbols(dfs);
        final BigDecimal a = scanner.nextBigDecimal();
        final BigDecimal b = scanner.nextBigDecimal();
        final BigDecimal c = scanner.nextBigDecimal();
        final BigDecimal d = b.pow(2).subtract(a.multiply(c).multiply(BigDecimal.valueOf(4)));
        if(d.signum() < 0){
            System.out.println("No solution");
        } else if(d.signum() == 0){
            System.out.println("One solution: " +
                    df.format(b.negate().divide(a.multiply(BigDecimal.valueOf(2))))
                    );
        } else {
            BigDecimal sqrtD = BigDecimal.valueOf(StrictMath.sqrt(d.doubleValue()))
                    .setScale(2, BigDecimal.ROUND_HALF_UP);
            BigDecimal minusB = b.negate();
            BigDecimal a2 = a.multiply(BigDecimal.valueOf(2));
            System.out.println("Two solutions: " +
                    df.format(minusB.subtract(sqrtD).divide(a2)) + ", " +
                    df.format(minusB.add(sqrtD).divide(a2))
                    );
        }
    }

    @Override
    public void task11(){
        final Reader reader = new Reader(System.in);
        int n = Integer.getInteger(reader.readLine(), 0);
        String str;
        switch(n){
            case 1:
                str = "January";
                break;
            case 2:
                str = "February";
                break;
            case 3:
                str = "March";
                break;
            case 4:
                str = "April";
                break;
            case 5:
                str = "May";
                break;
            case 6:
                str = "June";
                break;
            case 7:
                str = "July";
                break;
            case 8:
                str = "August";
                break;
            case 9:
                str = "September";
                break;
            case 10:
                str = "October";
                break;
            case 11:
                str = "November";
                break;
            case 12:
                str = "December";
                break;
            default:
                str = "INCORRECT INPUT DATA";
        }
        System.out.println(str);
    }
    @Override
    public void task12(){
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        int[][] matrix = readMatrix(scanner);
        Arrays.sort(matrix, Comparator.comparingInt(row -> row[n]));
        System.out.print(matrixToString(matrix));
    }

    private String matrixToString(final int[][] matrix){
        StringBuilder builder = new StringBuilder();
        AtomicInteger index = new AtomicInteger(1);
        Arrays.stream(matrix).flatMapToInt(Arrays::stream).forEach(i ->{
            builder.append(i);
            builder.append(index.getAndIncrement() % matrix.length == 0 ? "\n" :"\t");
        });
        return builder.toString();
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
}
