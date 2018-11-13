package com.example.algo.LinkedList;

import java.io.Serializable;

public class LinkedList<T extends Serializable & Comparable<T>> {

    Node<T> head;

    public Node<T> add(Node<T> node) {
        if (this.head == null) {
            this.head = node;
        }

        else if (this.head.getNext() == null) {
            this.head.setNext(node);
        }

        else {
            getLast().setNext(node);
        }
        return node;
    }

    public Node<T> getLast() {
        Node<T> current = this.head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        return current;
    }

    public Node<T> findNode(T value) {
        Node<T> current = this.head;
        while (current != null && current.getData().compareTo(value) != 0) {
            current = current.getNext();
        }
        return current != null && current.getData().compareTo(value) == 0 ? current : null;
    }

    public void print() {
        Node<T> current = this.head;
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
    }

}
