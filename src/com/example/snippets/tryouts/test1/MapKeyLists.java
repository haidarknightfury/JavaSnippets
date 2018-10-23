package com.example.snippets.tryouts.test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapKeyLists {

    public static void main(String[] args) {

        Map<List<String>, String> mapList = new HashMap<>();
        mapList.put(Arrays.asList("1", "2"), "Haidar");

        List<String> keys = new ArrayList<>();
        keys.add("4");
        keys.add("3");
        Collections.sort(keys);

        mapList.put(keys, "Huss");

        String val = mapList.get(Arrays.asList("1", "2"));
        String val2 = mapList.get(Arrays.asList("3", "4"));

        System.out.println(val);
        System.out.println(val2);
    }

}
