package com.epam.courses.jf.practice.igulyaev.second;

import com.epam.courses.jf.practice.common.second.ITaskStorage;
import com.epam.courses.jf.practice.common.second.*;

import java.util.HashMap;
import java.util.Map;

public class TaskStorage implements ITaskStorage {
    private Map<String, ITestableTask> taskMap;

    public TaskStorage() {
        taskMap = new HashMap<>();
        taskMap.put(ITestableTask1.class.getSimpleName(), new TestableTask1());
        taskMap.put(ITestableTask2.class.getSimpleName(), new TestableTask2());
        taskMap.put(ITestableTask3.class.getSimpleName(), new TestableTask3());
        taskMap.put(ITestableTask4.class.getSimpleName(), new TestableTask4());
        taskMap.put(ITestableTask6.class.getSimpleName(), new TestableTask6());
    }

    @Override
    public <T extends ITestableTask> T getSolver(Class<T> taskInterface) {
        return (T) taskMap.get(taskInterface);
    }
}
