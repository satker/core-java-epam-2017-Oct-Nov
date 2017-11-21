package com.epam.courses.jf.practice.hkryzhik.second;

import com.epam.courses.jf.practice.common.second.ITestableTask5;

import java.math.BigDecimal;
import java.util.List;

public class Task5 implements ITestableTask5{
    @Override
    public double calcResistance(List<IMeasurement> measurements) {

        BigDecimal numerator = new BigDecimal(0);
        BigDecimal denominator = new BigDecimal(0);

        for (IMeasurement measurement : measurements) {
             numerator.add(new BigDecimal(measurement.getCurrent() * measurement.getVoltage()));
             denominator.add(new BigDecimal(measurement.getCurrent() * measurement.getCurrent()));
        }

        if(denominator.intValue() != 0) {
            return numerator.divide(denominator).doubleValue();
        }else {
            return 0;
        }
    }
}
