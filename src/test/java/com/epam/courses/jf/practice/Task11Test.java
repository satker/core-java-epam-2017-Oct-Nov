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

public class Task11Test {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ISolver solver = new Solver();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void case1() {
        String dataIn = "12 0";
        System.setIn(new ByteArrayInputStream(dataIn.getBytes()));
        solver.task11();
        String outData = outContent.toString();
        assertTrue("Test11 Failed!", outData.equals("INCORRECT INPUT DATA\r\n"));
    }

    @Test
    public void case2() {
        String dataIn = "12";
        System.setIn(new ByteArrayInputStream(dataIn.getBytes()));
        solver.task11();
        String outData = outContent.toString();
        assertTrue("Test11 Failed!", outData.equals("December\r\n"));
    }


    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setIn(null);
    }
}
