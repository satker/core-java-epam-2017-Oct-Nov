package com.epam.courses.jf.practice.asunyaev.second;

import com.epam.courses.jf.practice.common.second.ITestableTask19;

import java.util.*;

import static java.lang.Math.ceil;

public class Task19 implements ITestableTask19 {

    public static void main(String[] args) {
        Task19 task = new Task19();
        Set<ICar> cars = new HashSet<ICar>(Arrays.asList(new Car(0, 30), new Car(10, 5)));
        int t = task.getNumberOvertaking(cars, 100, 2);
        System.out.print(t);
    }

    @Override
    public int getNumberOvertaking(Set<ICar> cars, long lengthLap, int numberLaps) {
        int overtakingCount = 0;
        ArrayList<ICar> carsList = new ArrayList<>(cars);
        carsList.sort(Comparator.comparingInt(ICar::getSpeed).reversed());
        for (int i = 0; i < carsList.size(); i++) {
            ICar firstCar = carsList.get(i);

            for (int j = i + 1; j < carsList.size(); j++) {
                ICar secondCar = carsList.get(j);
                double p1 = firstCar.getStartPosition();
                double p2 = secondCar.getStartPosition();
                int v1 = firstCar.getSpeed();
                int v2 = secondCar.getSpeed();
                for (int k = 0; k < numberLaps; k++) {
                    double t = (p2 - p1)/(v1 - v2);
                    if ((t > 0) && (t < (double) lengthLap/v1)) {
                        overtakingCount++;
                    }
                    p2 += (v2 * (double) lengthLap/v1) % lengthLap;
                }
            }
        }

        return overtakingCount;
    }

    private static class Car implements ICar {

        private int startPosition;

        private int speed;

        private Car(int startPosition, int speed) {
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
