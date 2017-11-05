package com.epam.courses.jf.practice.vplaksin.second;

import com.epam.courses.jf.practice.common.second.ITestableTask12;

import java.util.List;

public class Task12 implements ITestableTask12 {

    @Override
    public List<Integer> transform(List<Integer> integers, int value) {

        loop:
        for (int i = 0; i < integers.size(); i++) {
            if (integers.get(i) >= value) {
                for (int j = integers.size() - 1; j > i; j--) {
                    if (integers.get(j) < value) {
                        integers.set(i, integers.get(i) ^ integers.get(j));
                        integers.set(j, integers.get(i) ^ integers.get(j));
                        integers.set(i, integers.get(i) ^ integers.get(j));
                        continue loop;
                    }
                }

                if (integers.get(i) > value) {
                    for (int j = integers.size() - 1; j > i; j--) {
                        if (integers.get(j) == value) {
                            integers.set(i, integers.get(i) ^ integers.get(j));
                            integers.set(j, integers.get(i) ^ integers.get(j));
                            integers.set(i, integers.get(i) ^ integers.get(j));
                            continue loop;
                        }
                    }
                }
            }
        }

        return integers;

    }

}

