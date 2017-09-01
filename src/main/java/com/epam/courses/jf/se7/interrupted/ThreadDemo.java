package com.epam.courses.jf.se7.interrupted;

import java.io.IOException;

public class ThreadDemo {

    public static void main(String[] args) throws IOException {
        Talk talk = new Talk();
        talk.start();

        System.in.read();
        talk.interrupt();
    }
}
