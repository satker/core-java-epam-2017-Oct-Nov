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

public class Task7Test {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ISolver solver = new Solver();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void case1() {
        String data1 = "11" + "\n" +
                "The Java programming language is a general-purpose, concurrent, class-based, object-oriented language" + "\n";
        System.setIn(new ByteArrayInputStream(data1.getBytes()));
        solver.task7();
        assertTrue("Test7 Failed!", outContent.toString().equals("The is a\r\n"));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setIn(null);
    }
}

