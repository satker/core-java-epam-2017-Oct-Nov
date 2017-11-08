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

public class Task8Test {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ISolver solver = new Solver();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void case1() {
        String data1 = "15" + "\n" +
                "Chapter 11 describes exceptions, chapter 13 describes binary " +
                "compatibility... chapter 22 presents a syntactic grammar" + "\n";
        System.setIn(new ByteArrayInputStream(data1.getBytes()));
        solver.task8();
        assertTrue("Test8 Failed!", outContent.toString().equals("22\r\n"));
    }

    @Test
    public void case2() {
        String data1 = "15" + "\n" +
                "Chapter 11 describes exceptions, chapter 13 describes binary " +
                "compatibility... chapter presents a syntactic grammar" + "\n";
        System.setIn(new ByteArrayInputStream(data1.getBytes()));
        solver.task8();
        assertTrue("Test8 Failed!", outContent.toString().equals("11\r\n"));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setIn(null);
    }
}
