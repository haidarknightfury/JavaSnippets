package com.example.algo.LinkedList;

import java.io.Serializable;

// X-> Y-> Z

public class Node<T extends Serializable & Comparable<T>> {

    private Node<T> next;

    private T data;

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return this.data;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node [data=" + this.data + "]";
    }

}
