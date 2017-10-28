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

public class Task3Test {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ISolver solver = new Solver();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void case1() {
        String data1 = "5" + "\n" +
                "Послушайте!" + "\n" +
                "Ведь, если звезды зажигают -" + "\n" +
                "значит - это кому-нибудь нужно?" + "\n" +
                "Значит - кто-то хочет, чтобы они были?" + "\n" +
                "Значит - кто-то называет эти плевочки жемчужиной?" + "\n";
        System.setIn(new ByteArrayInputStream(data1.getBytes()));
        solver.task3();
        assertTrue("Test3 Failed!",outContent.toString().equals("" +
                "AVERAGE (31)" + "\r\n" +
                "(11): \"Послушайте!\"" + "\r\n" +
                "(28): \"Ведь, если звезды зажигают -\"" + "\r\n"
        ));

    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setIn(null);
    }
}
