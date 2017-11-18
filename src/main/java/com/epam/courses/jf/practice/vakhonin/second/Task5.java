package com.epam.courses.jf.practice.vakhonin.second;

import com.epam.courses.jf.practice.common.second.ITestableTask5;

import java.util.List;

import java.math.BigDecimal;

/**
 * Created by igorvahonin on 13.11.17.
 */
public class Task5 implements ITestableTask5{
//    OLS - method degenerate into simple average resistance
    @Override
    public double calcResistance(List<IMeasurement> measurements) {
        double averageResistance;
        BigDecimal voltage, current;
        BigDecimal sumOfII = BigDecimal.ZERO;
        BigDecimal sumOfUI = BigDecimal.ZERO;

        for(IMeasurement measurement: measurements){
            voltage = BigDecimal.valueOf(measurement.getVoltage());
            current = BigDecimal.valueOf(measurement.getCurrent());
            sumOfII = sumOfII.add(current.pow(2));
            sumOfUI = sumOfUI.add(voltage.multiply(current));
        }

        averageResistance = sumOfUI.divide(sumOfII, 6, BigDecimal.ROUND_HALF_UP).doubleValue();
        return averageResistance;
    }

}
