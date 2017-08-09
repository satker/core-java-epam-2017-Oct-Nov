package com.epam.courses.jf.se2.varargs;

public class VarArgs {

    public static int getArgCount(Integer...args) {
        if (args.length == 0) {
            System.out.print("No arg");
        }
        for (int i : args) {
            System.out.print("arg:" + i + " ");
        }
        return args.length;
    }

    public static void getArgCount(Integer[]...args) {
        if (args.length == 0) {
            System.out.print("No arg2");
        }
        for (Integer[] mas : args) {
            for (int x : mas) {
                System.out.print("arg2:" + x + " ");
            }
        }
    }

    public static void main(String args[]) {
        System.out.println("N=" + getArgCount(7, 71, 555));

        Integer[] i = { 1, 2, 3, 4, 5 };
        printArgCount(7, "No", true, null);
        printArgCount(i, i, i);
        printArgCount(i, 4, 71);
        printArgCount(i);
        // printArgCount(5, 7); // ERROR

    }

    public static void printArgCount(Object... args) { // 1
        System.out.println("Object args: " + args.length);
    }

    public static void printArgCount(Integer[]... args) { // 2
        System.out.println("Integer[] args: " + args.length);
    }

    public static void printArgCount(int... args) { // 3
        System.out.print("int args: " + +args.length);
    }

    static void methodName(Integer...args) {}
    static void methodName(long...args) {}
    static void methodName(Object...args) {}
    static void methodName(int x1, int x2) {}
    static void methodName(int...args) {}
    static void methodName(String...args) {}
}
