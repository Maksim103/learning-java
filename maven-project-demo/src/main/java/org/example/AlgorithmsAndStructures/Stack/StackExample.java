package org.example.AlgorithmsAndStructures.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack theStack = new Stack(10);
        theStack.push(20);
        theStack.push(40);
        theStack.push(60);
        theStack.push(80);

        theStack.pop();
        System.out.println(theStack.peek());

        theStack.printAllElements();
    }
}
