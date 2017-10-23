package com.epam.courses.jf.practice.first;

import org.junit.Assert;

import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Проверяет выполнение третьей задачи.
 *
 * Ввести N строк. Вывести те строки, длина которых меньше средней.
 * Под 'средней' подразумевается среднеарифметическая величина длины всех строк, округленная до целого в меньшую сторону.
 *
 * {@see <a href="https://bitbucket.org/elefus/spring-java-school-epam-2016/wiki/Task%201.3">Задание №3</a>}
 */
public class Task3Test extends AbstractTaskTest {

    /** Шаблон проверки средней длины */
    private static final Pattern PATTERN_AVERAGE = Pattern.compile("^AVERAGE\\s*\\(\\d+\\)$");

    /** Шаблон проверки найденной строки */
    private static final Pattern PATTERN_FOUND_STRING = Pattern.compile("^\\(\\d+\\):\\s*\".+\"$");

    /**
     * Проверяет совпадение полученной средней длины с ожидаемым результатом
     * @param expected Ожидаемое значение
     * @param existing Полученное значение
     */
    private void checkFoundAverage(String expected, String existing) {
        if (!PATTERN_AVERAGE.matcher(existing).matches()) {
            Assert.fail("The result is malformed (AVERAGE): " + existing);
        }
        super.assertEquals("Incorrect result (AVERAGE)!", expected, existing);
    }

    /**
     * Проверяет совпадение найденной строки с ожидаемым результатом
     * @param expected Ожидаемое значение
     * @param existing Полученное значение
     */
    private void checkFoundString(String expected, String existing) {
        if (!PATTERN_FOUND_STRING.matcher(existing).matches()) {
            Assert.fail("The result is malformed: " + existing);
        }
        super.assertEquals("Incorrect result!", expected, existing);
    }

    /**
     * Производит тестирование задачи с указанными исходными данными.
     * @param strings Анализируемые строки.
     * @param average Ожидаемое среднее значение.
     * @param expectedStrings Строки, удовлетворяющие условию.
     */
    private void test(String[] strings, int average, String[] expectedStrings) throws IOException {
        try (DecoratorIO decoratorIO = new DecoratorIO()) {
            // Prepare
            super.setupStreams(decoratorIO);
            writeIn.write(String.valueOf(strings.length).concat("\n").getBytes());
            for (String string : strings) {
                writeIn.write(string.getBytes());
            }

            // Run
            SOLVER.task3();

            // Asserts
            this.checkFoundAverage("AVERAGE (" + average + ")", readOut.readLine());
            for (String expected : expectedStrings) {
                this.checkFoundString(expected, readOut.readLine());
            }
        }
    }

    /**
     * Передается некоторое количество строк различной длины.
     */
    @org.junit.Test (timeout = 2000)
    public void test1() throws Exception {
        this.test(new String[]{
                "_______8\n",
                "________10\n",
                "__________12\n",
                "____________14\n"
        }, 11, new String[]{
                "(8): \"_______8\"",
                "(10): \"________10\""
        });
    }

    /**
     * Передаются три строки.
     * При округлении среднего отбрасывается средняя по длине строка (т.к. в условии сказано о строгом неравенстве).
     */
    @org.junit.Test (timeout = 2000)
    public void test2() throws Exception {
        this.test(new String[]{
                "_______8\n",
                "________9\n",
                "________10\n"
        }, 9, new String[]{
                "(8): \"_______8\""
        });
    }

    /**
     * Передаются четыре строки.
     * При округлении среднего отбрасывается строка длины 9 (т.к. среднее равно 9.25).
     */
    @org.junit.Test (timeout = 2000)
    public void test3() throws Exception {
        this.test(new String[]{
                "_______8\n",
                "________9\n",
                "________10\n",
                "________10\n"
        }, 9, new String[]{
                "(8): \"_______8\""
        });
    }

    /**
     * Передаются четыре строки.
     * Проверяется округление среднего в меньшую сторону до 9 (среднее равно 9.75).
     */
    @org.junit.Test (timeout = 2000)
    public void test4() throws Exception {
        this.test(new String[]{
                "_______8\n",
                "________9\n",
                "________10\n",
                "__________12\n"
        }, 9, new String[]{
                "(8): \"_______8\""
        });
    }
}