package com.epam.courses.jf.practice.vkostin.second;

import com.epam.courses.jf.practice.common.second.ITestableTask13;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

public class Task13 implements ITestableTask13 {

    /*
    public static void main(String[] args) {
        Task13 task = new Task13();
        AbstractGraph graph = task.createGraph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(0, 5);
        graph.addEdge(2, 1);
        graph.addEdge(5, 2);
        graph.addEdge(3, 1);
        graph.addEdge(4, 3);
        System.out.println(graph.isExistEdge(0, 4));
        graph.removeEdge(0, 4);
        System.out.println(graph.isExistEdge(0, 4));
    }
    */

    @Override
    public AbstractGraph createGraph(int numberNodes) {
        return new Graph(numberNodes);
    }

    private class Graph extends AbstractGraph {

        public Map<Integer, HashSet<Integer>> graphStructure = new LinkedHashMap<>();

        public Graph(int numberNodes) {
            super(numberNodes);
            for (int i = 0; i < NUMBER_NODES; ++i) {
                graphStructure.put(i, new HashSet<Integer>());
            }
        }

        @Override
        public void addEdge(int first, int second) {
            if (!graphStructure.get(first).contains(second)) {
                graphStructure.get(first).add(second);
                graphStructure.get(second).add(first);
            }
            System.out.println(graphStructure);

        }

        @Override
        public void removeEdge(int first, int second) {
            if (graphStructure.get(first).contains(second)) {
                graphStructure.get(first).remove(second);
                graphStructure.get(second).remove(first);
            }
            System.out.println(graphStructure);

        }

        @Override
        public boolean isExistEdge(int first, int second) {
            return graphStructure.get(first).contains(second);
        }
    }
}
