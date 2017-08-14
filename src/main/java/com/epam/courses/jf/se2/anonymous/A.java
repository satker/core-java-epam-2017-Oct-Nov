package com.epam.courses.jf.se2.anonymous;

/**
 * Created by Nikolai_Plokhoi on 8/9/2017.
 */
public class A {

    public static void main(String[] args) {
        int value;

        value = 5;
        new A() {
            @Override
            protected void method() {
                System.out.println(value);
            }
        };
    }

    protected void method() {

    }
}
