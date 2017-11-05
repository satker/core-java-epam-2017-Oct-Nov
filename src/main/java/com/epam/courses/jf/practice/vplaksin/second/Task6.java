package com.epam.courses.jf.practice.vplaksin.second;

import com.epam.courses.jf.practice.common.second.ITestableTask6;

import java.util.HashMap;

public class Task6 implements ITestableTask6 {

    @Override
    public HashMap<Integer, Integer> addPolynomials(HashMap<Integer, Integer> first, HashMap<Integer, Integer> second) {

        HashMap<Integer, Integer> result = new HashMap<>(first);

        for (Integer key : second.keySet()) {
            if (result.containsKey(key)) {
                result.put(key, result.get(key) + second.get(key));
            } else {
                result.put(key, second.get(key));
            }
        }

        return result;

    }

}
