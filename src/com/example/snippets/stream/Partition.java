package com.example.snippets.stream;

import static java.util.stream.Collectors.groupingBy;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Partition {

    public static void main(String[] args) {
        final List<String> list = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "X");
        final AtomicInteger counter = new AtomicInteger(0);
        final int size = 5;

        // 0/5 -> 0 , 1/5 -> 0, 2/5->0 , 3/5->0, 4/5->0
        // 5/5 -> 1 , 6/5 -> 1, 7/5->1 , 8/5->1, 9/5->1
        // groupyBy ->
        final Collection<List<String>> partitioned = list.stream().collect(groupingBy(it -> counter.getAndIncrement() / size)).values();
        partitioned.forEach(System.out::println);
    }

}
