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

        String tempSmall ="";
        String tempBig ="";
        Scanner scanner = new Scanner(System.in);
        String[] strings = getStrings(scanner);
        tempSmall = strings[0];
        tempBig = strings[0];
        for (String str: strings){

            if(str.length()<= tempSmall.length()){
                tempSmall = str;
            }
            if(str.length()>= tempBig.length()){
                tempBig = str;
            }
        }
        System.out.printf("MIN (%d): \"%s\"%n", tempSmall.length(), tempSmall);
        System.out.printf("MAX (%d): \"%s\"%n", tempBig.length(), tempBig);


    }
    @Override
    public void task2() {
        Scanner sc = new Scanner(System.in);
        String arrStr [] = getStrings(sc);
        Arrays.sort(arrStr,Comparator.comparingInt(String::length)
                .thenComparing(String::compareTo));

        for(String str: arrStr){
            System.out.printf("(%d):\"%s\"%n", str.length(), str);

        }

    }

    /***

     * @param scanner
     * @return String[]
     * <p>getStrings() method to get Strins from System.in()</p>
     */
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
                System.out.printf("(%d):\"%s\"%n",str.length(),str);
            }
        }
    }

}
