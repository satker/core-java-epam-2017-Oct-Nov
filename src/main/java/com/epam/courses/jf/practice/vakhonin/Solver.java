package com.epam.courses.jf.practice.vakhonin;

import com.epam.courses.jf.practice.common.first.ISolver;

import java.util.*;

/**
 * Created by igorvahonin on 03.11.17.
 */
public class Solver implements ISolver {
    public void task1() {
        Scanner in;
        int numberOfStrings, length, minLength, maxLength;
        int numberOfShortestString = 0;
        int numberOfLongestString = 0;
        String s, minString, maxString;
        String[] strings;

        in = new Scanner(System.in);
        numberOfStrings = Integer.valueOf(in.nextLine());
        strings = new String[numberOfStrings];
//        in = new Scanner(System.in);

        for (int j = 0; j < numberOfStrings; j++) {
            strings[j] = in.nextLine();
        }

        numberOfShortestString = 0;
        numberOfLongestString = 0;
        minLength = strings[0].length();
        maxLength = minLength;
        for (int j = 1; j < numberOfStrings; j++) {
            s = strings[j];
            length = s.length();
            if (length <= minLength) {
                minLength = length;
                numberOfShortestString = j;
            }
            if (length >= maxLength) {
                maxLength = length;
                numberOfLongestString = j;
            }
        }
        minString = strings[numberOfShortestString];
        maxString = strings[numberOfLongestString];
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
