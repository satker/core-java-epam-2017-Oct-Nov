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

public class Task17Test {
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
                "-2 1 2\n" +
                "0 -1 0\n" +
                "1 -2 3";
        System.setIn(new ByteArrayInputStream(dataIn.getBytes()));
        solver.task17();
        String outData = outContent.toString();
        assertTrue("Test17 Failed!", outData.equals("8\r\n"));
    }

}
