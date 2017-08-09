package com.epam.courses.jf.practice.first.data;

public class NumberMatrix<T extends Number> {

    protected final T[][] DATA;

    public NumberMatrix(T[][] data) {
        DATA = data;
    }

    /**
     * @return Ширина матрицы.
     */
    public int getWidth() {
        return DATA.length;
    }

    /**
     * @return Высота матрицы.
     */
    public int getHeight() {
        return DATA.length == 0 ? 0 : DATA[0].length;
    }

    @Override
    public boolean equals(Object anotherObject) {
        if (this == anotherObject) return true;
        if (anotherObject == null || !(anotherObject instanceof NumberMatrix<?>)) return false;
        NumberMatrix<?> anotherMatrix = (NumberMatrix<?>) anotherObject;
        if (anotherMatrix.getWidth() != this.getWidth() || anotherMatrix.getHeight() != this.getHeight()) {
            return false;
        }
        for (int row = 0; row < this.getWidth(); ++row) {
            for (int column = 0; column < this.getHeight(); ++column) {
                if (!DATA[row][column].equals(anotherMatrix.DATA[row][column])) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hashCode =  0;
        for (Number[] row : DATA) {
            for (Number element : row) {
                hashCode += element.intValue();
            }
        }
        return hashCode;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder((int) Math.pow(DATA.length, 3));
        builder.append(this.getWidth()).append("\n");
        builder.append(this.getHeight()).append("\n");
        for (Number[] row : DATA) {
            for (Number value : row) {
                builder.append(value).append(" ");
            }
            builder.setLength(builder.length() - 1);
            builder.append("\n");
        }
        return builder.toString();
    }
}
