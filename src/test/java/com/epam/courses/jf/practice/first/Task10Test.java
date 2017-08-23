package com.epam.courses.jf.practice.first;

import org.junit.Assert;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Проверяет выполнение десятой задачи.
 *
 * Написать программу, позволяющую корректно находить корни квадратного уравнения.
 *
 * {@see <a href="https://bitbucket.org/elefus/spring-java-school-epam-2016/wiki/Task%201.10">Задание №10</a>}
 */
public class Task10Test extends AbstractTaskTest {

    /** Шаблон дробного числа с округлением до второго знака */
    private static final Pattern REGEX_DECIMAL = Pattern.compile("-?(0|([1-9]\\d*))(\\.\\d{1,2})?");

    /** Шаблоны возможных ответов */
    private static final Pattern REGEX_NO_SOLUTION = Pattern.compile("^No solution$");
    private static final Pattern REGEX_ONE_SOLUTION = Pattern.compile("^One solution: " + REGEX_DECIMAL.pattern() + "$");
    private static final Pattern REGEX_TWO_SOLUTIONS = Pattern.compile("^Two solutions: " + REGEX_DECIMAL.pattern() + ",\\s*" + REGEX_DECIMAL.pattern() + "$");

    /**
     * Проверяет результат решения уравнения.
     * @param existing Полученное значение.
     * @param roots Ожидаемые корни уравнения.
     */
    private void checkResult(String existing, double...roots) {
        switch (roots.length) {
            case 0:
                if (!REGEX_NO_SOLUTION.matcher(existing).matches()) {
                    Assert.fail("The result is malformed: " + existing);
                }
                return;

            case 1:
                if (!REGEX_ONE_SOLUTION.matcher(existing).matches()) {
                    Assert.fail("The result is malformed: " + existing);
                }
                Matcher matcher = REGEX_DECIMAL.matcher(existing);
                if (matcher.find()) {
                    double foundRoot = Double.parseDouble(matcher.group());
                    Assert.assertEquals("Incorrect result: " + foundRoot, foundRoot, roots[0], 0.01);
                }
                return;

            case 2:
                if (!REGEX_TWO_SOLUTIONS.matcher(existing).matches()) {
                    Assert.fail("The result is malformed: " + existing);
                }
                matcher = REGEX_DECIMAL.matcher(existing);
                Set<Double> expected = new HashSet<>();
                expected.add(roots[0]);
                expected.add(roots[1]);

                Set<Double> actual = new HashSet<>();
                for (int i = 0; i < expected.size(); i++) {
                    if (!matcher.find()) {
                        Assert.fail("Incorrect result!");
                    }
                    actual.add(Double.parseDouble(matcher.group()));
                }
                Assert.assertEquals(expected, actual);
        }
    }

    /**
     * Производит тестирование задачи с указанными исходными данными.
     * @param a Коэффициент A в уравнении.
     * @param b Коэффициент B в уравнении.
     * @param c Коэффициент C в уравнении.
     * @param roots Ожидаемые корни уравнения.
     */
    private void test(int a, int b, int c, double...roots) throws IOException {
        try (DecoratorIO decoratorIO = new DecoratorIO()) {
            // Prepare
            super.setupStreams(decoratorIO);
            writeIn.write(String.format("%d %d %d%n", a, b, c).getBytes());

            // Run
            SOLVER.task10();

            // Asserts
            this.checkResult(readOut.readLine(), roots);
        }
    }

    /**
     * Нет корней уравнения.
     */
    @org.junit.Test(timeout = 2000)
    public void test1() throws Exception {
        this.test(4, 2, 1);
    }

    /**
     * Один корень уравнения.
     */
    @org.junit.Test(timeout = 2000)
    public void test2() throws Exception {
        this.test(4, 4, 1, -0.5);
    }

    /**
     * Два корня уравнения
     */
    @org.junit.Test(timeout = 2000)
    public void test3() throws Exception {
        this.test(1, 6, 1, -5.83, -0.17);
    }
}