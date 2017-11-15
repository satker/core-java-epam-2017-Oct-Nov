package com.epam.courses.jf.practice.mallayarov.second;

import com.epam.courses.jf.practice.common.second.I2DPoint;
import com.epam.courses.jf.practice.common.second.ITestableTask17;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

public class Task17Impl implements ITestableTask17 {
    @Override
    public Set<I2DPoint> analyze(Set<ISegment> segments) {
        TreeMap<Integer, SimplePoint> crossedSegments = new TreeMap<>();
        ISegment[] segmentsArray = segments.toArray(new ISegment[segments.size()]);

        for (int i = 0; i < segmentsArray.length - 1; ++i) {
            for (int j = 1; j < segmentsArray.length; ++j) {
                SimplePoint crossPoint = crossPoint(segmentsArray[i], segmentsArray[j]);
                if (crossPoint != null) {
                    crossedSegments.put(i * segmentsArray.length + j, crossPoint);
                }
            }
        }

        double minAbs = Double.MAX_VALUE;
        for (SimplePoint point : crossedSegments.values()) {
            minAbs = Math.min(minAbs, point.getX());
        }

        Set<SimplePoint> pointsWithMinAbs = new HashSet<>();
        for (SimplePoint point : crossedSegments.values()) {
            if (point.getX() == minAbs) {
                pointsWithMinAbs.add(point);
            }
        }

        return new HashSet<>(pointsWithMinAbs);
    }

    public SimplePoint crossPoint(ISegment firstSegment, ISegment secondSegment) {
        // https://en.wikipedia.org/wiki/Line%E2%80%93line_intersection

        double x1 = firstSegment.first().getX();
        double y1 = firstSegment.first().getY();
        double x2 = firstSegment.second().getX();
        double y2 = firstSegment.second().getY();

        double x3 = secondSegment.first().getX();
        double y3 = secondSegment.first().getY();
        double x4 = secondSegment.second().getX();
        double y4 = secondSegment.second().getY();

        double denominator = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);
        if (denominator != 0) {
            double firstXDelta = x1 - x2;
            double firstYDelta = y1 - y2;
            double firstAdditionalPart = x1 * y2 - y1 * x2;

            double secondXDelta = x3 - x4;
            double secondYDelta = y3 - y4;
            double secondAdditionalPart = x3 * y4 - y3 * x4;

            double x = (firstAdditionalPart * secondXDelta - firstXDelta * secondAdditionalPart) / denominator;
            double y = (firstAdditionalPart * secondYDelta - firstYDelta * secondAdditionalPart) / denominator;

            if (isPointBelongsToSegment(firstSegment, x, y) && isPointBelongsToSegment(secondSegment, x, y)) {
                return new SimplePoint(x + 0d, y + 0d);
            }
        }
        return null;
    }

    public boolean isPointBelongsToSegment(ISegment segment, double x, double y) {
        return (segment.first().getX() <= x && segment.second().getX() >= x) ||
                (segment.first().getY() <= y && segment.second().getY() >= y);
    }

    public class SimplePoint implements I2DPoint {

        double x;
        double y;

        public SimplePoint(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public double getX() {
            return x;
        }

        @Override
        public double getY() {
            return y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            SimplePoint point = (SimplePoint) o;

            return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0;
        }

        @Override
        public int hashCode() {
            int result;
            long temp;
            temp = Double.doubleToLongBits(x);
            result = (int) (temp ^ (temp >>> 32));
            temp = Double.doubleToLongBits(y);
            result = 31 * result + (int) (temp ^ (temp >>> 32));
            return result;
        }
    }
}