package com.epam.courses.jf.practice.vakhonin.second;

import com.epam.courses.jf.practice.common.second.ITestableTask12;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by igorvahonin on 13.11.17.
 */
public class Task12 implements ITestableTask12{

    @Override
    public List<Integer> transform(List<Integer> integers, int value) {
        Set<Integer> set = new TreeSet<>(integers);

        List<Integer> list = new ArrayList<>(set);



        return list;
    }
}
