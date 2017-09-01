package com.epam.courses.jf.se7;

import java.util.Random;

public class IntegerSetterGetter extends Thread {

    private final Random rand = new Random();
    private final SharedResource resource;
    private volatile boolean run = true;

    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new IntegerSetterGetter(String.valueOf(i), resource);
        }
        for (Thread thread : threads) {
            thread.start();
        }
    }

    public IntegerSetterGetter(String name, SharedResource resource) {
        super(name);
        this.resource = resource;
    }

    public void stopThread() {
        run = false;
    }

    @Override
    public void run() {
        try {
            while (run) {
                if (rand.nextInt(3) >= 2) {
                    getIntegersFromResource();
                } else {
                    setIntegersIntoResource();
                }
            }
            System.out.println("Поток " + getName() + " завершил работу.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void getIntegersFromResource() throws InterruptedException {
        synchronized (resource) {
            System.out.println("Поток " + getName() + " хочет извлечь число.");
            Integer number = resource.getElement();
            while (number == null) {
                System.out.println("Поток " + getName() + " ждет пока очередь заполнится.");
                resource.wait();
                System.out.println("Поток " + getName() + " возобновил работу.");
                number = resource.getElement();
            }
            System.out.println("Поток " + getName() + " извлек число " + number);
        }
    }

    private void setIntegersIntoResource() throws InterruptedException {
        synchronized (resource) {
            Integer number = rand.nextInt(500);
            resource.setElement(number);
            System.out.println("Поток " + getName() + " записал число " + number);
            resource.notify();
        }
    }
}

