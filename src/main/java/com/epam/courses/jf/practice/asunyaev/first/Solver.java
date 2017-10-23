package com.epam.courses.jf.practice.asunyaev.first;

import com.epam.courses.jf.practice.common.first.ISolver;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Arrays;

public class Solver implements ISolver {

    public static void main(String[] args) {
        Solver solver = new Solver();
        solver.task11();
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

}
