package com.epam.courses.jf.practice.common.second;

import java.util.Set;

/**
 * Интерфейс для юнит-тестирования задания №19.
 *
 * На кольцевой гоночной трассе стоит N автомобилей.
 * Для каждого из них известны начальное положение и скорость.
 * Определить, сколько произойдет обгонов за указанное количество кругов.
 */
public interface ITestableTask19 extends ITaskStorage.ITestableTask {

    /**
     * @param cars Расположенные на трассе машины.
     * @param lengthLap Длина трассы.
     * @param numberLaps Количество кругов.
     * @return Количество осуществленных обгонов.
     */
    int getNumberOvertaking(Set<ICar> cars, long lengthLap, int numberLaps);

    /**
     * Машина.
     */
    interface ICar {

        /** @return Позиция в начальный момент времени. */
        int getStartPosition();

        /** @return Скорость движения. */
        int getSpeed();
    }
}