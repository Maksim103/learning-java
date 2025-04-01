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

        Node.insertAtStart(new Node(7), head);
        Node.insertAtEnd(new Node(1010), head);
        Node.insertAfterNode(new Node(129494), head, 0);

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

    public static Node insertAtStart(Node newNode, Node head) {
        newNode.next = head;
        head = newNode;

        return head;
    }

    public static Node insertAtEnd(Node newNode, Node head) {
        Node currentNode = head;

        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next = newNode;
        return head;
    }

    public static Node insertAfterNode(Node newNode, Node head, int index) {
        Node currentNode = head;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        Node temp = currentNode.next;
        currentNode.next = newNode;
        newNode.next = temp;

        return head;
    }

    public static Node deleteAtFirst(Node head) {
        head = head.next;

        return head;
    }

    public static Node deleteAtLast(Node head) {
        Node currentNode = head;

        while (currentNode.next.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next = null;
        return head;
    }

    public static Node deleteAfterNode(Node head, int index) {
        Node currentNode = head;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        currentNode.next = currentNode.next.next;
        return head;
    }
}
