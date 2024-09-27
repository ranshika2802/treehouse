package com.rajat.concurrency;

public class Sender implements Runnable {
    private Data data;

    public Sender(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        String[] packets = {
                "First Packet",
                "second packet",
                "third packet",
                "fourth packet",
                "END"
        };
        for(String s:packets) {
            data.send(s);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread interrupted");
            }
        }
    }
}
