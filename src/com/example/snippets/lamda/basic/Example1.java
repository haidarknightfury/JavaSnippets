package com.example.snippets.lamda.basic;

public class Example1 {

    public static void main(String[] args) {

        Example1 Tester = new Example1();

        MathOperation addition = (int a, int b) -> a + b;

        // returns value if a single line of operation is available
        MathOperation substraction = (a, b) -> a - b;

        // If there are multiple operations then curly braces are necessary
        MathOperation multiplication = (a, b) -> {
            return a * b;
        };

        MathOperation division = (a, b) -> a / b;

        System.out.println(Tester.operate(4, 4, addition));
        System.out.println(Tester.operate(4, 4, substraction));
        System.out.println(Tester.operate(4, 4, multiplication));
        System.out.println(Tester.operate(4, 4, division));

        MessageService messageService = message -> System.out.println("Hello" + message);
        messageService.sayMessage("World");

        // Test QuadFunction
        QuadFunction<Integer, Integer, Integer, Integer> quadFunction = (a, b, c) -> a + b + c;
        System.out.println(String.format("result of quad function is %s", quadFunction.operate(1, 2, 3)));
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface MessageService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }

    interface QuadFunction<T, U, V, W> {
        T operate(U u, V v, W w);
    }

}
