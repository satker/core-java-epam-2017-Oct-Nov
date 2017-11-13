package com.epam.courses.jf.practice.mallayarov.second;

import com.epam.courses.jf.practice.common.second.ITestableTask12;

import java.util.List;

public class Task12Impl implements ITestableTask12 {
    @Override
    public List<Integer> transform(List<Integer> integers, int value) {

            int low = 0;
            int high = integers.size() - 1;
            int i = 0;
            while (i <= high) {
                int cmp = integers.get(i) - value;
                if (cmp < 0) swap(integers, low++, i++);
                else if (cmp > 0) swap(integers, i, high--);
                else ++i;
        }
        return integers;
    }

    private void swap(List<Integer> list, int first, int second) {
        int temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }
}
