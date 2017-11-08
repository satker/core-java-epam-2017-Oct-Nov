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

public class Task9Test {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ISolver solver = new Solver();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void case1() {
        String data1 = "5" + "\n";
        System.setIn(new ByteArrayInputStream(data1.getBytes()));
        solver.task9();
        String outData = outContent.toString();
        assertTrue("Test9 Failed!", outData.equals(
                "1\t2\t3\t4\t5\r\n" +
                        "6\t7\t8\t9\t10\r\n" +
                        "11\t12\t13\t14\t15\r\n" +
                        "16\t17\t18\t19\t20\r\n" +
                        "21\t22\t23\t24\t25\r\n"
        ));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setIn(null);
    }
}
