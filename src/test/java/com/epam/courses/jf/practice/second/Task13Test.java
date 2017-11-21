package com.epam.courses.jf.practice.second;

import org.junit.Assert;
import com.epam.courses.jf.practice.common.second.ITestableTask13;

/**
 * Проверяет выполнение тринадцатой задачи.
 *
 * Реализовать класс Graph, представляющий собой неориентированный граф.
 * В конструкторе класса передается количество вершин в графе.
 * Методы должны поддерживать быстрое добавление и удаление ребер.
 */
public class Task13Test extends AbstractTaskTest {

    /**
     * Пустой граф.
     */
    @org.junit.Test (timeout = 2000)
    public void test1() throws Exception {
        // Prepare
        ITestableTask13 solver = TASK_STORAGE.getSolver(ITestableTask13.class);
        final int SIZE = 5;

        // Run
        ITestableTask13.AbstractGraph graph = solver.createGraph(SIZE);

        // Asserts
        for (int i = 0; i < SIZE; ++i) {
            for (int j = 0; j < SIZE; ++j) {
                Assert.assertFalse(graph.isExistEdge(i, j));
            }
        }
    }

    /**
     * Добавление уже существующего ребра.
     */
    @org.junit.Test (timeout = 2000)
    public void test2() throws Exception {
        // Prepare
        ITestableTask13 solver = TASK_STORAGE.getSolver(ITestableTask13.class);

        // Run
        ITestableTask13.AbstractGraph graph = solver.createGraph(2);
        graph.addEdge(0, 1);
        graph.addEdge(0, 1);

        // Asserts
        Assert.assertTrue(graph.isExistEdge(0, 1));
    }

    /**
     * Добавление двух одинаковых ребер и удаление одного из них.
     */
    @org.junit.Test (timeout = 2000)
    public void test3() throws Exception {
        // Prepare
        ITestableTask13 solver = TASK_STORAGE.getSolver(ITestableTask13.class);

        // Run
        ITestableTask13.AbstractGraph graph = solver.createGraph(2);
        graph.addEdge(0, 1);
        graph.addEdge(0, 1);
        graph.removeEdge(0, 1);

        // Asserts
        Assert.assertFalse(graph.isExistEdge(0, 1));
    }

    /**
     * Создание полного графа.
     */
    @org.junit.Test (timeout = 2000)
    public void test4() throws Exception {
        // Prepare
        ITestableTask13 solver = TASK_STORAGE.getSolver(ITestableTask13.class);
        final int SIZE = 5;

        // Run
        ITestableTask13.AbstractGraph graph = solver.createGraph(SIZE);
        for (int i = 0; i < SIZE; ++i) {
            for (int j = 0; j < SIZE; ++j) {
                if (i != j) {
                    graph.addEdge(i, j);
                }
            }
        }

        // Asserts
        for (int i = 0; i < SIZE; ++i) {
            for (int j = 0; j < SIZE; ++j) {
                if (i != j) {
                    Assert.assertTrue(graph.isExistEdge(i, j));
                }
            }
        }
    }
}