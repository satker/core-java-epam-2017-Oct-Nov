package com.epam.courses.jf.se7;

class Clicker extends Thread {

    private volatile boolean running = true;

    int click = 0;

    @Override
    public void run() {
        while (running) {
            click++;
        }
    }

    public void stopClick() {
        running = false;
    }
}
