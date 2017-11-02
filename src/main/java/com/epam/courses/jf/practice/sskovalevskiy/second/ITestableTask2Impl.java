package com.epam.courses.jf.practice.sskovalevskiy.second;

import com.epam.courses.jf.practice.common.second.ITestableTask2;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by asus on 25.10.2017.
 */
public class ITestableTask2Impl implements ITestableTask2 {
    @Override
    public Set<File> getFiles(File directory) {
        Set<File> files = new HashSet<>();

        for (File file : directory.listFiles()){
            if (file.isDirectory()){
                files.add(file);
                files.addAll(getFiles(file));
            } else {
                files.add(file);
            }
        }
        return files;
    }
}
