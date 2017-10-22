package com.epam.courses.jf.practice.common.first;

import java.util.Scanner;

public class Solver implements ISolver {

    private static String[] readStrings(Scanner scanner) {

        int n = Integer.parseInt(scanner.nextLine());

        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = scanner.nextLine();
        }

        return result;

    }

}
