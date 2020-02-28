package com.example.otherpatterns.pipeline_pattern;

public class Main {

    public static class AdditionInput {
        public final int int1;
        public final int int2;

        public AdditionInput(int int1, int int2) {
            this.int1 = int1;
            this.int2 = int2;
        }
    }

    public static class AddIntegersStep implements Step<AdditionInput, Integer> {
        @Override
        public Integer process(AdditionInput input) {
            return input.int1 + input.int2;
        }
    }

    public static class IntToStringStep implements Step<Integer, String> {
        @Override
        public String process(Integer input) {
            return input.toString();
        }
    }

    public static class Detailized implements Step<String, String> {

        @Override
        public String process(String input) throws StepException {
            return "The sum is " + input;
        }

    }

    public static void main(String[] args) {
        Pipeline<AdditionInput, String> pipeline = new Pipeline<>(new AddIntegersStep()).pipe(new IntToStringStep()).pipe(new Detailized());
        System.out.println(pipeline.execute(new AdditionInput(1, 3))); // outputs 4
    }

}
