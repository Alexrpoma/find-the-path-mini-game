package com.scopic.javachallenge;
// ---------------------------------------------------------------------------------------------
// PLEASE DO NOT MODIFY, RENAME OR REMOVE ANY OF CLASSES, METHODS AND VARIABLES BELOW.
// YOU CAN ADD YOUR OWN METHODS AND VARIABLES TO THE EXISTING CLASSES AND USE THEM IN YOUR WORK.
// ---------------------------------------------------------------------------------------------

import javax.annotation.processing.SupportedSourceVersion;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Path {

    public Path() {
        this.positions = new ArrayList<>();
    }

    public List<Position> positions;

    public Path(List<Position> positions) {
        this.positions = positions;
    }


    @Override
    public String toString() {
        return positions.stream().map(Object::toString)
                .collect(Collectors.joining(", "));
    }


 

    // You can add your own class members here.
}
