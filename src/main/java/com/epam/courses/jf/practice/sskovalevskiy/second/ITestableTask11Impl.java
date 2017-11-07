package com.epam.courses.jf.practice.sskovalevskiy.second;

import com.epam.courses.jf.practice.common.second.ITestableTask11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by asus on 01.11.2017.
 */
public class ITestableTask11Impl implements ITestableTask11 {
    @Override
    public String emulate(ArrayList<String> peoples) {
        return removeEvery2ndElement(peoples);
    }

    @Override
    public String emulate(LinkedList<String> peoples) {
        return removeEvery2ndElement(peoples);
    }

    private String removeEvery2ndElement(List<String> peoples){
        boolean previousElementWasRemoved = false;
        while (peoples.size() > 1){
            Iterator iterator = peoples.iterator();
            while (iterator.hasNext()){
                iterator.next();
                if (!previousElementWasRemoved){
                    iterator.remove();
                    previousElementWasRemoved = true;
                } else {
                    previousElementWasRemoved = false;
                }
            }
        }
        return peoples.get(0);
    }
}
