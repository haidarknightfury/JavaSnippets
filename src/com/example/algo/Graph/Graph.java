package com.example.algo.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph<T extends Comparable<T>> {
    private Map<String, List<Node<T>>> graph;

    public Graph() {
        this.setGraph(new HashMap<>());
    }

    public void addLink(Node<T> first, Node<T> second) {
        this.graph.computeIfPresent(first.getLabel(), (str, list) ->
            {
                if (!list.contains(second)) {
                    list.add(second);
                }
                return list;
            });

        this.graph.computeIfAbsent(first.getLabel(), (str) ->
            {
                ArrayList<Node<T>> arrayList = new ArrayList<>();
                arrayList.add(second);
                return arrayList;
            });
    }

    public void delete(Node<T> node) {
        this.graph.remove(node.getLabel());
    }

    public Map<String, List<Node<T>>> getGraph() {
        return this.graph;
    }

    public void printGraph() {
        this.graph.entrySet().stream().forEach(entry ->
            {
                System.out.println(entry.getKey() + " : " + entry.getValue());

            });
    }

    public void setGraph(Map<String, List<Node<T>>> graph) {
        this.graph = graph;
    }

    public void traversal(Node<T> labelStart) {
        Deque<Node<T>> stack = new ArrayDeque<Node<T>>();
        List<Node<T>> visited = new ArrayList<>();
        stack.add(labelStart);
        while (!stack.isEmpty()) {
            Node<T> current = stack.pop();
            List<Node<T>> nodesAttached = this.graph.getOrDefault(current.getLabel(), new ArrayList<>());
            nodesAttached.stream().filter(node -> visited.contains(node) || !stack.contains(node)).forEach(node ->
                {
                    stack.addLast(node);
                });
            if (!visited.contains(current)) {
                visited.add(current);
            }

        }
    }

}
