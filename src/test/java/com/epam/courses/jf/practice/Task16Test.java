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

public class Task16Test {
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
        solver.task16();
        String outData = outContent.toString();
        assertTrue("Test16 Failed!", outData.equals("3 2 3\n"+
                "0 2 -1\n"+
                "1 -1 1\n"
        ));
    }


}
