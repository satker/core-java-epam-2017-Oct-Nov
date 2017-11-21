package com.epam.courses.jf.practice.second;

import org.junit.Assert;
import com.epam.courses.jf.practice.common.second.ITestableTask7;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Проверяет выполнение седьмой задачи.
 *
 * Умножить два многочлена заданной степени, если коэффициенты многочленов хранятся в различных списках.
 * Элемент списка с индексом i соответствует коэффициенту i-й степени.
 */
public class Task7Test extends AbstractTaskTest {

    /**
     * Производит тестирование задачи с указанными исходными данными.
     * @param first Первый многочлен.
     * @param second Второй многочлен.
     * @param expected Результирующий многочлен.
     */
    private void test(List<Integer> first, List<Integer> second, List<Integer> expected) throws IOException {
        // Prepare
        ITestableTask7 solver = TASK_STORAGE.getSolver(ITestableTask7.class);

        // Run
        List<Integer> result = solver.multiplyPolynomials(first, second);

        // Asserts
        if (expected.size() == result.size()) {
            Assert.assertEquals(expected, result);
        } else if (result.size() > expected.size()) {
            for (int i = 0; i < expected.size(); ++i) {
                Assert.assertEquals(expected.get(i), result.get(i));
            }
            for (int i = expected.size(); i < result.size(); ++i) {
                Assert.assertEquals(0, (int)result.get(i));
            }
        } else {
            Assert.fail("Incorrect result!");
        }
    }

    /**
     * Нулевые многочлены.
     */
    @org.junit.Test (timeout = 2000)
    public void test1() throws Exception {
        test(Collections.singletonList(0), Collections.singletonList(0), Collections.singletonList(0));
    }

    /**
     * Нулевой и ненулевой многочлены.
     */
    @org.junit.Test (timeout = 2000)
    public void test2() throws Exception {
        test(Arrays.asList(1, 5), Collections.singletonList(0), Collections.singletonList(0));
    }

    /**
     * Многочлены 1 степени.
     */
    @org.junit.Test (timeout = 2000)
    public void test3() throws Exception {
        test(Arrays.asList(1, 5), Arrays.asList(1, 2), Arrays.asList(1, 7, 10));
    }

    /**
     * Многочлены 1 и 2 степени.
     */
    @org.junit.Test (timeout = 2000)
    public void test4() throws Exception {
        test(Arrays.asList(1, 5), Arrays.asList(1, 2, 3), Arrays.asList(1, 7, 13, 15));
    }

    /**
     * Многочлены 3 степени.
     */
    @org.junit.Test (timeout = 2000)
    public void test5() throws Exception {
        test(Arrays.asList(1, 0, 0, 3), Arrays.asList(1, 0, 3, 2), Arrays.asList(1, 0, 3, 5, 0, 9, 6));
    }
}
