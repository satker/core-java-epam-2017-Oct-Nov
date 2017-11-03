package com.epam.courses.jf.practice.sskovalevskiy.second;

import com.epam.courses.jf.practice.common.second.ITestableTask13;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by asus on 01.11.2017.
 */
public class ITestableTask13Impl implements ITestableTask13 {
    @Override
    public AbstractGraph createGraph(int numberNodes) {
        return new Graph(numberNodes);
    }


    class Graph extends AbstractGraph{

        Set<Edge> edges;

        public Graph(int numberNodes) {
            super(numberNodes);
            edges = new HashSet<>();
        }

        @Override
        public void addEdge(int first, int second) {
            if (first < second){
                edges.add(new Edge(first, second));
            } else {
                edges.add(new Edge(second, first));
            }
        }

        @Override
        public void removeEdge(int first, int second) {
            if (first < second){
                edges.remove(new Edge(first, second));
            } else {
                edges.remove(new Edge(second, first));
            }

        }

        @Override
        public boolean isExistEdge(int first, int second) {
            if (first < second){
                return edges.contains(new Edge(first, second));
            } else {
                return edges.contains(new Edge(second, first));
            }
        }

        class Edge<Integer> {
            private Integer first;
            private Integer second;

            public Edge(Integer first, Integer second) {
                this.first = first;
                this.second = second;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                Edge<?> edge = (Edge<?>) o;

                if (first != null ? !first.equals(edge.first) : edge.first != null) return false;
                return second != null ? second.equals(edge.second) : edge.second == null;
            }

            @Override
            public int hashCode() {
                int result = first != null ? first.hashCode() : 0;
                result = 31 * result + (second != null ? second.hashCode() : 0);
                return result;
            }
        }
    }
}
