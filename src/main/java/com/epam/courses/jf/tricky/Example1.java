package com.epam.courses.jf.tricky;

@SuppressWarnings("all")
public class Example1 {

    private final Example1 field = new Example1();

    public int show() {
        return (true ? null : 0);
    }

    public static void main(String[] args) {
        Example1 variable = new Example1();
        System.out.println(variable.show());
    }
}
