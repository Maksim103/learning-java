package org.example.Multithreading.Examples;

public class VolatileMethod {
    private volatile static boolean RUNNING = true;

    public static class Counter implements Runnable {
        @Override
        public void run() {
            long count = 0;
            while (RUNNING) {
                count++;
            }

            System.out.println(count); // не выведется, если не добавить к переменной RUNNING слово volatile
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start");

        new Thread(new Counter(), "Counter").start();

        Thread.sleep(10_000);
        RUNNING = false;
        System.out.println("Stop");
    }
}
