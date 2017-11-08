package com.epam.courses.jf.practice;

import com.epam.courses.jf.practice.common.first.ISolver;
import com.epam.courses.jf.practice.nbikbaev.first.Solver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;

public class Task10Test {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ISolver solver = new Solver();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void case1() {
        String dataIn = "2 7 0";
        System.setIn(new ByteArrayInputStream(dataIn.getBytes()));
        solver.task10();
        String outData = outContent.toString();
        assertTrue("Test10 Failed!", outData.equals("Two solutions: -3.50,0.00\r\n"));
    }

    @Test
    public void case2() {
        String dataIn = "4 4 1";
        System.setIn(new ByteArrayInputStream(dataIn.getBytes()));
        solver.task10();
        String outData = outContent.toString();
        assertTrue("Test10 Failed!", outData.equals("One solution: -0.50\r\n"));
    }

    @Test
    public void case3() {
        String dataIn = "7 0 35";
        System.setIn(new ByteArrayInputStream(dataIn.getBytes()));
        solver.task10();
        String outData = outContent.toString();
        assertTrue("Test10 Failed!", outData.equals("No solution\r\n"));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setIn(null);
    }
}
