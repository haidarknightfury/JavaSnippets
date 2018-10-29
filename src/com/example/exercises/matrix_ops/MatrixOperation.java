package com.example.exercises.matrix_ops;

public class MatrixOperation {

    public static IMatrixOperation MatrixSum() {
        return (Matrix m1, Matrix m2) -> {
            Matrix result = new Matrix(m1.getSize());
            for (int i = 0; i < m1.getSize(); i++) {
                for (int j = 0; j < m2.getSize(); j++) {
                    result.setArray(i, j, m1.getArrayAt(i, j) + m2.getArrayAt(i, j));
                }
            }
            return result;
        };
    }

    public static IMatrixOperation MatrixSubs() {
        return (Matrix m1, Matrix m2) -> {
            Matrix result = new Matrix(m1.getSize());
            for (int i = 0; i < m1.getSize(); i++) {
                for (int j = 0; j < m2.getSize(); j++) {
                    result.setArray(i, j, m1.getArrayAt(i, j) - m2.getArrayAt(i, j));
                }
            }
            return result;
        };
    }
    
    
    public static IMatrixOperation MatrixDotProduct() {
    		return (Matrix m1, Matrix m2)->{
    			Matrix result = new Matrix(m1.getSize());
    			for(int i=0;i< m1.getSize();i++) {
    				for(int j =0; j<m2.getSize(); j++) {
    					result.setArray(i,j, m1.getArrayAt(i, j)* m2.getArrayAt(i, j));
    				}
    			}
				return result;
    		};
    }
   

}
