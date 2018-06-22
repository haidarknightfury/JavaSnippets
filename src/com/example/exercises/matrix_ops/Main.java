package com.example.exercises.matrix_ops;

public class Main {

    public static void main(String args[]) {
        Matrix m1 = new Matrix(3);
        m1.resetArray(10);

        Matrix m2 = new Matrix(3);
        m2.resetArray(5);

        MatrixOperation.MatrixSum().compute(m1, m2).print();

        MatrixOperation.MatrixSubs().compute(m1, m2).print();

    }
}
