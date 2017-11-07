package com.epam.courses.jf.practice.sskovalevskiy.second;

import com.epam.courses.jf.practice.common.second.ITestableTask11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by asus on 01.11.2017.
 */
public class ITestableTask11Impl implements ITestableTask11 {
    @Override
    public String emulate(ArrayList<String> peoples) {
        ArrayList<String> persons = new ArrayList<>(peoples);
        while (persons.size() > 1) {
            Iterator iterator = persons.iterator();
            for (int i = 0; iterator.hasNext(); i++, iterator.next()) {
                if (i % 2 == 1) {
                    i = 0;
                    iterator.remove();
                }
            }
        }
        return persons.get(0);
    }

    @Override
    public String emulate(LinkedList<String> peoples) {
        LinkedList<String> persons = new LinkedList<>(peoples);
        while (persons.size() > 1) {
            Iterator iterator = persons.iterator();
            for (int i = 0; iterator.hasNext(); i++, iterator.next()) {
                if (i % 2 == 1) {
                    i = 0;
                    iterator.remove();
                }
            }
        }
        return persons.get(0);
    }
}
