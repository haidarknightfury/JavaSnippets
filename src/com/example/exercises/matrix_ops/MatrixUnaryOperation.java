package com.example.exercises.matrix_ops;

public class MatrixUnaryOperation {
	
	public static IMatrixUnaryOperation Transpose() {
		return (Matrix matrix) ->{
			Matrix transpose= new Matrix(matrix.getSize());
			
			return matrix;
		};
		
	}
}
