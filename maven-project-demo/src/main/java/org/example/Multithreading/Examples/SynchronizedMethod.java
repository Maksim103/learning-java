package org.example.Multithreading.Examples;

public class SynchronizedMethod {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Job job1 = new Job(sb);
        Job job2 = new Job(sb);

        Thread thread1 = new Thread(job1);
        Thread thread2 = new Thread(job2);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        System.out.println("Длина строки: " + sb.length());  // Должно быть 20_000
    }
}

class Job implements Runnable {
    private final StringBuilder sb;

    public Job(StringBuilder sb) {
        this.sb = sb;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10_000; i++) {
            synchronized (sb) {
                sb.append("A");
            }
        }
    }
}