package com.epam.courses.jf.practice.nbikbaev.second;

import com.epam.courses.jf.practice.common.second.*;

public class TaskStorage implements ITaskStorage {

    @Override
    public <T extends ITestableTask> T getSolver(Class<T> taskInterface) {
        if (ITestableTask1.class.equals(taskInterface)) {
            return (T) new Task1();
        }
        if (ITestableTask2.class.equals(taskInterface)) {
            return (T) new Task2();
        }
        if (ITestableTask3.class.equals(taskInterface)) {
            return (T) new Task3();
        }
        if (ITestableTask4.class.equals(taskInterface)) {
            return (T) new Task4();
        }
        return null;
    }
}
