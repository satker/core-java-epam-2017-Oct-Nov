package com.epam.courses.jf.practice.igulyaev.second;

import com.epam.courses.jf.practice.common.second.ITestableTask6;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TestableTask6 implements ITestableTask6 {
    @Override
    public HashMap<Integer, Integer> addPolynomials(HashMap<Integer, Integer> first, HashMap<Integer, Integer> second) {
        int n  = Math.max(Collections.max(first.keySet()), Collections.max(second.keySet()));
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; ++i){
            Integer firstInt = first.get(i);
            Integer secondInt = second.get(i);
            if(!(firstInt == null && secondInt == null)){
                if(firstInt == null){
                    map.put(i, secondInt);
                } else if(secondInt == null){
                    map.put(i, firstInt);
                } else {
                    map.put(i, firstInt + secondInt);
                }
            }
        }
        return (HashMap<Integer,Integer>)map;
    }
}