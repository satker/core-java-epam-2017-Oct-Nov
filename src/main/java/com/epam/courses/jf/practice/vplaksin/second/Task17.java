package com.epam.courses.jf.practice.vplaksin.second;

import com.epam.courses.jf.practice.common.second.I2DPoint;
import com.epam.courses.jf.practice.common.second.ITestableTask17;

import java.util.HashSet;
import java.util.Set;

import static java.lang.Math.min;

public class Task17 implements ITestableTask17 {

    private static double[] line(ISegment segment) {
        I2DPoint first = segment.first();
        I2DPoint second = segment.second();

        final double A;
        final double B;
        final double C;

        if (first.getX() == second.getX()) {
            A = 1;
            B = 0;
            C = -first.getX();
        } else if (first.getY() == second.getY()) {
            A = 0;
            B = 1;
            C = -first.getY();
        } else {
            A = 1;
            B = (first.getX() - second.getX()) / (second.getY() - first.getY());
            C = -first.getX() * A - first.getY() * B;
        }

        return new double[]{A, B, C};
    }

    private static boolean isPointOnLine(I2DPoint point, ISegment segment) {
        I2DPoint first = segment.first();
        I2DPoint second = segment.second();
        double x = point.getX();
        double y = point.getY();
        double x1 = first.getX();
        double y1 = first.getY();
        double x2 = second.getX();
        double y2 = second.getY();
        if ((x >= x1 && x <= x2 || x >= x2 && x <= x1)
                && (y >= y1 && y <= y2 || y <= y1 && y >= y2)) {
            return true;
        } else {
            return false;
        }
    }

    private static I2DPoint intersection(ISegment segment1, ISegment segment2) {
        I2DPoint first1 = segment1.first();
        I2DPoint second1 = segment1.second();
        I2DPoint first2 = segment2.first();
        I2DPoint second2 = segment2.second();

        if ((!first1.equals(first2) || !second1.equals(second2))
                && (!first1.equals(second2) || !second1.equals(first2))) {
            double[] line1 = line(segment1);
            double[] line2 = line(segment2);
            final double A1 = line1[0];
            final double B1 = line1[1];
            final double C1 = line1[2];
            final double A2 = line2[0];
            final double B2 = line2[1];
            final double C2 = line2[2];

            if (A1 == A2 && B1 == B2) {
                if (C1 == C2) {
                    if (isPointOnLine(first1, segment2)) {
                        return first1;
                    } else if (isPointOnLine(second1, segment2)) {
                        return second1;
                    } else if (isPointOnLine(first2, segment1)) {
                        return first2;
                    } else if (isPointOnLine(second2, segment1)) {
                        return second2;
                    } else {
                        return null;
                    }
                } else {
                    return null;
                }
            } else {
                final double x;
                final double y;
                if (A1 != 0) {
                    y = (A2 * C1 - A1 * C2) / (A1 * B2 - A2 * B1);
                    x = (-C1 - B1 * y) / A1;
                } else {
                    y = (A1 * C2 - A2 * C1) / (A2 * B1 - A1 * B2);
                    x = (-C2 - B2 * y) / A2;
                }
                I2DPoint point = new Point2D(x, y);
                if (isPointOnLine(point, segment1) && isPointOnLine(point, segment2)) {
                    return point;
                } else {
                    return null;
                }
            }
        }
        return null;
    }

    @Override
    public Set<I2DPoint> analyze(Set<ISegment> segments) {
        Set<I2DPoint> intersections = new HashSet<>();
        double min = 0;
        boolean isMinInitialised = false;
        for (ISegment segment1 : segments) {
            for (ISegment segment2 : segments) {
                I2DPoint point = intersection(segment1, segment2);
                if (point != null) {
                    intersections.add(point);
                    if (isMinInitialised) {
                        min = min(min, point.getX());
                    } else {
                        min = point.getX();
                        isMinInitialised = true;
                    }
                }
            }
        }

        Set<I2DPoint> result = new HashSet<>();
        for (I2DPoint point : intersections) {
            if (point.getX() == min) {
                result.add(point);
            }
        }
        return result;
    }

    private class Segment implements ISegment {

        private I2DPoint first;
        private I2DPoint second;

        private Segment(I2DPoint first, I2DPoint second) {
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
