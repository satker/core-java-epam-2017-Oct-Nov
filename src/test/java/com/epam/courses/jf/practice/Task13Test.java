package com.epam.courses.jf.practice;

import org.junit.Test;
import java.io.ByteArrayInputStream;


import static org.junit.Assert.assertTrue;

public class Task13Test extends TaskTest {

    @Test
    public void case1() {
        String dataIn = "-2\n" + "3\n" +
                "-1 2 3\n" +
                "1 0 -3\n" +
                "-2 -1 2\n";
        System.setIn(new ByteArrayInputStream(dataIn.getBytes()));
        solver.task13();
        String outData = outContent.toString();
        assertTrue("Test13 Failed!", outData.equals("3\r\n" +
                "-2 -1 2\n" +
                "-1 2 3\n" +
                "1 0 -3\n"
        ));
    }

}
