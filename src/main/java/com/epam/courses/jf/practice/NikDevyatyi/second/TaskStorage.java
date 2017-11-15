package com.epam.courses.jf.practice.NikDevyatyi.second;

import com.epam.courses.jf.practice.common.second.ITaskStorage;

public class TaskStorage implements ITaskStorage {
    public <T extends ITestableTask> T getSolver(Class<T> taskInterface) {
        switch (taskInterface.getSimpleName()){
            case "ITestableTask1":
                return (T) new  TestableTask1();
        }
        switch (taskInterface.getSimpleName()){
            case "ITestableTask2":
                return (T) new  TestableTask2();
        }
        switch (taskInterface.getSimpleName()){
            case "ITestableTask3":
                return (T) new  TestableTask3();
        }
        return null;
    }
}
