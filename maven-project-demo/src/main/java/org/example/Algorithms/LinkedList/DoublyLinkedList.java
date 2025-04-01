package org.example.Algorithms.LinkedList;

public class DoublyLinkedList {
    public static void main(String[] args) {
        DoublyNode nodeOne = new DoublyNode(1);
        DoublyNode nodeTwo = new DoublyNode(2);
        DoublyNode nodeThree = new DoublyNode(3);
        DoublyNode nodeFour = new DoublyNode(4);

        DoublyNode head = nodeOne;
        DoublyNode tail = nodeFour;

        nodeOne.next = nodeTwo;

        nodeTwo.next = nodeThree;
        nodeTwo.prev = nodeOne;

        nodeThree.next = nodeFour;
        nodeThree.prev = nodeTwo;

        nodeFour.prev = nodeThree;
    }
}

class DoublyNode {
    int data;
    DoublyNode next;
    DoublyNode prev;

    public DoublyNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
