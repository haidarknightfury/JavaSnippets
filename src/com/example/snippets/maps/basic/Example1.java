package com.example.snippets.maps.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Example1 {
    public static void main(String[] args) {

        // 1. Map if absent -> if value not present in map, enter it
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val" + i);
        }

        // 2. Looping a map
        map.forEach((id, val) -> System.out.println(val));

        // 3. Collecting keys and values
        ArrayList<String> values = (ArrayList<String>) map.values().stream().collect(Collectors.toList());
        ArrayList<Integer> keys = (ArrayList<Integer>) map.keySet().stream().filter(x -> x > 5).collect(Collectors.toList());

        // 4. change the value of Map.get(3) to value+key - In build commands to check
        map.computeIfPresent(3, (num, val) -> val + num);
        System.out.println(map.get(3));

        // 5. Inbuild command to check if absent
        map.computeIfAbsent(100, num -> "val" + num);
        System.out.println(map.get(100));

        // REMOVE ENTRIES
        map.remove(3, "val3"); // will remove only if 3 maps to 'val3'
        Optional<String> value = Optional.of(map.get(3));
        System.out.println(value.orElse("NotFound"));

        map.remove(3, "val33");// now will remove
        Optional<String> value1 = Optional.ofNullable(map.get(3));
        System.out.println(value1.orElse("not present"));

        map.getOrDefault(42, "not found");

        // 7. MERGING ENTRIES
        map.merge(9, "val9", (valu, newValue) -> valu.concat(newValue));
        System.out.println(map.get(9));

        map.merge(9, "concat", (valu, newValue) -> valu.concat(newValue));
        System.out.println(map.get(9));

    }
}
