package com.scopic.javachallenge;
// ---------------------------------------------------------------------------------------------
// PLEASE DO NOT MODIFY, RENAME OR REMOVE ANY OF CLASSES, METHODS AND VARIABLES BELOW.
// YOU CAN ADD YOUR OWN METHODS AND VARIABLES TO THE EXISTING CLASSES AND USE THEM IN YOUR WORK.
// ---------------------------------------------------------------------------------------------

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sequence {
    public int score;
    public List<Integer> codes;

    public Sequence( List<Integer> codes, int score) {
        this.score = score;
        this.codes = codes;
    }

    public  boolean empty(){
        return this.codes.size() == 0;
    }


    // You can add your own class members here.
}
