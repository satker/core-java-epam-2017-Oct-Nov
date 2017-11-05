package com.epam.courses.jf.practice.igulyaev.second;

import com.epam.courses.jf.practice.common.second.ITaskStorage;
import com.epam.courses.jf.practice.common.second.ITestableTask2;

import java.util.HashMap;
import java.util.Map;

public class TaskStorage implements ITaskStorage {
    private Map<String, ITestableTask> taskMap;

    public TaskStorage() {
        taskMap = new HashMap<>();
        taskMap.put(ITestableTask2.class.getSimpleName(), new TestableTask2());
    }

    @Override
    public <T extends ITestableTask> T getSolver(Class<T> taskInterface) {
        return (T) taskMap.get(taskInterface);
    }
}
