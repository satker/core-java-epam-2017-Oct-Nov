package com.epam.courses.jf.practice.SigarevVL.second;

import com.epam.courses.jf.practice.common.second.ITestableTask6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Task6 implements ITestableTask6 {

    @Override
    public HashMap<Integer, Integer> addPolynomials(HashMap<Integer, Integer> first, HashMap<Integer, Integer> second) {
        HashMap<Integer, Integer> resultPolynomial = new HashMap<>(first);

        for (Map.Entry<Integer, Integer> entry : second.entrySet()) {

            if (resultPolynomial.containsKey(entry.getKey())) {
                int sum = resultPolynomial.get(entry.getKey()) + entry.getValue();
                resultPolynomial.put(entry.getKey(), sum);
            } else {
                resultPolynomial.put(entry.getKey(), entry.getValue());
            }
        }
        return resultPolynomial;
    }
}
