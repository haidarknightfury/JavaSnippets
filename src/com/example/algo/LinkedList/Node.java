package com.example.algo.LinkedList;

import java.io.Serializable;

// X-> Y-> Z

public class Node<T extends Serializable & Comparable<T>> {

    public Node(T data) {
        this.data = data;
    }

    private Node<T> next;

    private T data;

    public Node<T> getNext() {
        return this.next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node [data=" + this.data + "]";
    }

}
