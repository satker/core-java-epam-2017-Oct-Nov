package com.epam.courses.jf.practice.common.first;

import java.util.Scanner;

public class Solver implements ISolver {
    private Scanner scanner;
    public Solver(){
        scanner = new Scanner(System.in);
    }
    @Override
    public void task1() {
        int n = scanner.nextInt();
        String maxString = scanner.nextLine();
        String minString = maxString;
        for(int i = 1; i < n; ++i){
            String str = scanner.nextLine();
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
}
