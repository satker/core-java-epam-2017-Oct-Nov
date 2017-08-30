package com.epam.courses.jf.se7;

import java.util.concurrent.TimeUnit;

public class ThreadDemo {

    public static void main(String[] args) {
        Thread walk = new Thread(new Walk(), "Walking thread");
        walk.start();

        Talk talk  = new Talk();
        talk.start();

        //Walk w = new Walk(); // просто объект, не поток
        // w.run(); //выполнится метод, но поток не запустится!
        System.out.println("Main thread end");

        while (walk.isAlive());
        while (talk.isAlive());
        System.out.println();
    }
}
