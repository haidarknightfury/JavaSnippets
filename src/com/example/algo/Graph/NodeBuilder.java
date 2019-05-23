package com.example.algo.Graph;

public class NodeBuilder<T> {

    String label;
    T data;

    public NodeBuilder() {
    }

    public Node<T> build() {
        return new Node<T>(this.label, this.data);
    }

    public NodeBuilder<T> ofData(T data) {
        this.data = data;
        return this;
    }

    public NodeBuilder<T> ofLabel(String label) {
        this.label = label;
        return this;
    }
}
