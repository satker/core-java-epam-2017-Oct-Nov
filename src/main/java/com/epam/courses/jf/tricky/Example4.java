package com.epam.courses.jf.tricky;

@SuppressWarnings("all")
public class Example4 {

    int getValue() {
        return (true ? null : 0);
    }

    public static void main(String[] args)  {
        Example4 obj = new Example4();
        System.out.println(obj.getValue());
    }
}