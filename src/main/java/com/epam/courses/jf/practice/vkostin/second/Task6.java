package com.epam.courses.jf.practice.vkostin.second;

import com.epam.courses.jf.practice.common.second.ITestableTask6;

import java.util.HashMap;
import java.util.Map;

public class Task6 implements ITestableTask6 {

    /*
    public static void main(String[] args) {
        HashMap<Integer,Integer> poly1 = new HashMap<>();
        HashMap<Integer,Integer> poly2 = new HashMap<>();

        poly1.put(4, 5);
        poly1.put(2, 10);
        poly1.put(0, 7);

        poly2.put(5, 8);
        poly2.put(3, 9);
        poly2.put(2, 2);

        Task6 task = new Task6();
        System.out.println(task.addPolynomials(poly1, poly2));
    }
    */

    @Override
    public HashMap<Integer, Integer> addPolynomials(HashMap<Integer, Integer> first, HashMap<Integer, Integer> second) {
        HashMap<Integer,Integer> resultPoly = new HashMap<>();
        Integer currentKey;

        resultPoly.putAll(first);

        for (Map.Entry<Integer,Integer> pair : second.entrySet()) {
            currentKey = pair.getKey();
            if (resultPoly.containsKey(currentKey)) {
                resultPoly.put(currentKey,
                        pair.getValue() + resultPoly.get(currentKey));
            } else {
                resultPoly.put(currentKey, pair.getValue());
            }
        }

        return resultPoly;
    }
}
