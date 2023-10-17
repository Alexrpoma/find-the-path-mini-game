package com.scopic.javachallenge;

import java.util.ArrayList;
import java.util.List;

public class SequenceOverlapping {

  public static List<Sequence> apply(List<Sequence> sequences) {

    if (sequences.size() != 2) {
      System.out.println("Overlapping for more than 2 sequences is not supported yet.");
      return sequences;
    }

    List<Integer> sequence1 = sequences.get(0).codes;
    List<Integer> sequence2 = sequences.get(1).codes;
    List<Integer> result1 = new ArrayList<>();
    List<Integer> result2 = new ArrayList<>();
    List<Sequence> finalResult = new ArrayList<>();
    int totalScore = sequences.get(0).score + sequences.get(1).score;

    if (sequence1.contains(sequence2.get(0))) {
      result1 = overlappingTwoSequences(sequence1, sequence2);
    }
    if (sequence2.contains(sequence1.get(0))) {
      result2 = overlappingTwoSequences(sequence2, sequence1);
    }
    if (!result1.isEmpty() || !result2.isEmpty()) {
      if (!result1.isEmpty()) finalResult.add(new Sequence(result1, totalScore));
      if (!result2.isEmpty()) finalResult.add(new Sequence(result2, totalScore));
      return finalResult;
    }
    System.out.println("Overlapping: IMPOSSIBLE");
    result1.addAll(sequence1);
    result1.addAll(sequence2);
    finalResult.add(new Sequence(result1, totalScore));
    result2.addAll(sequence2);
    result2.addAll(sequence1);
    finalResult.add(new Sequence(result2, totalScore));
    return finalResult;
  }

  private static List<Integer> overlappingTwoSequences(List<Integer> sequence1, List<Integer> sequence2) {
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < sequence1.size(); i++) {
      if (sequence1.get(i).equals(sequence2.get(0))) {
        List<Integer> sliceSeq1 = sequence1.subList(i, sequence1.size());
        List<Integer> sliceSeq2;
        if (sliceSeq1.size() > sequence2.size()) {
          sliceSeq1 = sliceSeq1.subList(0, sequence2.size());
          if (sliceSeq1.equals(sequence2)) {
            result.addAll(sequence1);
            break;
          }
        }
        else {
          sliceSeq2 = sequence2.subList(0, sliceSeq1.size());
          if (sliceSeq1.equals(sliceSeq2)) {
            result.addAll(sequence1.subList(0, i));
            result.addAll(sequence2);
            break;
          }
        }
      }
    }
    return result;
  }
}
