package com.example.dailyproblem;

public class Problem6 {

    public static void main(String args[]) {

        XORNode head = new XORNode();
        head.data = 5;

        XORNode next = new XORNode();
        next.data = 10;

        int xor = head.data ^ next.data;
        System.out.println(xor);

    }

    public static class XORNode {

        Integer data;

        XORNode both;

    }

    public static class XORLinkedList {

        XORNode head;

        public void add() {

        }

        public XORNode get(int index) {
            return new XORNode();
        }

    }

}
