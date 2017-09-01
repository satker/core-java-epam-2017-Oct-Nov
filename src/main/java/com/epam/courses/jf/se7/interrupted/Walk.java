package com.epam.courses.jf.se7.interrupted;

import java.util.concurrent.TimeUnit;

public class Walk implements Runnable {

    @Override
    public void run() {

        for (int i = 0; ; i++) {
            System.out.println("Walking");
            System.err.println("Walking interrupted by main thread: ");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {

                System.err.println(e);
                System.err.println("Walking interrupted by main thread: ");
            }
        }
    }
}
