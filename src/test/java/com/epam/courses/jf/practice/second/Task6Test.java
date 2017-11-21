package com.epam.courses.jf.practice.second;

import org.junit.Assert;
import com.epam.courses.jf.practice.common.second.ITestableTask6;

import java.io.IOException;
import java.util.HashMap;

/**
 * Проверяет выполнение шестой задачи.
 *
 * Сложить два многочлена, если коэффициенты многочленов хранятся в объекте HashMap.
 * Степень элемента многочлена – ключ, коэффициент элемента многочлена – значение.
 * Коэффициенты многочления, ключи для которых отсутствуют в карте, равны нулю.
 */
public class Task6Test extends AbstractTaskTest {

    /**
     * Производит тестирование задачи с указанными исходными данными.
     * @param first Первый многочлен.
     * @param second Второй многочлен.
     * @param expected Результирующий многочлен.
     */
    private void test(HashMap<Integer, Integer> first, HashMap<Integer, Integer> second, HashMap<Integer, Integer> expected) throws IOException {
        // Prepare
        ITestableTask6 solver = TASK_STORAGE.getSolver(ITestableTask6.class);

        // Run
        HashMap<Integer, Integer> result = solver.addPolynomials(first, second);

        // Asserts
        Assert.assertEquals(expected, result);
    }

    /**
     * Нулевые многочлены.
     */
    @org.junit.Test (timeout = 2000)
    public void test1() throws Exception {
        test(new HashMap<Integer, Integer>(), new HashMap<Integer, Integer>(), new HashMap<Integer, Integer>());
    }

    /**
     * Нулевой и ненулевой многочлены.
     */
    @org.junit.Test (timeout = 2000)
    public void test2() throws Exception {
        HashMap<Integer, Integer> first = new HashMap<>();
        first.put(0, 5);
        first.put(2, 5);
        test(first, new HashMap<Integer, Integer>(), first);
    }

    /**
     * Многочлены с непересекающимися коэффициентами.
     */
    @org.junit.Test (timeout = 2000)
    public void test3() throws Exception {
        HashMap<Integer, Integer> first = new HashMap<>();
        first.put(0, 5);
        first.put(2, 5);
        HashMap<Integer, Integer> second = new HashMap<>();
        second.put(1, 10);
        second.put(3, 10);
        HashMap<Integer, Integer> result = new HashMap<>();
        result.put(0, 5);
        result.put(1, 10);
        result.put(2, 5);
        result.put(3, 10);
        test(first, second, result);
    }

    /**
     * Многочлены с пересекающимися коэффициентами.
     */
    @org.junit.Test (timeout = 2000)
    public void test4() throws Exception {
        HashMap<Integer, Integer> first = new HashMap<>();
        first.put(0, 5);
        first.put(1, 5);
        HashMap<Integer, Integer> second = new HashMap<>();
        second.put(1, 10);
        second.put(2, 10);
        HashMap<Integer, Integer> result = new HashMap<>();
        result.put(0, 5);
        result.put(1, 15);
        result.put(2, 10);
        test(first, second, result);
    }
}
