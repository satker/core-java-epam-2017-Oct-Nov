package com.epam.courses.jf.se7;

public class GetStateDemo {

    public static void main(String args[]) {
        Thread th1 = new Thread(() -> {
            Thread.State state = Thread.currentThread().getState();
            System.out.println(Thread.currentThread().getName() + " " + state);
        });
        System.out.println(th1.getName() + " " + th1.getState());
        th1.start();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println(e);
        }
        Thread.State state = th1.getState();
        System.out.println(th1.getName() + " " + state);
    }
}

