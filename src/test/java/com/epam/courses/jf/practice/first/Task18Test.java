package com.epam.courses.jf.practice.first;

import org.junit.Assert;
import com.epam.courses.jf.practice.first.data.*;

import java.io.IOException;

/**
 * Проверяет выполнение восемнадцатой задачи.
 *
 * Найти максимальный элемент(ы) в матрице и удалить из матрицы все строки и столбцы, его содержащие.
 *
 * {@see <a href="https://bitbucket.org/elefus/spring-java-school-epam-2016/wiki/Task%201.18">Задание №18</a>}
 */
public class Task18Test extends AbstractTaskTest {

    /**
     * Производит тестирование задачи с указанными исходными данными.
     * @param original Исходная матрица.
     * @param transformed Преобразованная матрица.
     */
    private void test(SquareNumberMatrix<Integer> original, NumberMatrix<Integer> transformed) throws IOException {
        try (DecoratorIO decoratorIO = new DecoratorIO()) {
            // Prepare
            super.setupStreams(decoratorIO);
            writeIn.write(original.toString().getBytes());

            // Run
            SOLVER.task18();

            // Asserts
            super.assertEquals("Incorrect result", transformed, IntMatrix.parse(readOut));
        }
    }

    /**
     * Матрица размерности 2 с одним максимальным элементом.
     */
    @org.junit.Test (timeout = 2000)
    public void test1() throws Exception {
        this.test(new SquareIntMatrix(new Integer[][]{
                { 0, 1 },
                { 2, 0 }
        }), SquareIntMatrix.IDENTITY_MATRIX);
    }

    /**
     * Матрица размерности 4 с двумя максимальными элементами, в разных строках и столбцах.
     */
    @org.junit.Test (timeout = 2000)
    public void test2() throws Exception {
        this.test(new SquareIntMatrix(new Integer[][] {
                        {  4,  2, 0,  1 },
                        {  0,  2, 1,  1 },
                        {  3,  4, 2, -1 },
                        { -4, -2, 0,  2 }
                }), new SquareIntMatrix(new Integer[][] {
                        { 1,  1 },
                        { 0,  2 }
                })
        );
    }

    /**
     * Матрица размерности 5 с двумя максимальными элементами в одной строке.
     * В результате должна получиться прямоугольная матрица.
     */
    @org.junit.Test (timeout = 2000)
    public void test3() throws Exception {
        this.test(new SquareIntMatrix(new Integer[][] {
                        { 2,   0,  3,  4,  0 },
                        { 1,   3,  0,  2, -1 },
                        { 2,  -1, -5,  4,  0 },
                        { 5,   4,  5, -2,  2 },
                        { 1,   2,  4, -4,  3 }
                }), new IntMatrix(new Integer[][]{
                        {  0,  4,  0 },
                        {  3,  2, -1 },
                        { -1,  4,  0 },
                        {  2, -4,  3 }
                })
        );
    }
}