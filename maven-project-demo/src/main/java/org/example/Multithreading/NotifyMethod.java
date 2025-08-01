package org.example.Multithreading;

public class NotifyMethod {
    public static void main(String[] args) {
        Clock clock = new Clock();
        Thread tick = new Thread(clock, "Tick");
        Thread tock = new Thread(clock, "Tock");

        tick.start();
        tock.start();
    }
}

class Clock implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            doTikTok(true);
        }
        doTikTok(false);
    }

    private synchronized void doTikTok(boolean isRunning) {
        if (!isRunning) {
            notify();
            return;
        }

        if (Thread.currentThread().getName().equals("Tick")) {
            System.out.println("Tick");
            notify();

            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Tock");
            notify();

            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}