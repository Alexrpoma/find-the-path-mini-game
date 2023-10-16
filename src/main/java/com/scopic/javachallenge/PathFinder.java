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
        Path path = new Path();
        int codeIndex = 0;
        int row = 0;
        int col = 0;
        if (sequences.size() == 1) {
            Sequence sequence = sequences.get(0);
            List<Integer> codes = sequence.codes;
            int sequenceLength = codes.size();
            finder(codes, sequenceLength, codeIndex, col, row, path);
            return path;
        }
        List<Sequence> overlapSequences = SequenceOverlapping.apply(sequences);
        if (overlapSequences != null) {
            sequencesFinder(overlapSequences, codeIndex, col, row, path);
        }
        else {
            sequencesFinder(sequences, codeIndex, col, row, path);
        }
        return path;
    }

    private void sequencesFinder(List<Sequence> overlapSequences, int codeIndex, int col, int row, Path path) {
        for (Sequence sequence : overlapSequences) {
            List<Integer> codes = sequence.codes;
            int sequenceLength = codes.size();
            finder(codes, sequenceLength, codeIndex, col, row, path);
            // Only the first solution for now
            if (!path.positions.isEmpty()) break;
        }
    }

    // You can add your own class members here.
    private void finder(List<Integer> codes, int sequenceLength, int codeIndex, int col, int row, Path path) {
        while (codeIndex < sequenceLength) {
            int code = codes.get(codeIndex);
            if (codeIndex % 2 == 0) {
                col = findColInRow(code, matrix, row);
                if (col != -1) {
                    path.addPosition(row, col);
                    codeIndex++;
                }
            } else {
                row = findRowInCol(code, matrix, col);
                if (row != -1) {
                    path.addPosition(row, col);
                    codeIndex++;
                }
            }
            if (row == -1 || col == -1) {
                path.deleteLastPosition();
                if (path.positions.isEmpty()) {
                    row = 0;
                    col = 0;
                } else {
                    Position lastPosition = path.positions.get(path.positions.size() - 1);
                    row = lastPosition.row;
                    col = lastPosition.column;
                }
                codeIndex--;
            }
        }
    }

    private int findColInRow(int code, Matrix matrix, int row) {
        for (int col = 0; col < matrix.getColumnCount(); col++) {
            if (matrix.getValue(row, col) == code) {
                matrix.values[row][col] = -1;
                return col;
            }
        }
        return -1;
    }

    private int findRowInCol(int code, Matrix matrix, int col) {
        for (int row = 0; row < matrix.getRowCount(); row++) {
            if (matrix.getValue(row, col) == code) {
                matrix.values[row][col] = -1;
                return row;
            }
        }
        return -1;
    }

}
