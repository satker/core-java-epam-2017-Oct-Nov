package com.epam.courses.jf.practice.desided.second;

import com.epam.courses.jf.practice.common.second.ITestableTask4;

import java.util.HashSet;
import java.util.Set;

public class Task4 implements ITestableTask4{


    @Override
    public Set<Integer> intersection(Set<Integer> first, Set<Integer> second) {

        Set<Integer> res = new HashSet<>(first);
        res.retainAll(second);
        return res;
    }

    @Override
    public Set<Integer> union(Set<Integer> first, Set<Integer> second) {

        Set<Integer> res = new HashSet<>(first);
        res.addAll(second);
        return res;
    }
}
