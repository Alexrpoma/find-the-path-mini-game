package com.scopic.javachallenge;
// ---------------------------------------------------------------------------------------------
// PLEASE DO NOT MODIFY, RENAME OR REMOVE ANY OF CLASSES, METHODS AND VARIABLES BELOW
// EXCEPT PATHFINDER.RUN() METHOD THAT YOU NEED TO IMPLEMENT.
// YOU CAN ADD YOUR OWN METHODS AND VARIABLES TO THE EXISTING CLASSES AND USE THEM IN YOUR WORK.
// ---------------------------------------------------------------------------------------------

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is used to find the shortest path with the highest score for a given matrix and a list of sequences.
 */
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
        dataValidate();
        Path path = new Path();
        sequencesFinder(SequenceOverlapping.apply(sequences), path);
        if (path.positions.size() > maxPathLength || path.positions.isEmpty()) {
            separateSequenceFinder(path);
        }
        return path;
    }

    private Sequence sequencesFinder(List<Sequence> sequences, Path path) {
        for (Sequence sequence : sequences) {
            for (int startRow = 0; startRow < matrix.getRowCount(); startRow++) {
                findPathForSequence(sequence, path, startRow);
                if (!path.positions.isEmpty()) return sequence;
            }
        }
        return null;
    }

    private void separateSequenceFinder(Path path) {
        path.positions.clear();
        //Sort sequences by highest score and shortest codes size
        sequences.sort((seq1, seq2) -> {
            if (seq1.score == seq2.score) {
                return seq1.codes.size() - seq2.codes.size();
            }
            return seq2.score - seq1.score;
        });

        Sequence sequenceWithSolution = sequencesFinder(sequences, path);

        //Here we try to find a path joining two sequences through wasted moves
        if (sequenceWithSolution != null) {
            List<Position> path1 = new ArrayList<>(path.positions);
            path.positions.clear();
            for (Sequence sequence : sequences) {
                if (!sequence.equals(sequenceWithSolution)) {
                    List<Sequence> sequences = new ArrayList<>();
                    sequences.add(sequence);
                    sequencesFinder(sequences, path);
                }
            }
            if (!path.positions.isEmpty()) {
                List<Position> path2 = new ArrayList<>(path.positions);
                if (!path1.get(path1.size() - 1).equals(path2.get(0))) {
                    Position positionConnector = new Position(path2.get(0).row, path1.get(path1.size() - 1).column);
                    if (!path1.contains(positionConnector) && !path2.contains(positionConnector)) {
                        path.positions.clear();
                        path.positions.addAll(path1);
                        path.positions.add(positionConnector);
                        path.positions.addAll(path2);
                        if (path.positions.size() > maxPathLength) {
                            path.positions.clear();
                            path.positions.addAll(path1);
                        }
                    }
                }
            } else {
                path.positions.addAll(path1);
            }
        }
        //--------------------------------------------------------------------
        if (path.positions.isEmpty()) {
            throw new PathNotFoundError("Path not found");
        }
    }


    private void findPathForSequence(Sequence sequence, Path path, int row) {
        List<Integer> codes = sequence.codes;
        int sequenceLength = codes.size();
        int codeIndex = 0;
        int col = 0;
        Map<Position, Integer> visitedPositions = new HashMap<>();
        while (codeIndex < sequenceLength) {
            int code = codes.get(codeIndex);
            if (codeIndex % 2 == 0) {
                col = findColInRow(code, matrix, row);
                if (col != -1) {
                    visitedPositions.put(new Position(row, col), code);
                    if (row > 0 && codeIndex == 0) {
                        // wasted move
                        matrix.values[row][col] = code; // restore first found code in matrix
                        addWastedMove(sequence, path, col, codes);
                        break;
                    }
                    path.addPosition(row, col);
                    codeIndex++;
                }
            } else {
                row = findRowInCol(code, matrix, col);
                if (row != -1) {
                    visitedPositions.put(new Position(row, col), code);
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
        // restore matrix
        visitedPositions.forEach(
            (position, savedCode) -> matrix.values[position.row][position.column] = savedCode
        );
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

    private void dataValidate() {
        DataValidator.apply(matrix, sequences, maxPathLength);
    }

}
