package com.epam.courses.jf.practice.NikDevyatyi.second;

import com.epam.courses.jf.practice.common.second.ITestableTask4;

import java.util.Set;

public class TestableTask4 implements ITestableTask4 {
    @Override
    public Set<Integer> intersection(Set<Integer> first, Set<Integer> second) {
        Set<Integer> result;
        result = first;
        result.retainAll(second);
        return result;
    }

    @Override
    public Set<Integer> union(Set<Integer> first, Set<Integer> second) {
        Set<Integer> result;
        result = first;
        result.addAll(second);
        return result;
    }
}
