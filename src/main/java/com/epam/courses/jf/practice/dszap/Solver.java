package com.epam.courses.jf.practice.dszap;

import com.epam.courses.jf.practice.common.first.ISolver;

import java.util.Scanner;

public class Solver implements ISolver {

    @Override
    public void task1() {
        Scanner reader = new Scanner(System.in);

        int size = reader.nextInt();

        if (size < 1) {
            throw new IllegalArgumentException();
        }
        String min = reader.next();
        String max = min;

        for (int i = 1; i < size; i++) {
            String next = reader.next();
            if (next.length() <= min.length()) {
                min = next;
            }
            if (next.length() >= max.length()) {
                max = next;
            }
        }

        System.out.printf("MIN (%d): \"%s\"%n", min.length(), min);
        System.out.printf("MAX (%d): \"%s\"%n", max.length(), max);

    }
}
