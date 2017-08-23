package com.epam.courses.jf.practice.first;

import org.junit.Assert;

import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Проверяет выполнение второй задачи.
 *
 * Ввести N строк. Упорядочить и вывести строки в порядке возрастания значений их длины.
 * В случае, если длины строк совпадают - упорядочить их в лексикографическом порядке.
 *
 * {@see <a href="https://bitbucket.org/elefus/spring-java-school-epam-2016/wiki/Task%201.2">Задание №2</a>}
 */
public class Task2Test extends AbstractTaskTest {

    /** Шаблон проверки результата */
    private static final Pattern PATTERN_FOUND_STRING = Pattern.compile("^\\(\\d+\\): \".+\"$");

    /**
     * Проверяет совпадение полученной строки с ожидаемым результатом
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
     * @param original Анализируемые строки.
     * @param sorted Отсортированные строки.
     */
    private void test(String[] original, String[] sorted) throws IOException {
        try (DecoratorIO decoratorIO = new DecoratorIO()) {
            // Prepare
            super.setupStreams(decoratorIO);
            writeIn.write(String.valueOf(original.length).concat("\n").getBytes());
            for (String string : original) {
                writeIn.write(string.getBytes());
            }

            // Run
            SOLVER.task2();

            // Asserts
            for (String expected : sorted) {
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
                "_______________________25\n",
                "______________________24\n",
                "________________________26\n",
                "__________________________28\n"
        }, new String[]{
                "(24): \"______________________24\"",
                "(25): \"_______________________25\"",
                "(26): \"________________________26\"",
                "(28): \"__________________________28\""
        });
    }

    /**
     * Передается некоторое количество строк.
     * Некоторые из них равной длины, но разные по содержанию.
     */
    @org.junit.Test (timeout = 2000)
    public void test2() throws Exception {
        this.test(new String[]{
                "_________________________27\n",
                "_____________________23\n",
                "________________________26\n",
                "+++++++++++++++++++++23\n"
        }, new String[]{
                "(23): \"+++++++++++++++++++++23\"",
                "(23): \"_____________________23\"",
                "(26): \"________________________26\"",
                "(27): \"_________________________27\""
        });
    }

    /**
     * Передается некоторое количество строк.
     * Некоторые из них полностью совпадают.
     */
    @org.junit.Test (timeout = 2000)
    public void test3() throws Exception {
        this.test(new String[]{
                "_________________________27\n",
                "_____________________23\n",
                "_________________________27\n",
                "_____________________23\n"
        }, new String[]{
                "(23): \"_____________________23\"",
                "(23): \"_____________________23\"",
                "(27): \"_________________________27\"",
                "(27): \"_________________________27\""
        });
    }

    /**
     * Передается одна строка.
     */
    @org.junit.Test (timeout = 2000)
    public void test4() throws Exception {
        this.test(new String[]{
                "_________________________27\n"
        }, new String[]{
                "(27): \"_________________________27\""
        });
    }

    /**
     * Проверяется лексикографический порядок строк.
     */
    @org.junit.Test (timeout = 2000)
    public void test5() throws Exception {
        this.test(new String[]{
                "_________________________27\n",
                "_____________________23\n",
                "________________________26\n",
                "+++++++++++++++++++++++25\n"
        }, new String[]{
                "(23): \"_____________________23\"",
                "(25): \"+++++++++++++++++++++++25\"",
                "(26): \"________________________26\"",
                "(27): \"_________________________27\""
        });
    }
}