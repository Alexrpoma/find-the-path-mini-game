package com.scopic.javachallenge;
// ---------------------------------------------------------------------------------------------
// PLEASE DO NOT MODIFY, RENAME OR REMOVE ANY OF CLASSES, METHODS AND VARIABLES BELOW
// EXCEPT PATHFINDER.RUN() METHOD THAT YOU NEED TO IMPLEMENT.
// YOU CAN ADD YOUR OWN METHODS AND VARIABLES TO THE EXISTING CLASSES AND USE THEM IN YOUR WORK.
// ---------------------------------------------------------------------------------------------

import java.util.ArrayList;
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
        Path path = new Path();
        if (sequences.size() == 1) {
            for (int startRow = 0; startRow < matrix.getRowCount(); startRow++) {
                findPathForSequence(sequences.get(0), path, startRow);
                if (!path.positions.isEmpty()) break;
            }
            return path;
        }
        List<Sequence> overlapSequences = SequenceOverlapping.apply(sequences);
        if (overlapSequences != null) {
            sequencesFinder(overlapSequences, path);
        }
        else {
            sequencesFinder(sequences, path);
        }
        if (path.positions.size() == maxPathLength) {
            System.out.println("Max path length reached: " + maxPathLength);
        }
        if (path.positions.isEmpty()) {
            System.out.println("Path: NOT FOUND");
        }
        return path;
    }

    private void sequencesFinder(List<Sequence> overlapSequences, Path path) {
        for (Sequence sequence : overlapSequences) {
            for (int startRow = 0; startRow < matrix.getRowCount(); startRow++) {
                findPathForSequence(sequence, path, startRow);
                if (!path.positions.isEmpty()) break;
            }
            // Only the first solution for now
            if (!path.positions.isEmpty()) break;
        }
    }

    // You can add your own class members here.
    private void findPathForSequence(Sequence sequence, Path path, int row) {
        List<Integer> codes = sequence.codes;
        int sequenceLength = codes.size();
        int codeIndex = 0;
        int col = 0;
        while (codeIndex < sequenceLength) {
            int code = codes.get(codeIndex);
            if (codeIndex % 2 == 0) {
                col = findColInRow(code, matrix, row);
                if (col != -1) {
                    if (row > 0 && codeIndex == 0) {
                        // wasted move
                        matrix.values[row][col] = code;
                        addWastedMove(sequence, path, col, codes);
                        break;
                    }
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
            if (codeIndex < 0) {
                break;
            }
        }
    }

    private void addWastedMove(Sequence sequence, Path path, int col, List<Integer> codes) {
        List<Integer> newSequence = new ArrayList<>();
        newSequence.add(matrix.getValue(0, col));
        newSequence.addAll(codes);
        findPathForSequence(new Sequence(newSequence, sequence.score), path, 0);
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
