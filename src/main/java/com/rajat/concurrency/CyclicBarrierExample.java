package com.rajat.concurrency;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(4);
        CyclicBarrier barrier = new CyclicBarrier(3, new ActionWorker());

        es.submit(new MyWorker(barrier));
        es.submit(new MyWorker(barrier));
        es.submit(new MyWorker(barrier));
        es.submit(new MyWorker(barrier));

        es.shutdown();
    }
}
