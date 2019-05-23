package com.example.algo.Graph;

public class Main {

    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>();
        NodeBuilder<Integer> nodeBuilder = new NodeBuilder<>();
        graph.addLink(nodeBuilder.ofLabel("A").ofData(1).build(), nodeBuilder.ofLabel("B").ofData(1).build());
        graph.addLink(nodeBuilder.ofLabel("A").ofData(1).build(), nodeBuilder.ofLabel("C").ofData(1).build());
        graph.addLink(nodeBuilder.ofLabel("A").ofData(1).build(), nodeBuilder.ofLabel("D").ofData(1).build());

        graph.addLink(nodeBuilder.ofLabel("B").ofData(1).build(), nodeBuilder.ofLabel("C").ofData(1).build());

        graph.traversal(nodeBuilder.ofLabel("A").ofData(1).build());
        graph.delete(nodeBuilder.ofLabel("B").build());
        graph.printGraph();
    }
}
