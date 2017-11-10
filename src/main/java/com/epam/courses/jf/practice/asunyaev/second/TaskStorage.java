package com.epam.courses.jf.practice.asunyaev.second;

import com.epam.courses.jf.practice.common.second.ITaskStorage;

public class TaskStorage implements ITaskStorage {

    public <T extends ITestableTask> T getSolver(Class<T> taskInterface) {
        String interfaceName = taskInterface.getSimpleName();

        switch(interfaceName) {
            case "ITestableTask1":
                return (T) new Task1();
            default:
                return null;
        }
    }
}
