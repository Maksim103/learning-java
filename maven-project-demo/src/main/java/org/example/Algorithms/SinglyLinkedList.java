package org.example.Algorithms;

public class SinglyLinkedList {
    public static void main(String[] args) {
        Node nodeOne = new Node(1);
        Node nodeTwo = new Node(2);
        Node nodeThree = new Node(3);
        Node nodeFour = new Node(4);

        Node head = nodeOne;
        Node tail = nodeFour;

        nodeOne.next = nodeTwo;
        nodeTwo.next = nodeThree;
        nodeThree.next = nodeFour;

        Node currentNode = head;

        while (currentNode != null) {
            System.out.println(currentNode.data + " - data");
            currentNode = currentNode.next;
        }
    }
}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
