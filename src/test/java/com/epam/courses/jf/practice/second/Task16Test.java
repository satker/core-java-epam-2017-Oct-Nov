package com.epam.courses.jf.practice.second;

import org.junit.Assert;
import com.epam.courses.jf.practice.common.second.I2DPoint;
import com.epam.courses.jf.practice.common.second.ITestableTask16;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Проверяет выполнение шестнадцатой задачи.
 *
 * На клетчатой бумаге нарисован круг.
 * Вывести в файл описания всех клеток, целиком лежащих внутри круга.
 * Выводить в порядке возрастания расстояния от клетки до центра круга.
 * Использовать класс PriorityQueue.
 */
public class Task16Test extends AbstractTaskWithResourcesTest {

    /**
     * Производит тестирование задачи с указанными исходными данными.
     * @param center Центр окружности.
     * @param radius Радиус окружности.
     * @param innerPoints Точки, лежащие внутри окружности.
     */
    public void test(I2DPoint center, int radius, Map<I2DPoint, Double> innerPoints) throws Exception{
        try (AbstractTaskWithResourcesTest ignored = this) {
            // Prepare
            ITestableTask16 solver = TASK_STORAGE.getSolver(ITestableTask16.class);
            File file = prepareFile();

            // Run
            ITestableTask16.IFileWithPoints result = solver.analyze(center, radius, file);

            // Asserts
            Assert.assertTrue(result.getFile().exists());
            if (innerPoints.isEmpty()) {
                Assert.assertTrue(result.getFile().length() == 0);
            } else {
                Assert.assertTrue(result.getFile().length() != 0);
            }
            checkEqualMaps(innerPoints, result.getPoints());
        }
    }

    /**
     * Центр в начальных координатах, единичный радиус.
     */
    @org.junit.Test (timeout = 2000)
    public void test1() throws Exception {
        I2DPoint center = new Point2D(0, 0);
        Map<I2DPoint, Double> innerPoints = new HashMap<>();
        innerPoints.put(center, 0d);
        test(center, 1, innerPoints);
    }

    /**
     * Центр в начальных координатах, радиус равен 2.
     */
    @org.junit.Test (timeout = 2000)
    public void test2() throws Exception {
        I2DPoint center = new Point2D(0, 0);
        Map<I2DPoint, Double> innerPoints = new HashMap<>();
        innerPoints.put(center, 0d);
        innerPoints.put(new Point2D(-1, -1), 1.4142d);
        innerPoints.put(new Point2D(0, -1), 1d);
        innerPoints.put(new Point2D(1, -1), 1.4142d);
        innerPoints.put(new Point2D(-1, 0), 1d);
        innerPoints.put(new Point2D(1, 0), 1d);
        innerPoints.put(new Point2D(-1, 1), 1.4142d);
        innerPoints.put(new Point2D(0, 1), 1d);
        innerPoints.put(new Point2D(1, 1), 1.4142d);
        test(center, 2, innerPoints);
    }

    /**
     * Центр в середине клетки, радиус равен 1.
     */
    @org.junit.Test (timeout = 2000)
    public void test3() throws Exception {
        I2DPoint center = new Point2D(0.5, 0.5);
        Map<I2DPoint, Double> innerPoints = new HashMap<>();
        innerPoints.put(new Point2D(1, 0), 0.707106);
        innerPoints.put(new Point2D(1, 1), 0.707106);
        innerPoints.put(new Point2D(0, 1), 0.707106);
        innerPoints.put(new Point2D(0, 0), 0.707106);
        test(center, 1, innerPoints);
    }

    /**
     * Центр в координатах (1, 1), радиус равен 2.
     */
    @org.junit.Test (timeout = 2000)
    public void test4() throws Exception {
        I2DPoint center = new Point2D(1, 1);
        Map<I2DPoint, Double> innerPoints = new HashMap<>();
        innerPoints.put(new Point2D(0, 0), 1.4142d);
        innerPoints.put(new Point2D(1, 0), 1d);
        innerPoints.put(new Point2D(2, 0), 1.4142d);
        innerPoints.put(new Point2D(0, 1), 1d);
        innerPoints.put(center, 0d);
        innerPoints.put(new Point2D(2, 1), 1d);
        innerPoints.put(new Point2D(0, 2), 1.4142d);
        innerPoints.put(new Point2D(1, 2), 1d);
        innerPoints.put(new Point2D(2, 2), 1.4142d);
        test(center, 2, innerPoints);
    }

    /**
     * Проверяет соответствие карт, сравнивая значения их {@link Map.Entry}
     * @param expected Ожидаемое значение.
     * @param actual Полученное значение.
     */
    private void checkEqualMaps(Map<I2DPoint, Double> expected, Map<I2DPoint, Double> actual) {
        if (expected.size() != actual.size()) {
            Assert.fail("Different size maps: " + expected.size() + " " + actual.size());
        }
        for (Map.Entry<I2DPoint, Double> actualEntry : actual.entrySet()) {
            for (Map.Entry<I2DPoint, Double> expectedEntry : expected.entrySet()) {
                if (expectedEntry.getKey().equals(actualEntry.getKey())) {
                    Assert.assertEquals(expectedEntry.getValue(), actualEntry.getValue(), 0.001);
                }
            }
        }
    }
}