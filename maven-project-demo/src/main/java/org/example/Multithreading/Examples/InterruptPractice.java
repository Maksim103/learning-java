package org.example.Multithreading.Examples;

public class InterruptPractice {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Counter(), "Counter");
        thread.start();

        Thread.sleep(5_000);
        thread.interrupt();
    }
}

class Counter implements Runnable {
    private long count = 0;

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            count++;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().isInterrupted()); // После исключения флаг interrupt сбрасывается на false

                Thread.currentThread().interrupt();
                System.out.println(Thread.interrupted()); // Сразу выводит текущий флаг interrupt сбрасывается на false
                System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().isInterrupted());

                Thread.currentThread().interrupt();
                System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().isInterrupted());

                throw new RuntimeException(e);
            }
        }

        System.out.println(count);
    }
}

