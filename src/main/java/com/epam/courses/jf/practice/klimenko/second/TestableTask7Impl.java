package com.epam.courses.jf.practice.klimenko.second;

import com.epam.courses.jf.practice.common.second.ITestableTask7;

import java.util.Arrays;
import java.util.List;

public class TestableTask7Impl implements ITestableTask7 {
    @Override
    public List<Integer> multiplyPolynomials(List<Integer> first, List<Integer> second) {
        Integer[] ret = new Integer[first.size() + second.size()];
        for(int firstPower = 0; firstPower < first.size(); ++firstPower) {
            for(int secondPower = 0; secondPower < second.size(); ++secondPower) {
                ret[firstPower + secondPower] = first.get(firstPower) * second.get(secondPower);
            }
        }
        return Arrays.asList(ret);
    }
}
