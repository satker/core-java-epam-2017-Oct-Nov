package com.epam.courses.jf.practice.common.second;

import java.util.List;

/**
 * Интерфейс для юнит-тестирования задания №7.
 *
 * Умножить два многочлена заданной степени, если коэффициенты многочленов хранятся в различных списках.
 * Элемент списка с индексом i соответствует коэффициенту i-й степени.
 */
public interface ITestableTask7 extends ITaskStorage.ITestableTask {

    /**
     * Осуществляет перемножение двух многочленов.
     * @param first Первый многочлен.
     * @param second Второй многочлен.
     * @return Многочлен, полученный в результате перемножения.
     */
    List<Integer> multiplyPolynomials(List<Integer> first, List<Integer> second);
}