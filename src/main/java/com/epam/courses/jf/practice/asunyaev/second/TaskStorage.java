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
            case "ITestableTask3":
                return (T) new Task3();
            case "ITestableTask4":
                return (T) new Task4();
            case "ITestableTask5":
                return (T) new Task5();
            case "ITestableTask6":
                return (T) new Task6();
            case "ITestableTask7":
                return (T) new Task7();
            default:
                return null;
        }
    }
}
