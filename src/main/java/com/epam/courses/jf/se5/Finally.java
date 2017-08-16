package com.epam.courses.jf.se5;

public class Finally {

    static int procA() {
        try {
            System.out.println("Внутри procA");
            throw new RuntimeException("demo");
        } catch (RuntimeException ex) {
            System.out.println("Внутри catch A");
            return 1;
        } finally {
            System.out.println("finally для procA ");
            return 0;
        }
    }

    static int procB() {
        try {
            System.out.println("Внутри procB");
            return 0;
        } finally {
            System.out.println("finally для procB ");
            return 1;
        }
    }

    static void procC() {
        try {
            System.exit(0);
            System.out.println("Внутри procC");
        } finally {
            System.out.println("finally procC");
        }
    }

    public static void main(String args[]) {
        try {
            System.out.println(procA());
        } catch (Exception e) {
            System.out.println("Исключение выброшено");
        }
        System.out.println(procB());
        procC();
    }
}

