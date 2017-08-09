package com.epam.courses.jf.practice.first.data;

import java.math.BigDecimal;
import java.util.Comparator;

public class SquareNumberMatrix<T extends Number> extends NumberMatrix<T> {

    /**
     * Выполняет сравнение двух чисел (generic).
     */
    private final static Comparator<Number> NUMBER_COMPARATOR = new Comparator<Number>() {
        @Override
        public int compare(Number first, Number second) {
            return new BigDecimal(first.toString()).compareTo(new BigDecimal(second.toString()));
        }
    };

    public SquareNumberMatrix(T[][] data) {
        super(data);
        for (Number[] row : data) {
            if (row.length != this.getDimension()) {
                throw new IllegalArgumentException("Matrix isn't square!");
            }
            for (Number element : row) {
                if (NUMBER_COMPARATOR.compare(element, this.getDimension()) > 0) {
                    throw new IllegalArgumentException("Matrix element greater than dimension!");
                }
            }
        }
    }

    /**
     * @return Размерность матрицы.
     */
    public int getDimension() {
        return this.getWidth();
    }

    @Override
    public String toString() {
        return super.toString().replaceFirst("\\d+\\n\\d+", String.valueOf(this.getDimension()));
    }
}
