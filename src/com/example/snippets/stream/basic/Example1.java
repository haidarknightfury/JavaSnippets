package com.example.snippets.stream.basic;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Example1 {
    // stream() -Returns a sequential stream considering collection as its source.
    // parallelStream() - Returns a parallel Stream considering collection as its
    // source.

    public static void main(String[] args) {

        List<String> strings = Arrays.asList("abc", "bc", "", "efg", "");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

        // foreach
        Random random = new Random();
        // limit- reduce size of stream
        random.ints().limit(10).forEach(System.out::println);

        // map- map element to corresponding result
        List<Integer> numbers = Arrays.asList(3, 4, 5, 6, 7, 8, 2, 4);
        List<Integer> squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        System.out.println("PRINTING SKIPPED LIST, SKIPPED 3 AND 4");
        numbers.stream().skip(2).forEach(System.out::println);

        // get count of empty string
        long count = strings.stream().filter(string -> string.isEmpty()).count();

        // sorted
        Random rnd = new Random();
        rnd.ints().limit(10).sorted().forEach(System.out::println);

        List<String> strings2 = Arrays.asList("abc", "", "dc", "edf");
        long count2 = strings2.parallelStream().filter(string -> string.isEmpty()).count();

        // collectors
        List<String> filters = strings.stream().filter(str -> !str.isEmpty()).collect(Collectors.toList());
        System.out.println(filters);

        String mergedStr = strings.stream().filter(str -> !str.isEmpty()).collect(Collectors.joining(", "));
        System.out.println(mergedStr);

        // statistics - min max avg sum
        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println(stats.getMax() + "," + stats.getSum());

    }

}
