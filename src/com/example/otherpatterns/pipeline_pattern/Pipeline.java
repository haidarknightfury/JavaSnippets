package com.example.otherpatterns.pipeline_pattern;

public class Pipeline<I, O> {
    private final Step<I, O> current;

    public Pipeline(Step<I, O> current) {
        this.current = current;
    }

    <NewO> Pipeline<I, NewO> pipe(Step<O, NewO> next) {
        return new Pipeline<>(input -> next.process(this.current.process(input)));
    }

    public O execute(I input) throws Step.StepException {
        return this.current.process(input);
    }
}