package com.epam.courses.jf.practice.asunyaev.second;

import com.epam.courses.jf.practice.common.second.ITaskStorage;

import java.util.HashMap;
import java.util.Map;

public class TaskStorage implements ITaskStorage {

    public <T extends ITestableTask> T getSolver(Class<T> taskInterface) {
        if (taskInterface == Task1.class) {
            return (T) new Task1();
        }
        if (taskInterface == Task2.class) {
            return (T) new Task2();
        }
        if (taskInterface == Task3.class) {
            return (T) new Task3();
        }
        if (taskInterface == Task4.class) {
            return (T) new Task4();
        }
        if (taskInterface == Task5.class) {
            return (T) new Task5();
        }
        if (taskInterface == Task6.class) {
            return (T) new Task6();
        }
        if (taskInterface == Task7.class) {
            return (T) new Task7();
        }
        if (taskInterface == Task8.class) {
            return (T) new Task8();
        }
        if (taskInterface == Task9.class) {
            return (T) new Task9();
        }
        if (taskInterface == Task10.class) {
            return (T) new Task10();
        }
        if (taskInterface == Task11.class) {
            return (T) new Task11();
        }
        if (taskInterface == Task12.class) {
            return (T) new Task12();
        }
        if (taskInterface == Task13.class) {
            return (T) new Task13();
        }
        if (taskInterface == Task14.class) {
            return (T) new Task14();
        }
        if (taskInterface == Task15.class) {
            return (T) new Task15();
        }
        return null;
    }
}
