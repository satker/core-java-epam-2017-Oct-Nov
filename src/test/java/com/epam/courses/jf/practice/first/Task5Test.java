package com.epam.courses.jf.practice.first;

import org.junit.Assert;

import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Проверяет выполнение пятой задачи.
 *
 * Ввести N слов. Найти количество слов, содержащих только символы латинского алфавита.
 * Вывести количество слов среди найденных, с равным числом гласных и согласных букв.
 *
 * {@see <a href="https://bitbucket.org/elefus/spring-java-school-epam-2016/wiki/Task%201.5">Задание №5</a>}
 */
public class Task5Test extends AbstractTaskTest {

    /** Шаблон проверки найденного количества */
    private static final Pattern PATTERN_FOUND_NUMBER = Pattern.compile("^\\d+$");

    /**
     * Проверяет совпадение найденного количества с ожидаемым результатом
     * @param expected Ожидаемое значение
     * @param existing Полученное значение
     */
    private void checkFoundNumber(int expected, String existing) {
        if (!PATTERN_FOUND_NUMBER.matcher(existing).matches()) {
            Assert.fail("The result is malformed: " + existing);
        }
        super.assertEquals("Incorrect result!", String.valueOf(expected), existing);
    }

    /**
     * Производит тестирование задачи с указанными исходными данными.
     * @param words Анализируемые слова.
     * @param count Количество слов, удовлетворяющих условию.
     */
    private void test(String[] words, int count) throws IOException {
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
            SOLVER.task5();

            // Asserts
            this.checkFoundNumber(count, readOut.readLine());
        }
    }

    /**
     * Передается некоторое количество слов. Ни одно из них не состоит из букв английского алфавита.
     */
    @org.junit.Test (timeout = 2000)
    public void test1() throws Exception {
        this.test(new String[]{"1", "1", "1", "1"}, 0);
    }

    /**
     * Передается некоторое количество слов.
     * Некоторые из них состоят из букв английского алфавита.
     * Но ни одно из них не содержит одинаковое количество гласных и согласных.
     */
    @org.junit.Test (timeout = 2000)
    public void test2() throws Exception {
        this.test(new String[]{"1", "1", "a", "b", "abc"}, 0);
    }

    /**
     * Передается некоторое количество слов.
     * Некоторые из них состоят из букв английского алфавита.
     * Одно из них содержит одинаковое количество гласных и согласных.
     */
    @org.junit.Test (timeout = 2000)
    public void test3() throws Exception {
        this.test(new String[]{"1", "1", "a", "b", "ab"}, 1);
    }

    /**
     * Передается некоторое количество слов.
     * Некоторые из них состоят из букв английского алфавита.
     * Три из них содержат одинаковое количество гласных и согласных.
     */
    @org.junit.Test (timeout = 2000)
    public void test4() throws Exception {
        this.test(new String[]{"1", "1", "a", "b", "ab", "ce", "uz"}, 3);
    }
}