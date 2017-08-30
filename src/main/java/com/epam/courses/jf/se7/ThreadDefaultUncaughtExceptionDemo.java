package com.epam.courses.jf.se7;

public class ThreadDefaultUncaughtExceptionDemo {

    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler((t, e) -> System.out.println(t + " (default handler)throws exception: " + e));

        Runnable throwRuntimeException = () -> { throw new RuntimeException(); };
        Thread t1 = new Thread(throwRuntimeException);
        Thread t2 = new Thread(throwRuntimeException);
        t2.setUncaughtExceptionHandler((t, e) -> System.out.println(t + " throws exception: " + e));

        t1.start();
        t2.start();
    }
}