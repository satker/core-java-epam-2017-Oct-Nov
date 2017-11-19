package com.epam.courses.jf.practice.sskovalevskiy.second;

import com.epam.courses.jf.practice.common.second.I2DPoint;
import com.epam.courses.jf.practice.common.second.ITestableTask15;

import java.io.*;
import java.util.*;

/**
 * Created by asus on 26.10.2017.
 */
public class ITestableTask15Impl implements ITestableTask15 {

    @Override
    public IFileWithLines analyze(Set<I2DPoint> points, File output) {

        List<Line> allLines = new ArrayList<>();
        Set<Line> lines = new HashSet<>();
        for (I2DPoint point : points) {
            for (I2DPoint anotherPoint : points) {
                if (point != anotherPoint) {
                    allLines.add(new Line(point, anotherPoint));
                }
            }
        }

        for (Line line : allLines) {
            for (Line anotherLine : allLines) {
                if (line.equals(anotherLine)) {
                    line.getPoints().addAll(anotherLine.getPoints());
                    anotherLine.getPoints().addAll(line.getPoints());
                }
            }
        }

        lines.addAll(allLines);

        return new IFileWithLines() {
            @Override
            public File getFile() {
                return output;
            }

            @Override
            public Set<ILine> getLines() {
                return new HashSet<>(lines);
            }
        };
    }

    class Line implements ILine {

        private Set<I2DPoint> points;
        private double angle;
        private double shift;

        Line(I2DPoint first, I2DPoint second) {
            if (points == null) {
                points = new HashSet<>();
            }
            points.add(first);
            points.add(second);
            angle = (first.getY() - second.getY()) / (first.getX() - second.getX());
            shift = first.getY() - angle * first.getX();
        }

        @Override
        public Set<I2DPoint> getPoints() {
            return points;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Line line = (Line) o;

            return Double.compare(line.angle, angle) == 0 && Double.compare(line.shift, shift) == 0;
        }

        @Override
        public int hashCode() {
            int result;
            long temp;
            temp = Double.doubleToLongBits(angle);
            result = (int) (temp ^ (temp >>> 32));
            temp = Double.doubleToLongBits(shift);
            result = 31 * result + (int) (temp ^ (temp >>> 32));
            return result;
        }
    }
}