package com.rajat.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchExample {
   static ExecutorService es = Executors.newFixedThreadPool(3);
    static CountDownLatch latch = new CountDownLatch(3);

    public static void main(String[] args) throws InterruptedException {
//        es.submit(new MyWorker(latch));
//        es.submit(new MyWorker(latch));
//        es.submit(new MyWorker(latch));
//        es.submit(new MyWorker(latch));
        latch.await();

        System.out.println("THread finished countdown latch");
        es.shutdown();
    }
}
