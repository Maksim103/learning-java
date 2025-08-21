package org.example.Multithreading.Examples;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class BlockingDequeExample {
    public static void main(String[] args) {
        BlockingDeque<Integer> deque = new LinkedBlockingDeque<>(10);

        Thread threadHostess = new Thread(new Hostess(deque));
        Thread threadWaiter = new Thread(new Waiter(deque));

        threadHostess.start();
        threadWaiter.start();
    }
}

class Hostess implements Runnable {
    private final BlockingDeque<Integer> deque;

    public Hostess(BlockingDeque<Integer> deque) {
        this.deque = deque;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 20; i++) {
                System.out.println("[Hostess] пригласил гостя №" + i);
                deque.put(i);
                System.out.println("[Hostess] еще есть свободных столиков: " + deque.remainingCapacity());
                Thread.sleep(200);
            }
        } catch (InterruptedException interruptedException) {
            System.out.println(interruptedException.getMessage());
        }
    }
}

class Waiter implements Runnable {
    private final BlockingDeque<Integer> deque;

    public Waiter(BlockingDeque<Integer> deque) {
        this.deque = deque;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(1000);
                Integer taken = deque.take();
                System.out.println("[Waiter] обслужил гостя №" + taken);
                System.out.println("[Waiter] еще есть свободных столиков : " + deque.remainingCapacity());

                if (deque.isEmpty()) {
                    break;
                }
            }
        } catch (InterruptedException interruptedException) {
            System.out.println(interruptedException.getMessage());
        }
    }
}
