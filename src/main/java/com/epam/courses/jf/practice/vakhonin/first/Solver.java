package com.epam.courses.jf.practice.vakhonin.first;

import com.epam.courses.jf.practice.common.first.ISolver;

import java.util.*;

/**
 * Created by igorvahonin on 03.11.17.
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

    public void task2() {
        int numberOfStrings, length;
        Map<Integer, ArrayList<String>> stringsMap;
        Scanner in;

        in = new Scanner(System.in);
        numberOfStrings = in.nextInt();
        String[] strings = new String[numberOfStrings];
        in = new Scanner(System.in);
        for (int j = 0; j < numberOfStrings; j++) {
            strings[j] = in.nextLine();
        }
        stringsMap = new TreeMap();
        for (String string : strings) {
            length = string.length();
            if (!stringsMap.containsKey(length)) {
                stringsMap.put(length, new ArrayList());
            }
            stringsMap.get(length).add(string);
        }

        for (Map.Entry<Integer, ArrayList<String>> entry : stringsMap.entrySet()) {
            List<String> stringListWithSameLength = entry.getValue();
            stringListWithSameLength.sort(String::compareToIgnoreCase);
            for (String s : stringListWithSameLength) {
                System.out.printf("(%d): \"%s\"%n", entry.getKey(), s);
            }
        }
    }
}
