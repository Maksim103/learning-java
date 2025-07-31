package org.example.Multithreading.ReadFile2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader("./maven-project-demo/src/main/java/org/example/Multithreading/ReadFile2/data.txt"));
        Job job1 = new Job(reader);
        Job job2 = new Job(reader);
        Job job3 = new Job(reader);

        Thread thread1 = new Thread(job1);
        Thread thread2 = new Thread(job2);
        Thread thread3 = new Thread(job3);

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            Thread.sleep(30);
            thread1.interrupt();
            thread2.interrupt();
            thread3.interrupt();

            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        System.out.println("Первый поток: " + job1.getList());
        System.out.println("Второй поток: " + job2.getList());
        System.out.println("Третий поток: " + job3.getList());
    }
}

class Job implements Runnable {
    private final ArrayList<String> list = new ArrayList<>();
    private BufferedReader reader;

    public ArrayList<String> getList() {
        return list;
    }

    public Job(BufferedReader reader) {
        this.reader = reader;
    }

    @Override
    public void run() {
        try {
            Thread currentThread = Thread.currentThread();
            String text;
            while (((text = reader.readLine()) != null) && (!currentThread.isInterrupted())) {
                list.add(text);

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
