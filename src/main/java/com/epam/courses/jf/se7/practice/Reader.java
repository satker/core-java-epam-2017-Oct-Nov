package com.epam.courses.jf.se7.practice;

import java.util.concurrent.TimeUnit;

public class Reader extends Thread {

    private final Storage storage;

    public Reader(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(storage.read());
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
