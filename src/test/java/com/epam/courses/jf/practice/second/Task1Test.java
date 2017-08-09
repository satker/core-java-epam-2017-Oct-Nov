package com.epam.courses.jf.practice.second;

import org.junit.Assert;
import com.epam.courses.jf.practice.common.second.ITestableTask1;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Проверяет выполнение первой задачи.
 *
 * Ввести строки из файла, записать в список.
 * Вывести строки в файл в обратном порядке.
 */
public class Task1Test extends AbstractTaskWithResourcesTest {

    /**
     * Производит тестирование задачи с указанными исходными данными.
     * @param input Файл с входными данными.
     * @param expected Строки, содержащиеся в исходном файле.
     */
    private void test(File input, List<String> expected) throws IOException {
        try (AbstractTaskWithResourcesTest ignored = this) {
            // Prepare
            ITestableTask1 solver = TASK_STORAGE.getSolver(ITestableTask1.class);
            File output = prepareFile();

            // Run
            List<String> result = solver.reverseFile(input, output);

            // Asserts
            Assert.assertEquals(expected, result);
            Collections.reverse(expected);
            Assert.assertEquals(expected, Files.readAllLines(output.toPath(), Charset.defaultCharset()));
        }
    }

    /** Естественный сценарий. */
    @org.junit.Test (timeout = 2000)
    public void test1() throws Exception {
        List<String> expected = Arrays.asList("a", "b", "c", "d", "e", "f", "g");
        test(prepareFile(getResource("ru/spb/epam/second/task1/test1.txt")), expected);
    }

    /** Пустой файл. */
    @org.junit.Test (timeout = 2000)
    public void test2() throws Exception {
        test(prepareFile(), Collections.<String>emptyList());
    }
}
