package com.epam.courses.jf.se7;

class NewThread extends Thread {

    NewThread(String threadName) {
        super(threadName);
        System.out.println("New thread: " + this);
    }

    @Override
    public void run() {
        Thread current = Thread.currentThread();
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(current.getName() + ": " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(current.getName() + " interrupted.");
        }
        System.out.println(current.getName() + " exiting.");
    }
}

