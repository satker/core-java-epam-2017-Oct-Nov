package com.epam.courses.jf.practice.first.data;

import java.util.Formatter;
import java.util.Locale;

/**
 * Квадратная матрица десятичных чисел.
 */
public class SquareDoubleMatrix extends SquareNumberMatrix<Double> {

    public SquareDoubleMatrix(Double[][] data) {
        super(data);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(this.getDimension() * 5);
        builder.append(this.getDimension()).append("\n");
        for (Double[] row : DATA) {
            for (Double element : row) {
                builder.append(String.format("%.3f%n", element));
            }
        }
        return builder.toString();
    }
}
