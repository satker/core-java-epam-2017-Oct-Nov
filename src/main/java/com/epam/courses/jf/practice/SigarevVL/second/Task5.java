package com.epam.courses.jf.practice.SigarevVL.second;

import com.epam.courses.jf.practice.common.second.ITestableTask5;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class Task5 implements ITestableTask5 {

    @Override
    public double calcResistance(List<IMeasurement> measurements) {

        BigDecimal voltageAndCurrentMultiplection = new BigDecimal(0);
        BigDecimal currentSquare = new BigDecimal(0);

        for (IMeasurement measurement : measurements) {
            voltageAndCurrentMultiplection = voltageAndCurrentMultiplection.
                    add(BigDecimal.valueOf(measurement.getCurrent()
                            * measurement.getVoltage()));

            currentSquare = currentSquare
                    .add(BigDecimal.valueOf(measurement.getCurrent() * measurement.getCurrent()));
        }

        return voltageAndCurrentMultiplection
                .divide(currentSquare, 6, RoundingMode.HALF_UP).doubleValue();
    }
}
