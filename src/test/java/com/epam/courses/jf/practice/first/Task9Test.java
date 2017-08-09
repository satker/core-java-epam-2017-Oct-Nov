package com.epam.courses.jf.practice.first;

import org.junit.Assert;
import com.epam.courses.jf.practice.first.data.IntMatrix;

import java.io.IOException;

/**
 * Проверяет выполнение девятой задачи.
 *
 * Написать программу, которая выводит числа от 1 до N^2 в виде матрицы NxN слева направо и сверху вниз.
 *
 * {@see <a href="https://bitbucket.org/elefus/spring-java-school-epam-2016/wiki/Task%201.9">Задание №9</a>}
 */
public class Task9Test extends AbstractTaskTest {

    /**
     * Проверяет совпадение полученной строки с ожидаемой.
     * @param expected Ожидаемое значение.
     * @param existing Полученное значение.
     */
    private void checkReceivedLine(String expected, String existing) {
        if (!IntMatrix.PATTERN_LINE.matcher(existing).matches()) {
            Assert.fail("The result is malformed: " + existing);
        }
        super.assertEquals("Incorrect result!", expected, existing);
    }

    /**
     * Производит тестирование задачи с указанными исходными данными.
     * @param dimension Размерность создаваемой матрицы.
     */
    private void test(int dimension) throws IOException {
        try (DecoratorIO decoratorIO = new DecoratorIO()) {
            // Prepare
            super.setupStreams(decoratorIO);
            writeIn.write(String.valueOf(dimension).concat("\n").getBytes());

            // Run
            SOLVER.task9();

            // Asserts
            StringBuilder builder = new StringBuilder(4 * dimension);
            int counter = 0;
            for (int i = 0; i < dimension; ++i) {
                for (int j = 0; j < dimension; ++j) {
                    builder.append(++counter);
                    if (j != dimension - 1) {
                        builder.append('\t');
                    }
                }
                this.checkReceivedLine(builder.toString(), readOut.readLine());
                builder.setLength(0);
            }
        }
    }

    /**
     * Единичная матрица.
     */
    @org.junit.Test
    public void test1() throws Exception {
        this.test(1);
    }

    /**
     * Матрица размерности 100.
     */
    @org.junit.Test
    public void test2() throws Exception {
        this.test(10);
    }
}