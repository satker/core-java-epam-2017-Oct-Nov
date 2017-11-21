package com.epam.courses.jf.practice.second;

import org.junit.Assert;
import com.epam.courses.jf.practice.common.second.ITestableTask12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Проверяет выполнение двенадцатой задачи.
 *
 * Задан список целых чисел и число X.
 * Не используя вспомогательных объектов и не изменяя размера списка,
 *    переставить элементы списка так, чтобы сначала шли числа, не превосходящие X, а затем числа, большие X.
 */
public class Task12Test extends AbstractTaskTest {

    /**
     * Производит тестирование задачи с указанными исходными данными.
     * @param list Список, подвергающийся трансформации.
     * @param delimiter Значение, по которому производится разделение.
     */
    public void test(List<Integer> list, int delimiter) throws Exception {
        // Prepare
        ITestableTask12 solver = TASK_STORAGE.getSolver(ITestableTask12.class);

        // Run
        List<Integer> result = solver.transform(list, delimiter);

        // Asserts
        Relation relation = Relation.LESS;
        for (Integer value : result) {
            relation = relation.next(delimiter, value);
            if (relation == null) {
                Assert.fail("Wrong sequence");
            }
        }
    }

    /**
     * Возможные отношения между граничным и указанным значениями.
     */
    private enum Relation {
        LESS {
            @Override
            public Relation next(int delimiter, int value) {
                return value < delimiter ? LESS : EQUALS.next(delimiter, value);
            }
        },
        EQUALS {
            @Override
            public Relation next(int delimiter, int value) {
                return value == delimiter ? EQUALS : GREATER.next(delimiter, value);
            }
        },
        GREATER {
            @Override
            public Relation next(int delimiter, int value) {
                return value > delimiter ? GREATER : null;
            }
        };

        public abstract Relation next(int delimiter, int value);
    }

    /**
     * Пустой список.
     */
    @org.junit.Test (timeout = 2000)
    public void test1() throws Exception {
        test(new ArrayList<Integer>(), 10);
    }

    /**
     * Список, не содержащий одинаковых элементов и не содержащий значения, по которому производится разделение.
     */
    @org.junit.Test (timeout = 2000)
    public void test2() throws Exception {
        final int delimiter = 6;
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 4, 2, 7, 5));
        test(list, delimiter);
    }

    /**
     * Список, содержащий одинаковые элементы но не содержащий значения, по которому производится разделение.
     */
    @org.junit.Test (timeout = 2000)
    public void test3() throws Exception {
        final int delimiter = 6;
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 1, 4, 4, 2, 7, 5, 2));
        test(list, delimiter);
    }

    /**
     * Список, содержащий одинаковые элементы и значение, по которому производится разделение.
     */
    @org.junit.Test (timeout = 2000)
    public void test4() throws Exception {
        final int delimiter = 4;
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 1, 4, 2, 7, 5, 2));
        test(list, delimiter);
    }
}