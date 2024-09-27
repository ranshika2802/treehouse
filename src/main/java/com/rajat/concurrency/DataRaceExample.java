package com.rajat.concurrency;

public class DataRaceExample {
    long i = 0;

    Runnable task1 = () -> {
       i=3;
    };

    Runnable task2 = () -> {
        i=7;
    };

    public static void main(String[] args) throws InterruptedException {
        DataRaceExample dataRaceExample = new DataRaceExample();
        new Thread(dataRaceExample.task1).start();
        new Thread(dataRaceExample.task2).start();

        Thread.sleep(2000);
        System.out.println(dataRaceExample.i);
    }
}
