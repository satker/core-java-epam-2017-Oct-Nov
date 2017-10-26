package com.epam.courses.jf.practice.sskovalevskiy.second;

import com.epam.courses.jf.practice.common.second.ITestableTask4;

import java.util.Set;

/**
 * Created by asus on 24.10.2017.
 */
public class ITestableTask4Impl implements ITestableTask4 {
    @Override
    public Set<Integer> intersection(Set<Integer> first, Set<Integer> second) {
        first.retainAll(second);
        return first;
    }

    @Override
    public Set<Integer> union(Set<Integer> first, Set<Integer> second) {
        first.addAll(second);
        return first;
    }
}
