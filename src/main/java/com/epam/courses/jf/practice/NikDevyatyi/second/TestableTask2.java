package com.epam.courses.jf.practice.NikDevyatyi.second;

import com.epam.courses.jf.practice.common.second.ITestableTask2;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestableTask2 implements ITestableTask2 {
    @Override
    public Set<File> getFiles(File directory) {

        Set<File> fileTree = new HashSet<File>();
        List<File> res= new ArrayList<>();
        if(directory==null||directory.listFiles()==null){
            return fileTree;
        }
        for (File entry : directory.listFiles()) {
            if (entry.isFile()){
                //fileTree.add(entry);
                fileTree.add(entry);
            }
            else {
                //fileTree.addAll(getFiles(entry));
                fileTree.add(entry);
                fileTree.addAll(getFiles(entry));
            }
        }
        //for(File item : fileTree){
        //    System.out.println(item.toString());
        //}
        return fileTree;

    }
    private static File getAllFiles(File curDir) {
        File result  = null;
        File[] filesList = curDir.listFiles();
        for (File f : filesList) {
            if (f.isDirectory())
                getAllFiles(f);
            if (f.isFile()) {
                result =  f;
            }

        }
        return result;

    }


    }
