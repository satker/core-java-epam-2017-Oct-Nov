package com.epam.courses.jf.practice.akunats.second;

import com.epam.courses.jf.practice.common.second.ITestableTask15;
import org.junit.Assert;
import com.epam.courses.jf.practice.common.second.I2DPoint;
import com.epam.courses.jf.practice.akunats.second.AbstractTaskWithResourcesTest;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static com.epam.courses.jf.practice.common.second.ITestableTask15.ILine;

/**
 * Проверяет выполнение пятнадцатой задачи.
 *
 * На плоскости задано N точек.
 * Вывести в файл описания всех прямых, которые проходят более чем через 2 точки из заданных.
 */
public class Task15Test extends AbstractTaskWithResourcesTest{

    /**
     * Производит тестирование задачи с указанными исходными данными.
     * @param points Анализируемые точки на плоскости.
     * @param lines Множество обнаруженных линий.
     */
    public void test(Set<I2DPoint> points, Set<ILine> lines) throws Exception{
        try (AbstractTaskWithResourcesTest ignored = this) {
            // Prepare
            ITestableTask15 solver = new Task15();
            File file = prepareFile();

            // Run
            ITestableTask15.IFileWithLines result = solver.analyze(points, file);

            // Asserts
            Assert.assertTrue(result.getFile().exists());
            linesCycle: for (ILine expectedLine : lines) {
                for (ILine actualLine : result.getLines()) {
                    if (expectedLine.getPoints().size() != actualLine.getPoints().size()) {
                        continue linesCycle;
                    }
                    pointsCycle: for (I2DPoint expectedPoint : expectedLine.getPoints()) {
                        for (I2DPoint actualPoint : actualLine.getPoints()) {
                            if (expectedPoint.equals(actualPoint)) {
                                continue pointsCycle;
                            }
                        }
                        continue linesCycle;
                    }
                    continue linesCycle;
                }
                Assert.fail("Expected line not found!");
            }
        }
    }

    /**
     * Пустое множество точек.
     */
    @org.junit.Test ()
    public void test1() throws Exception {
        test(Collections.<I2DPoint>emptySet(), Collections.<ILine>emptySet());
    }

    /**
     * Прямая, содержащая 2 точки.
     */
    @org.junit.Test ()
    public void test2() throws Exception {
        Set<I2DPoint> points = new HashSet<>(Arrays.<I2DPoint>asList(new Point(1, 1), new Point(1, 2)));
        test(points, Collections.<ILine>emptySet());
    }

    /**
     * Две пересекающихся прямых по 2 точки.
     */
    @org.junit.Test ()
    public void test3() throws Exception {
        Set<I2DPoint> points = new HashSet<>(Arrays.<I2DPoint>asList(
                new Point(1, 1),
                new Point(1, 2),
                new Point(3, 1)));
        test(points, Collections.<ILine>emptySet());
    }

    /**
     * Горизонтальная линия, содержащая 3 точки.
     */
    @org.junit.Test ()
    public void test4() throws Exception {
        Set<I2DPoint> points = new HashSet<>(Arrays.<I2DPoint>asList(
                new Point(1, 1),
                new Point(1, 2),
                new Point(1, 3)));
        Set<ILine> lines = new HashSet<>(Collections.<ILine>singletonList(new Line(points)));
        test(points, lines);
    }

    /**
     * Диагональная линия, содержащая 4 точки.
     */
    @org.junit.Test ()
    public void test5() throws Exception {
        Set<I2DPoint> points = new HashSet<>(Arrays.<I2DPoint>asList(
                new Point(1, 1),
                new Point(2, 2),
                new Point(3, 3),
                new Point(3, 3)));
        Set<ILine> lines = new HashSet<>(Collections.<ILine>singletonList(new Line(points)));
        test(points, lines);
    }

    /**
     * Две пересекающиеся диагональные линии, содержащие по 5 точек.
     */
    @org.junit.Test ()
    public void test6() throws Exception {
        Line first = new Line(new HashSet<>(Arrays.<I2DPoint>asList(
                new Point(1, 1),
                new Point(2, 2),
                new Point(3, 3),
                new Point(4, 4),
                new Point(5, 5)
        )));
        Line second = new Line(new HashSet<>(Arrays.<I2DPoint>asList(
                new Point(0, 4),
                new Point(1, 3),
                new Point(2, 2),
                new Point(3, 1),
                new Point(4, 0)
        )));
        Set<I2DPoint> points = new HashSet<>(first.getPoints());
        points.addAll(second.getPoints());
        test(points, new HashSet<ILine>(Arrays.asList(first, second)));
    }

    /** Линия на плоскости. */
    private class Line implements ILine {

        /** Точки из исходного множества, лежащие на линии. */
        private final Set<I2DPoint> POINTS;

        private Line(Set<I2DPoint> points) {
            POINTS = points;
        }

        @Override
        public Set<I2DPoint> getPoints() {
            return POINTS;
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other == null || !(other instanceof ILine)) {
                return false;
            }
            ILine line = (ILine) other;
            return !(POINTS != null ? !POINTS.equals(line.getPoints()) : line.getPoints() != null);

        }

        @Override
        public int hashCode() {
            return POINTS != null ? POINTS.hashCode() : 0;
        }
    }
}
