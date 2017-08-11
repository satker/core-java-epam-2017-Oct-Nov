package com.epam.courses.jf.practice.second;

import org.junit.Assert;
import com.epam.courses.jf.practice.common.second.ITestableTask10;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * Проверяет выполнение десятой задачи.
 *
 * Задан файл, содержащий английские слова (без знаков препинания).
 * Требуется выделить все различные слова и посчитать частоту их встречаемости.
 * Слова, отличающиеся регистром букв, считать различными.
 * Использовать класс HashMap.
 */
public class Task10Test extends AbstractTaskWithResourcesTest {

    /**
     * Производит тестирование задачи с указанными исходными данными.
     * @param input Файл с исходными данными.
     * @param expected Ожидаемый результат.
     */
    private void test(File input, HashMap<String, Integer> expected) throws IOException {
        // Prepare
        ITestableTask10 solver = TASK_STORAGE.getSolver(ITestableTask10.class);

        // Run
        HashMap<String, Integer> result = solver.countNumberWords(input);

        // Asserts
        Assert.assertEquals(expected, result);
    }

    /**
     * Пустой файл.
     */
    @org.junit.Test (timeout = 2000)
    public void test1() throws Exception {
        test(prepareFile(), new HashMap<String, Integer>());
    }

    /**
     * Различные слова в нижнем и верхнем регистре.
     */
    @org.junit.Test (timeout = 2000)
    public void test2() throws Exception {
        HashMap<String, Integer> expected = new HashMap<>(6);
        expected.put("qwerty", 1);
        expected.put("test", 1);
        expected.put("words", 1);
        expected.put("Words", 1);
        expected.put("Test", 2);
        expected.put("Qwerty", 3);
        test(prepareFile(getResource("com/epam/courses/jf/practice/second/task9_10/text.txt")), expected);
    }
}
