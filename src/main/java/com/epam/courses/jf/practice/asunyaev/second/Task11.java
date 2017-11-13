package com.epam.courses.jf.practice.asunyaev.second;

import com.epam.courses.jf.practice.common.second.ITestableTask11;

import java.util.ArrayList;
import java.util.LinkedList;

public class Task11 implements ITestableTask11 {

    public String emulate(ArrayList<String> peoples) {
        int i = 0;
        while(peoples.size() > 1) {
            peoples.remove(i);
            i++;
            if (i == peoples.size()) {
                i = 0;
            }
        }
        return peoples.get(0);
    }

    public String emulate(LinkedList<String> peoples) {
        int i = 0;
        while(peoples.size() > 1) {
            peoples.remove(i);
            i++;
            if (i == peoples.size()) {
                i = 0;
            }
        }
        return peoples.get(0);
    }
}
