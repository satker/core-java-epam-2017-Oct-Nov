package com.epam.courses.jf.se7;

public class ThreadGroupDemo {

    public static void main(String[] args) {

        ThreadGroup groupA = new ThreadGroup("Group A");
        MyThread ob1 = new MyThread("One", groupA);
        ob1.start();

        MyThread ob2 = new MyThread("Two", groupA);
        ob2.start();

        ThreadGroup groupB = new ThreadGroup("Group B");
        MyThread ob3 = new MyThread("Three", groupB);
        ob3.start();

        MyThread ob4 = new MyThread("Four", groupB);
        ob4.start();

        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        groupA.interrupt();
    }
}

