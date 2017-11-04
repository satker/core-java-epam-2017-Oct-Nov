package com.epam.courses.jf.practice.vplaksin.second;

import com.epam.courses.jf.practice.common.second.ITestableTask5;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class Task5 implements ITestableTask5 {

    @Override
    public double calcResistance(List<IMeasurement> measurements) {

        BigDecimal sumUI = BigDecimal.ZERO;
        BigDecimal sumII = BigDecimal.ZERO;

        for (IMeasurement measurement : measurements) {
            BigDecimal u = BigDecimal.valueOf(measurement.getVoltage());
            BigDecimal i = BigDecimal.valueOf(measurement.getCurrent());
            sumUI = sumUI.add(u.multiply(i));
            sumII = sumII.add(i.multiply(i));
        }

        if (sumII.equals(BigDecimal.ZERO)) {
            return 0;
        }

        return sumUI.divide(sumII, 6, RoundingMode.HALF_UP).doubleValue();

    }

}
