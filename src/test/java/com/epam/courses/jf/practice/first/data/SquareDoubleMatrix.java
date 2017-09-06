package com.epam.courses.jf.practice.first.data;

import java.util.Arrays;
import java.util.stream.Collectors;

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
            String line = Arrays.stream(row)
                                .map(elem -> String.format("%.3f", elem))
                                .collect(Collectors.joining(" "));
            builder.append(line);
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }
}
