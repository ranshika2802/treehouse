package com.rajat.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MyWorker implements Runnable{
//    private final CountDownLatch latch;

    private final CyclicBarrier barrier;

    public MyWorker(CyclicBarrier barrier) {
        this.barrier = barrier;
    }
    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName());

            Thread.sleep(1000);
            barrier.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }  catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        } finally {
//            barrier.reset();
//            latch.countDown();
        }
    }
}
