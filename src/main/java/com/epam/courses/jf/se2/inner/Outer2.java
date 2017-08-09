package com.epam.courses.jf.se2.inner;

import java.util.Date;

public class Outer2 {

    private Inner inner;
    private String str;
    private Date date;

    static {
        System.out.println("Static initializer");
    }

    private final static Object prfsi_polr2 = new Object();

    Outer2() {
        inner = new Inner();
        inner.field = 5;
        System.out.println(inner.field);
    }

    class Inner {

        private int i;
        // public static int static_pole; // ERROR
        // public final static int[] intArr = {1, 2, 3,};
        public final static int pubfsi_pole = 22;
        private final static String prfsi_polr = "wqer";
        // private final static Object prfsi_polr2 = new Object();
        private int field;

        public void method() {
            System.out.println(Outer2.this.str);
            System.out.println(str);
        }
    }

    public void callMethodInInner() {
        inner.method();
    }

}

class Main {
    public static void main(String[] args) {
        System.out.println(Outer2.Inner.pubfsi_pole);
    }
}
