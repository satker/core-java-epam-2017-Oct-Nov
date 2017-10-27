package com.epam.courses.jf.practice.klimenko.second;

import com.epam.courses.jf.practice.common.second.ITaskStorage;

public class TaskStorageImpl implements ITaskStorage {
    @Override
    public <T extends ITestableTask> T getSolver(Class<T> taskInterface) {
        return null;
    }
}
