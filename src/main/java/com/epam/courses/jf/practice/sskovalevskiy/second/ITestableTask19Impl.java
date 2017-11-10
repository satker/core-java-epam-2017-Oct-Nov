package com.epam.courses.jf.practice.sskovalevskiy.second;

import com.epam.courses.jf.practice.common.second.ITestableTask19;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;

/**
 * Created by asus on 28.10.2017.
 */
public class ITestableTask19Impl implements ITestableTask19 {
    @Override
    public int getNumberOvertaking(Set<ICar> cars, long lengthLap, int numberLaps) {

//        1й за время t проедет S1 = V1*t,
//        2й за время t проедет S2 = V2*t = lengthLap + V1*t => t = lengthLap/(V2 - V1), где t - время на один обгон
//        Далее:
//        Общее время движения любой ICar: T = lengthLap*numberLaps/ICar.getSpeed()
//        Тогда за своё время движения T ICarX обгонит ICarY T/t раз, при условии, что ICarX.getSpeed() > ICarY.getSpeed()


        ArrayList<ICar> list = new ArrayList<>(cars);
        Comparator<ICar> comparator = (o1, o2) -> o2.getSpeed() - o1.getSpeed();
        list.sort(comparator);

        int totalNumberOfOvertakings = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            double T = (lengthLap * numberLaps) / list.get(i).getSpeed();
            for (int j = i + 1; j < list.size(); j++) {

                if (list.get(i).getSpeed() == list.get(j).getSpeed()){
                    continue;
                }
                double t = lengthLap / (list.get(i).getSpeed() - list.get(j).getSpeed());
                totalNumberOfOvertakings += (int) T/t;
            }
        }
        return totalNumberOfOvertakings;
    }

    static class Car implements ICar, Comparable<Car> {
        private int racePosition;
        private final int startPosition;
        private final int speed;
        private int laps;
        private long currentPosition;

        int getRacePosition() {
            return racePosition;
        }

        void setRacePosition(int racePosition) {
            this.racePosition = racePosition;
        }

        int getLaps() {
            return laps;
        }

        void setLaps(int laps) {
            this.laps = laps;
        }

        long getCurrentPosition() {
            return currentPosition;
        }

        void setCurrentPosition(long currentPosition) {
            this.currentPosition = currentPosition;
        }

        Car(int startPosition, int speed) {
            this.startPosition = startPosition;
            this.speed = speed;
            this.laps = 0;
            this.racePosition = 0;
            this.currentPosition = startPosition;
        }

        @Override
        public int getStartPosition() {
            return startPosition;
        }

        @Override
        public int getSpeed() {
            return speed;
        }

        @Override
        public int compareTo(Car o) {
            if (currentPosition != o.currentPosition) {
                return Long.compare(this.currentPosition, o.currentPosition);
            } else {
                return Integer.compare(racePosition, o.racePosition);
            }
        }

        @Override
        public String toString() {
            return "Car{" +
                    "laps=" + laps +
                    ", currentPosition=" + currentPosition +
                    '}';
        }
    }
}
