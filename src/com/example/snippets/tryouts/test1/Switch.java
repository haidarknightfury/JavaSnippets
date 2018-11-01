package com.example.snippets.tryouts.test1;

import java.util.ArrayList;
import java.util.List;

/**
 * Generic enabled Object Oriented Switch/Case construct
 * LINK :: https://stackoverflow.com/questions/5086322/java-switch-statement-multiple-cases
 * http://www.vertigrated.com/blog/2011/02/a-generic-object-oriented-replacement-for-large-switch-case-and-if-else-statements-in-java/
 * 
 * @param <T> type to switch on
 */
public class Switch<T extends Comparable<T>> {
    private final List<Case<T>> cases;

    public Switch() {
        this.cases = new ArrayList<>();
    }

    /**
     * Register the Cases with the Switch
     *
     * @param c case to register
     */
    public void register(final Case<T> c) {
        this.cases.add(c);
    }

    /**
     * Run the switch logic on some input
     *
     * @param type input to Switch on
     */
    public void evaluate(final T type) {
        for (final Case<T> c : this.cases) {
            if (c.of(type)) {
                break;
            }
        }
    }

    /**
     * Generic Case condition
     *
     * @param <T> type to accept
     */
    public static interface Case<T extends Comparable<T>> {
        public boolean of(final T type);
    }

    public static abstract class AbstractCase<T extends Comparable<T>> implements Case<T> {
        protected final boolean breakOnCompletion;

        protected AbstractCase() {
            this(true);
        }

        protected AbstractCase(final boolean breakOnCompletion) {
            this.breakOnCompletion = breakOnCompletion;
        }
    }

    /**
     * Example of standard "equals" case condition
     *
     * @param <T> type to accept
     */
    public static abstract class EqualsCase<T extends Comparable<T>> extends AbstractCase<T> {
        private final T type;

        public EqualsCase(final T type) {
            super();
            this.type = type;
        }

        public EqualsCase(final T type, final boolean breakOnCompletion) {
            super(breakOnCompletion);
            this.type = type;
        }
    }

    /**
     * Concrete example of an advanced Case conditional to match a Range of values
     *
     * @param <T> type of input
     */
    public static abstract class InRangeCase<T extends Comparable<T>> extends AbstractCase<T> {
        private final static int GREATER_THAN = 1;
        private final static int EQUALS = 0;
        private final static int LESS_THAN = -1;
        protected final T start;
        protected final T end;

        public InRangeCase(final T start, final T end) {
            this.start = start;
            this.end = end;
        }

        public InRangeCase(final T start, final T end, final boolean breakOnCompletion) {
            super(breakOnCompletion);
            this.start = start;
            this.end = end;
        }

        private boolean inRange(final T type) {
            return (type.compareTo(this.start) == EQUALS || type.compareTo(this.start) == GREATER_THAN) &&
                    (type.compareTo(this.end) == EQUALS || type.compareTo(this.end) == LESS_THAN);
        }
    }

    /**
     * Show how to apply a Chain of Responsibility Pattern to implement a Switch/Case construct
     *
     * @param args command line arguments aren't used in this example
     */
    public static void main(final String[] args) {
        final Switch<Integer> integerSwitch = new Switch<>();
        final Case<Integer> case1 = new EqualsCase<Integer>(1) {
            @Override
            public boolean of(final Integer type) {
                if (super.type.equals(type)) {
                    System.out.format("Case %d, break = %s\n", type, super.breakOnCompletion);
                    return super.breakOnCompletion;
                } else {
                    return false;
                }
            }
        };
        integerSwitch.register(case1);
        // more instances for each matching pattern, granted this will get verbose with lots of options but is just
        // and example of how to do standard "switch/case" logic with this pattern.
        integerSwitch.evaluate(0);
        integerSwitch.evaluate(1);
        integerSwitch.evaluate(2);

        final Switch<Integer> inRangeCaseSwitch = new Switch<>();
        final Case<Integer> rangeCase = new InRangeCase<Integer>(5, 100) {
            @Override
            public boolean of(final Integer type) {
                if (super.inRange(type)) {
                    System.out.format("Case %s is between %s and %s, break = %s\n", type, this.start, this.end, super.breakOnCompletion);
                    return super.breakOnCompletion;
                } else {
                    return false;
                }
            }
        };
        inRangeCaseSwitch.register(rangeCase);
        // run some examples
        inRangeCaseSwitch.evaluate(0);
        inRangeCaseSwitch.evaluate(10);
        inRangeCaseSwitch.evaluate(200);

        // combining both types of Case implementations
        integerSwitch.register(rangeCase);
        integerSwitch.evaluate(1);
        integerSwitch.evaluate(10);

    }
}