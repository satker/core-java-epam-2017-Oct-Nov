package com.epam.courses.jf.se2.enums;

public enum Direction {
    FORWARD(1.0) {
        @Override
        public Direction opposite() {
            return BACKWARD;
        }
    },
    BACKWARD(2.0) {
        @Override
        public Direction opposite() {
            return FORWARD;
        }
    };

    private double ratio;

    abstract public Direction opposite();

    Direction(double r) {
        ratio = r;
    }

    public double getRatio() {
        return ratio;
    }

    public static Direction byRatio(double r) {
        if (r == 1.0)	return FORWARD;
        else if (r == 2.0) return BACKWARD;
        else throw new IllegalArgumentException();
    }
}


class Main {

    public static void main(String[] args) {
        Direction forward = Direction.FORWARD;
        Direction backward = forward.opposite();
    }
}