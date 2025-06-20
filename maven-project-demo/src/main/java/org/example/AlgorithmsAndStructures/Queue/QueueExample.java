package org.example.AlgorithmsAndStructures.Queue;

public class QueueExample {
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
