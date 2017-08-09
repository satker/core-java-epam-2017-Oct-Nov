package com.epam.courses.jf.practice.second;

import org.junit.Assert;
import com.epam.courses.jf.practice.common.second.ITestableTask5;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.epam.courses.jf.practice.common.second.ITestableTask5.IMeasurement;

/**
 * Проверяет выполнение пятой задачи.
 *
 * Список содержит результаты измерений тока и напряжения на неизвестном сопротивлении R.
 * Найти приближенное число R методом наименьших квадратов.
 * Для повышения точности вычислений использовать класс {@link java.math.BigDecimal}
 */
public class Task5Test extends AbstractTaskTest {

    /**
     * Производит тестирование задачи с указанными исходными данными.
     * @param measurements Результаты измерений.
     * @param resistance Сопротивление при измерениях.
     */
    private void test(List<IMeasurement> measurements, double resistance) throws IOException {
        // Prepare
        ITestableTask5 solver = TASK_STORAGE.getSolver(ITestableTask5.class);

        // Run
        double result = solver.calcResistance(measurements);

        // Asserts
        Assert.assertEquals(resistance, result, 0.000001);
    }

    /**
     * Нулевое напряжение.
     */
    @org.junit.Test (timeout = 2000)
    public void test1() throws Exception {
        test(Collections.singletonList(createMeasurement(10, 0)), 0);
    }

    /**
     * Одно измерение.
     */
    @org.junit.Test (timeout = 2000)
    public void test2() throws Exception {
        test(Collections.singletonList(createMeasurement(0.5, 12)), 24);
    }

    /**
     * Несколько измерений.
     */
    @org.junit.Test (timeout = 2000)
    public void test3() throws Exception {
        test(Arrays.asList(
                createMeasurement(0.78, 67.3),
                createMeasurement(0.82, 64.4),
                createMeasurement(0.80, 66.4),
                createMeasurement(0.85, 67.5),
                createMeasurement(0.77, 70.0),
                createMeasurement(0.79, 71.8)), 84.5579359117167);
    }

    /**
     * @param current Измерение тока.
     * @param voltage Измерение напряжения.
     * @return Измерение с указанными значениями.
     */
    private IMeasurement createMeasurement(final double current, final double voltage) {
        return new IMeasurement() {
            @Override
            public double getCurrent() {
                return current;
            }

            @Override
            public double getVoltage() {
                return voltage;
            }
        };
    }
}
