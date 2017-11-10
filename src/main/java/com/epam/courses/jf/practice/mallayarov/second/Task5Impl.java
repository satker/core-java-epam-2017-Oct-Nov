package com.epam.courses.jf.practice.mallayarov.second;

import com.epam.courses.jf.practice.common.second.ITestableTask5;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class Task5Impl implements ITestableTask5 {
    @Override
    public double calcResistance(List<IMeasurement> measurements) {
        BigDecimal result;
        BigDecimal numerator = new BigDecimal(0.0);
        BigDecimal denominator = new BigDecimal(0.0);
        for (IMeasurement measurement : measurements) {
            numerator = numerator.add(new BigDecimal(measurement.getCurrent() * measurement.getVoltage()));
            denominator = denominator.add(new BigDecimal(measurement.getCurrent() * measurement.getCurrent()));
        }
        result = numerator.divide(denominator, RoundingMode.HALF_UP);
        return result.doubleValue();
    }
}
