package com.epam.courses.jf.practice.klimenko.second;

import com.epam.courses.jf.practice.common.second.I2DPoint;

public class Point2DImpl implements I2DPoint {
    double x, y;

    Point2DImpl() {
        x = y = 0;
    }

    Point2DImpl(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double getX() {
        return 0;
    }

    @Override
    public double getY() {
        return 0;
    }
}
