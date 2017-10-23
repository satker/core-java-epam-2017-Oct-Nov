package com.epam.courses.jf.practice.first;

import org.junit.Assert;
import com.epam.courses.jf.practice.first.data.*;

import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Проверяет выполнение двадцать пятой задачи.
 *
 * Найти число локальных минимумов.
 * Соседями элемента матрицы назовем элементы, имеющие с ним общую сторону или угол.
 * Элемент матрицы называется локальным минимумом, если он строго меньше всех своих соседей.
 *
 * {@see <a href="https://bitbucket.org/elefus/spring-java-school-epam-2016/wiki/Task%201.25">Задание №25</a>}
 */
public class Task25Test extends AbstractTaskTest {

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
     * @param matrix Анализируемая матрица.
     * @param numberLocalMinimums Количество локальных минимумов.
     */
    private void test(SquareNumberMatrix<Integer> matrix, int numberLocalMinimums) throws IOException {
        try (DecoratorIO decoratorIO = new DecoratorIO()) {
            // Prepare
            super.setupStreams(decoratorIO);
            writeIn.write(matrix.toString().getBytes());

            // Run
            SOLVER.task25();

            // Asserts
            this.checkFoundNumber(numberLocalMinimums, readOut.readLine());
        }
    }

    /**
     * Единичная матрица.
     */
    @org.junit.Test (timeout = 2000)
    public void test1() throws Exception {
        this.test(SquareIntMatrix.IDENTITY_MATRIX, 1);
    }

    /**
     * Матрица размерности 4.
     * Присутствует один локальный минимум (в углу).
     */
    @org.junit.Test (timeout = 2000)
    public void test2() throws Exception {
        this.test(new SquareIntMatrix(new Integer[][]{
                {  4,   0,  1,  2 },
                {  2,  -1, -1,  1 },
                { -2,  -2,  3,  1 },
                {  4,  -1,  2, -1 }
        }), 1);
    }

    /**
     * Матрица размерности 2.
     * Локальные минимумы отсутствуют.
     */
    @org.junit.Test (timeout = 2000)
    public void test3() throws Exception {
        this.test(new SquareIntMatrix(new Integer[][]{
                { 2, 0 },
                { 0, 2 }
        }), 0);
    }

    /**
     * Матрица размерности 4.
     * Присутствует два локальных минимума.
     */
    @org.junit.Test (timeout = 2000)
    public void test4() throws Exception {
        this.test(new SquareIntMatrix(new Integer[][]{
                { 4,   0,  1,  2 },
                { 2,  -1, -1,  1 },
                { 0,  -2,  3,  1 },
                { 4,  -1,  2, -1 }
        }), 2);
    }

}