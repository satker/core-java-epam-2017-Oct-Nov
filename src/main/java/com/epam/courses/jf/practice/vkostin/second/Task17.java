package com.epam.courses.jf.practice.vkostin.second;

import com.epam.courses.jf.practice.common.second.I2DPoint;
import com.epam.courses.jf.practice.common.second.ITestableTask17;

import java.util.*;

public class Task17 implements ITestableTask17 {

    /*
    public static void main(String[] args) {
        Task17 task = new Task17();

        Set<ISegment> testSet = new HashSet<>();
        testSet.add(new Segment(new TwoDPoint(1,4), new TwoDPoint(3, 2)));
        testSet.add(new Segment(new TwoDPoint(2,1), new TwoDPoint(5, 4)));
        testSet.add(new Segment(new TwoDPoint(1,8), new TwoDPoint(4, 6)));
        testSet.add(new Segment(new TwoDPoint(-1,6), new TwoDPoint(5, 7)));
        testSet.add(new Segment(new TwoDPoint(7,7), new TwoDPoint(7, 3)));

        testSet.add(new Segment(new TwoDPoint(2,5), new TwoDPoint(3, 4)));
        testSet.add(new Segment(new TwoDPoint(3,4), new TwoDPoint(4, 5)));

        task.analyze(testSet);
    }
    */

    private TwoDPoint findIntersection(Segment line1, Segment line2) {
        /**
         * Search for the point of intersection of two straight lines.
         */
        double[] coefsLine1 = getLineEquation(line1.first, line1.second);
        double[] coefsLine2 = getLineEquation(line2.first, line2.second);
        double x = (coefsLine1[1] - coefsLine2[1])
                / (coefsLine2[0] - coefsLine1[0]);
        double y = coefsLine1[0] * x + coefsLine1[1];

        return new TwoDPoint(x, y);
    }

    private double[] getLineEquation(I2DPoint pA, I2DPoint pB) {
        // y = [0]*x + [1];
        double[] coefficients = new double[2];
        coefficients[0] = (pB.getY() - pA.getY()) / (pB.getX() - pA.getX());
        coefficients[1] = pA.getY() - pA.getX() * coefficients[0];

        return coefficients;
    }

    @Override
    public Set<I2DPoint> analyze(Set<ISegment> segments) {

        Set<I2DPoint> pointsWithMinAbscissa = new HashSet<>();
        // abscissas of all points of intersection
        Map<Double,ArrayList<TwoDPoint>> abscissas = new TreeMap<>();

        for (ISegment segmExternal : segments) {
            for (ISegment segmInternal : segments) {
                if (!segmExternal.equals(segmInternal)) {
                    // current intersection point
                    TwoDPoint curPoint = findIntersection(
                            (Segment) segmExternal,
                            (Segment) segmInternal);

                    double limit1XExt = ((Segment) segmExternal).first.getX();
                    double limit1YExt = ((Segment) segmExternal).first.getY();
                    double limit2XExt = ((Segment) segmExternal).second.getX();
                    double limit2YExt = ((Segment) segmExternal).second.getY();

                    double limit1XInt = ((Segment) segmInternal).first.getX();
                    double limit1YInt = ((Segment) segmInternal).first.getY();
                    double limit2XInt = ((Segment) segmInternal).second.getX();
                    double limit2YInt = ((Segment) segmInternal).second.getY();

                    if ((Math.min(limit1XExt, limit2XExt) <= curPoint.getX())
                                && (curPoint.getX() <= Math.max(limit1XExt, limit2XExt))
                            && ((Math.min(limit1YExt, limit2YExt) <= curPoint.getY())
                                && (curPoint.getY() <= Math.max(limit1YExt, limit2YExt)))) {

                        if ((Math.min(limit1XInt, limit2XInt) <= curPoint.getX())
                                    && (curPoint.getX() <= Math.max(limit1XInt, limit2XInt))
                                && ((Math.min(limit1YInt, limit2YInt) <= curPoint.getY())
                                    && (curPoint.getY() <= Math.max(limit1YInt, limit2YInt)))) {

                            if (abscissas.containsKey(curPoint.getX())) {
                                abscissas.get(curPoint.getX()).add(curPoint);
                            } else {
                                abscissas.put(curPoint.getX(), new ArrayList<>());
                                abscissas.get(curPoint.getX()).add(curPoint);
                            }
                        }
                    }
                }
            }
        }


        TwoDPoint prePoint = new TwoDPoint(999.999, 999.999);
        for (Double aDouble : abscissas.keySet()) {
            for (TwoDPoint point : abscissas.get(aDouble)) {
                if ((point.getX() != prePoint.getX()) && (point.getY() != prePoint.getY())) {
                    if (abscissas.get(aDouble).contains(point)) {
                        pointsWithMinAbscissa.add(point);
                        prePoint = point;
                    }
                }
            }
            break;
        }

        return pointsWithMinAbscissa;
    }


    private static class Segment implements ISegment {

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
