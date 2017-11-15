package com.epam.courses.jf.practice.nzenkova.second;

import com.epam.courses.jf.practice.common.second.ITestableTask3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;


public class TestableTask3 implements ITestableTask3 {
    @Override
    public List<String> sortPoems(Set<IPoem> poems, String author) {
        ArrayList<String> list = new ArrayList<>();
        for (IPoem poem : poems) {
            if (poem.getAuthor().equals(author)) {
                list.addAll(poem.getLines());
            }
        }
        list.sort(Comparator.comparingInt(String::length));

        return list;
    }
}
