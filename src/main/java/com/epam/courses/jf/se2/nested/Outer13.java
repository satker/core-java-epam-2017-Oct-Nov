package com.epam.courses.jf.se2.nested;

public class Outer13 {

    private static int x = 10;

    static class Inner1 {

        public static void method() {
            System.out.println("inner1 outer.x=" + x);
        }
    }

    class Inner2 extends Outer13.Inner1 {

        public void outer2Method() {
            System.out.println("x=" + x); // ERROR
        }
    }
}

class Outer14 extends Outer13.Inner1 {

    public void outer2Method() {
         //System.out.println("x=" + x); // ERROR
    }
}
