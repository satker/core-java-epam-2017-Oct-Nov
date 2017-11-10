package com.epam.courses.jf.practice.mallayarov.second;

import com.epam.courses.jf.practice.common.second.ITestableTask11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Task11Impl implements ITestableTask11 {

    public static final int K = 2;

    @Override
    public String emulate(ArrayList<String> peoples) {
        int pointer = 0;

        while (peoples.size() > 1) {
            peoples.remove(pointer);
            pointer = (pointer + K - 1) % peoples.size();

        }
        return peoples.get(0);
    }

    @Override
    public String emulate(LinkedList<String> peoples) {
        int pointer = 0;
        while (peoples.size() > 1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (pointer % 2 == 0) {
                    iterator.remove();
                }
                ++pointer;
            }
        }

        return peoples.getFirst();
    }
}
