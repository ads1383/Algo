package algo.otus.algorithm.util;

public class Matrix2D {
    public static Matrix2D IDENTITY = new Matrix2D(1, 0, 1, 0);
    public static Matrix2D BASE = new Matrix2D(1, 1, 1, 0);

    private long[] array;

    public Matrix2D(long... args) {
        this.array = args;
    }

    public Matrix2D multiply(Matrix2D matrix2D) {
        long[] m = matrix2D.getArray();
        array = new long[] {
                array[0] * m[0] + array[1] * m[2], array[0] * m[1] + array[1] * m[3],
                array[2] * m[0] + array[3] * m[2], array[2] * m[1] + array[3] * m[3],
        };
        return this;
    }

    public long[] getArray() {
        return array;
    }
}
