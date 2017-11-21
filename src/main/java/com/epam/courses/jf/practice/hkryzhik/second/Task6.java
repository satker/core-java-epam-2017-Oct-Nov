package com.epam.courses.jf.practice.hkryzhik.second;

import com.epam.courses.jf.practice.common.second.ITestableTask6;

import java.util.HashMap;
import java.util.Map;

public class Task6 implements ITestableTask6 {
    @Override
    public HashMap<Integer, Integer> addPolynomials(HashMap<Integer, Integer> first, HashMap<Integer, Integer> second) {

        HashMap<Integer, Integer> result = new HashMap<>(first);

        result.putAll(second);

        if(first.size() > second.size()){
            second.keySet().forEach(e -> {
                if(first.containsKey(e)) {
                    result.put(e, first.get(e) + second.get(e));
                }
            });
        }else {
            first.keySet().forEach(e -> {
                if(second.containsKey(e)){
                    result.put(e, first.get(e) + second.get(e));
                }
            });
        }
        return result;
    }
}
