package org.example.Multithreading.ReadFile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader("./maven-project-demo/src/main/java/org/example/Multithreading/ReadFile/data.txt"));
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
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Первый поток считал: " + job1.getList());
        System.out.println("Второй поток считал: " + job2.getList());
        System.out.println("Третий поток считал: " + job3.getList());
    }
}

class Job implements Runnable {
    private final ArrayList<String> list = new ArrayList<>();
    private final BufferedReader reader;

    public Job(BufferedReader reader) {
        this.reader = reader;
    }

    public ArrayList<String> getList() {
        return list;
    }

    @Override
    public void run() {
        try {
            String text;
            while ((text = reader.readLine()) != null) {
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