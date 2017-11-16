package com.epam.courses.jf.practice.SigarevVL.second;

import com.epam.courses.jf.practice.common.second.ITestableTask2;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class Task2 implements ITestableTask2 {

    @Override
    public Set<File> getFiles(File directory) {

        Set<File> set = new HashSet<>();

        for (File unit : directory.listFiles()) {
            if (unit.isDirectory()) {
                set.add(unit);
                set.addAll(getFiles(unit));
            } else {
                set.add(unit);
            }
        }

        return set;

    }

}
