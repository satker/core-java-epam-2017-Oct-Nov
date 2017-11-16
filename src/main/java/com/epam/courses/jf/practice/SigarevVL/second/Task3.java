package com.epam.courses.jf.practice.SigarevVL.second;

import com.epam.courses.jf.practice.common.second.ITestableTask3;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Task3 implements ITestableTask3 {

    @Override
    public List<String> sortPoems(Set<IPoem> poems, String author) {
        List<String> list = new ArrayList<>();

        for (IPoem poem : poems) {
            if (poem.getAuthor().equals(author)) {
                for (String string : poem.getLines()) {
                    list.add(string);
                }
            }
        }
        Collections.sort(list, (a, b) -> a.length() - b.length());

        return list;
    }

}
