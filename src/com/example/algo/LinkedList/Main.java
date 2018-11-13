package com.example.algo.LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(new Node<>(1));
        linkedList.add(new Node<>(2));
        linkedList.add(new Node<>(3));
        linkedList.add(new Node<>(4));

        linkedList.print();

        System.out.println(linkedList.getLast());
        System.out.println(linkedList.findNode(3));
        System.out.println(linkedList.findNode(4));

    }

}
