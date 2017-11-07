package com.epam.courses.jf.practice.sskovalevskiy.second;

import com.epam.courses.jf.practice.common.second.ITestableTask5;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 01.11.2017.
 * Решено, как описано в  http://yun.moluch.ru/archive/5/287/
 */
public class ITestableTask5Impl implements ITestableTask5 {

    @Override
    public double calcResistance(List<IMeasurement> measurements) {

        double UI = 0;
        double I2 = 0;

        for (IMeasurement measurement : measurements) {
            UI += measurement.getVoltage() * measurement.getCurrent();
            I2 += Math.pow(measurement.getCurrent(), 2);
        }

        return UI/I2;
    }
}
