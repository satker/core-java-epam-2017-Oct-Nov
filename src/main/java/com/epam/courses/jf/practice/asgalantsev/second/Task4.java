package com.epam.courses.jf.practice.asgalantsev.second;

import com.epam.courses.jf.practice.common.second.ITestableTask4;

import java.util.Set;
import java.util.TreeSet;

public class Task4 implements ITestableTask4 {
    @Override
    public Set<Integer> intersection(Set<Integer> first, Set<Integer> second) {
        Set<Integer> firstCopy = new TreeSet<>(first);
        firstCopy.retainAll(second);
        return firstCopy;
    }

    @Override
    public Set<Integer> union(Set<Integer> first, Set<Integer> second) {
        Set<Integer> firstCopy = new TreeSet<>(first);
        firstCopy.addAll(second);
        return firstCopy;
    }
}
