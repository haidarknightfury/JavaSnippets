# Using Maps in JAVA 8

```java
  public class Example1 {
  public static void main(String[] args) {

    Map<Integer, String> map = new HashMap<>();
    for (int i = 0; i < 10; i++) {
      map.putIfAbsent(i, "val" + i);
    }

    map.forEach((id, val) -> System.out.println(val));

    ArrayList<String> values = (ArrayList<String>) map.values().stream().collect(Collectors.toList());
    ArrayList<Integer> keys = (ArrayList<Integer>) map.keySet().stream().filter(x -> x > 5)
        .collect(Collectors.toList());

    // change the value of Map.get(3) to value+key
    map.computeIfPresent(3, (num, val) -> val + num);
    System.out.println(map.get(3)); 

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

    // MERGING ENTRIES
    // value is value at 9, newValue is "val9"
    map.merge(9, "val9", (value, newValue) -> valu.concat(newValue));
    System.out.println(map.get(9));

    // similar to merge
    if(map.contains(9)){
      map.get(9).concat("val9");
    }
    else{
      map.put(9,"val9")
    }

    map.merge(9, "concat", (value, newValue) -> valu.concat(newValue));
    System.out.println(map.get(9));

  }
}


```