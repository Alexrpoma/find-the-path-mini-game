package com.scopic.javachallenge.app;

// /////////////////////////////////////////////////////////////////////////////
//  THIS IS A TESTING PROJECT. YOU CAN FREELY MODIFY THE CODE BELOW IN ORDER TO TEST YOUR WORK.
// /////////////////////////////////////////////////////////////////////////////

import com.scopic.javachallenge.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {


    public void runTest() {
        Test app = new Test();
        app.runExample1();
        app.runExample2();
        app.runExample3();
        app.runExample4();
        app.runExample5();
        app.runExample6();
        app.runExample7();
        app.runExample8();
        app.runExample9();
    }


    public void runExample1() {
        int[][] mArray  =  {
                {0x3A, 0x3A, 0x10, 0x9B, 0x72},
                {0x9B, 0x72, 0x3A, 0x10, 0x72},
                {0x10, 0x3A, 0x3A, 0x3A, 0x10},
                {0x3A, 0x10, 0x3A, 0x9B, 0x72},
                {0x10, 0x10, 0x3A, 0x72, 0x72}
        };

        Matrix matrix = new Matrix(mArray);

        List<Sequence> sequences = new ArrayList<>();
        sequences.add(new Sequence(Arrays.asList(0x3A, 0x10, 0x9B),10));

        int maxPathLength = 3;
        Integer[][] positionArray =  {{0, 1}, {3, 1}, {3, 3}};

        List<Position> positions = new ArrayList<>();
        for (Integer[] pos : Arrays.asList(positionArray)){
            positions.add(new Position(pos[0], pos[1]));
        }
        Path expectedSolution = new Path(positions);
        this.runExample("example of a simple puzzle with one sequence", matrix, sequences, maxPathLength, expectedSolution);
    }

    public void runExample2() {
        int[][] mArray  = {
                {0x3A, 0x3A, 0x10, 0x9B, 0x72},
                {0x9B, 0x72, 0x3A, 0x10, 0x72},
                {0x10, 0x3A, 0x3A, 0x3A, 0x10},
                {0x3A, 0x10, 0x3A, 0x9B, 0x72},
                {0x10, 0x10, 0x3A, 0x72, 0x72}
        };
        Matrix matrix = new Matrix(mArray);
        List<Sequence> sequences = new ArrayList<>();
        sequences.add(new Sequence(Arrays.asList(0x9B, 0x3A),20));
        sequences.add(new Sequence(Arrays.asList(0x10, 0x10, 0x3A),30));

        int maxPathLength = 5;

        Integer[][] positionArray =  {{0, 3}, {2, 3}, {2, 0}, {4, 0}, {4, 2}};

        List<Position> positions = new ArrayList<>();
        for (Integer[] pos : Arrays.asList(positionArray)){
            positions.add(new Position(pos[0], pos[1]));
        }

        Path expectedSolution = new Path(positions);

        this.runExample("example of a puzzle with two sequences", matrix, sequences, maxPathLength, expectedSolution);
    }

    public void runExample3() {
        int[][] mArray  = {
                {0x9B, 0x9B, 0x72, 0x9B, 0xD4},
                {0x10, 0xD4, 0xD4, 0x9B, 0x10},
                {0x72, 0x9B, 0x3A, 0x10, 0x9B},
                {0x3A, 0xD4, 0x9B, 0x3A, 0x9B},
                {0x72, 0x10, 0x10, 0xD4, 0x10}
        };
        Matrix matrix = new Matrix(mArray);
        List<Sequence> sequences = new ArrayList<>();
        sequences.add(new Sequence(Arrays.asList(0x10, 0xD4, 0x72, 0x72),20));
        sequences.add(new Sequence(Arrays.asList(0x3A, 0x10, 0xD4),10));

        int maxPathLength = 7;

        Integer[][] positionArray =  {{0, 2}, {2, 2}, {2, 3}, {4, 3}, {4, 0}, {2, 0}};

        List<Position> positions = new ArrayList<>();
        for (Integer[] pos : Arrays.asList(positionArray)){
            positions.add(new Position(pos[0], pos[1]));
        }

        Path expectedSolution = new Path(positions);
        this.runExample("example of a puzzle with one wasted move", matrix, sequences, maxPathLength, expectedSolution);
    }

    public void runExample4() {
        int[][] mArray  = {
                {0x10, 0x10, 0x10, 0x10, 0x10},
                {0x10, 0x10, 0x10, 0x10, 0x10},
                {0x3A, 0xD4, 0x10, 0x9B, 0x72},
                {0x10, 0x10, 0x10, 0x10, 0x10},
                {0x10, 0x10, 0x10, 0x10, 0x10}
        };

        Matrix matrix = new Matrix(mArray);

        List<Sequence> sequences = new ArrayList<>();
        sequences.add(new Sequence(Arrays.asList(0x3A, 0x9B),10));
        sequences.add(new Sequence(Arrays.asList(0x72, 0xD4),10));

       int maxPathLength = 7;

        // NOTE: There are multiple possible solutions. Uncomment the suitable one below.
        Integer[][] positionArray =  {{0, 0}, {2, 0}, {2, 3}, {0, 3}, {0, 4}, {2, 4}, {2, 1}};
        // Integer[][] positions = {{0, 0}, {2, 0}, {2, 3}, {1, 3}, {1, 4}, {2, 4}, {2, 1}};
        // Integer[][] positions = {{0, 0}, {2, 0}, {2, 3}, {3, 3}, {3, 4}, {2, 4},{2, 1}};
        // Integer[][] positions = {{0, 0}, {2, 0}, {2, 3}, {4, 3}, {4, 4}, {2, 4}, {2, 1}};
        // Integer[][] positions = {{0, 4}, {2, 4}, {2, 1}, {0, 1}, {0, 0}, {2, 0}, {2, 3}};
        // Integer[][] positions = {{0, 4}, {2, 4}, {2, 1}, {1, 1}, {1, 0}, {2, 0}, {2, 3}};
        // Integer[][] positions = {{0, 4}, {2, 4}, {2, 1}, {3, 1}, {3, 0}, {2, 0}, {2, 3}};
        // Integer[][] positions = {{0, 4}, {2, 4}, {2, 1}, {4, 1}, {4, 0}, {2, 0}, {2, 3}};

        List<Position> positions = new ArrayList<>();
        for (Integer[] pos : Arrays.asList(positionArray)){
            positions.add(new Position(pos[0], pos[1]));
        }

        Path expectedSolution = new Path(positions);
        this.runExample("example of a puzzle with three wasted moves", matrix, sequences, maxPathLength, expectedSolution);
    }

    public void  runExample5() {

        int[][] mArray  = {
                {0x9B, 0x10, 0x72, 0x10, 0x10},
                {0x10, 0x3A, 0x3A, 0x3A, 0x10},
                {0x72, 0xD4, 0x10, 0x10, 0x9B},
                {0x3A, 0x72, 0xD4, 0x3A, 0x9B},
                {0x72, 0x10, 0x10, 0x10, 0x10}
        };
        Matrix matrix = new Matrix(mArray);

        List<Sequence> sequences = new ArrayList<>();
        sequences.add(new Sequence(Arrays.asList(0x9B, 0x3A, 0x72, 0xD4),20));
        sequences.add(new Sequence(Arrays.asList(0x72, 0xD4, 0x3A),10));

       int maxPathLength = 5;

        Integer[][] positionArray =  {{0, 0}, {3, 0}, {3, 1}, {2, 1}};

        List<Position> positions = new ArrayList<>();
        for (Integer[] pos : Arrays.asList(positionArray)){
            positions.add(new Position(pos[0], pos[1]));
        }

        Path expectedSolution = new Path(positions);
        this.runExample("example of a puzzle with competing sequences", matrix, sequences, maxPathLength, expectedSolution);
    }

    public void runExample6() {

        int[][] mArray  = {
                {0x9B, 0x3A, 0x3A, 0x9B},
                {0x10, 0x3A, 0x3A, 0x10},
                {0x3A, 0x3A, 0x72, 0x9B}
        };
        Matrix matrix = new Matrix(mArray);

        List<Sequence> sequences = new ArrayList<>();
        sequences.add(new Sequence(Arrays.asList(0x3A, 0xD4),10));
        sequences.add(new Sequence(Arrays.asList(0x72, 0x10),10));

       int maxPathLength = 6;

       this.runExampleWithoutSolution("example of a puzzle without any solution", matrix, sequences, maxPathLength);
    }

    public void runExample7() {
        int[][] mArray  = {
                {0x9B, 0x10, 0x72, 0x10, 0x10},
                {0x10, 0x3A, 0x3A, 0x3A, 0x10},
                {0x72, 0xD4, 0x10, 0x10, 0x9B},
                {0x3A, 0x72, 0xD4, 0x9B, 0x9B},
                {0x72, 0x10, 0x10, 0x10, 0x10}
        };
        Matrix matrix = new Matrix(mArray);
        List<Sequence> sequences = new ArrayList<>();
        sequences.add(new Sequence(Arrays.asList(0x9B, 0x3A, 0x72, 0xD4),10));
        sequences.add(new Sequence(Arrays.asList(0x72, 0xD4, 0x3A),10));

       int maxPathLength = 5;

       Integer[][] positionArray =  {{0, 2}, {3, 2}, {3, 0}};

        List<Position> positions = new ArrayList<>();
        for (Integer[] pos : Arrays.asList(positionArray)){
            positions.add(new Position(pos[0], pos[1]));
        }

        Path expectedSolution = new Path(positions);
        this.runExample("example of a puzzle with the shortest competing sequence", matrix, sequences, maxPathLength, expectedSolution);
    }

    public void runExample8() {

        int[][] mArray  = {
                {0x3A, 0x3A, 0x10, 0x9B, 0x72},
                {0x9B, 0x72, 0x3A, 0x10, 0x72},
                {0x10, 0xD4, 0x3A, 0x3A, 0x10},
                {0x3A, 0x10, 0x3A, 0x9B, 0x72},
                {0x10, 0x10, 0x3A, 0x72, 0x72}
        };
        Matrix matrix = new Matrix(mArray);

        List<Sequence> sequences = new ArrayList<>();
        sequences.add(new Sequence(Arrays.asList(0x9B, 0x3A, 0xFF),30));
        sequences.add(new Sequence(Arrays.asList(0x3A, 0xD4, 0x9B),30));
        sequences.add(new Sequence(Arrays.asList(0x3A, 0x3A, 0x72),30));

       int maxPathLength = 6;

        Integer[][] positionArray =  {{0, 0}, {3, 0}, {3, 4}};

        List<Position> positions = new ArrayList<>();
        for (Integer[] pos : Arrays.asList(positionArray)){
            positions.add(new Position(pos[0], pos[1]));
        }

        Path expectedSolution = new Path(positions);
        this.runExample("example of a puzzle with one possible sequence out of three", matrix, sequences, maxPathLength, expectedSolution);
    }

    public void runExample9() {

        int[][] mArray  = {
                {0x00, 0x10, 0xD4, 0x9B, 0x10, 0x9B, 0xD4, 0x72, 0xF0, 0x10},
                {0x9B, 0x3A, 0x9B, 0x9B, 0x72, 0xD4, 0x10, 0xD4, 0x72, 0x72},
                {0xF9, 0x3A, 0xD4, 0xD4, 0x9B, 0x3A, 0xFA, 0x10, 0x9B, 0x10},
                {0xD4, 0x3A, 0x9B, 0x3A, 0x3A, 0x72, 0x72, 0xD4, 0xF1, 0xF2},
                {0xF8, 0x10, 0x72, 0x3A, 0xF7, 0x72, 0xD4, 0x10, 0xD4, 0x3A},
                {0x10, 0xD4, 0x9B, 0x10, 0xF6, 0xF5, 0x3A, 0x10, 0x10, 0x72},
                {0x72, 0x10, 0xD4, 0x3A, 0x72, 0x10, 0x72, 0xD4, 0x3A, 0x9B},
                {0xD4, 0x3A, 0x72, 0xD4, 0x9B, 0x9B, 0xFB, 0x3A, 0x9B, 0x72},
                {0x10, 0x10, 0x9B, 0x3A, 0x3A, 0x72, 0x10, 0x9B, 0x72, 0x9B},
                {0x9B, 0x72, 0x10, 0x10, 0xD4, 0xF4, 0x72, 0x10, 0xD4, 0xF3}
        };
        Matrix matrix = new Matrix(mArray);

        List<Sequence> sequences = new ArrayList<>();
        sequences.add(new Sequence(Arrays.asList(0xFB),10));
        sequences.add(new Sequence(Arrays.asList(0xF8, 0xF9),20));
        sequences.add(new Sequence(Arrays.asList(0xF2, 0xF3),20));
        sequences.add(new Sequence(Arrays.asList(0xF0, 0xF1, 0xF2),30));
        sequences.add(new Sequence(Arrays.asList(0xF7, 0xF8, 0xF9, 0xFA),40));
        sequences.add(new Sequence(Arrays.asList(0xF4, 0xF5, 0xF6, 0xF7, 0xF8),50));

       int maxPathLength = 12;

        Integer[][] positionArray =  {{0, 8}, {3, 8}, {3, 9}, {9, 9}, {9, 5}, {5, 5}, {5, 4}, {4, 4}, {4, 0}, {2, 0}, {2, 6}, {7, 6}};

        List<Position> positions = new ArrayList<>();
        for (Integer[] pos : Arrays.asList(positionArray)){
            positions.add(new Position(pos[0], pos[1]));
        }

        Path expectedSolution = new Path(positions);
        this.runExample("example of a complex puzzle with six sequences", matrix, sequences, maxPathLength, expectedSolution);
    }

    public void runExample(String name, Matrix matrix, List<Sequence>  sequences, int maxPathLength, Path expectedSolution) {
        System.out.println("Running "+name);

        Path actualSolution;

        try {
            PathFinder pathFinder = new PathFinder(matrix, sequences,  maxPathLength);
            actualSolution = pathFinder.run();
        } catch (Error error) {
            if (error instanceof InvalidArgumentError) {
                System.out.println("InvalidArgumentError: "+error.getMessage());
            } else if (error instanceof PathNotFoundError) {
                System.out.println("PathNotFoundError: "+error.getMessage());
            }
            throw error;
        }

        System.out.println("Actual solution:   "+actualSolution);
        System.out.println("Expected solution: "+expectedSolution+ "\n");

//        if (!actualSolution.isEqual(expectedSolution)) {
//            throw new Error("Actual and expected solutions don't match");
//        }
    }

    public void runExampleWithoutSolution(String name, Matrix  matrix, List<Sequence> sequences, int  maxPathLength) {
        System.out.println("Running "+name);

        try {
            PathFinder pathFinder = new PathFinder(matrix, sequences,maxPathLength);
            pathFinder.run();
        } catch (Error error) {
            if (error instanceof InvalidArgumentError) {
                System.out.println("Actual exception:   InvalidArgumentError");
                System.out.println("Expected exception: PathNotFoundError");
            } else if (error instanceof PathNotFoundError) {
                System.out.println("Actual exception:   PathNotFoundError");
                System.out.println("Expected exception: PathNotFoundError\n");
                return;
            }
            throw error;
        }

        System.out.println("Actual exception:   It throws nothing");
        System.out.println("Expected exception: PathNotFoundError");
        throw new Error("Expected exception hasn't been thrown");
    }

}
