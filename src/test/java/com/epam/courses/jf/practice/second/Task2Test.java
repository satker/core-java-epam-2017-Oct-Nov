package com.epam.courses.jf.practice.second;

import org.junit.Assert;
import com.epam.courses.jf.practice.common.second.ITestableTask2;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Проверяет выполнение второй задачи.
 *
 * Сформировать множество элементов, входящих в каталог и его подкаталоги.
 */
public class Task2Test extends AbstractTaskWithResourcesTest {

    /** Директория, в которой располагаются ресурсы, связанные с задачей */
    private static final String RESOURCE_PATH = "com/epam/courses/jf/practice/second/task2";

    /**
     * @param directory Директория.
     * @param path Путь от указанной директории до файла.
     * @return Дескриптор указанного файла. 
     */
    private File getFile(File directory, String path) {
        return new File(directory.getAbsolutePath() + path);
    }

    @Override
    protected File prepareDirectory(String name) {
        return super.prepareDirectory(RESOURCE_PATH + name);
    }

    /**
     * Производит тестирование задачи с указанными исходными данными.
     * @param directory Исходный каталог.
     * @param expected Элементы, входящие в исходный каталог.
     */
    private void test(File directory, Set<File> expected) throws IOException {
        try (AbstractTaskWithResourcesTest ignored = this) {
            // Prepare
            ITestableTask2 solver = TASK_STORAGE.getSolver(ITestableTask2.class);

            // Run
            Set<File> result = solver.getFiles(directory);

            // Asserts
            Assert.assertEquals(expected, result);
        }
    }

    /** Пустая директория. */
    @org.junit.Test (timeout = 2000)
    public void test1() throws Exception {
        test(prepareDirectory(), Collections.<File>emptySet());
    }

    /** Директория с одним файлом. */
    @org.junit.Test (timeout = 2000)
    public void test2() throws Exception {
        File directory = prepareDirectory("/subdirectory/subdirectory");
        Set<File> expected = new HashSet<>(1);
        expected.add(getFile(directory, "/test2.txt"));
        test(directory, expected);
    }

    /** Вложенная директория. */
    @org.junit.Test (timeout = 2000)
    public void test3() throws Exception {
        File directory = prepareDirectory("/subdirectory");
        Set<File> expected = new HashSet<>(3);
        expected.add(getFile(directory, "/test2.txt"));
        expected.add(getFile(directory, "/subdirectory"));
        expected.add(getFile(directory, "/subdirectory/test2.txt"));
        test(directory, expected);
    }

    /** Файлы с одинаковым названием, но разным расширением. */
    @org.junit.Test (timeout = 2000)
    public void test4() throws Exception {
        File directory = prepareDirectory("");
        Set<File> expected = new HashSet<>(5);
        expected.add(getFile(directory, "/test2.txt"));
        expected.add(getFile(directory, "/test2.jpg"));
        expected.add(getFile(directory, "/subdirectory"));
        expected.add(getFile(directory, "/subdirectory/test2.txt"));
        expected.add(getFile(directory, "/subdirectory/subdirectory"));
        expected.add(getFile(directory, "/subdirectory/subdirectory/test2.txt"));
        test(directory, expected);
    }
}
