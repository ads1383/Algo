package algo.otus.algorithm.impl;

import algo.otus.algorithm.util.Matrix2D;

public class Fibonacci {

    private static final double PHI = (1 + Math.sqrt(5)) / 2;
    private static final double SQRT_FIVE = Math.sqrt(5);

    public static long matrix2D(int n) {
        Matrix2D res = Matrix2D.IDENTITY;
        Matrix2D base = Matrix2D.BASE;
        while(n > 1) {
            if ((n & 1) == 1) {
                res.multiply(base);
            }
            base.multiply(base);
            n >>= 1;
        }
        return res.multiply(base).getArray()[1];
    }

    public static long matrix(long n) {
        long [] m = {1, 1, 1, 0};
        for (int i = 1; i < n - 1; i++) {
            m = new long[]{m[0] + m[2], m[1] + m[3], m[0], m[1]};
        }
        return m[0];
    }

    public static double goldSection(long n) {
        return Math.pow(PHI, n) / SQRT_FIVE + 0.5;
    }

    public static long iterative(long n) {
        if (n <= 1) return n;
        long first = 1;
        long second = 1;
        for (int i = 2; i < n; i++) {
            long rec = second;
            second = second + first;
            first = rec;
        }
        return second;
    }

    public static long recourcive(long n) {
        if (n <= 1) return n;
        return recourcive(n - 1) + recourcive(n - 2);
    }
}
