package com.epam.courses.jf.practice.vkostin.second;

import com.epam.courses.jf.practice.common.second.ITestableTask19;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static java.lang.Math.ceil;

/**
 * Класс задания №19.
 *
 * На кольцевой гоночной трассе стоит N автомобилей.
 * Для каждого из них известны начальное положение и скорость.
 * Определить, сколько произойдет обгонов за указанное количество кругов.
 */

public class Task19 implements ITestableTask19 {

    /* example of use
    public static void main(String[] args) {
        Set<ICar> cars = new HashSet<>();
        cars.add(new Car(0, 10));
        cars.add(new Car(5, 4));
        cars.add(new Car(5, 4));

        Task19 task19 = new Task19();
        System.out.println(task19.getNumberOvertaking(cars, 20, 5));
    }
    */

    @Override
    public int getNumberOvertaking(Set<ICar> cars, long lengthLap, int numberLaps) {

        int numberOvertaking = 0;
        double handicap;
        ArrayList<ICar> listCars = new ArrayList<>(cars);

        for (int i = 0; i < listCars.size(); i++) {
            ICar firstCar = listCars.get(i);

            for (int j = i + 1; j < listCars.size(); j++) {
                ICar secondCar = listCars.get(j);


                if (firstCar.getSpeed() > secondCar.getSpeed()) {
                    handicap = (firstCar.getStartPosition() >= secondCar.getStartPosition()) ? 1 : 0;
                    numberOvertaking += ceil(numberLaps
                            * (1 - (double)secondCar.getSpeed() / (double)firstCar.getSpeed())
                            - handicap);

                } else {
                    handicap = (secondCar.getStartPosition() >= firstCar.getStartPosition()) ? 1 : 0;
                    numberOvertaking += ceil(numberLaps
                            * (1 - (double)firstCar.getSpeed() / (double)secondCar.getSpeed())
                            - handicap);
                }

            }
        }

        return numberOvertaking;
    }

    /**
     * Машина.
     */
    private static class Car implements ICar {

        private int startPosition;
        private int speed;

        Car(int startPosition, int speed) {
            this.startPosition = startPosition;
            this.speed = speed;
        }

        @Override
        public int getStartPosition() {
            return startPosition;
        }

        @Override
        public int getSpeed() {
            return speed;
        }
    }
}
