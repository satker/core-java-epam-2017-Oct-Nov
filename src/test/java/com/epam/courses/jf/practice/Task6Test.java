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

public class Task6Test {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ISolver solver = new Solver();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void case1() {
        String data1 = "12" + "\n" +
                "The original and reference implementation Java compilers were originally released by Sun" + "\n";
        System.setIn(new ByteArrayInputStream(data1.getBytes()));
        solver.task6();
        assertTrue("Test6 Failed!", outContent.toString().equals("by\r\n"));
    }

    @Test
    public void case2() {
        String data1 = "4" + "\n" +
                "Кто-то позвонил в дверь" + "\n";
        System.setIn(new ByteArrayInputStream(data1.getBytes()));
        solver.task6();
        assertTrue("Test6 Failed!", outContent.toString().equals("NOT FOUND\r\n"));
    }

    @Test
    public void case3() {
        String data1 = "1" + "\n" +
                "h" + "\n";
        System.setIn(new ByteArrayInputStream(data1.getBytes()));
        solver.task6();
        assertTrue("Test6 Failed!", outContent.toString().equals("NOT FOUND\r\n"));
    }

    @Test
    public void case4() {
        String data1 = "2" + "\n" +
                "aab by" + "\n";
        System.setIn(new ByteArrayInputStream(data1.getBytes()));
        solver.task6();
        assertTrue("Test6 Failed!", outContent.toString().equals("by\r\n"));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setIn(null);
    }
}
