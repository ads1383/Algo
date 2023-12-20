package algo.otus.algorithm.dancingLinks;

public record MatrixColumn(String constraintLabel) {
    public MatrixColumn {
        if (constraintLabel == null || constraintLabel.isEmpty()) {
            throw new IllegalArgumentException("Constraint label cannot be null or empty");
        }
    }
}
