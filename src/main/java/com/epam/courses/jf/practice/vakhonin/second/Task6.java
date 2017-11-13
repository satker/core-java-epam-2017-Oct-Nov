package com.epam.courses.jf.practice.vakhonin.second;

import com.epam.courses.jf.practice.common.second.ITestableTask6;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by igorvahonin on 13.11.17.
 */
public class Task6 implements ITestableTask6{

    @Override
    public HashMap<Integer, Integer> addPolynomials(HashMap<Integer, Integer> first, HashMap<Integer, Integer> second) {
        HashMap<Integer, Integer> sumSet = new HashMap<>(first);

        Integer value1, value2, sum;

        for(Integer key: second.keySet()){
            value2 = second.get(key);
            if(first.containsKey(key)){
                value1 = first.get(key);
                sum = value1 + value2;
                sumSet.put(key, sum);
            }
            else{
                sumSet.put(key, value2);
            }
        }
        
        return sumSet;
    }

}
