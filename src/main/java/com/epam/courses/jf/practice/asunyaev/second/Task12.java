package com.epam.courses.jf.practice.asunyaev.second;

import com.epam.courses.jf.practice.common.second.ITestableTask12;

import java.util.Iterator;
import java.util.List;

public class Task12 implements ITestableTask12 {
    public List<Integer> transform(List<Integer> integers, int value) {
        Iterator<Integer> iterator = integers.iterator();
        while(iterator.hasNext()) {
            Integer current = iterator.next();
            if (current.compareTo(value) > 0) {
                iterator.remove();
                integers.add(current);
            }
        }
        return integers;
    }
}
