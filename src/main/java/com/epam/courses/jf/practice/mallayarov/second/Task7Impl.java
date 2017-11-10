package com.epam.courses.jf.practice.mallayarov.second;

import com.epam.courses.jf.practice.common.second.ITestableTask7;

import java.util.ArrayList;
import java.util.List;

public class Task7Impl implements ITestableTask7 {
    @Override
    public List<Integer> multiplyPolynomials(List<Integer> first, List<Integer> second) {
        List<Integer> result = new ArrayList<>(first.size() + second.size());

        for (int i = 0; i < first.size() + second.size(); ++i) {
            result.add(i, 0);
        }

        for (int i = 0; i < first.size(); ++i) {
            for (int j = 0; j < second.size(); ++j) {
                result.set(i + j, result.get(i + j) + first.get(i) * second.get(j));

            }
        }

        return result;
    }
}
