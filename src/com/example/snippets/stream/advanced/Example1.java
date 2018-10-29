package com.example.snippets.stream.advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.example.utilities.Animal;

public class Example1 {

    public static void main(String[] args) {
        // Chaining operations on Streams
        List<String> myList = Arrays.asList("a", "b", "c1", "c2", "c3");
        myList.stream().filter(s -> s.startsWith("c")).map(String::toUpperCase).forEach(System.out::println);

        // find first element in array
        myList.stream().findFirst().ifPresent(System.out::println);

        // Generating Streams
        IntStream.range(1, 4).forEach(System.out::println);
        IntStream.range(1, 4).map(n -> 2 * n + 1).average().ifPresent(System.out::println);

        // Use of special mapping function - can convert Primitive to object using mapToObj
        Stream.of("c1", "c2", "c3").map(s -> s.substring(1)).mapToInt(Integer::parseInt).max().ifPresent(System.out::println);

        // anyMatch && allMatch

        // Use of collectors - transform into List, Set or Map
        List<Animal> animals = Arrays.asList(new Animal("HD", "Dog"), new Animal("HA", "Cat"), new Animal("HA", "Cat"), new Animal("HAB", "Cat"));
        animals.stream().filter(an -> an.name.startsWith("H")).collect(Collectors.toList());

        // Use of collectors to collect into a Map
        Map<String, List<Animal>> animalByCategory = animals.stream().collect(Collectors.groupingBy(an -> an.category));
        animalByCategory.forEach((cat, listofAnimals) -> System.out.format("type %s: %s", cat, listofAnimals));
        System.out.println();

        // https://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/

        // Grouping by a list of values
        Function<Animal, List<Object>> groupByAnimalDetails = anim -> Arrays.asList(anim.category, anim.name);
        Map<Object, List<Animal>> mapAnimals = animals.stream().collect(Collectors.groupingBy(groupByAnimalDetails, Collectors.toList()));
        System.out.println("Grouping Animals by category and name");
        System.out.println(mapAnimals);

        List<List<Animal>> animalsGrouped = new ArrayList<>(mapAnimals.values());
        System.out.println("List of List of animals grouped" + animalsGrouped);
        List<Animal> allAnimals = animalsGrouped.stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println("All Animals" + allAnimals);

    }

}
