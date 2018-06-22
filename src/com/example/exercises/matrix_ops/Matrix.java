/**
 * The class <strong>Matrix.java</strong>.
 *
 * @author hdargaye
 * @version 1.0
 *
 * @since JavaSnippets Jun 6, 2018
 */
package com.example.exercises.matrix_ops;

/**
 * The Class Matrix.
 */
public class Matrix {

    /** The array. */
    private Integer[][] array;

    /** The size. */
    private Integer size;

    /**
     * Instantiates a new matrix.
     */
    public Matrix(int size) {
        this.size = size;
        this.array = new Integer[this.size][this.size];
        this.resetArray(0);
    }

    /**
     * Reset array.
     */
    public void resetArray(int value) {
        for (int i = 0; i < this.array.length; i++) {
            for (int j = 0; j < this.array[i].length; j++) {
                this.array[i][j] = value;
            }
        }
    }

    public void print() {
        System.out.println("Matrix [size=" + this.size + "]");
        for (int i = 0; i < this.array.length; i++) {
            for (int j = 0; j < this.array[i].length; j++) {
                System.out.print(this.array[i][j] + " ");
            }
            System.out.println();
        }

    }

    /**
     * Sets the array.
     *
     * @param i the i
     * @param j the j
     * @param value the value
     */
    public void setArray(int i, int j, Integer value) {
        this.array[i][j] = value;
    }

    /**
     * Gets the array at.
     *
     * @param i the i
     * @param j the j
     * @return the array at
     */
    public Integer getArrayAt(int i, int j) {
        return this.array[i][j];
    }

    /**
     * Gets the array.
     *
     * @return the array
     */
    public Integer[][] getArray() {
        return this.array;
    }

    /**
     * Sets the array.
     *
     * @param array the new array
     */
    public void setArray(Integer[][] array) {
        this.array = array;
    }

    /**
     * Gets the size.
     *
     * @return the size
     */
    public Integer getSize() {
        return this.size;
    }

    /**
     * Sets the size.
     *
     * @param size the new size
     */
    public void setSize(Integer size) {
        this.size = size;
    }

}
