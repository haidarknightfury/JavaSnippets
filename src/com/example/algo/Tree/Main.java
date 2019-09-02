package com.example.algo.Tree;

public class Main {

    public static void main(String[] args) {
        Node root = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);

        root.setLeft(node1);
        root.setRight(node2);

        node2.setLeft(node3);
        node2.setRight(node4);

        Tree tree = new Tree(root);
        tree.inOrderTraversal(root);
    }
}
