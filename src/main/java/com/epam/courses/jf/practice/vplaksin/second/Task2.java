package com.epam.courses.jf.practice.vplaksin.second;

import com.epam.courses.jf.practice.common.second.ITestableTask2;

import java.io.File;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.HashSet;

public class Task2 implements ITestableTask2 {

    @Override
    public Set<File> getFiles(File directory) {
        Set<File> result = new HashSet<>();
        Queue<File> queue = new LinkedList<>();
        Collections.addAll(queue, directory.listFiles());

        while (!queue.isEmpty()) {
            File file = queue.remove();
            if (file.isDirectory()) {
                Collections.addAll(queue, file.listFiles());
            }
            result.add(file);
        }

        return result;
    }

}
