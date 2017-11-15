package com.epam.courses.jf.practice.nzenkova.second;

import com.epam.courses.jf.practice.common.second.ITestableTask2;

import java.io.File;
import java.util.Set;
import java.util.TreeSet;


public class TestableTask2 implements ITestableTask2 {
    private Set<File> set = new TreeSet<>();

    @Override
    public Set<File> getFiles(File directory) {
        getAll(directory.listFiles());
        return set;
    }

    /**
     * обход всех вложенных файлов и директорий
     *
     * @param files массив файлов и директорий
     */
    private void getAll(File[] files) {
        for (File file : files) {
            if (file.isDirectory()) {
                getAll(file.listFiles());
            }
        }
        for (File file : files) {
            set.add(new File(String.valueOf(file.getAbsoluteFile())));
        }
    }
}
