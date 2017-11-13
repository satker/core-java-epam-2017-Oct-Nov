package com.epam.courses.jf.practice.asunyaev.second;

import com.epam.courses.jf.practice.common.second.ITestableTask12;

import java.util.Iterator;
import java.util.List;

public class Task12 implements ITestableTask12 {
    public List<Integer> transform(List<Integer> integers, int value) {
        for (int i = 0; i < integers.size(); i++) {
            Integer current = integers.get(i);
            if (current.compareTo(value) > 0) {
                integers.set(i, integers.get(integers.size() - 1));
                integers.set(integers.size() - 1, integers.get(i));
            }
        }
        return integers;
    }
}
