package com.epam.courses.jf.practice.vkostin.second;

import com.epam.courses.jf.practice.common.second.ITestableTask5;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Task5 implements ITestableTask5 {

    /*
    public static void main(String[] args) {

        Measure measurement = new Measure(0.1, 0.27);
        Measure measurement1 = new Measure(0.2, 0.56);
        Measure measurement2 = new Measure(0.3, 0.9);
        Measure measurement3 = new Measure(0.4, 1.18);
        Measure measurement4 = new Measure(0.5, 1.49);

        List<IMeasurement> measurements = new ArrayList<>();

        measurements.add(measurement);
        measurements.add(measurement1);
        measurements.add(measurement2);
        measurements.add(measurement4);
        measurements.add(measurement3);

        Task5 task = new Task5();

        System.out.println(task.calcResistance(measurements));
    }
    */

    @Override
    public double calcResistance(List<IMeasurement> measurements) {

        BigDecimal activePowerSum = new BigDecimal(0.0);
        BigDecimal squaredCurrentSum = new BigDecimal(0.0);

        for (IMeasurement m : measurements) {
            activePowerSum = activePowerSum.add(BigDecimal.valueOf(m.getCurrent() * m.getVoltage()));
            squaredCurrentSum = squaredCurrentSum.add(BigDecimal.valueOf(m.getCurrent() * m.getCurrent()));
        }

        return activePowerSum
                .divide(squaredCurrentSum, 10, RoundingMode.CEILING)
                .doubleValue();

    }


    public static class Measure implements IMeasurement {

        private double current;
        private double voltage;

        Measure(double current, double voltage) {
            this.current = current;
            this.voltage = voltage;
        }

        public double getCurrent() {
            return current;
        }

        public double getVoltage() {
            return voltage;
        }
    }
}
