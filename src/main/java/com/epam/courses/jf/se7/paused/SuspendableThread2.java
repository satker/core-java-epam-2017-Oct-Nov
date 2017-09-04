package com.epam.courses.jf.se7.paused;

public class SuspendableThread2 extends Thread {

    private final Object waitingMonitor = new Object();
    private volatile boolean isRunning;

    @Override
    public void run() {
        while (!isInterrupted()) {
            waitIfSuspended();
            //...
        }
    }

    @Override
    public synchronized void start() {
        super.start();
        isRunning = true;
    }

    protected final void waitIfSuspended() {
        if (!isRunning) {
            synchronized (waitingMonitor) {
                while (!isRunning) {
                    try {
                        waitingMonitor.wait();
                    } catch (InterruptedException e) {
                        interrupt();
                        break;
                    }
                }
            }
        }
    }

    public final void _suspend() {
        isRunning = false;
    }

    public final void _resume() {
        isRunning = true;
        synchronized (waitingMonitor) {
            waitingMonitor.notify();
        }
    }
}