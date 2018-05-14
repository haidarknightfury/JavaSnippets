# Lamda Expressions

- Lamda is a way of using functional programming in Java. 

1. Example 1
 
  - No need to create a class for the implementation of the MathOperation
  - Lamdas are in the format : () -> {}  
  - If there is only one parameter - param -> operate(param);
  - Assigning a lamda to an interface requires there is only one method in the interface
  - The lamda is then matched accordingly to the type and method

```java
  public class Example1{
    public static void main(String [] args) {

      Example1 Test = new Example1();
      
      // returns a single value if there is single line
      MathOperation addition = (int a, int b)-> a + b;
      MathOperation substraction = (int a, int b)-> a - b;
      MathOperation multiplication = (int a, int b)-> a * b;

      // multiple lines - braces are required
      MathOperation division = (int a, int b)-> {
        return a/b;
      };

      // passing mathOperation as a parameter
      System.out.println(Tester.operate(4,4,addition));
      // directly passing the lamda [to be confirmed]
      System.out.println(Tester.operate(4,4,(a,b)-> a % b);

      // executing the lambda directly
      System.out.println(addition.operation(4,5));

      // MessageService - way of calling the lambda - the lambda is mapped to the only method in the interface
      MessageService messageService = message -> System.out.println("Hello"+ message);
      messageService.sayMesssage("world"); // execute the lambda 
    }

    private int operate(int a, int b, MathOperation mathOperation){
      return mathOperation.operation(a,b);
    }

    interface MathOperation{
      int operation(int a, int b);
    }

    interface MessageService{
      void sayMessage(String message);
    }
  }

```

2. Example 2 - Static method reference

```java
    public class Example2{
      public static void main(String [] args){
        List names = new ArrayList<>();
        names.add("Name 1");
        names.add("Name 2");

        // System.out::println method as a static method reference
        // each name will be mapped as parameter to System.out.println and printLn takes as parameter a string
        names.forEach(System.out::println);

      }
    }

```


3. Example 3 - More example

```java
  public class Example3{

    public static void main(String [] args){
      //paramters can also not be typed  to int
      // can use a predicate for this kind of situation where boolean is returned
      NumericTest testEven = (n) -> n % 2 == 0;
      NumericTest testOdd = (n) -> !testEven.test(n);

      System.out.println(testEven.test(10));
      System.out.println(testOdd.test(10));
    }

    // interface with only one method - use @functionalInterface
    interface NumericTest{
      boolean test(int n);
    }
  }

```



