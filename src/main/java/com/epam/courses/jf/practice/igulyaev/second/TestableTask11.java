package com.epam.courses.jf.practice.igulyaev.second;

import com.epam.courses.jf.practice.common.second.ITestableTask11;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Arrays;

public class TestableTask11 implements ITestableTask11 {

    public String emulate(ArrayList<String> peoples) {
        return emulate(peoples);
    }


    public String emulate(LinkedList<String> peoples) {
        return emulate(peoples);
    }

    private String emulate(List<String> peoples) {
        int start = 0;
        while(peoples.size() > 1){
            for(Iterator<String> i = peoples.listIterator(start); i.hasNext() && i.next()!= null && i.hasNext();){
                i.remove();
            }
            start = (peoples.size() + 1) % 2;
        }
        return peoples.get(0);
    }
}
