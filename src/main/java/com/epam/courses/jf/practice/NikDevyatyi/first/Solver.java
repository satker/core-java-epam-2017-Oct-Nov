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

}
