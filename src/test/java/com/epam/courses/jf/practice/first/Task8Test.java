package com.epam.courses.jf.practice.first;

import org.junit.Assert;

import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Проверяет выполнение восьмой задачи.
 *
 * Ввести N слов. Помимо обычных слов, во входной последовательности могут встречаться целые числа.
 * Среди них необходимо найти число-палиндром (одинаково читающееся в обоих направлениях).
 * Если таких чисел больше одного, найти второе из них.
 *
 * {@see <a href="https://bitbucket.org/elefus/spring-java-school-epam-2016/wiki/Task%201.8">Задание №8</a>}
 */
public class Task8Test extends AbstractTaskTest {

    /** Значение, соответствующее отсутствию среди переданных слов палиндрома. */
    private static final String NOT_FOUND = "NOT FOUND";

    /** Шаблон проверки найденного количества. */
    private static final Pattern PATTERN_FOUND_NUMBER = Pattern.compile("^\\d+|(" + NOT_FOUND + ")$");

    /**
     * Проверяет совпадение найденного количества с ожидаемым результатом.
     * @param expected Ожидаемое значение.
     * @param existing Полученное значение.
     */
    private void checkFoundPalindrome(String expected, String existing) {
        if (!PATTERN_FOUND_NUMBER.matcher(existing).matches()) {
            Assert.fail("The result is malformed: " + existing);
        }
        super.assertEquals("Incorrect result!", expected, existing);
    }

    /**
     * Производит тестирование задачи с указанными исходными данными.
     * @param words Анализируемые слова.
     * @param palindrome Найденный палиндром.
     *                   {@link Task26Test#NOT_FOUND} - если палиндром не найден.
     */
    private void test(String[] words, String palindrome) throws IOException {
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
            SOLVER.task8();

            // Asserts
            this.checkFoundPalindrome(palindrome, readOut.readLine());
        }
    }

    /**
     * Одно число-палиндром.
     */
    @org.junit.Test
    public void test1() throws Exception {
        this.test(new String[]{"121"}, "121");
    }

    /**
     * Два числа-палиндрома.
     */
    @org.junit.Test
    public void test2() throws Exception {
        this.test(new String[]{"121", "222"}, "222");
    }

    /**
     * Число-палиндром и слово-палиндром.
     */
    @org.junit.Test
    public void test3() throws Exception {
        this.test(new String[]{"121", "aba"}, "121");
    }

    /**
     * Только слова-палиндромы.
     */
    @org.junit.Test
    public void test4() throws Exception {
        this.test(new String[]{"cdc", "aba", "www"}, NOT_FOUND);
    }

    /**
     * Длинное число-палиндром (больше long).
     */
    @org.junit.Test
    public void test5() throws Exception {
        this.test(new String[]{"121", "1234567890987654321"}, "1234567890987654321");
    }
}