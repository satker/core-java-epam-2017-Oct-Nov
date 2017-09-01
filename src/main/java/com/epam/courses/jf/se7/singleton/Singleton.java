package com.epam.courses.jf.se7.singleton;

public class Singleton {

    private final String name = "123";

    private static volatile Singleton INSTANCE;

    private static final Object monitor = new Object();

    private Singleton() {}

    public static Singleton getInstance() {
        if (INSTANCE == null) {
            synchronized (monitor) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton();
                }
            }
        }
        return INSTANCE;
    }

    public static synchronized void method() {
        //...
    }
}
