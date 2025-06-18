package org.example.AlgorithmsAndStructures.BinaryTree;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(int data) {
        root = new Node(data);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1);

        /* Текущее представление дерева
           1
          / \
        null null
        */

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        /* Текущее представление дерева
              1
             / \
            2   3
           / \ / \
       null null null null
        */

        tree.root.left.left = new Node(4);

        /* Текущее представление дерева
               1
              / \
             2   3
            / \ / \
           4 null null null
          / \
        null null
        */
    }
}
