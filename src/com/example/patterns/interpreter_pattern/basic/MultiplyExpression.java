package com.example.patterns.interpreter_pattern.basic;

public class MultiplyExpression implements Expression {

    private String input;

    public MultiplyExpression(String input) {
        super();
        this.input = input;
    }

    public String getInput() {
        return this.input;
    }

    @Override
    public int interpret(InterpreterEngine engine) {
        return engine.multiply(this.getInput());
    }

    public void setInput(String input) {
        this.input = input;
    }

}
