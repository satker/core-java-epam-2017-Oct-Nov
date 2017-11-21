package com.epam.courses.jf.practice.asgalantsev.second;

import com.epam.courses.jf.practice.common.second.ITestableTask13;

public class Task13 implements ITestableTask13 {
    @Override
    public AbstractGraph createGraph(int numberNodes) {
        return null;
    }

    class Graph extends AbstractGraph {


        public Graph(int numberNodes) {
            super(numberNodes);
        }

        @Override
        public void addEdge(int first, int second) {

        }

        @Override
        public void removeEdge(int first, int second) {

        }

        @Override
        public boolean isExistEdge(int first, int second) {
            return false;
        }
    }
}
