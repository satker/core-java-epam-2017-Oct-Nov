package com.epam.courses.jf.practice.igulyaev.second;

import com.epam.courses.jf.practice.common.second.ITaskStorage;

public class TaskStorage implements ITaskStorage {
    @Override
    public <T extends ITestableTask> T getSolver(Class<T> taskInterface) {
        switch (taskInterface.getSimpleName()){
            case "ITestableTask2":
                return (T) new TestableTask2();
            default:
                return null;
        }
    }
}
