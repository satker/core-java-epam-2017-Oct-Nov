package com.epam.courses.jf.practice.klimenko.second;

import com.epam.courses.jf.practice.common.second.ITestableTask12;

import java.util.List;

public class TestableTask12Impl implements ITestableTask12 {
    @Override
    public List<Integer> transform(List<Integer> integers, int value) {
        int middle = 0;
        for (int i = 0; i < integers.size(); ++i) {
            if (integers.get(i) <= value) {
                if (i != middle) {
                    Integer tmp = integers.get(middle);
                    integers.set(middle, integers.get(i));
                    integers.set(i, tmp);
                }
                ++middle;
            }
        }
        return integers;
    }
}
