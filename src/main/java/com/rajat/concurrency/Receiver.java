package com.rajat.concurrency;

public class Receiver implements Runnable{
    private Data data;

    public Receiver(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        for(String receivedMessage = data.receive();
        !"END".equals(receivedMessage);
        receivedMessage = data.receive()) {
            System.out.println(receivedMessage);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Thread Interrupted");
        }

    }
}
