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

public class Task12Test {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ISolver solver = new Solver();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void case1() {
        String dataIn = "2\n" + "5\n" +
                "0 2 3 4 5\n" +
                "1 3 0 2 -1\n" +
                "-1 -1 -5 5 0\n" +
                "5 4 -4 -2 2\n" +
                "1 3 -3 -4 3";
        System.setIn(new ByteArrayInputStream(dataIn.getBytes()));
        solver.task12();
        String outData = outContent.toString();
        assertTrue("Test12 Failed!", outData.equals("5\n" +
                "-1 -1 -5 5 0\n" +
                "5 4 -4 -2 2\n" +
                "1 3 -3 -4 3\n" +
                "1 3 0 2 -1\n" +
                "0 2 3 4 5\n"
        ));
    }


    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setIn(null);
    }
}
