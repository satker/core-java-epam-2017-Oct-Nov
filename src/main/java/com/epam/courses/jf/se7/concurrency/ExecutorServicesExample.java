package com.epam.courses.jf.se7.concurrency;

import java.util.concurrent.*;

public class ExecutorServicesExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable1 = () -> {
            TimeUnit.SECONDS.sleep(3);
            return 1 + 2;
        };

        Callable<Integer> callable2 = () -> {
            TimeUnit.SECONDS.sleep(3);
            return 10;
        };

        ExecutorService service = Executors.newFixedThreadPool(2);
        Future<Integer> future1 = service.submit(callable1);
        future1.cancel(true);

        Future<Integer> future2 = service.submit(callable1);

        TimeUnit.SECONDS.sleep(5);
        System.out.println("After sleeping");
        System.out.println(future1.get());
        System.out.println(future2.get());
        service.shutdown();


    }
}
