package com.rajat.concurrency;

public class Main {

    public static void main(String[] args) {
        {
            MyBlockingQueue bq = new MyBlockingQueue(10);
            final Runnable producer = () -> {
                while (true) {
                        int item = createItem();
                        bq.put(item);
                        System.out.println("Item produced=" + item);
                }
            };
            new Thread(producer).start();

            final Runnable consumer = () -> {
                while (true) {
                        System.out.println("Item Consumed = " + bq.take());
                }
            };
            new Thread(consumer).start();
        }
    }

    private static Integer createItem() {
        return (int)(Math.random()*100);
    }
}