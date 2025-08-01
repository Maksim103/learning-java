package org.example.Multithreading.ReadFile3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("./maven-project-demo/src/main/java/org/example/Multithreading/ReadFile3/data.txt"))) {
            Controller controller = new Controller(br);

            Job job1 = new Job(controller);
            Job job2 = new Job(controller);

            Thread thread1 = new Thread(job1, "First");
            Thread thread2 = new Thread(job2, "Second");

            thread1.start();
            thread2.start();

            try {
                thread1.join();
                thread2.join();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            System.out.println("Первый поток: " + job1.getList());
            System.out.println("Второй поток: " + job2.getList());
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

class Controller {
    private final BufferedReader reader;
    private volatile String status = "First";

    public Controller(BufferedReader reader) {
        this.reader = reader;
    }

    public synchronized String readWord(String threadName) {
        String result = null;

        while (!threadName.equals(status)) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            result = reader.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        if (status.equals("First")) {
            status = "Second";
        } else {
            status = "First";
        }
        notify();

        return result;
    }
}

class Job implements Runnable {
    private final Controller controller;
    private final ArrayList<String> list = new ArrayList<>();

    public ArrayList<String> getList() {
        return list;
    }

    public Job(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void run() {
        String word = controller.readWord(Thread.currentThread().getName());
        while (word != null) {
            list.add(word);
            word = controller.readWord(Thread.currentThread().getName());
        }
    }
}
