package com.epam.courses.jf.practice.first;

import com.epam.courses.jf.practice.common.first.ISolver;

import java.io.File;
import java.net.URL;

/**
 * Фабрика объектов, решающих первое задание.
 * Определение конкретного экземпляра основывается на системном свойстве 'branch'.
 */
class SolverFactory {

    /** Пакет в котором расположена реализация первого задания */
    private static final String SOLVER_PACKAGE = "com.epam.courses.jf.practice." + System.getProperty("branch") + ".first";

    /**
     * @return Объект, реализующий первое задание
     */
    static ISolver getInstance() {
        URL ruURL = Thread.currentThread().getContextClassLoader().getResource(".");
        if (ruURL == null) {
            throw new IllegalArgumentException("There is no package with Solver!");
        }
        File rootFile = new File(ruURL.getPath()).getParentFile();
        File studentDirectory = new File(rootFile.getAbsolutePath() + "/classes/" + SOLVER_PACKAGE.replace(".", "/"));
        return SolverFactory.find(studentDirectory);
    }

    /**
     * Осуществляет поиск класса, реализующего интерфейс {@link ISolver}.
     * @param file Поиск осуществляется в указанной директории.
     * @return Объект класса, реализующего первого задание.
     */
    private static ISolver find(File file) {
	    String fileName = file.getName();
        if (file.isDirectory()) {
            File[] children = file.listFiles();
            if (children != null) {
                for (File child : children) {
                    ISolver result = SolverFactory.find(child);
                    if (result != null) {
                        return result;
                    }
                }
            }
            throw new IllegalArgumentException("Solver not found!");
        } else if (fileName.endsWith(".class")) {
            try {
                Class someClass = Class.forName(SOLVER_PACKAGE + "." + fileName.substring(0, fileName.length() - ".class".length()));
                return ISolver.class.isAssignableFrom(someClass) ? (ISolver)someClass.newInstance() : null;
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
        throw new RuntimeException("Not a directory: " + file);
    }
}
