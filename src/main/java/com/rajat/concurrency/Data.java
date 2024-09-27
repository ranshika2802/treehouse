package com.rajat.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Data {
    Lock lock = new ReentrantLock();
    Condition first = lock.newCondition();
    Condition second = lock.newCondition();
    private String packet;
    private boolean transfer = true;
    public /*synchronized*/ String receive() {
        while(transfer) {
            try {
//                wait();
                first.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread interrupted.");
            }
        }
        transfer = true;
        String returnPacket = packet;
//        notifyAll();
        first.signalAll();
        return returnPacket;
    }

    public /*synchronized*/ void send(String packet) {
        while(!transfer) {
            try {
//                wait();
                second.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread Interruped");
            }
        }
        transfer = false;
        this.packet = packet;
     second.signalAll();
//        notifyAll();
    }
}
