package com.epam.courses.jf.practice.second;

import org.junit.Assert;
import com.epam.courses.jf.practice.common.second.ITestableTask9;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;

/**
 * Проверяет выполнение девятой задачи.
 *
 * Задан файл, содержащий английские слова (без знаков препинания).
 * Требуется выделить все различные слова.
 * Слова, отличающиеся только регистром букв, считать одинаковыми.
 * Использовать класс HashSet.
 */
public class Task9Test extends AbstractTaskWithResourcesTest {

    /**
     * Производит тестирование задачи с указанными исходными данными.
     * @param input Файл с исходными данными.
     * @param expected Ожидаемый результат.
     */
    private void test(File input, HashSet<String> expected) throws IOException {
        // Prepare
        ITestableTask9 solver = TASK_STORAGE.getSolver(ITestableTask9.class);

        // Run
        HashSet<String> result = solver.getUniqueWords(input);

        nextWord: for (String expectedWord : expected) {
            for (String foundWord : result) {
                if (expectedWord.equalsIgnoreCase(foundWord)) {
                    continue nextWord;
                }
            }
            Assert.fail("Wasn't found expected word: " + expectedWord);
        }
    }

    /**
     * Пустой файл.
     */
    @org.junit.Test (timeout = 2000)
    public void test1() throws Exception {
        test(prepareFile(), new HashSet<String>());
    }

    /**
     * Различные слова в нижнем и верхнем регистре.
     */
    @org.junit.Test (timeout = 2000)
    public void test2() throws Exception {
        HashSet<String> expected = new HashSet<>(3);
        expected.add("qwerty");
        expected.add("test");
        expected.add("words");
        test(prepareFile(getResource("com/epam/courses/jf/practice/second/task9_10/text.txt")), expected);
    }
}
