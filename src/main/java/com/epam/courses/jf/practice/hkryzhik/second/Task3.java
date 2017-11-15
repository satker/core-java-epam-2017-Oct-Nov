package com.epam.courses.jf.practice.hkryzhik.second;

import com.epam.courses.jf.practice.common.second.ITestableTask3;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class Task3 implements ITestableTask3{

    @Override
    public List<String> sortPoems(Set<IPoem> poems, String author) {

        List<String> sortedLinesOfPoems = new ArrayList<>();

        for (IPoem poem : poems) {
            if(poem.getAuthor() == author){
                sortedLinesOfPoems.addAll(poem.getLines());
            }
        }

        sortedLinesOfPoems.sort((o1, o2) -> o1.length() - o2.length());

        return sortedLinesOfPoems;
    }
}
