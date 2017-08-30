package com.epam.courses.jf.se7;

public class ThreadGroupUncaughtExceptionDemo {

    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler((tread, ex) -> System.out.println("Default"));
        ParentThreadGroup parent = new ParentThreadGroup();
        NewThreadGroup g = new NewThreadGroup(parent, "one");

        SuicideThread t1 = new SuicideThread("1", g);
        SuicideThread t2 = new SuicideThread("2", g);
        SuicideThread t3 = new SuicideThread("3", g);

        t3.setUncaughtExceptionHandler((t, e) -> System.out.println(t + " throws exception: " + e));

        t1.start();
        t2.start();
        t3.start();
    }
}

class ParentThreadGroup extends ThreadGroup {

    public ParentThreadGroup() {
        super("Parent");
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("Lol we caught exception!");
    }
}

class NewThreadGroup extends ThreadGroup {

    NewThreadGroup(String name) {
        super(name);
    }

    public NewThreadGroup(ThreadGroup parent, String name) {
        super(parent, name);
    }

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        System.out.println(thread + " has unhandled exception:" + ex);
        try {
            throw ex;
        } catch (Throwable throwable) {
            throw new RuntimeException(ex);
        }
        //super.uncaughtException(thread, ex);
    }
}

class SuicideThread extends Thread {

    public SuicideThread(String threadname, ThreadGroup tgOb) {
        super(tgOb, threadname);
    }

    @Override
    public void run() {
        throw new RuntimeException("Oy, exception!!!");
    }
}
