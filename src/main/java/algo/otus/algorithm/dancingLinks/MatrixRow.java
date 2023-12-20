package algo.otus.algorithm.dancingLinks;

public record MatrixRow(String valueLabel, boolean[] values) {
    public MatrixRow {
        if (valueLabel == null || valueLabel.isEmpty()) {
            throw new IllegalArgumentException("Constraint label cannot be null or empty");
        }
    }
}
