package com.epam.courses.jf.practice.second;

import org.junit.Assert;
import com.epam.courses.jf.practice.common.second.ITestableTask19;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static com.epam.courses.jf.practice.common.second.ITestableTask19.ICar;

/**
 * Проверяет выполнение девятнадцатой задачи.
 *
 * На кольцевой гоночной трассе стоит N автомобилей.
 * Для каждого из них известны начальное положение и скорость.
 * Определить, сколько произойдет обгонов за указанное количество кругов.
 */
public class Task19Test extends AbstractTaskTest {

    /**
     * Производит тестирование задачи с указанными исходными данными.
     * @param cars Машины, участвующие в заезде.
     * @param lengthLap Длина одного круга.
     * @param numberLaps Количество кругов.
     * @param expected Ожидаемое количество обгонов
     */
    public void test(Set<ICar> cars, long lengthLap, int numberLaps, int expected) throws Exception {
        // Prepare
        ITestableTask19 solver = TASK_STORAGE.getSolver(ITestableTask19.class);

        // Run
        int result = solver.getNumberOvertaking(cars, lengthLap, numberLaps);

        // Asserts
        Assert.assertEquals(expected, result);
    }

    /**
     * Одна машина на трассе.
     */
    @org.junit.Test (timeout = 2000)
    public void test1() throws Exception {
        test(Collections.<ICar>singleton(new Car(0, 1)), 100, 1, 0);
    }

    /**
     * Две машины, один круг, без обгонов.
     */
    @org.junit.Test (timeout = 2000)
    public void test2() throws Exception {
        Set<ICar> cars = new HashSet<ICar>(Arrays.asList(new Car(10, 10), new Car(0, 5)));
        test(cars, 100, 1, 0);
    }

    /**
     * Две машины, два круга, два обгона.
     */
    @org.junit.Test (timeout = 2000)
    public void test3() throws Exception {
        Set<ICar> cars = new HashSet<ICar>(Arrays.asList(new Car(0, 30), new Car(10, 5)));
        test(cars, 100, 2, 2);
    }

    /**
     * Три машины, два круга, четыре обгона.
     */
    @org.junit.Test (timeout = 2000)
    public void test4() throws Exception {
        Set<ICar> cars = new HashSet<ICar>(Arrays.asList(new Car(0, 30), new Car(5, 25), new Car(10, 5)));
        test(cars, 100, 2, 5);
    }

    /**
     * Машина, участвующая в заезде.
     */
    private class Car implements ICar {

        private final int START_POSITION;

        private final int SPEED;

        private Car(int start_position, int speed) {
            START_POSITION = start_position;
            SPEED = speed;
        }

        @Override
        public int getStartPosition() {
            return START_POSITION;
        }

        @Override
        public int getSpeed() {
            return SPEED;
        }
    }
}