package com.example.snippets.threading.spliterator;

import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SpliteratorExample {

    public static void main(String[] args) {

        // 1. Generating list using stream
        List<Utility> utilities = Stream.generate(() -> new Utility("Hello")).limit(3).collect(Collectors.toList());

        // 2. Obtain the spliterator using spliterator API
        Spliterator<Utility> spliter1 = utilities.spliterator();

        // 3. Try advance - if an element present next, advance to next element
        Boolean hasNextElement = spliter1.tryAdvance(t ->
            {
                System.out.println(t.getName());
            });
        System.out.println(hasNextElement ? "Has Element Present" : "No Element Present"); // Meanwhile spliterator has one element less

        // 4. estimateSize - to get the estimated size of the spliterator
        System.out.println("BEFORE SPLITTING");
        System.out.println(spliter1.estimateSize());

        // 5. Splitting the spliterator into half - if more granular , would need to implement own spliterator
        Spliterator<Utility> spliter2 = spliter1.trySplit(); // Null if cannot be split
        System.out.println(spliter1.characteristics()); // CHARACTERISTIC of spliterator - ORDERED/SORTED/SUBSIZED

        // 6. Checking size after splits
        System.out.println(spliter1.estimateSize());
        spliter1.forEachRemaining(System.out::println);
        System.out.println("==============");
        System.out.println(spliter2.estimateSize());
        spliter2.forEachRemaining(System.out::println);
    }

}
