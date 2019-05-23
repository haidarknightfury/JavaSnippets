package com.example.algo.Graph;

public class Node<T> {
    private String label;
    private T data;

    public Node() {
    }

    public Node(String label, T data) {
        super();
        this.label = label;
        this.data = data;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object obj) {
        return this.getLabel().equals(((Node<T>) obj).getLabel());
    }

    public T getData() {
        return this.data;
    }

    public String getLabel() {
        return this.label;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Node [label=" + this.label + ", data=" + this.data + "]";
    }

}
