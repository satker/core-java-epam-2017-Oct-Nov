package com.epam.courses.jf.se5;

import java.io.IOException;

public class StackOverflow {

    public static void main(String[] args) throws IOException {
        method(0);
    }

    private static void method(int level) throws IOException {
        try {
            System.out.println("Inside method" + level);
            method(level + 1);
        } catch (Throwable ex) {
            System.in.read();
            System.out.println("Inside catch" + level);
            method(level + 1);
        } finally {
            System.out.println("Inside finally" + level);
        }
    }
}
