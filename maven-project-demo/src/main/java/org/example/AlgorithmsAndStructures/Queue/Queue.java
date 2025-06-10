package org.example.AlgorithmsAndStructures.Queue;

public class Queue {
    private int size;
    private final int capacity;
    private final int[] queueArray;

    private int head;
    private int tail;

    public Queue(int capacity) {
        this.capacity = capacity;
        queueArray = new int[capacity];

        size = 0;
        head = 0;
        tail = capacity-1;
    }

    public void push(int elem) {
        if (isFull()) {
            return;
        }

        tail = (tail+1) % capacity;
        queueArray[tail] = elem;
        size++;
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }

        int elem = queueArray[head];
        head = (head+1) % capacity;

        size--;
        return elem;
    }

    public int peekHead() {
        return queueArray[head];
    }

    public int peekTail() {
        return queueArray[tail];
    }

    public boolean isFull() {
        return (size == capacity);
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public void printAllElements() {
        while (size != 0) {
            int elem = queueArray[head];
            head = (head+1) % capacity;

            System.out.print(elem + " ");
            size--;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(55);

        queue.pop();
        queue.pop();
        queue.pop();
        queue.pop();
        queue.pop();

        System.out.println(queue.peekHead());
        System.out.println(queue.peekTail());

        System.out.println(queue.isFull());
        System.out.println(queue.isEmpty());

        queue.push(87);
        queue.push(1245);
        queue.push(55);

        queue.printAllElements();
    }
}
