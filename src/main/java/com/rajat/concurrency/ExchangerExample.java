package com.rajat.concurrency;

import java.util.concurrent.Exchanger;

public class ExchangerExample {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        Thread t1 = new Thread(() -> {
           String receivedMsg = "Message from Thread1";
            try {
                String exchange = exchanger.exchange(receivedMsg);
                System.out.println("Exchage Thread1 "+ exchange);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread(() -> {
            String receivedMsg = "Message from Thread2.";
            try {
                String exchange = exchanger.exchange(receivedMsg);
                System.out.println("Exchange Thread2 = "+ exchange);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t1.start();
        t2.start();
    }
}
