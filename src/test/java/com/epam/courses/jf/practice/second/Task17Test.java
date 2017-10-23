package com.epam.courses.jf.practice.second;

import org.junit.Assert;
import com.epam.courses.jf.practice.common.second.I2DPoint;
import com.epam.courses.jf.practice.common.second.ITestableTask17;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static com.epam.courses.jf.practice.common.second.ITestableTask17.ISegment;

/**
 * Проверяет выполнение семнадцатой задачи.
 *
 * На плоскости задано N отрезков.
 * Найти точку (возможно несколько) пересечения двух отрезков, имеющую минимальную абсциссу.
 * Использовать класс TreeMap.
 */
public class Task17Test extends AbstractTaskTest {

    /**
     * Производит тестирование задачи с указанными исходными данными.
     * @param segments Множество анализируемых отрезков.
     * @param expected Найденные точки.
     */
    public void test(Set<ISegment> segments, Set<I2DPoint> expected) throws Exception {
        // Prepare
        ITestableTask17 solver = TASK_STORAGE.getSolver(ITestableTask17.class);

        // Run
        Set<I2DPoint> result = solver.analyze(segments);

        // Asserts
        Set<I2DPoint> converted = new HashSet<>(result.size());
        for (I2DPoint point : result) {
            converted.add(new Point2D(point.getX(), point.getY()));
        }
        Assert.assertEquals(expected, converted);
    }

    /**
     * Одна точка пересечения.
     */
    @org.junit.Test (timeout = 2000)
    public void test1() throws Exception {
        Set<ISegment> segments = new HashSet<>(2);
        segments.add(new Segment(new Point2D(0, 0), new Point2D(2, 2)));
        segments.add(new Segment(new Point2D(2, 0), new Point2D(0, 2)));
        test(segments, Collections.<I2DPoint>singleton(new Point2D(1, 1)));
    }

    /**
     * Две точки пересечения с разной абсциссой.
     */
    @org.junit.Test (timeout = 2000)
    public void test2() throws Exception {
        Set<ISegment> segments = new HashSet<>(3);
        segments.add(new Segment(new Point2D(0, 0), new Point2D(0, 2)));
        segments.add(new Segment(new Point2D(2, 0), new Point2D(2, 2)));
        segments.add(new Segment(new Point2D(0, 2), new Point2D(2, 2)));
        test(segments, Collections.<I2DPoint>singleton(new Point2D(0, 2)));
    }

    /**
     * Три точки пересечения, две из них имеют минимальную абсциссу
     */
    @org.junit.Test (timeout = 2000)
    public void test3() throws Exception {
        Set<ISegment> segments = new HashSet<>(3);
        segments.add(new Segment(new Point2D(0, 0), new Point2D(0, 3)));
        segments.add(new Segment(new Point2D(0, 3), new Point2D(3, 0)));
        segments.add(new Segment(new Point2D(0, 0), new Point2D(3, 3)));
        test(segments, new HashSet<I2DPoint>(Arrays.asList(new Point2D(0, 3), new Point2D(0, 0))));
    }

    /**
     * Отрезок на двумерной плоскости.
     */
    private class Segment implements ISegment {

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