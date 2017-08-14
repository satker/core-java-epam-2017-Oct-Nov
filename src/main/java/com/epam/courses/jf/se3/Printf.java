package com.epam.courses.jf.se3;

public class Printf {

    public static void main(String[] args) {
        System.out.println(String.format(""));

        System.out.printf("QWERTY%n");
        System.out.printf("%d%n", 123);
        System.out.printf("%f%n", 0.123);
        System.out.printf("Hello %s%n", "Nick");
        int i = 1;
        System.out.printf("Hello %" + i + "$s%n", "Nick", "qwe");
        System.out.printf("Hello %2$s%n", "Nick", "qwe");
        System.out.printf("Hello %s %s%n", "Nick", "qwe");
        System.out.printf("Hello %s %<s %s%n", "Nick", "qwe");



    }
}
