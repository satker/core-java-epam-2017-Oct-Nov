package com.epam.courses.jf.se7.interrupted;

import java.util.concurrent.TimeUnit;

public class Talk extends Thread {

    public Talk() {
        super("Talking thread");
    }

    @Override
    public void run() {
        for (int i = 0; !isInterrupted(); i++) {
            System.out.println("Talking: " + i);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
                interrupt();
            }
        }
    }
}
