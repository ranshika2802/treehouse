package com.rajat.concurrency;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue<E> {

    Queue<E> queue;
    int capacity;
    Lock reentrantLock = new ReentrantLock();
    Condition producer = reentrantLock.newCondition();
    Condition consumer = reentrantLock.newCondition();
    public MyBlockingQueue(int capacity) {
        this.queue = new LinkedList<>();
        this.capacity = capacity;
    }

    public void put(E e){
        try {
            reentrantLock.lock();
            if(queue.size() == capacity) {
                producer.await();
            }
            queue.add(e);
            consumer.signalAll();
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        } finally {
            reentrantLock.unlock();
        }
    }

    public E take() {
        try {
            reentrantLock.lock();
            if(queue.size() == 0) {
                consumer.await();
            }
            E element = queue.remove();
            producer.signalAll();
            return element;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            reentrantLock.unlock();
        }
    }
}
