package com.epam.courses.jf.practice.mallayarov.second;

import com.epam.courses.jf.practice.common.second.ITestableTask6;

import java.util.HashMap;

public class Task6Impl implements ITestableTask6 {
    @Override
    public HashMap<Integer, Integer> addPolynomials(HashMap<Integer, Integer> first, HashMap<Integer, Integer> second) {
        HashMap<Integer, Integer> result = new HashMap<>();
        HashMap<Integer, Integer> biggestPolynomial = first.size() >= second.size() ? first : second;
        HashMap<Integer, Integer> lowestPolynomial = first.size() < second.size() ? first : second;

        result.putAll(biggestPolynomial);
        for (Integer key : lowestPolynomial.keySet()) {
            int firstValue = first.getOrDefault(key, 0);
            int secondValue = second.getOrDefault(key, 0);

            result.putIfAbsent(key, 0);
            result.put(key, firstValue + secondValue);
        }
        return result;
    }
}
