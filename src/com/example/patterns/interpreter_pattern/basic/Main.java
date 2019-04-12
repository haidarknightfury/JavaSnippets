package com.example.patterns.interpreter_pattern.basic;

public class Main {

    public static void main(String[] args) {
        Main main = new Main(new InterpreterEngine());
        System.out.println(main.interpret("add 10 and 2"));
        System.out.println(main.interpret("mult 10 and 2"));
    }

    private InterpreterEngine engine;

    public Main(InterpreterEngine engine) {
        this.engine = engine;
    }

    public int interpret(String input) {
        Expression expression = null;
        if (input.contains("add")) {
            expression = new AddExpression(input);
        } else if (input.contains("mult")) {
            expression = new MultiplyExpression(input);
        }
        return expression.interpret(this.engine);
    }

}
