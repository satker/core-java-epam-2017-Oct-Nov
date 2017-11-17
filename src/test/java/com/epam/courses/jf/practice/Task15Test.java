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

public class Task15Test {
    protected final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    protected final ISolver solver = new Solver();


    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setIn(null);
    }

    @Test
    public void case1() {
        String dataIn = "3\n" +
                "1 0 3\n" +
                "-1 2 2\n" +
                "1 -1 3";
        System.setIn(new ByteArrayInputStream(dataIn.getBytes()));
        solver.task15();
        String outData = outContent.toString();
        assertTrue("Test15 Failed!", outData.equals("-1\r\n"));
    }

    /*
    *     { 2,   0,  3,  4,  5 },
                        { 1,   3,  0,  2, -1},
                        { 2,  -1, -5,  5,  0},
                        { 5,   4, -4, -2,  2},
                        { 1,   2,  4, -4,  3 }
    * */
    @Test(timeout = 2000)
    public void case2() {
        String dataIn = "5\r\n" +
                "2 0 3 4 5\n" +
                "1 3 0 2 -1\n" +
                "2 -1 -5 5 0\n" +
                "5 4 -4 -2 2\n" +
                "1 2 4 -4 3\n";
        System.setIn(new ByteArrayInputStream(dataIn.getBytes()));
        solver.task15();
        String outData = outContent.toString();
        assertTrue("Test15 Failed!", outData.equals("-6\r\n"));
    }

}
