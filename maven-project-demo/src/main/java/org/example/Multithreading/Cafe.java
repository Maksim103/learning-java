package org.example.Multithreading;

/*
Повар может готовить блюда и выкладывать их на стол для раздачи.
На столе умещается только 3 блюда.
Если на столе уже лежит 3 блюда, то повар приостанавливается готовить и ждет, пока официант унесет часть тарелок.
*/

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Cafe {
    public static void main(String[] args) {
        Table table = new Table();
        Waiter waiter = new Waiter(table);
        Cook cook = new Cook(table);

        Thread threadWaiter = new Thread(waiter);
        Thread threadCook = new Thread(cook);

        threadWaiter.start();
        threadCook.start();
    }
}

class Waiter implements Runnable {
    private Table table;

    public Waiter(Table table) {
        this.table = table;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(5_000);
                table.getDish();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

class Cook implements Runnable {
    private Table table;

    public Cook(Table table) {
        this.table = table;
    }

    @Override
    public void run() {
        System.out.println("Повар начал готовить");

        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(1_000);
                table.putDish(i);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

class Table {
    private final ReentrantLock reentrantLock;
    private final Condition condition;
    private int countDishes = 0;

    public Table() {
        reentrantLock = new ReentrantLock();
        condition = reentrantLock.newCondition();
    }

    public void getDish() {
        reentrantLock.lock();
        try {
            while (countDishes < 1) {
                condition.await();
            }
            countDishes--;
            System.out.println("Официант забрал одну тарелку");
            System.out.println("На столе осталось " + countDishes + " тарелок");

            condition.signal();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            reentrantLock.unlock();
        }

    }

    public void putDish(int number) {
        reentrantLock.lock();
        try {
            while (countDishes >= 3) {
                condition.await();
            }

            countDishes++;
            System.out.println("Повар приготовил " + number + " блюдо. На столе " + countDishes + " тарелок");
            condition.signal();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            reentrantLock.unlock();
        }
    }
}