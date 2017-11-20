package com.epam.courses.jf.practice.desided.second;

import com.epam.courses.jf.practice.common.second.ITestableTask7;

import java.util.ArrayList;
import java.util.List;

public class Task7 implements ITestableTask7{
    @Override
    public List<Integer> multiplyPolynomials(List<Integer> first, List<Integer> second) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < first.size() + second.size() ; i++){
            list.add(0);
        }

        for (int i = 0; i < first.size(); i++){
            for (int x = 0; x < second.size(); x++){
                list.set(i + x, first.get(i) + second.get(x));
            }
        }

        return list;
    }
}
