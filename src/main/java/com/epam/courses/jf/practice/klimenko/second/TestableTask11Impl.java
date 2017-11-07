package com.epam.courses.jf.practice.klimenko.second;

import com.epam.courses.jf.practice.common.second.ITestableTask11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TestableTask11Impl implements ITestableTask11 {
    @Override
    public String emulate(ArrayList<String> peoples) {
        while (peoples.size() > 1) {
            for (int i = 0; i < peoples.size(); ++i) {
                peoples.remove(i);
            }
        }
        return peoples.get(0);
    }

    @Override
    public String emulate(LinkedList<String> peoples) {
        LinkedList<String> toErase = new LinkedList<>();
        while (peoples.size() > 1) {
            toErase.clear();
            for (Iterator<String> it = peoples.iterator(); it.hasNext();) {
                toErase.add(it.next());
                if(it.hasNext()) {
                    it.next();
                }
            }
            peoples.removeAll(toErase);
        }
        return peoples.get(0);
    }
}
