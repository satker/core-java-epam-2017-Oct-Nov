package com.epam.courses.jf.se7;

import java.util.Arrays;
import java.util.concurrent.*;
import java.util.Random;

public class ForkJoinQSort {

    public static void main(String... args) {
        int[] array  = new Random().ints(1_000_000, -1000, 1000).toArray();
        new ForkJoinPool().invoke(new Sorter(array, 0, array.length - 1));
        System.out.println(Arrays.toString(array));
    }

    /**
     * Рекурсивная задача для ForJoinPool, реализующая сортировку массива.
     */
    private static class Sorter extends RecursiveAction {

        /** Сортируемый массив. */
        private final int[] array;

        /** Индекс левой границы под-массива. */
        private final int from;

        /** Индекс правой границы под-массива. */
        private final int to;

        private Sorter(int[] array, int from, int to) {
            this.array = array;
            this.from = from;
            this.to = to;
        }

        @Override
        protected void compute() {
            if (from >= to) {
                return;
            }

            int i = from;
            int j = to;
            int m = i - (i - j) / 2;

            while (i < j) {
                while ((array[i] <= array[m]) && (i < m)) {
                    i++;
                }
                while ((array[j] >= array[m]) && (j > m)) {
                    j--;
                }
                if (i < j) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    if (i == m) {
                        m = j;
                    } else if (j == m) {
                        m = i;
                    }
                }
            }

            forkAndJoin(m);
        }

        /**
         * Порождает задачи для обработки под-массивов.
         * @param median Индекс разделительного элемента.
         */
        private void forkAndJoin(int median) {
            Sorter left = new Sorter(array, from, median);
            left.fork();

            Sorter right = new Sorter(array, median + 1, to);
            right.fork();

            left.join();
            right.join();
        }
    }
}
