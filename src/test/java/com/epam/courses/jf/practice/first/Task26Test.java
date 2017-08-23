package com.epam.courses.jf.practice.first;

import org.junit.Assert;
import com.epam.courses.jf.practice.first.data.*;

import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Проверяет выполнение двадцать шестой задачи.
 *
 * Найти наибольший среди локальных максимумов.
 * Соседями элемента матрицы назовем элементы, имеющие с ним общую сторону или угол.
 * Элемент матрицы называется локальным максимумом, если он строго больше всех своих соседей.
 *
 * {@see <a href="https://bitbucket.org/elefus/spring-java-school-epam-2016/wiki/Task%201.26">Задание №26</a>}
 */
public class Task26Test extends AbstractTaskTest {

    /** Значение, соответствующее отсутствию локальных максимумов в переданной матрице */
    private static final String NOT_FOUND = "NOT FOUND";

    /** Шаблон проверки найденного значения */
    private static final Pattern PATTERN_FOUND_VALUE = Pattern.compile("^(\\-?\\d+)|(" + NOT_FOUND + ")$");

    /**
     * Проверяет совпадение найденного количества с ожидаемым результатом.
     * @param expected Ожидаемое значение.
     * @param existing Полученное значение.
     */
    private void checkFoundValue(String expected, String existing) {
        if (!PATTERN_FOUND_VALUE.matcher(existing).matches()) {
            Assert.fail("The result is malformed: " + existing);
        }
        super.assertEquals("Incorrect result!", String.valueOf(expected), existing);
    }

    /**
     * Производит тестирование задачи с указанными исходными данными.
     * @param matrix Анализируемая матрица.
     * @param maxLocalMaximum Наибольший среди локальных максимумов.
     *                        {@link Task26Test#NOT_FOUND} - если локальные максимумы отсутствуют.
     */
    private void test(SquareNumberMatrix<Integer> matrix, String maxLocalMaximum) throws IOException {
        try (DecoratorIO decoratorIO = new DecoratorIO()) {
            // Prepare
            super.setupStreams(decoratorIO);
            writeIn.write(matrix.toString().getBytes());

            // Run
            SOLVER.task26();

            // Asserts
            this.checkFoundValue(maxLocalMaximum, readOut.readLine());
        }
    }

    /**
     * Единичная матрица.
     */
    @org.junit.Test (timeout = 2000)
    public void test1() throws Exception {
        this.test(SquareIntMatrix.IDENTITY_MATRIX, "1");
    }

    /**
     * Матрица размерности 4.
     * Присутствуют два одинаковых локальных максимума (в углах).
     */
    @org.junit.Test (timeout = 2000)
    public void test2() throws Exception {
        this.test(new SquareIntMatrix(new Integer[][]{
                {  4,  0,  1, 0 },
                {  2, -1, -1, 1 },
                { -2, -2,  3, 1 },
                {  4, -1,  2, 3 }
        }), "4");
    }

    /**
     * Матрица размерности 4.
     * Присутствуют два различных локальных максимума (в углах).
     */
    @org.junit.Test (timeout = 2000)
    public void test3() throws Exception {
        this.test(new SquareIntMatrix(new Integer[][]{
                { 3,  0,  1, 0 },
                { 0,  2, -1, 1 },
                { 2,  2,  0, 1 },
                { 0, -1,  2, 0 }
        }), "3");
    }

    /**
     * Матрица размерности 4.
     * Присутствуют три различных локальных максимума.
     */
    @org.junit.Test (timeout = 2000)
    public void test4() throws Exception {
        this.test(new SquareIntMatrix(new Integer[][]{
                { 2,  0,  1, 0 },
                { 0,  0, -1, 1 },
                { 2,  1,  0, 1 },
                { 0, -1,  2, 0 }
        }), "2");
    }
}