package com.epam.courses.jf.se7.practice;

public class Launcher {

    public static void main(String[] args) {
        Storage storage = new Storage();

        Writer writer = new Writer(storage);
        writer.start();

        Thread[] readers = new Thread[3];
        for (int i = 0; i < readers.length; i++) {
            readers[i] = new Reader(storage);
            readers[i].start();
        }
    }
}
