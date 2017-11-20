package com.epam.courses.jf.practice.SigarevVL.second;

import com.epam.courses.jf.practice.common.second.ITestableTask4;

import java.util.HashSet;
import java.util.Set;

public class Task4 implements ITestableTask4 {

    @Override
    public Set<Integer> intersection(Set<Integer> first, Set<Integer> second) {
        Set<Integer> intersectionOfMany = new HashSet<>(first);
        intersectionOfMany.retainAll(second);
        return intersectionOfMany;
    }

    @Override
    public Set<Integer> union(Set<Integer> first, Set<Integer> second) {
        Set<Integer> unionOfMany = new HashSet<>(first);
        unionOfMany.addAll(second);
        return null;
    }
}
