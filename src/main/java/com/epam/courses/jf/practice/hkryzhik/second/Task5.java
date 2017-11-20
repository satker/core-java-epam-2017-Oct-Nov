package com.epam.courses.jf.practice.hkryzhik.second;

import com.epam.courses.jf.practice.common.second.ITestableTask5;

import java.util.List;

public class Task5 implements ITestableTask5{
    @Override
    public double calcResistance(List<IMeasurement> measurements) {

        double numerator = 0;
        double denominator = 0;

        for (IMeasurement measurement : measurements) {
             numerator += measurement.getVoltage() * measurement.getCurrent();
             denominator += measurement.getCurrent() * measurement.getCurrent();
        }

        if(denominator != 0) {
            return numerator / denominator;
        }else {
            return 0;
        }
    }
}
