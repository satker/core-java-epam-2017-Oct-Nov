package com.epam.courses.jf.practice.asgalantsev.second;

import com.epam.courses.jf.practice.common.second.ITestableTask3;

import java.util.*;

public class Task3 implements ITestableTask3 {
    @Override
    public List<String> sortPoems(Set<IPoem> poems, String author) {
        List<String> list = Collections.emptyList();
        List<String> lines = new ArrayList<>();
        for (IPoem poem : poems) {
            if (poem.getAuthor().equals(author)) {
                lines.addAll(poem.getLines());
            }
        }
        if (lines.size() != 0)
            list = lines;

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() < s2.length())
                    return -1;
                else if (s1.length() > s2.length())
                    return 1;
                else
                    return 0;
            }
        });

        return list;
    }
}
