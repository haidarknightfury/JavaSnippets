package com.example.otherpatterns.threadpool_pattern;

public class EmployeeBasicProcessingTask extends Task {

    public static final int TIME_PER_TASK = 100;

    public EmployeeBasicProcessingTask(int numEmployees) {
        super(numEmployees * TIME_PER_TASK);
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.getClass().getSimpleName(), super.toString());
    }

}
