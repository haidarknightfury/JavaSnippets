package com.example.snippets.lamda.functional_interface.example2;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public interface Adder {

    String add(Function<String, String> f);

    void addInt(Consumer<Integer> f);

    String addStr(Supplier<String> f);
}
