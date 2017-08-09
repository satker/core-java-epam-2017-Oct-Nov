package com.epam.courses.jf.practice.second;

import org.junit.Assert;
import com.epam.courses.jf.practice.common.second.ITestableTask11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Проверяет выполнение одиннадцатой задачи.
 *
 * В кругу стоят N человек.
 * На каждой итерации цикла выбывает человек (через одного, начиная с первого), пока не останется единственный.
 * Разработать два решения, моделирующие процесс.
 * Первое должно использовать класс ArrayList, а второе – LinkedList.
 */
@SuppressWarnings("unchecked")
public class Task11Test extends AbstractTaskTest {

    /** Количество людей в круге */
    private static final int SIZE = 100000;

    /**
     * Проверяет правильность работы алгоритма для LinkedList.
     */
    @org.junit.Test (timeout = 10000)
    public void test1() throws Exception {
        // Prepare
        ITestableTask11 solver = TASK_STORAGE.getSolver(ITestableTask11.class);
        LinkedList<String> linked = prepareList(LinkedList.class);
        ArrayList<String> array = prepareList(ArrayList.class);

        // Run
        long linkedStartTime = System.currentTimeMillis();
        solver.emulate(linked);
        long linkedTime = System.currentTimeMillis() - linkedStartTime;

        long arrayStartTime = System.currentTimeMillis();
        solver.emulate(array);
        long arrayTime = System.currentTimeMillis() - arrayStartTime;

        // Asserts
        Assert.assertTrue(linkedTime < arrayTime);
    }

    /**
     * Проверяет правильность работы алгоритма для LinkedList.
     */
    @org.junit.Test (timeout = 10000)
    public void test2() throws Exception {
        // Prepare
        ITestableTask11 solver = TASK_STORAGE.getSolver(ITestableTask11.class);
        LinkedList<String> list = prepareList(LinkedList.class);

        // Run
        String result = solver.emulate(list);

        // Asserts
        Assert.assertEquals(list.size(), 1);
        Assert.assertEquals("68927", result);
    }

    /**
     * Проверяет правильность работы алгоритма для ArrayList.
     */
    @org.junit.Test (timeout = 10000)
    public void test3() throws Exception {
        // Prepare
        ITestableTask11 solver = TASK_STORAGE.getSolver(ITestableTask11.class);
        ArrayList<String> list = prepareList(ArrayList.class);

        // Run
        String result = solver.emulate(list);

        // Asserts
        Assert.assertEquals(list.size(), 1);
        Assert.assertEquals("68927", result);
    }

    /**
     * @param clazz Тип создаваемого списка
     * @return Список указанного типа, заполненный начальными значениями.
     */
    private <T extends List<String>> T prepareList(Class<T> clazz) {
        try {
            T list = clazz.getConstructor().newInstance();
            for (int i = 0; i < SIZE; ++i) {
                list.add(String.valueOf(i));
            }
            return list;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}