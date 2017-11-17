package com.epam.courses.jf.practice.asunyaev.second;

import com.epam.courses.jf.practice.common.second.ITestableTask18;

import java.util.*;

public class Task18 implements ITestableTask18 {

    public static void main(String[] args) {
        Task18 task = new Task18();
        IRectangularIntegerMatrix matrix = task.getRectangularIntegerMatrix(new int[][] {{1, 1, 2}, {1, 1, 2}, {1, 1, 2}});
        task.print(task.getMaxSubMatrix(matrix));

    }


    //За основу взят алгоритм с http://e-maxx.ru/algo/maximum_zero_submatrix
    @Override
    public IRectangularIntegerMatrix getMaxSubMatrix(IRectangularIntegerMatrix matrix) {
        IRectangularIntegerMatrix result = matrix;
        int n = matrix.getHeight();
        int m = matrix.getWidth();

        Set<Integer> differentValues = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                differentValues.add(matrix.getValue(i, j));
            }
        }

        int maxSize = 0;

        for (Integer element : differentValues) {
            Deque<Integer> stack = new ArrayDeque<>();
            int[] d = new int[m];
            Arrays.fill(d, -1);
            int[] d1 = new int[m];
            int[] d2 = new int[m];
            int size = 0;
            int iStart = 0;
            int iFinish = 0;
            int jStart = 0;
            int jFinish = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (matrix.getValue(i, j) != element) {
                        d[j] = i;
                    }
                }
                while (!stack.isEmpty()) {
                    stack.pop();
                }
                for (int j = 0; j < m; j++) {
                    while (!stack.isEmpty() && d[stack.peek()] <= d[j]) {
                        stack.pop();
                    }
                    d1[j] = stack.isEmpty() ? -1 : stack.peek();
                    stack.push(j);
                }
                while (!stack.isEmpty()) stack.pop();
                for (int j = m - 1; j >= 0; j--) {
                    while (!stack.isEmpty() && d[stack.peek()] <= d[j])  stack.pop();
                    d2[j] = stack.isEmpty() ? m : stack.peek();
                    stack.push(j);
                }
                for (int j = 0; j < m; j++) {
                    int oldSize = size;
                    size = Math.max(size, (i - d[j]) * (d2[j] - d1[j] - 1));
                    if ((oldSize - size) != 0) {
                        iStart = d[j] + 1;
                        iFinish = i;
                        jStart = d1[j] + 1;
                        jFinish = d2[j] - 1;
                    }
                }
            }

            if (size > maxSize) {
                result = generateSubMatrix(matrix, iStart, iFinish, jStart, jFinish);
                maxSize = size;
            }
        }

        return result;
    }

    IRectangularIntegerMatrix generateSubMatrix(IRectangularIntegerMatrix matrix, int iStart, int iFinish, int jStart, int jFinish) {
        int n = iFinish - iStart + 1;
        int m = jFinish - jStart + 1;
        int[][] subMatrix = new int[n][m];
        for (int i = iStart; i <= iFinish; i++) {
            for (int j = jStart; j <= jFinish; j++) {
                subMatrix[i - iStart][j - jStart] = matrix.getValue(i ,j);
            }
        }
        return new RectangularIntegerMatrix(subMatrix);
    }




    public IRectangularIntegerMatrix getRectangularIntegerMatrix(int[][] array) {
        return new RectangularIntegerMatrix(array);
    }

    private void print(IRectangularIntegerMatrix matrix) {
        for (int i = 0; i < matrix.getHeight(); i++) {
            for (int j = 0; j < matrix.getWidth(); j++) {
                System.out.print(matrix.getValue(i, j));
                if (j < matrix.getWidth() - 1) {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }

    private class RectangularIntegerMatrix implements IRectangularIntegerMatrix {

        private int[][] matrix;

        public RectangularIntegerMatrix(int[][] array) {
            matrix = Arrays.copyOf(array, array.length);
        }



        @Override
        public int getWidth() {
            return matrix[0].length;
        }

        @Override
        public int getHeight() {
            return matrix.length;
        }

        @Override
        public int getValue(int indexWidth, int indexHeight) {
            return matrix[indexWidth][indexHeight];
        }

    }
}
