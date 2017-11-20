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
        switch (taskInterface.getSimpleName()){
            case "ITestableTask4":
                return (T) new  TestableTask4();
        }
        switch (taskInterface.getSimpleName()){
            case "ITestableTask5":
                return (T) new  TestableTask5();
        }
        switch (taskInterface.getSimpleName()){
            case "ITestableTask6":
                return (T) new  TestableTask6();
        }switch (taskInterface.getSimpleName()){
            case "ITestableTask7":
                return (T) new  TestableTask7();
        }switch (taskInterface.getSimpleName()){
            case "ITestableTask8":
                return (T) new  TestableTask8();
        }switch (taskInterface.getSimpleName()){
            case "ITestableTask9":
                return (T) new  TestableTask9();
        }switch (taskInterface.getSimpleName()){
            case "ITestableTask10":
                return (T) new  TestableTask10();
        }

        return null;
    }
}
