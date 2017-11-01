package com.epam.courses.jf.practice.nzenkova.first;

import com.epam.courses.jf.practice.common.first.ISolver;

import java.util.Scanner;

/**
 * Created by natal on 01.11.2017.
 */
public class Solver implements ISolver {
    public void task1() {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.valueOf(scanner.nextLine());/* number of lines */
        int maxLength, minLength;
        String maxString = "", minString = "";
        String str = scanner.nextLine();//reading a row
        maxLength = str.length();
        minLength = str.length();
        maxString = str;
        minString = str;
        for (int i = 0; i < number - 1; ++i) {
            str = scanner.nextLine();//reading a next row
            if (str.length() >= maxLength) {
                maxLength = str.length();
                maxString = str;
            }
            if (str.length() <= minLength) {
                minLength = str.length();
                minString = str;
            }
        }
        System.out.printf("MIN (%d): \"%s\"%n", minLength, minString);
        System.out.printf("MAX (%d): \"%s\"%n", maxLength, maxString);
    }
}
