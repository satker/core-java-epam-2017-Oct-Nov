package com.epam.courses.jf.practice.mallayarov.second;

import com.epam.courses.jf.practice.common.second.ITestableTask3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class Task3Impl implements ITestableTask3 {
    @Override
    public List<String> sortPoems(Set<IPoem> poems, String author) {
        List<String> result = new ArrayList<>();
        for (IPoem poem : poems) {
            if (poem.getAuthor().equals(author)) {
                result.addAll(poem.getLines());
            }
        }

        result.sort(Comparator.comparingInt(String::length));
        return result;
    }
}
