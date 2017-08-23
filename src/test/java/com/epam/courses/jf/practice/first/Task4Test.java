package com.epam.courses.jf.practice.first;

import org.junit.Assert;

import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Проверяет выполнение четвертой задачи.
 *
 * Ввести N слов, состоящих из символов английского алфавита.
 * Найти слово, в котором число различных символов минимально.
 * Если таких слов несколько, найти первое из них.
 *
 * {@see <a href="https://bitbucket.org/elefus/spring-java-school-epam-2016/wiki/Task%201.4">Задание №4</a>}
 */
public class Task4Test extends AbstractTaskTest {

    /** Шаблон проверки найденной строки */
    private static final Pattern PATTERN_FOUND_WORD = Pattern.compile("^[a-zA-Z]+$");

    /**
     * Проверяет совпадение найденного слова с ожидаемым результатом
     * @param expected Ожидаемое значение
     * @param existing Полученное значение
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
     * @param expectedWord Слово, содержащее наименьшее число различных символов.
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
            SOLVER.task4();

            // Asserts
            this.checkFoundWord(expectedWord, readOut.readLine());
        }
    }

    /**
     * Передается некоторое количество слов.
     * Одно из них содержит минимальное количество различных символов.
     */
    @org.junit.Test (timeout = 2000)
    public void test1() throws Exception {
        this.test(new String[]{"abcd", "abc", "ab", "aa", "ba"}, "aa");
    }

    /**
     * Передается некоторое количество слов.
     * Два из них содержат минимальное количество различных символов.
     */
    @org.junit.Test (timeout = 2000)
    public void test2() throws Exception {
        this.test(new String[]{"aBcd", "aBc", "bb", "aa"}, "bb");
    }

    /**
     * Передается некоторое количество слов.
     * Два из них содержат минимальное количество различных символов и при этом одинаковы.
     */
    @org.junit.Test (timeout = 2000)
    public void test3() throws Exception {
        this.test(new String[]{"abcd", "abc", "BB", "BB"}, "BB");
    }

    /**
     * Передается некоторое количество слов.
     * Два из них одинаковой длины, но одно содержит одинаковые буквы в разном регистре, а второе - совсем разные.
     */
    @org.junit.Test (timeout = 2000)
    public void test4() throws Exception {
        this.test(new String[]{"AbCd", "abc", "ab", "bB"}, "ab");
    }

    /**
     * Передается одно слово.
     */
    @org.junit.Test (timeout = 2000)
    public void test5() throws Exception {
        this.test(new String[]{"abcd"}, "abcd");
    }
}