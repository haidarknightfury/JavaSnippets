package com.example.algo.LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(new Node<>(1));
        linkedList.add(new Node<>(1));
        linkedList.add(new Node<>(1));
        linkedList.add(new Node<>(1));

        linkedList.print();
    }

}
