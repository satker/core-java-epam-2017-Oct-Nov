package com.epam.courses.jf.practice.asunyaev.second;

import com.epam.courses.jf.practice.common.second.ITaskStorage;

public class TaskStorage implements ITaskStorage {

    public <T extends ITestableTask> T getSolver(Class<T> taskInterface) {
        String taskInterfaceName = taskInterface.getSimpleName();

        switch(taskInterfaceName) {
            case "ITestableTask1":
                return (T) new Task1();
            case "ITestableTask2":
                return (T) new Task2();
            default:
                return null;
        }
    }
}
