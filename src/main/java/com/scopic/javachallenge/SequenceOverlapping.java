package com.scopic.javachallenge;

import java.util.ArrayList;
import java.util.List;

public class SequenceOverlapping {

  public static List<Sequence> apply(List<Sequence> sequences) {

    List<Sequence> result;

    if (sequences.size() == 1) {
      return sequences;
    }

    if (sequences.size() > 2) {
      for (int i = 0; i < sequences.size() -1; i++) {
        for (int j =1; j < sequences.size(); j++) {
          List<Sequence> sequencesToCombine = new ArrayList<>();
          sequencesToCombine.add(sequences.get(i));
          sequencesToCombine.add(sequences.get(j));
          List<Sequence> combinedSequences = combiningTwoSequences(sequencesToCombine);
          if (!combinedSequences.isEmpty()) {
            sequences.remove(i);
            sequences.remove(j-1);
            sequences.add(combinedSequences.get(0));
            return apply(sequences);
          }
        }
      }
      return sequences;
    }

    result = combiningTwoSequences(sequences);

    if (result.isEmpty()) {
      System.out.println("Overlapping: IMPOSSIBLE");
      int totalScore = sequences.get(0).score + sequences.get(1).score;
      //Concatenate the codes of the first sequence and then the codes of the second sequence
      List<Integer> joinedCodes1 = new ArrayList<>();
      joinedCodes1.addAll(sequences.get(0).codes);
      joinedCodes1.addAll(sequences.get(1).codes);
      result.add(new Sequence(joinedCodes1, totalScore));
      //Concatenate the codes of the second sequence and then the codes of the first sequence
      List<Integer> joinedCodes2 = new ArrayList<>();
      joinedCodes2.addAll(sequences.get(1).codes);
      joinedCodes2.addAll(sequences.get(0).codes);
      result.add(new Sequence(joinedCodes2, totalScore));
    }
    return result;
  }

  private static List<Sequence> combiningTwoSequences(List<Sequence> sequences) {
    List<Sequence> result = new ArrayList<>();
    List<Integer> codesSeq1 = sequences.get(0).codes;
    List<Integer> codesSeq2 = sequences.get(1).codes;
    if (codesSeq1.contains(codesSeq2.get(0))) {
      Sequence sequence = overlappingTwoSequences(sequences.get(0), sequences.get(1));
      if (sequence != null) result.add(sequence);
    }
    if (codesSeq2.contains(codesSeq1.get(0))) {
      Sequence sequence = overlappingTwoSequences(sequences.get(1), sequences.get(0));
      if (sequence != null) result.add(sequence);
    }
    return result;
  }

  private static Sequence overlappingTwoSequences(Sequence sequence1, Sequence sequence2) {
    for (int i = 0; i < sequence1.codes.size(); i++) {
      if (sequence1.codes.get(i).equals(sequence2.codes.get(0))) {
        List<Integer> subListCodesSeq1 = sequence1.codes.subList(i, sequence1.codes.size());
        List<Integer> subListsCodesSeq2;
        if (subListCodesSeq1.size() > sequence2.codes.size()) {
          List<Integer> shortestSubListCodesSeq1 = subListCodesSeq1.subList(0, sequence2.codes.size());
          if (shortestSubListCodesSeq1.equals(sequence2.codes)) {
            sequence1.score = sequence1.score + sequence2.score;
            return sequence1;
          }
        }
        else {
          subListsCodesSeq2 = sequence2.codes.subList(0, subListCodesSeq1.size());
          if (subListCodesSeq1.equals(subListsCodesSeq2)) {
            List<Integer> totalCodes = new ArrayList<>();
            totalCodes.addAll(sequence1.codes);
            totalCodes.addAll(sequence2.codes.subList(subListCodesSeq1.size(), sequence2.codes.size()));
            return new Sequence(totalCodes, sequence1.score + sequence2.score);
          }
        }
      }
    }
    return null;
  }
}
