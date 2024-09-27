package com.rajat.concurrency;

public class ActionWorker implements Runnable{
    @Override
    public void run() {
        System.out.println("Ready for new task.");
    }
}
