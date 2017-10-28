package com.epam.courses.jf.practice.akunats.second;

import org.junit.Test;

public class Task18Test {
    @Test
    public void getMaxSubMatrix() {
        //RectangularIntegerMatrix matrix = new RectangularIntegerMatrix(1, 1);
        int[][] in = {{1, 1, 1}, {1, 1, 1}, {2, 2, 2}};
        /*int iter = 0;
        for (int i = 0; i < matrix.getHeight(); i++) {
            for (int j = 0; j < matrix.getWidth(); j++) {
                matrix.setMatrix(i, j, in[iter]);
                iter++;
            }
        }*/
        RectangularIntegerMatrix matrix = new RectangularIntegerMatrix(in);
        new Task18().getMaxSubMatrix(matrix);

    }
}
