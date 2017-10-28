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

public class Task2Test {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ISolver solver = new Solver();


    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void case1() {
        String data1 = "4" + "\n" +
                "Тихо струится река серебристая" + "\n" +
                "В царстве вечернем зеленой весны." + "\n" +
                "Солнце садится за горы лесистые." + "\n" +
                "Рог золотой выплывает луны." + "\n";
        System.setIn(new ByteArrayInputStream(data1.getBytes()));
        solver.task2();
        assertTrue(outContent.toString().equals("" +
                "(27): \"Рог золотой выплывает луны.\"" + "\r\n" +
                "(30): \"Тихо струится река серебристая\"" + "\r\n" +
                "(32): \"Солнце садится за горы лесистые.\"" + "\r\n" +
                "(33): \"В царстве вечернем зеленой весны.\"" + "\r\n"

        ));

    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setIn(null);
    }
}
