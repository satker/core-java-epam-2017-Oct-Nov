package com.epam.courses.jf.practice.first;

import org.junit.Assert;

import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Проверяет выполнение седьмой задачи.
 *
 * Ввести N слов. Найти слова, состоящие только из различных символов.
 *
 * {@see <a href="https://bitbucket.org/elefus/spring-java-school-epam-2016/wiki/Task%201.7">Задание №7</a>}
 */
public class Task7Test extends AbstractTaskTest {

    /** Значение, соответствующее отсутствию среди переданных слов слова, состоящего из различных символов. */
    private static final String NOT_FOUND = "NOT FOUND";

    /** Шаблон проверки найденного слова. */
    private static final Pattern PATTERN_FOUND_WORD = Pattern.compile("^([\\w']+ *)+|(NOT FOUND)$");

    /**
     * Проверяет совпадение найденного слова с ожидаемым результатом.
     * @param expected Ожидаемое значение.
     * @param existing Полученное значение.
     */
    private void checkFoundWord(String expected, String existing) {
        if (!PATTERN_FOUND_WORD.matcher(existing).matches()) {
            Assert.fail("The result is malformed: " + existing);
        }
        super.assertEquals("Incorrect result!", expected, existing);
    }

    /**
     * Производит тестирование задачи с указанными исходными данными.
     * @param words Анализируемые слова.
     * @param expectedWord Слова, состоящее из различных символов.
     *                     {@link Task26Test#NOT_FOUND} - если такие слова отсутствуют.
     */
    private void test(String[] words, String expectedWord) throws IOException {
        try (DecoratorIO decoratorIO = new DecoratorIO()) {
            // Prepare
            super.setupStreams(decoratorIO);
            StringBuilder builder = new StringBuilder(words.length * 10);
            for (int i = 0; i < words.length - 1; ++i) {
                builder.append(words[i]).append(" ");
            }
            builder.append(words[words.length - 1]).append("\n");
            writeIn.write(String.valueOf(words.length).concat("\n").getBytes());
            writeIn.write(builder.toString().getBytes());

            // Run
            SOLVER.task7();

            // Asserts
            this.checkFoundWord(expectedWord, readOut.readLine());
        }
    }

    /**
     * Одно слово, удовлетворяющее условию.
     */
    @org.junit.Test (timeout = 2000)
    public void test1() throws Exception {
        this.test(new String[]{"abc"}, "abc");
    }

    /**
     * Два слова, удовлетворяюющие условию.
     */
    @org.junit.Test (timeout = 2000)
    public void test2() throws Exception {
        this.test(new String[]{"abc", "abc"}, "abc");
    }

    /**
     * Слово из одного символа и одно слово, не удовлетворяющее условиям.
     */
    @org.junit.Test (timeout = 2000)
    public void test3() throws Exception {
        this.test(new String[]{"a", "cc"}, "a");
    }

    /**
     * Слово, содержащее специальные символы.
     */
    @org.junit.Test (timeout = 2000)
    public void test4() throws Exception {
        this.test(new String[]{"ab123_'c"}, "ab123_'c");
    }

    /**
     * Слова, удовлетворяющие условию отсутствуют.
     */
    @org.junit.Test (timeout = 2000)
    public void test5() throws Exception {
        this.test(new String[]{"aa", "cc"}, NOT_FOUND);
    }
}