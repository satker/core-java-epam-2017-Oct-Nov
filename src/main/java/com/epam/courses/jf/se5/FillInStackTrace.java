package com.epam.courses.jf.se5;

public class FillInStackTrace {

    public static void main(String[] args) {
        try {
            method();
        } catch (RuntimeException ex) {
            overrideStackTrace(ex);
        }

    }

    private static void overrideStackTrace(RuntimeException ex) {
        ex.fillInStackTrace();
        throw ex;
    }

    private static void method() {
        throw new RuntimeException();
    }
}
