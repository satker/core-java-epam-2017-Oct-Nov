package com.epam.courses.jf.practice.akunats.second;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Task13Test {
        @Test
        public void createGraph() {
            Task13 graph = new Task13();
            Task13.AbstractGraph crGraph = graph.createGraph(5);
            crGraph.addEdge(1, 3);
            crGraph.addEdge(2, 5);
            assertEquals(crGraph.isExistEdge(1, 3), true);
            crGraph.removeEdge(1, 3);
            assertEquals(crGraph.isExistEdge(1, 3), false);
        }

    }
