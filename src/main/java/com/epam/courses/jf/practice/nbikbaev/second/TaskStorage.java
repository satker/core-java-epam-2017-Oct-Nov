package com.epam.courses.jf.practice.nbikbaev.second;

import com.epam.courses.jf.practice.common.second.ITaskStorage;
import com.epam.courses.jf.practice.common.second.ITestableTask1;
import com.epam.courses.jf.practice.common.second.ITestableTask2;

public class TaskStorage implements ITaskStorage {

    @Override
    public <T extends ITestableTask> T getSolver(Class<T> taskInterface) {
        if (ITestableTask1.class.equals(taskInterface)) {
            return (T) new Task1();
        }
        if (ITestableTask2.class.equals(taskInterface)) {
            return (T) new Task2();
        }
        return null;
    }
}
