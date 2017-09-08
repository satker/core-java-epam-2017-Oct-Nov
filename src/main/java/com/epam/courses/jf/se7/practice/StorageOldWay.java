package com.epam.courses.jf.se7.practice;

import java.util.concurrent.TimeUnit;

public class StorageOldWay {

    private volatile String value = "DEFAULT";

    private final Object write = new Object();
    private final Object readDone = new Object();
    private volatile int reading = 0;

    String read() {
        synchronized (write) {
            ++reading;
        }

        try {
            TimeUnit.SECONDS.sleep(1);
            return value;
        } catch (InterruptedException ignored) {
            throw new RuntimeException(ignored);
        } finally {
            synchronized (readDone) {
                if (--reading == 0) {
                    readDone.notify();
                }
            }
        }
    }

    void write(String s) {
        synchronized (write) {

            while (reading != 0) {
                synchronized (readDone) {
                    try {
                        readDone.wait();
                    } catch (InterruptedException ignored) {
                    }
                }
            }

            value = s;

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ignored) {
            }
        }
    }
}
