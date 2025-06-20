package org.example.AlgorithmsAndStructures.Stack;

public class Stack {
    private int size;
    private long[] stackArray;
    private int top;

    public Stack(int size) {
        this.size = size;
        stackArray = new long[size];
        top = -1;
    }

    public void push(long elem) {
        top++;
        stackArray[top] = elem;
    }

    public long pop() {
        return stackArray[top--];
    }

    public long peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == (size-1));
    }

    public void printAllElements() {
        while (top != -1) {
            long value = stackArray[top--];
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
