package com.epam.courses.jf.practice.NikDevyatyi.second;

import com.epam.courses.jf.practice.common.second.ITestableTask5;

import java.math.BigDecimal;
import java.util.List;

public class TestableTask5 implements ITestableTask5 {
    @Override
    public double calcResistance(List<IMeasurement> measurements) {
        BigDecimal SumUI = new BigDecimal(0.);
        BigDecimal SumUU = new BigDecimal(0.);
        for(IMeasurement item: measurements){
            SumUI = SumUI.add(new BigDecimal(item.getCurrent()).multiply(new BigDecimal(item.getVoltage())));
            SumUU = SumUU.add(new BigDecimal(item.getVoltage()).multiply(new BigDecimal(item.getVoltage())));
        }
        if(SumUI.doubleValue()==0.){
            return 0.;
        }
        return SumUU.divide(SumUI,0).doubleValue();

    }
}
