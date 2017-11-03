package com.epam.courses.jf.practice.common.second;

/**
 * Интерфейс для юнит-тестирования задания №18.
 *
 * Дана матрица из целых чисел.
 * Найти в ней прямоугольную подматрицу, состоящую из максимального количества одинаковых элементов.
 * Использовать стек.
 */
public interface ITestableTask18 extends ITaskStorage.ITestableTask {

    /**
     * @param matrix Анализируемая матрица.
     * @return Подматрица, состоящая из максимального количества одинаковых элементов.
     */
    IRectangularIntegerMatrix getMaxSubMatrix(IRectangularIntegerMatrix matrix);

    /**
     * Прямоугольная матрица целых чисел.
     */
    interface IRectangularIntegerMatrix {

        /** @return Ширина матрицы. */
        int getWidth();

        /** @return Высота матрицы. */
        int getHeight();

        /**
         * @param indexWidth Индекс по ширине.
         * @param indexHeight Индекс по высоте.
         * @return Значение, располагающееся в указанной ячейке.
         */
        int getValue(int indexWidth, int indexHeight);
    }
}