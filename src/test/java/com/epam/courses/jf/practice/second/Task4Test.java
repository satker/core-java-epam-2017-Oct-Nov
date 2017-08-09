package com.epam.courses.jf.practice.second;

import org.junit.Assert;
import com.epam.courses.jf.practice.common.second.ITestableTask4;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Проверяет выполнение четвертой задачи.
 *
 * Определить множество на основе множества целых чисел.
 * Создать методы для определения пересечения и объединения множеств.
 * Запрещена модификация исходных множеств.
 */
public class Task4Test extends AbstractTaskTest {

    /** Пустое множество целых чисел. */
    private static final Set<Integer> EMPTY_SET = Collections.emptySet();

    /**
     * Производит тестирование задачи с указанными исходными данными.
     * @param first Первое множество.
     * @param second Второе множество.
     * @param intersection Пересечение множеств.
     * @param union Объединение множеств.
     */
    private void test(Set<Integer> first, Set<Integer> second, Set<Integer> intersection, Set<Integer> union) throws IOException {
        // Prepare
        ITestableTask4 solver = TASK_STORAGE.getSolver(ITestableTask4.class);

        // Run
        Set<Integer> resultIntersection = solver.intersection(first, second);
        Set<Integer> resultUnion = solver.union(first, second);

        // Asserts
        Assert.assertEquals(intersection, resultIntersection);
        Assert.assertEquals(union, resultUnion);
    }

    /**
     * Пустые множества.
     */
    @org.junit.Test (timeout = 2000)
    public void test1() throws Exception {
        test(EMPTY_SET, EMPTY_SET, EMPTY_SET, EMPTY_SET);
    }

    /**
     * Пустое и непустое множество.
     */
    @org.junit.Test (timeout = 2000)
    public void test2() throws Exception {
        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3));
        test(EMPTY_SET, set, EMPTY_SET, set);
    }

    /**
     * Два непустых множества, без одинаковых элементов.
     */
    @org.junit.Test (timeout = 2000)
    public void test3() throws Exception {
        Set<Integer> first = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> second = new HashSet<>(Arrays.asList(4, 5, 6));
        test(first, second, EMPTY_SET, new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    /**
     * Два непустых пеоесекающихся множества.
     */
    @org.junit.Test (timeout = 2000)
    public void test4() throws Exception {
        Set<Integer> first = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> second = new HashSet<>(Arrays.asList(3, 4, 5));
        test(first, second, Collections.singleton(3), new HashSet<>(Arrays.asList(1, 2, 3, 4, 5)));
    }

    /**
     * Два одинаковых множества.
     */
    @org.junit.Test (timeout = 2000)
    public void test5() throws Exception {
        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3));
        test(set, set, set, set);
    }
}
