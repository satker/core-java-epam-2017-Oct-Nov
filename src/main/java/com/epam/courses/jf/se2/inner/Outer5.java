package com.epam.courses.jf.se2.inner;

public class Outer5 {

    Inner inner;

    private int value;

    Outer5() {
        inner = new Inner();
    }

    class Inner implements Cloneable {
        public final static int pubfsi_pole = 22;
        private final static int prfsi_polr = 33;

        void method() {
            System.out.println(value);
        }
    }

    class Inherited extends OuterParent {

    }

    class A extends Inner {

    }

    public void callMethodInInner() {
        System.out.println(Inner.prfsi_polr);
        System.out.println(Inner.pubfsi_pole);
    }
}

class OuterParent {


    public static void main(String[] args) {
        Outer5 outer = new Outer5();
        Outer5.Inner ref = outer.new Inner();

        class B {

        }

        B b = new B();
    }

    public void method() {
        final int x = 3;
        class Inner1 {
            private int a;
            void print() {
                System.out.println("x=" + x);
            }
        }
        Inner1 obj = new Inner1();
        obj.print();
        obj.a = 5;
    }
}