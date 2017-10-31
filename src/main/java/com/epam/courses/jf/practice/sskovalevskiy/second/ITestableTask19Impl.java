package com.epam.courses.jf.practice.sskovalevskiy.second;

import com.epam.courses.jf.practice.common.second.ITestableTask19;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

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
}
