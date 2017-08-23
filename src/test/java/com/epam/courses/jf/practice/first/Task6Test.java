package com.epam.courses.jf.practice.first;

import org.junit.Assert;

import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Проверяет выполнение шестой задачи.
 *
 * Ввести N слов. Найти слово, символы в котором идут в строгом порядке возрастания их кодов.
 * Если таких слов несколько, найти первое из них.
 *
 * {@see <a href="https://bitbucket.org/elefus/spring-java-school-epam-2016/wiki/Task%201.6">Задание №6</a>}
 */
public class Task6Test extends AbstractTaskTest {

    /** Значение, соответствующее отсутствию среди переданных слов слова, удовлетворяющего условию. */
    private static final String NOT_FOUND = "NOT FOUND";

    /** Шаблон проверки найденного слова */
    private static final Pattern PATTERN_FOUND_WORD = Pattern.compile("^\\w+|(NOT FOUND)$");

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
     * @param expectedWord Слова, в котором символы строго возрастают.
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
            SOLVER.task6();

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
     * Слово из одного символа и одно слово, удовлетворяющее условию.
     */
    @org.junit.Test (timeout = 2000)
    public void test2() throws Exception {
        this.test(new String[]{"a", "abc"}, "abc");
    }

    /**
     * Слово из одного символа и одно слово, не удовлетворяющее условию.
     */
    @org.junit.Test (timeout = 2000)
    public void test3() throws Exception {
        this.test(new String[]{"a", "cbc"}, NOT_FOUND);
    }

    /**
     * Три слова, удовлетворяющие условию.
     */
    @org.junit.Test (timeout = 2000)
    public void test4() throws Exception {
        this.test(new String[]{"ab", "cd", "fg"}, "ab");
    }

    /**
     * Проверка слова, содержащего одинаковые символы.
     */
    @org.junit.Test (timeout = 2000)
    public void test5() throws Exception {
        this.test(new String[]{"aa", "ab"}, "ab");
    }
}