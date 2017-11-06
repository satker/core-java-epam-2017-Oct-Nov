package com.epam.courses.jf.practice.klimenko.second;

import com.epam.courses.jf.practice.common.second.ITestableTask13;

public class TestableTask13Impl implements ITestableTask13 {
    @Override
    public AbstractGraph createGraph(int numberNodes) {
        return new GraphImpl(numberNodes);
    }

    private class GraphImpl extends AbstractGraph {
        private Boolean[][] edges;

        GraphImpl(int numberNodes) {
            super(numberNodes);
            edges = new Boolean[numberNodes][numberNodes];
        }

        @Override
        public void addEdge(int first, int second) {
            edges[first][second] = edges[second][first] = true;
        }

        @Override
        public void removeEdge(int first, int second) {
            edges[first][second] = edges[second][first] = false;
        }

        @Override
        public boolean isExistEdge(int first, int second) {
            return edges[first][second];
        }
    }
}
