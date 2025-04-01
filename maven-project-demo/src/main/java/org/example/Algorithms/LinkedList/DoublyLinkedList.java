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

        DoublyNode.printLinkedListFromHead(head);
        DoublyNode.printLinkedListFromTail(tail);
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

    public static void printLinkedListFromHead(DoublyNode head) {
        DoublyNode currentNode = head;

        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }

        System.out.println();
    }

    public static void printLinkedListFromTail(DoublyNode tail) {
        DoublyNode currentNode = tail;

        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.prev;
        }

        System.out.println();
    }

    public static DoublyNode insertAtStart(DoublyNode newNode, DoublyNode head) {
        if (head == null) {
            head = newNode;
        } else {
            DoublyNode oldHead = head;

            head = newNode;
            oldHead.prev = head;
            head.next = oldHead;
        }

        return head;
    }

    public static DoublyNode insertAtEnd(DoublyNode newNode, DoublyNode tail) {
        if (tail == null) {
            tail = newNode;
        } else {
            DoublyNode oldTail = tail;

            tail = newNode;
            oldTail.next = tail;
            tail.prev = oldTail;
        }

        return tail;
    }

    public static DoublyNode insertAfterNode(DoublyNode newNode, DoublyNode head, int index) {
        DoublyNode currentNode = head;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        newNode.next = currentNode.next;
        newNode.prev = currentNode;
        currentNode.next.prev = newNode;
        currentNode.next = newNode;

        return head;
    }
}
