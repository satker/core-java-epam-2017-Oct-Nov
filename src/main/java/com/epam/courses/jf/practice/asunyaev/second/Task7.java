package com.epam.courses.jf.practice.asunyaev.second;

import com.epam.courses.jf.practice.common.second.ITestableTask7;

import java.util.ArrayList;
import java.util.List;

public class Task7 implements ITestableTask7 {
    public List<Integer> multiplyPolynomials(List<Integer> first, List<Integer> second) {
        int n = first.size();
        int m = second.size();
        List<Integer> result = new ArrayList<>(n + m);
        for (int k = 0; k < n+m-1; ++k) {
            int s = 0;
            for (int i = 0; i <= k; ++i) {
                if (i >= n || k-i >= m) {
                    continue;
                }
                s += first.get(i) * second.get(k-i);
            }
            result.add(k, s);
        }
        return result;
    }
}
