package com.example.algo.Tree;

public class Tree {

    Node root;

    public Tree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return this.root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void inOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.getData());
        this.inOrderTraversal(node.getLeft());
        this.inOrderTraversal(node.getRight());
    }

}
