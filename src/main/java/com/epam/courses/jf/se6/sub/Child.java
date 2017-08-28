package com.epam.courses.jf.se6.sub;

import com.epam.courses.jf.se6.Parent;

public class Child extends Parent {

    public static void main(String[] args) {
    }

    Child(int field) {
        super(field);
    }

    public void method(Child parent) {
        System.out.println(parent.protectedMethod());
        System.out.println(protectedMethod());

    }
}

class SubChild extends Child {

    SubChild(int field) {
        super(field);
    }
}
