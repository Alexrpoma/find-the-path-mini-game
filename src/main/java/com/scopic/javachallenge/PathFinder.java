package com.scopic.javachallenge;
// ---------------------------------------------------------------------------------------------
// PLEASE DO NOT MODIFY, RENAME OR REMOVE ANY OF CLASSES, METHODS AND VARIABLES BELOW
// EXCEPT PATHFINDER.RUN() METHOD THAT YOU NEED TO IMPLEMENT.
// YOU CAN ADD YOUR OWN METHODS AND VARIABLES TO THE EXISTING CLASSES AND USE THEM IN YOUR WORK.
// ---------------------------------------------------------------------------------------------

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PathFinder {
    public Matrix matrix;
    public List<Sequence> sequences;
    public int maxPathLength;

    public PathFinder(Matrix matrix, List<Sequence> sequences, int maxPathLength) {
        this.matrix = matrix;
        this.sequences = sequences;
        this.maxPathLength = maxPathLength;

       
    }

    public Path run() {
        // You can add your own class members here.
        return new Path();
    }

    // You can add your own class members here.




}
