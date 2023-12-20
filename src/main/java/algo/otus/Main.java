package algo.otus;

import algo.otus.algorithm.dancingLinks.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // https://tomjack.ca/technology/2022/07/17/dancing-links-algx-java.html

        ExactCoverMatrix ecm = new ExactCoverMatrix(
                List.of(new MatrixColumn("13"), new MatrixColumn("14"),
                        new MatrixColumn("23"), new MatrixColumn("24"),
                        new MatrixColumn("31"), new MatrixColumn("32"), new MatrixColumn("33"), new MatrixColumn("34"),
                        new MatrixColumn("41"), new MatrixColumn("42"), new MatrixColumn("43"), new MatrixColumn("44")
                ),
                List.of(
                        new MatrixRow("A", new boolean[]{true, true, false, true, false, false, false, false, false, false, false, false}),
                        new MatrixRow("B", new boolean[]{true, true, true, false, false, false, false, false, false, false, false, false}),
                        new MatrixRow("C", new boolean[]{true, false, true, true, false, false, false, false, false, false, false, false}),
                        new MatrixRow("D", new boolean[]{false, true, true, true, false, false, false, false, false, false, false, false}),
                        new MatrixRow("E", new boolean[]{false, false, true, true, false, false, false, true, false, false, false, false}),
                        new MatrixRow("F", new boolean[]{false, false, true, true, false, false, true, false, false, false, false, false}),
                        new MatrixRow("G", new boolean[]{false, false, true, false, false, false, true, true, false, false, false, false}),
                        new MatrixRow("H", new boolean[]{false, false, false, true, false, false, true, true, false, false, false, false}),
                        new MatrixRow("I", new boolean[]{false, false, false, false, false, false, true, true, false, false, false, true}),
                        new MatrixRow("J", new boolean[]{false, false, false, false, false, false, true, true, false, false, true, false}),
                        new MatrixRow("K", new boolean[]{false, false, false, false, false, false, true, false, false, false, true, true}),
                        new MatrixRow("L", new boolean[]{false, false, false, false, false, false, false, true, false, false, true, true}),
                        new MatrixRow("M", new boolean[]{false, false, false, false, true, true, false, false, true, false, false, false}),
                        new MatrixRow("N", new boolean[]{false, false, false, false, true, true, false, false, false, true, false, false}),
                        new MatrixRow("O", new boolean[]{false, false, false, false, true, false, false, false, true, true, false, false}),
                        new MatrixRow("P", new boolean[]{false, false, false, false, false, true, false, false, true, true, false, false}),
                        new MatrixRow("Q", new boolean[]{false, false, false, false, false, true, true, false, false, false, true, false}),
                        new MatrixRow("R", new boolean[]{false, false, false, false, false, true, true, false, false, true, false, false}),
                        new MatrixRow("S", new boolean[]{false, false, false, false, false, true, false, false, false, true, true, false}),
                        new MatrixRow("T", new boolean[]{false, false, false, false, false, false, true, false, false, true, true, false}),
                        new MatrixRow("U", new boolean[]{false, false, true, false, false, true, true, false, false, false, false, false})
                )
        );
        DLXBoard b = new DLXBoard(ecm);
        List<List<Node>> results = b.attemptSolve();
        System.out.println();
    }
}
