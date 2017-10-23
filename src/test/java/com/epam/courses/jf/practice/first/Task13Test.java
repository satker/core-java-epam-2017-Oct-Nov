package com.epam.courses.jf.practice.first;

import org.junit.Assert;
import com.epam.courses.jf.practice.first.data.*;

import java.io.IOException;

/**
 * Проверяет выполнение тринадцатой задачи.
 *
 * Выполнить циклический сдвиг матрицы размерности N на k позиций вниз.
 *
 * {@see <a href="https://bitbucket.org/elefus/spring-java-school-epam-2016/wiki/Task%201.13">Задание №13</a>}
 */
public class Task13Test extends AbstractTaskTest {

    /**
     * Производит тестирование задачи с указанными исходными данными.
     * @param countShifts Количество сдвигов матрицы.
     *                    Положительное число - матрица сдвигается вниз.
     *                    Отрицательное число - матрица сдвигается вверх.
     *                    0 - матрица остается без изменений.
     * @param original Исходная матрица.
     * @param transformed Матрица после преобразования.
     */
    private void test(int countShifts, SquareNumberMatrix<Integer> original, SquareNumberMatrix<Integer> transformed) throws IOException {
        try (DecoratorIO decoratorIO = new DecoratorIO()) {
            // Prepare
            super.setupStreams(decoratorIO);
            writeIn.write(String.format("%d%n%s%n", countShifts, original).getBytes());

            // Run
            SOLVER.task13();

            // Asserts
            super.assertEquals("Incorrect result", transformed, SquareIntMatrix.parse(readOut));
        }
    }

    /**
     * Единичная матрица.
     */
    @org.junit.Test (timeout = 2000)
    public void test1() throws Exception {
        this.test(5, SquareIntMatrix.IDENTITY_MATRIX, SquareIntMatrix.IDENTITY_MATRIX);
    }

    /**
     * Матрица размерности 5, сдвиг осуществляется на 2 позиции вниз.
     */
    @org.junit.Test (timeout = 2000)
    public void test2() throws Exception {
        this.test(2, new SquareIntMatrix(new Integer[][] {
                        { 0,   2,  3,  4,  5 },
                        { 1,   3,  0,  2, -1},
                        { -1, -1, -5,  5,  0},
                        { 5,   4, -4, -2,  2},
                        { 1,   3, -3, -4,  3 }
                }), new SquareIntMatrix(new Integer[][] {
                        { 5,   4, -4, -2,  2},
                        { 1,   3, -3, -4,  3 },
                        { 0,   2,  3,  4,  5 },
                        { 1,   3,  0,  2, -1},
                        { -1, -1, -5,  5,  0}
                })
        );
    }

    /**
     * Матрица размерности 5, сдвиг осуществляется на 2 позиции вверх.
     */
    @org.junit.Test (timeout = 2000)
    public void test3() throws Exception {
        this.test(-2, new SquareIntMatrix(new Integer[][] {
                        { 0,   2,  3,  4,  5 },
                        { 1,   3,  0,  2, -1},
                        { -1, -1, -5,  5,  0},
                        { 5,   4, -4, -2,  2},
                        { 1,   3, -3, -4,  3 }
                }), new SquareIntMatrix(new Integer[][] {
                        { -1, -1, -5,  5,  0},
                        { 5,   4, -4, -2,  2},
                        { 1,   3, -3, -4,  3 },
                        { 0,   2,  3,  4,  5 },
                        { 1,   3,  0,  2, -1}
                })
        );
    }

    /**
     * Матрица размерности 5, сдвиг осуществляется на 5 позиции вверх (остается на месте).
     */
    @org.junit.Test (timeout = 2000)
    public void test4() throws Exception {
        this.test(5, new SquareIntMatrix(new Integer[][] {
                        { -1, -1, -5,  5,  0},
                        { 5,   4, -4, -2,  2},
                        { 1,   3, -3, -4,  3 },
                        { 0,   2,  3,  4,  5 },
                        { 1,   3,  0,  2, -1}
                }), new SquareIntMatrix(new Integer[][] {
                        { -1, -1, -5,  5,  0},
                        { 5,   4, -4, -2,  2},
                        { 1,   3, -3, -4,  3 },
                        { 0,   2,  3,  4,  5 },
                        { 1,   3,  0,  2, -1}
                })
        );
    }

    /**
     * Матрица размерности 5, без сдвига.
     */
    @org.junit.Test (timeout = 2000)
    public void test5() throws Exception {
        this.test(0, new SquareIntMatrix(new Integer[][] {
                        { -1, -1, -5,  5,  0},
                        { 5,   4, -4, -2,  2},
                        { 1,   3, -3, -4,  3 },
                        { 0,   2,  3,  4,  5 },
                        { 1,   3,  0,  2, -1}
                }), new SquareIntMatrix(new Integer[][] {
                        { -1, -1, -5,  5,  0},
                        { 5,   4, -4, -2,  2},
                        { 1,   3, -3, -4,  3 },
                        { 0,   2,  3,  4,  5 },
                        { 1,   3,  0,  2, -1}
                })
        );
    }
}