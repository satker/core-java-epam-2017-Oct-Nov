package com.epam.courses.jf.se7;

import java.util.concurrent.TimeUnit;

public class Talk extends Thread {

    public Talk() {
        super("Talking thread");
    }

    @Override
    public void run() {
        for (int i = 0; i < 8; i++) {
            System.out.println("Talking");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
