package com.epam.courses.jf.practice.nzenkova.second;

import com.epam.courses.jf.practice.common.second.ITaskStorage;

public class TaskStorage implements ITaskStorage{
    @Override
    public <T extends ITestableTask> T getSolver(Class<T> taskInterface) {
        String taskInterfaceName = taskInterface.getSimpleName();
        switch(taskInterfaceName){
            case "ITestableTask1": return (T) new TestableTask1();
            default: return null;
        }
    }
}
