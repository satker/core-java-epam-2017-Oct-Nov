package com.epam.courses.jf.practice.sskovalevskiy.second;

import com.epam.courses.jf.practice.common.second.ITestableTask12;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by asus on 28.10.2017.
 */
public class ITestableTask12Impl implements ITestableTask12 {
    @Override
    public List<Integer> transform(List<Integer> integers, int value) {


        Collections.sort(integers);
        return integers;
    }
}
