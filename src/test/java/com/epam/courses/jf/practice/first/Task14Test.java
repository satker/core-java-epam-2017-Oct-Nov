package com.epam.courses.jf.practice.first;

import org.junit.Assert;

import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Проверяет выполнение четырнадцатой задачи.
 *
 * Найти наибольшее число строго возрастающих элементов последовательности, идущих подряд.
 *
 * {@see <a href="https://bitbucket.org/elefus/spring-java-school-epam-2016/wiki/Task%201.14">Задание №14</a>}
 */
public class Task14Test extends AbstractTaskTest {

    /** Шаблон проверки найденного количества */
    private static final Pattern PATTERN_FOUND_NUMBER = Pattern.compile("^\\d+$");

    /**
     * Проверяет совпадение найденного количества с ожидаемым результатом.
     * @param count Ожидаемое количество элементов.
     * @param existing Полученное значение.
     */
    private void checkFoundCount(int count, String existing) {
        if (!PATTERN_FOUND_NUMBER.matcher(existing).matches()) {
            Assert.fail("The result is malformed: " + existing);
        }
        super.assertEquals("Incorrect result!", count, Integer.parseInt(existing));
    }

    /**
     * Производит тестирование задачи с указанными исходными данными.
     * @param length Длина максимальной возрастающий подпоследовательности.
     * @param elements Исходная последовательность.
     */
    private void test(int length, int...elements) throws IOException {
        try (DecoratorIO decoratorIO = new DecoratorIO()) {
            // Prepare
            super.setupStreams(decoratorIO);
            StringBuilder builder = new StringBuilder(elements.length * 3);
            for (int element : elements) {
                builder.append(element).append(" ");
            }
            builder.setLength(builder.length() - 1);
            writeIn.write(String.format("%d%n%s%n", elements.length, builder.toString()).getBytes());

            // Run
            SOLVER.task14();

            // Asserts
            this.checkFoundCount(length, readOut.readLine());
        }
    }

    /**
     * Последовательность, не содержащая возрастающих подпоследовательностей.
     */
    @org.junit.Test (timeout = 2000)
    public void test1() throws Exception {
        this.test(0, 6, 5, 4, 3, 2, 1, 0, -1);
    }

    /**
     * Последовательность, являющаяся полностью возрастающей.
     */
    @org.junit.Test (timeout = 2000)
    public void test2() throws Exception {
        this.test(5, 1, 2, 3, 4, 100500);
    }

    /**
     * Последовательность, состоящая из одного элемента.
     */
    @org.junit.Test (timeout = 2000)
    public void test3() throws Exception {
        this.test(0, -1);
    }

    /**
     * Последовательность, содержащая две возрастающих подпоследовательности одинаковой длины.
     */
    @org.junit.Test (timeout = 2000)
    public void test4() throws Exception {
        this.test(3, 1, 2, 3, 2, 1, 2, 3, 2);
    }

    /**
     * Последовательность, содержащая две возрастающих подпоследовательности разной длины.
     */
    @org.junit.Test (timeout = 2000)
    public void test5() throws Exception {
        this.test(4, 1, 2, 3, 2, 1, 2, 3, 4);
    }

    /**
     * Последовательность, содержащая одинаковые элементы.
     */
    @org.junit.Test (timeout = 2000)
    public void test6() throws Exception {
        this.test(4, 1, 1, 1, 2, 1, 2, 3, 4);
    }

    /**
     * Последовательность, состоящая только из одинаковых элементов.
     */
    @org.junit.Test (timeout = 2000)
    public void test7() throws Exception {
        this.test(0, 1, 1, 1, 1);
    }
}