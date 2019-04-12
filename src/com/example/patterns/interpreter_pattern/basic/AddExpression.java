package com.example.patterns.interpreter_pattern.basic;

public class AddExpression implements Expression {

    private String expression;

    public AddExpression(String expression) {
        this.setExpression(expression);
    }

    @Override
    public int interpret(InterpreterEngine engine) {
        return engine.add(this.getExpression());
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}
