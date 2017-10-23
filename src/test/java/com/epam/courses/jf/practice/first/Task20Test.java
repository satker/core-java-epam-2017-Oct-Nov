package com.epam.courses.jf.practice.first;

import org.junit.Assert;
import com.epam.courses.jf.practice.first.data.*;

import java.io.IOException;

/**
 * Проверяет выполнение двадцатой задачи.
 *
 * Найти в матрице минимальный элемент и переместить его в указанное место путем перестановки строк и столбцов.
 * Гарантируется, что минимальный элемент в матрице встречается ровно один раз.
 *
 * {@see <a href="https://bitbucket.org/elefus/spring-java-school-epam-2016/wiki/Task%201.20">Задание №20</a>}
 */
public class Task20Test extends AbstractTaskTest {

    /** Исходная квадратная матрица */
    private final static SquareNumberMatrix<Integer> ORIGINAL = new SquareIntMatrix(new Integer[][] {
            {  4,  2, 0,  1 },
            {  0,  2, 0,  1 },
            {  3,  4, 0, -1 },
            { -4, -2, 0,  2 }
    });

    /**
     * Производит тестирование задачи с указанными исходными данными.
     * @param row Индекс строки, в которую необходимо переместить минимальный элемент.
     * @param column Индекс столбца, в который необходимо переместить минимальный элемент.
     * @param original Исходная матрица.
     * @param transformed Преобразованная матрица.
     */
    private void test(int row, int column, SquareNumberMatrix<Integer> original, SquareNumberMatrix<Integer> transformed) throws IOException {
        try (DecoratorIO decoratorIO = new DecoratorIO()) {
            // Prepare
            super.setupStreams(decoratorIO);
            writeIn.write(String.valueOf(row).concat("\n").getBytes());
            writeIn.write(String.valueOf(column).concat("\n").getBytes());
            writeIn.write(original.toString().getBytes());

            // Run
            SOLVER.task20();

            // Asserts
            super.assertEquals("Incorrect result", transformed, SquareIntMatrix.parse(readOut));
        }
    }

    /**
     * Единичная матрица.
     */
    @org.junit.Test (timeout = 2000)
    public void test1() throws Exception {
        this.test(0, 0, SquareIntMatrix.IDENTITY_MATRIX, SquareIntMatrix.IDENTITY_MATRIX);
    }

    /**
     * Матрица размерности 4.
     * Требуется перестановка и столбца и строки.
     */
    @org.junit.Test (timeout = 2000)
    public void test2() throws Exception {
        this.test(0, 1, ORIGINAL , new SquareIntMatrix(new Integer[][] {
                        { -2, -4, 0,  2 },
                        {  2,  0, 0,  1 },
						{  4,  3, 0, -1 },
						{  2,  4, 0,  1 }
                })
        );
    }

    /**
     * Матрица размерности 4.
     * Требуется перестановка только столбца.
     */
    @org.junit.Test (timeout = 2000)
    public void test3() throws Exception {
        this.test(3, 1, ORIGINAL, new SquareIntMatrix(new Integer[][] {
                        {  2,  4, 0,  1 },
                        {  2,  0, 0,  1 },
                        {  4,  3, 0, -1 },
                        { -2, -4, 0,  2 }
                })
        );
    }

    /**
     * Матрица размерности 4.
     * Требуется перестановка только строки.
     */
    @org.junit.Test (timeout = 2000)
    public void test4() throws Exception {
        this.test(2, 0, ORIGINAL, new SquareIntMatrix(new Integer[][] {
                        {  4,  2, 0,  1 },
                        {  0,  2, 0,  1 },
                        { -4, -2, 0,  2 },
                        {  3,  4, 0, -1 }
                })
        );
    }

    /**
     * Матрица размерности 4.
     * Перестановок не требуется.
     */
    @org.junit.Test (timeout = 2000)
    public void test5() throws Exception {
        this.test(3, 0, ORIGINAL, ORIGINAL);
    }
}