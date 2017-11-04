package com.epam.courses.jf.practice.vplaksin.second;

import com.epam.courses.jf.practice.common.second.ITestableTask5;

import java.math.BigDecimal;
import java.util.List;

public class Task5 implements ITestableTask5 {

    @Override
    public double calcResistance(List<IMeasurement> measurements) {

        BigDecimal sumUI = BigDecimal.ZERO;
        BigDecimal sumII = BigDecimal.ZERO;

        for (IMeasurement measurement : measurements) {
            BigDecimal u = BigDecimal.valueOf(measurement.getVoltage());
            BigDecimal i = BigDecimal.valueOf(measurement.getCurrent());
            sumUI.add(u.multiply(i));
            sumII.add(i.multiply(i));
        }

        return sumUI.divide(sumII).doubleValue();

    }

}
