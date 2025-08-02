package org.example.Multithreading;

import java.time.LocalTime;
import java.util.ArrayList;

public class MessageQueue {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        Producer producer = new Producer(myQueue);
        Consumer consumer = new Consumer(myQueue);

        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(consumer);

        thread1.start();
        thread2.start();

        try {
            Thread.sleep(30_000);
            thread1.interrupt();
            thread2.interrupt();

            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("The work finished\n" + "The queue:");
        ArrayList<String> list = myQueue.getQueue();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}

class MyQueue {
    private final int MAX_LENGTH = 5;
    private final ArrayList<String> queue = new ArrayList<>();

    public ArrayList<String> getQueue() {
        return queue;
    }

    public synchronized void put(String item) throws InterruptedException {
        if (queue.size() >= MAX_LENGTH) {
            notify();

            while (queue.size() >= MAX_LENGTH) {
                wait();
            }
        }

        queue.add(item);
        notify();
    }

    public synchronized String get() throws InterruptedException {
        if (queue.isEmpty()) {
            notify();

            while (queue.isEmpty()) {
                wait();
            }
        }
        String result = queue.getFirst();
        queue.removeFirst();
        notify();

        return result;
    }
}

class Producer implements Runnable {
    private final MyQueue myQueue;

    public Producer(MyQueue myQueue) {
        this.myQueue = myQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                myQueue.put(LocalTime.now().toString());
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}

class Consumer implements Runnable {
    private final MyQueue myQueue;

    public Consumer(MyQueue myQueue) {
        this.myQueue = myQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String item = myQueue.get();
                System.out.println(item);
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
