package com.epam.courses.jf.practice.vakhonin.second;

import com.epam.courses.jf.practice.common.second.ITestableTask11;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by igorvahonin on 13.11.17.
 */
public class Task11 implements ITestableTask11{

    @Override
    public String emulate(ArrayList<String> peoples){

        int size = peoples.size();
        int j = 0;
        int nextIndex = 0;
        while(size!=1){
            peoples.remove(nextIndex % size);
            j++;
            nextIndex = j % size;
            size--;
        }

        return peoples.get(0);
    }

    @Override
    public String emulate(LinkedList<String> peoples){

        int size = peoples.size();
        int j = 0;
        int nextIndex = 0;
        while(size!=1){
            peoples.remove(nextIndex % size);
            j++;
            nextIndex = j % size;
            size--;
        }
        return peoples.get(0);
    }

}
