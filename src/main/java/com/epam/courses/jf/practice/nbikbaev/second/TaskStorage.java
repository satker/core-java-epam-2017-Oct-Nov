package com.epam.courses.jf.practice.nbikbaev.second;

import com.epam.courses.jf.practice.common.second.ITaskStorage;

public class TaskStorage implements ITaskStorage {

    @Override
    public <T extends ITestableTask> T getSolver(Class<T> taskInterface) {
        return (T) new Task1();
    }
}
