package com.epam.courses.jf.se3.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Nikolai_Plokhoi on 8/14/2017.
 */
public class Main {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("ab+c");
        Matcher firstMatcher = pattern.matcher("ac");
        Matcher secondMatcher = pattern.matcher("abbbc4abbbc");

        System.out.println(firstMatcher.matches());
        System.out.println(secondMatcher.matches());
        System.out.println(secondMatcher.lookingAt());

        secondMatcher.reset();
        if (secondMatcher.find(4)) {
            System.out.println(secondMatcher.group());
        }
    }
}
