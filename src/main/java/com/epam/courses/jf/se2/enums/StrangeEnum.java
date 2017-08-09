package com.epam.courses.jf.se2.enums;

public enum StrangeEnum {
    FIRST(0),
    THIRD(2),
    SECOND(1);

    private final int number;

    StrangeEnum(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
