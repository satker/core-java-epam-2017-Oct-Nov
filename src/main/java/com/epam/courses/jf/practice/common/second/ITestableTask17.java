package com.epam.courses.jf.practice.common.second;

import java.util.Set;

/**
 * Интерфейс для юнит-тестирования задания №17.
 *
 * На плоскости задано N отрезков.
 * Найти точку (возможно несколько) пересечения двух отрезков, имеющую минимальную абсциссу.
 * Использовать класс TreeMap.
 */
public interface ITestableTask17 extends ITaskStorage.ITestableTask {

    /**
     * Осуществляет анализ переданных отрезков.
     * @param segments Множество отрезков.
     * @return Множество точек пересечения, имеющих минимальную абсциссу.
     */
    Set<I2DPoint> analyze(Set<ISegment> segments);

    /**
     * Орезок.
     */
    interface ISegment {

        /** @return Первая точка отрезка. */
        I2DPoint first();

        /** @return Вторая точка отрезка. */
        I2DPoint second();
    }
}