package com.epam.courses.jf.se7;

public class CurrentThreadDemo {

    public static void main(String args[]) {
        Thread main = Thread.currentThread();
        System.out.println("Текущий поток: " + main);
        main.setName("My Thread");
        System.out.println("После изменения имени: " + main);
        try {
            for (int n = 5; n > 0; n--) {
                System.out.println(n);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

