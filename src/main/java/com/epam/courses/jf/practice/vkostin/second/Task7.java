package com.epam.courses.jf.practice.vkostin.second;

import com.epam.courses.jf.practice.common.second.ITestableTask7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Task7 implements ITestableTask7 {

    /*
    public static void main(String[] args) {
        List<Integer> poly1 = Arrays.asList(0, 1, 3, 7, 0, 0, 5);
        List<Integer> poly2 = Arrays.asList(5, 0, 4);

        Task7 task = new Task7();
        System.out.println(task.multiplyPolynomials(poly1, poly2));
    }
    */

    @Override
    public List<Integer> multiplyPolynomials(List<Integer> first, List<Integer> second) {

        List<Integer> resultPoly = new ArrayList<>(Collections
                .nCopies((first.size() - 1) + (second.size() - 1) + 1, 0));

        System.out.println(resultPoly);

        for (int i = 0; i < first.size(); ++i) {
            for (int j = 0; j < second.size(); ++j) {
                resultPoly.set(i + j, resultPoly.get(i + j) + first.get(i) * second.get(j));
            }
        }

        return resultPoly;
    }
}
