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
        BigDecimal size = BigDecimal.valueOf(measurements.size());
        double averageResistance;
        BigDecimal voltage, current, resistance;
        BigDecimal sumResistance = BigDecimal.ZERO;
        for(IMeasurement measurement: measurements){
            voltage = BigDecimal.valueOf(measurement.getVoltage());
            current = BigDecimal.valueOf(measurement.getCurrent());
            resistance = voltage.divide(current);
            sumResistance.add(resistance);
        }
        System.out.println(sumResistance);
        averageResistance = sumResistance.divide(size, 6, BigDecimal.ROUND_HALF_UP).doubleValue();
        return averageResistance;
    }

}
