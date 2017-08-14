package com.epam.courses.jf.se2.interfaces;

public class Main extends Left implements Right, Third {

    @Override
    public int getValue() {
        return Right.super.getValue();
    }
}

class Left {

    int getValue() {
        return 0;
    }
}

interface Right {

    default int getValue() {
        return 0;
    }
}

interface Third {

    int getValue();
}
