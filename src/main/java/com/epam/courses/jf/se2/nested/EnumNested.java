package com.epam.courses.jf.se2.nested;

import java.util.ArrayList;

public enum EnumNested {
    A(0),
    B(1);

    private final int number;

    EnumNested(int number) {
        this.number = number;
    }

    class Nested {

        public int getNumber() {
            return number;
        }
    }
}

class Launcher {

    public static void main(String[] args) {
        System.out.println(EnumNested.B.new Nested().getNumber());
    }
}
