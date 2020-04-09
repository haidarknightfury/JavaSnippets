package com.example.otherpatterns.threadpool_pattern;

public class EmployeeAdvancedProcessingTask extends Task {

    public static final int TIME_PER_TASK = 200;

    public EmployeeAdvancedProcessingTask(int numEmployees) {
        super(numEmployees * TIME_PER_TASK);
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.getClass().getSimpleName(), super.toString());
    }

}
