package com.example.snippets.lamda.functional_interface.example2;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

// Function are functional interface that take an argument and produce a reply
// call method apply to apply the lambda to the argument
// T is input and R is result
public class AdderImpl implements Adder {

  // function takes an argument and returns an argument
  @Override
  public String add(Function<String, String> f) {
    return f.apply("something");
  }

  // consumer takes an argument but does not return anything
  @Override
  public void addInt(Consumer<Integer> f) {
    f.accept(1);
  }

  // supplier takes no argument but must return an object
  @Override
  public String addStr(Supplier<String> f) {
    return f.get();
  }

  public static void main(String[] args) {
    AdderImpl adder = new AdderImpl();

    String result = adder.add(p -> {
      return p.substring(0, 3);
    });
    System.out.println(result);

    // apply to lowercase
    System.out.println(adder.add(String::toLowerCase));

    adder.addInt(f -> System.out.println(f));

    // supplier takes no arguments
    adder.addStr(() -> "str");

    Function<Integer, Integer> even = p -> {
      return p % 2;
    };

    System.out.println(even.apply(10));
  }
}
