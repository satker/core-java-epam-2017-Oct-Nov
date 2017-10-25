package com.epam.courses.jf.practice.akunats.second;

import com.epam.courses.jf.practice.common.second.I2DPoint;
import com.epam.courses.jf.practice.common.second.ITestableTask17;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Task17 implements ITestableTask17 {
    @Override
    public Set<I2DPoint> analyze(Set<ISegment> segments) {
        Set<I2DPoint> result = new HashSet<>();
        Iterator<ISegment> iter = segments.iterator();
        while (iter.hasNext()) { // первый шаг
            Set<I2DPoint> interSet = new HashSet<>();
            ISegment line = iter.next();
            for (ISegment nextLine : segments) { // первый шаг
                if (!nextLine.equals(line)) {
                    // Считаем коэффициенты уравнение прямой Ax + By + C = 0
                    double A1 = line.second().getY() - line.first().getY();
                    double B1 = line.second().getX() - line.first().getX();
                    double C1 = line.first().getY() * B1 - line.first().getX() * A1;

                    double A2 = nextLine.second().getY() - nextLine.first().getY();
                    double B2 = nextLine.second().getX() - nextLine.first().getX();
                    double C2 = nextLine.first().getY() * B2 - nextLine.first().getX() * A2;
                    // точка пересечения прямых
                    double pointIntersectionY = (C1 * A2 - C2 * A1) / (B1 * A2 - B2 * A1);
                    double pointIntersectionX = (B1 * pointIntersectionY - C1) / A1;

                    double minX1 = line.second().getX() < line.first().getX()
                            ? line.second().getX() : line.first().getX();
                    double maxX1 = line.second().getX() < line.first().getX()
                            ? line.first().getX() : line.second().getX();
                    double minY1 = line.second().getY() < line.first().getY()
                            ? line.second().getY() : line.first().getY();
                    double maxY1 = line.second().getY() < line.first().getY()
                            ? line.first().getY() : line.second().getY();

                    double minX2 = nextLine.second().getX() < nextLine.first().getX()
                            ? nextLine.second().getX() : nextLine.first().getX();
                    double maxX2 = nextLine.second().getX() < nextLine.first().getX()
                            ? nextLine.first().getX() : nextLine.second().getX();
                    double minY2 = nextLine.second().getY() < nextLine.first().getY()
                            ? nextLine.second().getY() : nextLine.first().getY();
                    double maxY2 = nextLine.second().getY() < nextLine.first().getY()
                            ? nextLine.first().getY() : nextLine.second().getY();
                    // Лежит ли точка в отрезке
                    if (((pointIntersectionX >= minX1 && pointIntersectionX <= maxX1)
                            && (pointIntersectionY >= minY1 && pointIntersectionY <= maxY1))
                            && ((pointIntersectionX >= minX2 && pointIntersectionX <= maxX2)
                            && (pointIntersectionY >= minY2 && pointIntersectionY <= maxY2))) {
                        interSet.add(new Point(pointIntersectionX, pointIntersectionY));
                    }
                }
            }
            if (!interSet.isEmpty()) {
                I2DPoint minXpoint = interSet.stream().min(Comparator.comparingDouble(I2DPoint::getX)).get();
                result.add(minXpoint);
            }
            iter.remove();
        }
        return result;
    }

    private class Segment implements ISegment {
        private I2DPoint first;
        private I2DPoint second;

        Segment(I2DPoint first, I2DPoint second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public I2DPoint first() {
            return first;
        }

        @Override
        public I2DPoint second() {
            return second;
        }
    }
}
