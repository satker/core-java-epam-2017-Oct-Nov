package com.epam.courses.jf.practice.first;

import org.junit.Assert;

import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Проверяет выполнение первой задачи.
 *
 * Ввести N строк, найти самую короткую и самую длинную строки. Вывести найденные строки и их длину.
 * Если строк, удовлетворяющих условию, более одной - вывести последнюю из них.
 *
 * {@see <a href="https://bitbucket.org/elefus/spring-java-school-epam-2016/wiki/Task%201.1">Задание №1</a>}
 */
public class Task1Test extends AbstractTaskTest {

    /** Шаблон проверки результата, содержащего минимальную строку */
    private static final Pattern PATTERN_MIN = Pattern.compile("^MIN \\(\\d+\\): \".+\"$");

    /** Шаблон проверки результата, содержащего максимальную строку */
    private static final Pattern PATTERN_MAX = Pattern.compile("^MAX \\(\\d+\\): \".+\"$");

    /**
     * Проверяет совпадение полученной минимальной строки с ожидаемым результатом
     * @param expected Ожидаемое значение
     * @param existing Полученное значение
     */
    private void checkFoundMin(String expected, String existing) {
        if (!PATTERN_MIN.matcher(existing).matches()) {
            Assert.fail("The result is malformed (MIN): " + existing);
        }
        super.assertEquals("Incorrect result (MIN)!", expected, existing);
    }

    /**
     * Проверяет совпадение полученной максимальной строки с ожидаемым результатом
     * @param expected Ожидаемое значение
     * @param existing Полученное значение
     */
    private void checkFoundMax(String expected, String existing) {
        if (!PATTERN_MAX.matcher(existing).matches()) {
            Assert.fail("The result is malformed (MAX): " + existing);
        }
        super.assertEquals("Incorrect result (MAX)!", expected, existing);
    }

    /**
     * Производит тестирование задачи с указанными исходными данными.
     * @param strings Анализируемые строки.
     * @param lowest Наименьшая строка.
     * @param highest Наибольшая строка.
     */
    private void test(String[] strings, String lowest, String highest) throws IOException {
        try (DecoratorIO decoratorIO = new DecoratorIO()) {
            // Prepare
            super.setupStreams(decoratorIO);
            writeIn.write(String.valueOf(strings.length).concat("\n").getBytes());
            for (String string : strings) {
                writeIn.write(string.getBytes());
            }

            // Run
            SOLVER.task1();

            // Asserts
            this.checkFoundMin(lowest, readOut.readLine());
            this.checkFoundMax(highest, readOut.readLine());
        }
    }

    /**
     * Передается некоторое количество строк различной длины.
     * Одна из них самая длинная, другая - самая короткая.
     */
    @org.junit.Test
    public void test1() throws Exception {
        this.test(new String[]{
                "_______________________25\n",
                "______________________24\n",
                "________________________26\n",
                "__________________________28\n"
            },
            "MIN (24): \"______________________24\"",
            "MAX (28): \"__________________________28\""
        );
}

    /**
     * Передается некоторое количество строк различной длины.
     * Две из них являются самыми короткими, две - самыми длинными.
     */
    @org.junit.Test
    public void test2() throws Exception {
        this.test(new String[]{
                        "++++++++++++++++++++++24\n",
                        "++++++++++++++++++++22\n",
                        "______________________24\n",
                        "____________________22\n"
                },
                "MIN (22): \"____________________22\"",
                "MAX (24): \"______________________24\""
        );
    }

    /**
     * Передается несколько строк одинаковой длины.
     */
    @org.junit.Test
    public void test3() throws Exception {
        this.test(new String[]{
                        "++++++++++++++++++++22\n",
                        "____________________22\n"
                },
                "MIN (22): \"____________________22\"",
                "MAX (22): \"____________________22\""
        );
    }

    /**
     * Передается одна строка.
     */
    @org.junit.Test
    public void test4() throws Exception {
        this.test(new String[]{
                        "____________________22\n"
                },
                "MIN (22): \"____________________22\"",
                "MAX (22): \"____________________22\""
        );
    }
}