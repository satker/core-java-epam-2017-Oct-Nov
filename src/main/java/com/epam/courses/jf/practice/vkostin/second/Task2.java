package com.epam.courses.jf.practice.vkostin.second;

import com.epam.courses.jf.practice.common.second.ITestableTask2;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class Task2 implements ITestableTask2 {

    /*
    public static void main(String[] args) {

        Task2 task = new Task2();
        File directoryPath = new File("..\\vkostin");

        System.out.println(task.getFiles(directoryPath));
    }
    */

    @Override
    public Set<File> getFiles(File directory) {

        Set<File> files = new HashSet<>();
        File[] currentDirFiles = directory.listFiles();

        assert currentDirFiles != null;
        for (File elem : currentDirFiles) {
            if (elem.isDirectory()) {
                files.addAll(getFiles(elem));
            } else {
                files.add(elem);
            }
        }

        return files;
    }
}