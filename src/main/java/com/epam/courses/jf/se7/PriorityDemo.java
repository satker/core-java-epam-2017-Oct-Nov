package com.epam.courses.jf.se7;

public class PriorityDemo {

    public static void main(String args[]) {
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);

        int count = 9;
        Clicker[] threads = new Clicker[count];
        for (int i = 0; i < count; i++) {
            threads[i] = new Clicker();
            threads[i].setPriority(i + 1);
        }

        for (Clicker thread : threads) {
            thread.start();
        }

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        try {
            for (Clicker thread : threads) {
                thread.stopClick();
            }
            for (Clicker thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            System.out.println("InterruptedException caught");
        }
        for (int i = 0; i < count; i++) {
            System.out.println(i + 1 + " thread: " + threads[i].click);
        }
    }
}

