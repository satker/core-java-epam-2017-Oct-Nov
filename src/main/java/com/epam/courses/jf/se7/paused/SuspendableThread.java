package com.epam.courses.jf.se7.paused;

public class SuspendableThread extends Thread {

    private volatile State current;

    private final Object monitorObject = new Object();

    @Override
    public void run() {
        while (current != State.STOPPED) {
            waitIfPaused();
            // ...
        }
    }

    private void waitIfPaused() {
        if (current == State.SUSPENDED) {
            synchronized (monitorObject) {
                try {
                    while (current != State.RUNNABLE) {
                        monitorObject.wait();
                    }
                } catch (InterruptedException e) {
                    current = State.STOPPED;
                }
            }
        }
    }

    @Override
    public synchronized void start() {
        current = State.RUNNABLE;
        super.start();
    }

    public void _suspend() {
        if (current != State.STOPPED) {
            current = State.SUSPENDED;
        }
    }

    public void _resume() {
        if (current == State.SUSPENDED) {
            current = State.RUNNABLE;
            synchronized (monitorObject) {
                monitorObject.notify();
            }
        }
    }

    public void _stop() {
        if (current == State.SUSPENDED) {
            this.interrupt();
        }
        current = State.STOPPED;
    }

    private enum State {
        RUNNABLE,
        SUSPENDED,
        STOPPED
    }
}
