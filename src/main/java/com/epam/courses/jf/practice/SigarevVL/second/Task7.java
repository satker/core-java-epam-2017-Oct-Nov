package com.epam.courses.jf.practice.SigarevVL.second;

import com.epam.courses.jf.practice.common.second.ITestableTask7;

import java.util.ArrayList;
import java.util.List;

public class Task7 implements ITestableTask7 {

    @Override
    public List<Integer> multiplyPolynomials(List<Integer> first, List<Integer> second) {
        List<Integer> multiplyResult = new ArrayList<>(first.size() + second.size());

        for (int i = 0; i < first.size() + second.size() - 1; i++) {
            multiplyResult.add(0);
        }

        for (int i = 0; i < first.size(); i++) {
            for (int j = 0; j < second.size(); j++) {
                multiplyResult.set((i + j), multiplyResult.get(i + j) + first.get(i) * second.get(j));
            }
        }

        return multiplyResult;
    }
}
