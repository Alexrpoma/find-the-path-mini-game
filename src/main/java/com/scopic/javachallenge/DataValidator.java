package com.scopic.javachallenge;

import java.util.List;

public class DataValidator {
  public static void apply(Matrix matrix, List<Sequence> sequences, int maxPathLength) {
    if (matrix.getRowCount() == 0 || matrix.getColumnCount() == 0) {
      throw new InvalidArgumentError("Matrix must not be empty.");
    }
    if (sequences.isEmpty()) {
      throw new InvalidArgumentError("There should be at least one sequence.");
    }
    for (Sequence sequence : sequences) {
      if (sequence.empty()) {
        throw new InvalidArgumentError("All sequences should be non-empty.");
      }
      if (sequence.score <= 0) {
        throw new InvalidArgumentError("All sequences should have a score greater than zero.");
      }
    }
    if (maxPathLength <= 0) {
      throw new InvalidArgumentError("Maximum path length should be greater than zero.");
    }
  }
}
