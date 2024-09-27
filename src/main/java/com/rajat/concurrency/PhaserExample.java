package com.rajat.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class PhaserExample {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(4);
        Phaser phaser = new Phaser(3);
        es.submit(new Task(phaser));
        es.submit(new Task(phaser));
        es.submit(new Task(phaser));
        es.submit(new Task(phaser));

        Thread.sleep(10000);
        es.shutdown();

    }

    static class Task implements Runnable {

        private Phaser phaser;

        public Task(Phaser phaser) {
            this.phaser = phaser;
        }

        @Override
        public void run() {
            try {
            System.out.println(Thread.currentThread().getName()+ "starting pfase 1");
                Thread.sleep(2000);
                phaser.arriveAndAwaitAdvance();

                System.out.println(Thread.currentThread().getName()+" staring phase 2");
                Thread.sleep(2000);
                phaser.arriveAndDeregister();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


