package org.example.Multithreading.Examples;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    public static void main(String[] args) {
        Incrementer incrementer = new Incrementer();
        IncrementerJob incrementerJob1 = new IncrementerJob(incrementer);
        IncrementerJob incrementerJob2 = new IncrementerJob(incrementer);
        IncrementerJob incrementerJob3 = new IncrementerJob(incrementer);

        Thread thread1 = new Thread(incrementerJob1);
        Thread thread2 = new Thread(incrementerJob2);
        Thread thread3 = new Thread(incrementerJob3);

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(incrementer.getAmount());
    }
}


class Incrementer {
    private final ReentrantLock reentrantLock = new ReentrantLock();
    private long amount = 0L;

    public void increaseAmount() {
        reentrantLock.lock();
        try {
            amount++;
        } finally {
            reentrantLock.unlock();
        }
    }

    public long getAmount() {
        return amount;
    }
}

class IncrementerJob implements Runnable {
    private Incrementer incrementer;

    public IncrementerJob(Incrementer incrementer) {
        this.incrementer = incrementer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            incrementer.increaseAmount();
        }
    }
}
