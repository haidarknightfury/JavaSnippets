package com.example.algo.Tree;

public class Node {

    private Integer data;
    private Node left;
    private Node right;

    public Node(Integer data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public Node(Integer data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public Integer getData() {
        return this.data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public Node getLeft() {
        return this.left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return this.right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

}
