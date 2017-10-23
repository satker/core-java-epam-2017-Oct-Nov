package com.epam.courses.jf.practice.second;

import com.epam.courses.jf.practice.common.second.ITaskStorage;

import java.io.File;
import java.net.URL;

/**
 * Базовый класс для классов юнит-тестирования задач, входящих во второе задание.
 * Инициализирует объект
 */
public abstract class AbstractTaskTest {

    /** Пакет в котором расположена реализация второго задания. */
    private static final String STORAGE_PACKAGE = "com.epam.courses.jf.practice." + System.getProperty("branch") + ".second";

    /** Хранилище, содержащее объекты, реализующие второе задание. */
    protected final ITaskStorage TASK_STORAGE;

    /**
     * @return Объект, реализующий второе задание.
     */
    private static ITaskStorage getStorage() {
        URL ruURL = Thread.currentThread().getContextClassLoader().getResource(".");
        if (ruURL == null) {
            throw new IllegalArgumentException("There is no package with TaskStorage!");
        }
        File rootFile = new File(ruURL.getPath()).getParentFile();
        File studentDirectory = new File(rootFile.getAbsolutePath() + "/classes/" + STORAGE_PACKAGE.replace(".", "/"));
        return AbstractTaskTest.find(studentDirectory);
    }

    /**
     * Осуществляет поиск класса, реализующего интерфейс {@link ITaskStorage}.
     * @param file Поиск осуществляется в указанной директории.
     * @return Объект класса, реализующего второе задание.
     */
    private static ITaskStorage find(File file) {
        String fileName = file.getName();
        if (file.isDirectory()) {
            File[] children = file.listFiles();
            if (children != null) {
                for (File child : children) {
                    ITaskStorage result = AbstractTaskTest.find(child);
                    if (result != null) {
                        return result;
                    }
                }
            }
            throw new IllegalArgumentException("TaskStorage not found!");
        } else if (fileName.endsWith(".class")) {
            try {
                Class someClass = Class.forName(STORAGE_PACKAGE + "." + fileName.substring(0, fileName.length() - ".class".length()));
                return ITaskStorage.class.isAssignableFrom(someClass) ? (ITaskStorage)someClass.newInstance() : null;
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
        throw new RuntimeException("Not a directory: " + file);
    }

    protected AbstractTaskTest() {
        TASK_STORAGE = AbstractTaskTest.getStorage();
    }
}
