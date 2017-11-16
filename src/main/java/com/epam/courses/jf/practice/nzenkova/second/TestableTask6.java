package com.epam.courses.jf.practice.nzenkova.second;

import com.epam.courses.jf.practice.common.second.ITestableTask6;

import java.util.HashMap;


public class TestableTask6 implements ITestableTask6 {
    @Override
    public HashMap<Integer, Integer> addPolynomials(HashMap<Integer, Integer> first, HashMap<Integer, Integer> second) {
        for (Integer integer : second.keySet()) {
            Integer toPut = 0;
            if (first.get(integer) != null) toPut += first.get(integer);
            if (second.get(integer) != null) toPut += second.get(integer);
            first.put(integer, toPut);
        }

        return first;
    }
}
