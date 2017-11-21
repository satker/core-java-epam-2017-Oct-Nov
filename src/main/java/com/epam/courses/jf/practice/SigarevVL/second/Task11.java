package com.epam.courses.jf.practice.SigarevVL.second;

import com.epam.courses.jf.practice.common.second.ITestableTask11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Task11 implements ITestableTask11 {

    @Override
    public String emulate(ArrayList<String> peoples) {
        int i = 1;
        while (peoples.size() != 1)  {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                i++;
                iterator.next();
                if (i == 2) {
                    iterator.remove();
                    i = 0;
                }
            }
        }
        return peoples.get(0);
    }

    @Override
    public String emulate(LinkedList<String> peoples) {
        int i = 1;
        while (peoples.size() != 1)  {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                i++;
                iterator.next();
                if (i == 2) {
                    iterator.remove();
                    i = 0;
                }
            }
        }
        return peoples.get(0);
    }
}
