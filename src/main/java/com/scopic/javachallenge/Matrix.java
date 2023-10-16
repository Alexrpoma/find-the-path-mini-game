package com.scopic.javachallenge;
// ---------------------------------------------------------------------------------------------
// PLEASE DO NOT MODIFY, RENAME OR REMOVE ANY OF CLASSES, METHODS AND VARIABLES BELOW.
// YOU CAN ADD YOUR OWN METHODS AND VARIABLES TO THE EXISTING CLASSES AND USE THEM IN YOUR WORK.
// ---------------------------------------------------------------------------------------------

public class Matrix {
    int[][]  values;

    public Matrix(int[][] values) {
        this.values = values;
    }

    public int getRowCount(){
        return this.values.length;
    }

    public int getColumnCount(){
        return this.values[0].length;
    }

    public int getValue(int row, int column){
        return this.values[row][column];
    }

    // You can add your own class members here.
}
