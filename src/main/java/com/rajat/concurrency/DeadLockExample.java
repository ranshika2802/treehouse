package com.rajat.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockExample {
    private final static Object o1 = new Object();
    private final static Object o2 = new Object();

    private final static Lock l1 = new ReentrantLock();
    private final static Lock l2 = new ReentrantLock();
    public static void main(String[] args) {
        DeadLockExample deadLockExample = new DeadLockExample();

        ExecutorService es = Executors.newFixedThreadPool(2);
        es.submit(deadLockExample.thisMethod);
        es.submit(deadLockExample.thatMethod);

        es.shutdown();
//        Thread t1 = new Thread(deadLockExample.thisMethod);
//        Thread t2 = new Thread(deadLockExample.thatMethod);
//        t1.start();
//        t2.start();

    }
    Runnable thisMethod =() -> {
        try {
            l1.tryLock();
            System.out.println(Thread.currentThread().getName() + " acquired lock1");

            // Adding some delay to make deadlock more likely
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

           l2.tryLock();
                System.out.println(Thread.currentThread().getName() + " acquired lock2");
        } finally {
            l2.unlock();
            l1.unlock();
        }
    };

    Runnable thatMethod =() -> {
        try {
            l2.tryLock();
            System.out.println(Thread.currentThread().getName() + " acquired lock2");

            // Adding some delay to make deadlock more likely
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            l1.tryLock();

                System.out.println(Thread.currentThread().getName() + " acquired lock1");
        } finally {
            l1.unlock();
            l2.unlock();
        }
    };
}
