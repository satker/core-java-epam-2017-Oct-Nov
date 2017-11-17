package com.epam.courses.jf.practice.asunyaev.second;

import com.epam.courses.jf.practice.common.second.ITestableTask19;

import java.util.ArrayList;
import java.util.Set;
import static java.lang.Math.ceil;

public class Task19 implements ITestableTask19 {
    @Override
    public int getNumberOvertaking(Set<ICar> cars, long lengthLap, int numberLaps) {
        int overtakingCount = 0;
        double handicap;
        ArrayList<ICar> listCars = new ArrayList<>(cars);
        for (int i = 0; i < listCars.size(); i++) {
            ICar firstCar = listCars.get(i);

            for (int j = i + 1; j < listCars.size(); j++) {
                ICar secondCar = listCars.get(j);
                if (firstCar.getSpeed() > secondCar.getSpeed()) {
                    handicap = (firstCar.getStartPosition() >= secondCar.getStartPosition()) ? 1 : 0;
                    overtakingCount += numberLaps - handicap;
                } else {
                    handicap = (secondCar.getStartPosition() >= firstCar.getStartPosition()) ? 1 : 0;
                    overtakingCount += numberLaps - handicap;
                }
            }
        }

        return overtakingCount;
    }

    private class Car implements ICar {

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
