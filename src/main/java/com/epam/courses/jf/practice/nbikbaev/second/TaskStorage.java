package com.epam.courses.jf.practice.nbikbaev.second;

import com.epam.courses.jf.practice.common.second.*;

public class TaskStorage implements ITaskStorage {

    @Override
    public <T extends ITestableTask> T getSolver(Class<T> taskInterface) {
        if (taskInterface == ITestableTask1.class){
            return (T) new Task1();
        }
        if (taskInterface == ITestableTask2.class){
            return (T) new Task2();
        }
        if (taskInterface == ITestableTask3.class){
            return (T) new Task3();
        }
        if (taskInterface == ITestableTask4.class){
            return (T) new Task4();
        }
        if (taskInterface == ITestableTask5.class){
            return (T) new Task5();
        }
        if (taskInterface == ITestableTask6.class){
            return (T) new Task6();
        }
        if (taskInterface == ITestableTask7.class){
            return (T) new Task7();
        }
        if (taskInterface == ITestableTask8.class){
            return (T) new Task8();
        }
        if (taskInterface == ITestableTask9.class){
            return (T) new Task9();
        }
        if (taskInterface == ITestableTask10.class){
            return (T) new Task10();
        }
        return null;
    }
}
