package com.epam.courses.jf.practice.nbikbaev.second;

import com.epam.courses.jf.practice.common.second.ITestableTask11;

import java.util.*;

public class Task11 implements ITestableTask11 {
    @Override
    public String emulate(ArrayList<String> peoples) {
        while (peoples.size() != 1) {
            if (peoples.size() % 2 == 0) {
                excludeEachSecond(peoples);
            } else {
                excludeEachSecond(peoples);
                Collections.rotate(peoples, -1);
            }
        }
        return peoples.get(0);
    }

    private void excludeEachSecond(List<String> peoples) {
        for (int i = 0; i < peoples.size(); ++i) {
            peoples.remove(i);
        }
    }

    @Override
    public String emulate(LinkedList<String> peoples) {
        int k = 0;
        while (peoples.size() > 1) {
            ListIterator iterator = peoples.listIterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (k % 2 == 0) {
                    iterator.remove();
                }
                k++;
            }
        }
        return peoples.get(0);
    }
}
