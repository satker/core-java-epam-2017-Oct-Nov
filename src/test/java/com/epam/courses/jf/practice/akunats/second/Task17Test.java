package com.epam.courses.jf.practice.akunats.second;

import com.epam.courses.jf.practice.common.second.I2DPoint;
import com.epam.courses.jf.practice.common.second.ITestableTask17;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;


public class Task17Test {
    public void test(Set<ITestableTask17.ISegment> segments, Set<I2DPoint> expected) throws Exception {
        // Prepare
        ITestableTask17 solver = new Task17();

        // Run
        Set<I2DPoint> result = solver.analyze(segments);

        // Asserts
        Set<I2DPoint> converted = new HashSet<>(result.size());
        for (I2DPoint point : result) {
            converted.add(new Point(point.getX(), point.getY()));
        }
        Assert.assertEquals(expected, converted);
    }

    /**
     * Одна точка пересечения.
     */
    @org.junit.Test (timeout = 2000)
    public void test1() throws Exception {
        Set<ITestableTask17.ISegment> segments = new HashSet<>(2);
        segments.add(new Segment(new Point(0, 0), new Point(2, 2)));
        segments.add(new Segment(new Point(2, 0), new Point(0, 2)));
        test(segments, Collections.<I2DPoint>singleton(new Point(1, 1)));
    }

    /**
     * Две точки пересечения с разной абсциссой.
     */
    @org.junit.Test ()
    public void test2() throws Exception {
        Set<ITestableTask17.ISegment> segments = new HashSet<>(3);
        segments.add(new Segment(new Point(0, 0), new Point(0, 2)));
        segments.add(new Segment(new Point(2, 0), new Point(2, 2)));
        segments.add(new Segment(new Point(0, 2), new Point(2, 2)));
        test(segments, Collections.<I2DPoint>singleton(new Point(0, 2)));
    }

    /**
     * Три точки пересечения, две из них имеют минимальную абсциссу
     */
    @org.junit.Test (timeout = 2000)
    public void test3() throws Exception {
        Set<ITestableTask17.ISegment> segments = new HashSet<>(3);
        segments.add(new Segment(new Point(0, 0), new Point(0, 3)));
        segments.add(new Segment(new Point(0, 3), new Point(3, 0)));
        segments.add(new Segment(new Point(0, 0), new Point(3, 3)));
        test(segments, new HashSet<I2DPoint>(Arrays.asList(new Point(0, 3), new Point(0, 0))));
    }

    /**
     * Отрезок на двумерной плоскости.
     */
    private class Segment implements ITestableTask17.ISegment {

        private final I2DPoint FIRST;

        private final I2DPoint SECOND;

        private Segment(I2DPoint start, I2DPoint end) {
            FIRST = start;
            SECOND = end;
        }

        @Override
        public I2DPoint first() {
            return FIRST;
        }

        @Override
        public I2DPoint second() {
            return SECOND;
        }
    }

}
