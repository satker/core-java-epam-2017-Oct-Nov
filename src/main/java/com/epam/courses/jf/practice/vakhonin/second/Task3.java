package com.epam.courses.jf.practice.vakhonin.second;

import com.epam.courses.jf.practice.common.second.ITestableTask3;

import java.util.*;

/**
 * Created by igorvahonin on 13.11.17.
 */
public class Task3 implements ITestableTask3{
    @Override
    public List<String> sortPoems(Set<IPoem> poems, String author) {

        List<String> strings = new ArrayList<>();

        for (IPoem poem: poems){
            if(poem.getAuthor().equals(author)){
                 strings.addAll(poem.getLines());
            }
        }

        strings.sort(new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s2.length() - s1.length();
            }
        });
        
        return strings;
    }
}
