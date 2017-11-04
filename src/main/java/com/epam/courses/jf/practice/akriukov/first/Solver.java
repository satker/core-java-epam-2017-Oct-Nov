package com.epam.courses.jf.practice.akriukov.first;

import com.epam.courses.jf.practice.common.first.ISolver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solver implements ISolver{


    @Override
    public void task1() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int numberOfLines = 0;
                numberOfLines = Integer.parseInt(reader.readLine());
            String[] lines = new String[numberOfLines];

            for (int i = 0; i < numberOfLines; i++) {
                lines[i] = reader.readLine();
            }

            int minLength = lines[0].length();
            int maxLength = lines[0].length();
            String minString = lines[0];
            String maxString = lines[0];

            for (int i = 0; i < numberOfLines; i++) {
                if (minLength >= lines[i].length()) {
                    minLength = lines[i].length();
                    minString = lines[i];
                }
                if (maxLength <= lines[i].length()) {
                    maxLength = lines[i].length();
                    maxString = lines[i];
                }

            }
            System.out.printf("MIN (%d): \"%s\"%n", minLength, minString);
            System.out.printf("MAX (%d): \"%s\"%n", maxLength, maxString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
