package com.epam.courses.jf.tricky;

@SuppressWarnings("all")
public class Example2 {

    public static void show() {
        System.out.println("Static method called");
    }

    public static void main(String[] args)  {
        Example2 obj = null;
        obj.show();
    }
}
