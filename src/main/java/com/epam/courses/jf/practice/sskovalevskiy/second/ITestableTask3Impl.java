package com.epam.courses.jf.practice.sskovalevskiy.second;

import com.epam.courses.jf.practice.common.second.ITestableTask3;

import java.util.*;

/**
 * Created by asus on 23.10.2017.
 */
public class ITestableTask3Impl implements ITestableTask3 {
    @Override
    public List<String> sortPoems(Set<IPoem> poems, String author) {

        List<String> sortedByAuthorPoemsLines = new ArrayList<>();

        for (IPoem poem : poems) {
            if (poem.getAuthor().equals(author)) {
                for (String poemLine : poem.getLines()) {
                    sortedByAuthorPoemsLines.add(poemLine);
                }
            }
        }

        Collections.sort(sortedByAuthorPoemsLines, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        return sortedByAuthorPoemsLines;
    }
}
