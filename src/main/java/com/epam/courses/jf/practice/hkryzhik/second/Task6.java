package com.epam.courses.jf.practice.hkryzhik.second;

import com.epam.courses.jf.practice.common.second.ITestableTask6;

import java.util.HashMap;

public class Task6 implements ITestableTask6 {
    @Override
    public HashMap<Integer, Integer> addPolynomials(HashMap<Integer, Integer> first, HashMap<Integer, Integer> second) {

        if(first.size() > second.size()){
            second.keySet().forEach(e -> first.put(e, first.get(e) + second.get(e)));
            return first;
        }else {
            first.keySet().forEach(e -> second.put(e, first.get(e) + second.get(e)));
            return second;
        }
    }
}
