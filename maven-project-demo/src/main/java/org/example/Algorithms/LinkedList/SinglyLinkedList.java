package org.example.Algorithms.LinkedList;

public class SinglyLinkedList {
    public static void main(String[] args) {
        SynglyNode nodeOne = new SynglyNode(1);
        SynglyNode nodeTwo = new SynglyNode(2);
        SynglyNode nodeThree = new SynglyNode(3);
        SynglyNode nodeFour = new SynglyNode(4);

        SynglyNode head = nodeOne;
        SynglyNode tail = nodeFour;

        nodeOne.next = nodeTwo;
        nodeTwo.next = nodeThree;
        nodeThree.next = nodeFour;

        SynglyNode.insertAtStart(new SynglyNode(7), head);
        SynglyNode.insertAtEnd(new SynglyNode(1010), head);
        SynglyNode.insertAfterNode(new SynglyNode(129494), head, 0);

        SynglyNode.printLinkedList(head);
        System.out.println("-------------------------");

        SynglyNode.deleteAtFirst(head);
        SynglyNode.deleteAtLast(head);
        SynglyNode.deleteAfterNode(head, 2);

        SynglyNode.printLinkedList(head);

        System.out.println(SynglyNode.searchNodeInLinkedList(head, 4).data);
    }
}

class SynglyNode {
    int data;
    SynglyNode next;

    public SynglyNode(int data) {
        this.data = data;
        this.next = null;
    }

    public static SynglyNode insertAtStart(SynglyNode newNode, SynglyNode head) {
        newNode.next = head;
        head = newNode;

        return head;
    }

    public static SynglyNode insertAtEnd(SynglyNode newNode, SynglyNode head) {
        SynglyNode currentNode = head;

        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next = newNode;
        return head;
    }

    public static SynglyNode insertAfterNode(SynglyNode newNode, SynglyNode head, int index) {
        SynglyNode currentNode = head;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        SynglyNode temp = currentNode.next;
        currentNode.next = newNode;
        newNode.next = temp;

        return head;
    }

    public static SynglyNode deleteAtFirst(SynglyNode head) {
        head = head.next;

        return head;
    }

    public static SynglyNode deleteAtLast(SynglyNode head) {
        SynglyNode currentNode = head;

        while (currentNode.next.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next = null;
        return head;
    }

    public static SynglyNode deleteAfterNode(SynglyNode head, int index) {
        SynglyNode currentNode = head;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        currentNode.next = currentNode.next.next;
        return head;
    }

    public static void printLinkedList(SynglyNode head) {
        SynglyNode currentNode = head;

        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }

        System.out.println();
    }

    public static SynglyNode searchNodeInLinkedList(SynglyNode head, int searchValue) {
        SynglyNode currentNode = head;

        while (currentNode != null && currentNode.data != searchValue) {
            currentNode = currentNode.next;
        }

        return currentNode;
    }
}
