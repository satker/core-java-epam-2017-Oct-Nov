package com.epam.courses.jf.practice;

import com.epam.courses.jf.practice.common.first.ISolver;
import com.epam.courses.jf.practice.nbikbaev.first.Solver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;

public class Task1Test {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ISolver solver = new Solver();


    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void case1() {
        String data1 = "4" + "\n" +
                "Унылая пора! Очей очарованье!" + "\n" +
                "Приятна мне твоя прощальная краса —" + "\n" +
                "Люблю я пышное природы увяданье," + "\n" +
                "В багрец и в золото одетые леса," + "\n";
        System.setIn(new ByteArrayInputStream(data1.getBytes()));
        solver.task1();
        assertTrue(outContent.toString().equals("MIN (29): \"Унылая пора! Очей очарованье!\"" + "\r\n" +
                "MAX (35): \"Приятна мне твоя прощальная краса —\"\r\n"));

    }

    @Test
    public void case2() {
        ISolver solver = new Solver();
        String data2 = "4" + "\n" +
                "Или восторг самозабвенья" + "\n" +
                "Губительный изведал ты" + "\n" +
                "Безумно возалкал паденья" + "\n" +
                "И сам остановил винты?" + "\n";
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(data2.getBytes()));
        solver.task1();
        assertTrue(outContent.toString().equals("MIN (22): \"И сам остановил винты?\"" + "\r\n" +
                "MAX (24): \"Безумно возалкал паденья\"\r\n"));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }


}
