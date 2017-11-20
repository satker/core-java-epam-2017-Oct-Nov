package com.epam.courses.jf.practice.desided.second;

import com.epam.courses.jf.practice.common.second.ITestableTask6;

import java.util.HashMap;
import java.util.Map;

public class Task6 implements ITestableTask6{

    @Override
    public HashMap<Integer, Integer> addPolynomials(HashMap<Integer, Integer> first, HashMap<Integer, Integer> second) {

        HashMap<Integer, Integer> res = new HashMap<>(first);

        for (Map.Entry entry : second.entrySet()){

            if (res.containsKey(entry.getKey())){
                res.put((int)entry.getKey(), (int) entry.getValue() + res.get(entry.getKey()));
            }
            else {
                res.put((int)entry.getKey(), (int) entry.getValue());
            }
        }
        return res;
    }
}
