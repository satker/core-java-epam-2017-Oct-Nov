package com.epam.courses.jf.practice.mallayarov.second;

import com.epam.courses.jf.practice.common.second.ITestableTask13;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Task13Impl implements ITestableTask13 {

    @Override
    public AbstractGraph createGraph(int numberNodes) {
        return new MyAbstractGraph(numberNodes);
    }

    private class MyAbstractGraph extends AbstractGraph {

        HashMap<Integer, Set<Integer>> edgesMap = new HashMap<>(); // min key, list of values

        public MyAbstractGraph(int numberNodes) {
            super(numberNodes);
        }

        @Override
        public void addEdge(int first, int second) {
            int key = Math.min(first, second);
            int value = Math.max(first, second);
            if (!edgesMap.containsKey(key))
                edgesMap.put(key, new HashSet<>());
            edgesMap.get(key).add(value);
        }

        @Override
        public void removeEdge(int first, int second) {
            int key = Math.min(first, second);
            int value = Math.max(first, second);

            if (isExistEdge(key, value))
                edgesMap.get(key).remove(value);
        }

        @Override
        public boolean isExistEdge(int first, int second) {
            int key = Math.min(first, second);
            int value = Math.max(first, second);

            return edgesMap.containsKey(key) && edgesMap.get(key).contains(value);
        }
    }
}
