package com.epam.courses.jf.se7;

import java.util.concurrent.TimeUnit;

public class ThreadUncaughtExceptionDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> { throw new RuntimeException("It is a greate exception."); });
        t.setUncaughtExceptionHandler((t1, e) -> System.out.println(t1 + " throws exception: " + e));
        t.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(t.getState());
    }
}

