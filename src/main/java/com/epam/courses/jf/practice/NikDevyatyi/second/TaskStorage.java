package com.epam.courses.jf.practice.NikDevyatyi.second;

import com.epam.courses.jf.practice.common.second.ITaskStorage;

public class TaskStorage implements ITaskStorage {
    public <T extends ITestableTask> T getSolver(Class<T> taskInterface) {
        switch (taskInterface.getSimpleName()){
            case "ITestabaleTask1":
                return (T) new  TestableTask1();
        }
        switch (taskInterface.getSimpleName()){
            case "ITestabaleTask2":
                return (T) new  TestableTask2();
        }
        switch (taskInterface.getSimpleName()){
            case "ITestabaleTask3":
                return (T) new  TestableTask3();
        }
        return null;
    }
}
