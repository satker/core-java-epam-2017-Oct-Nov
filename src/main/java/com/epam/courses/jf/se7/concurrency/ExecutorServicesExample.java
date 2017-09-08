package com.epam.courses.jf.se7.concurrency;

import java.util.List;
import java.util.concurrent.*;

public class ExecutorServicesExample {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(1);
        service.submit(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("");
            }
        });
        service.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        List<Runnable> notRunnedTasks = service.shutdownNow();

//        shutdownNowExecutorService();
//        Runnable counter = () -> {
//            for (int i = 0; i < Integer.MAX_VALUE; i++) {
//                try {
//                    TimeUnit.MILLISECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//
//        Exchanger<String> exchanger = new Exchanger<>();
//
//        new Thread(() -> {
//            try {
//                System.out.println("Another thread value: " + exchanger.exchange("qqqq"));
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
//
//        TimeUnit.SECONDS.sleep(1);
//
//        System.out.println("Main thread value: " + exchanger.exchange("213"));

    }

    private static void shutdownNowExecutorService() {
        Callable<Integer> callable1 = () -> {
            TimeUnit.SECONDS.sleep(3);
            return 1;
        };

        ExecutorService service = Executors.newFixedThreadPool(2);
        Future<Integer> future1 = service.submit(callable1);
        Future<Integer> future2 = service.submit(callable1);
        Future<Integer> future3 = service.submit(callable1);
        Future<Integer> future4 = service.submit(callable1);
        Future<Integer> future5 = service.submit(callable1);

        try {
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<Runnable> cancelled = service.shutdownNow();
        System.out.println(cancelled);

        System.out.println("After sleeping");
        try {
            System.out.println(future1.get());
            System.out.println(future2.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
