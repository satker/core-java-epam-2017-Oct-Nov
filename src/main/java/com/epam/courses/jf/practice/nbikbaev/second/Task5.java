package com.epam.courses.jf.practice.nbikbaev.second;

import com.epam.courses.jf.practice.common.second.ITestableTask5;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class Task5 implements ITestableTask5 {
    @Override
    public double calcResistance(List<IMeasurement> measurements) {
        BigDecimal current = new BigDecimal(0);
        BigDecimal currentSum = new BigDecimal(0);
        BigDecimal voltage = new BigDecimal(0);
        BigDecimal power = new BigDecimal(0);
        for (IMeasurement measurement : measurements) {
            current = current.add(new BigDecimal(measurement.getCurrent()));
            voltage = voltage.add(new BigDecimal(measurement.getVoltage()));
            power = power.add(new BigDecimal(measurement.getCurrent() * measurement.getVoltage()));
            currentSum = currentSum.add(new BigDecimal(measurement.getCurrent() * measurement.getCurrent()));
        }
        BigDecimal x = power.multiply(new BigDecimal(measurements.size())).subtract(voltage.multiply(current));
        BigDecimal y = currentSum.multiply(new BigDecimal(measurements.size())).subtract(current.pow(2));
        BigDecimal res = x.divide(y, 10, RoundingMode.CEILING);
        return x.doubleValue();
    }
}
