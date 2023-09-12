package algo.otus.algorithm.impl;

public class Power {

    public static double powerB(double digit, long pow) {
        double result = 1.0;
        long abs = Math.abs(pow);
        long x = abs / 2;
        long y = abs % 2;
        for (int i = 0; i < x; i++) {
            result *= digit;
        }
        result *= result;
        for (int i = 0; i < y; i++) {
            result *= digit;
        }
        if (pow < 0) {
            result = 1.0 / result;
        };
        return result;
    }

    public static double powerBRecursive(double digit, long pow) {
        if (pow == 0) return 1.0;
        if (pow == 1) return digit;
        if (pow < 0) {
            return 1.0 / (digit * powerBRecursive(digit, Math.abs(pow) - 1));
        }
        if (pow % 2 == 0) {
            double res = powerBRecursive(digit, pow / 2);
            return res * res;
        }
        return digit * powerBRecursive(digit, pow - 1);
    }

    public static double power(double digit, long pow) {
        double result = 1.0;
        long abs = Math.abs(pow);
        for (int i = 0; i < abs; i++) {
            result *= digit;
        }
        if (pow < 0) {
            result = 1.0 / result;
        };
        return result;
    }

    public static double powerRecursive(double digit, int pow) {
        if (pow == 0) return 1.0;
        if (pow < 0) {
            return 1.0 / (digit * powerRecursive(digit, Math.abs(pow) - 1));
        }
        return digit * powerRecursive(digit, pow - 1);
    }
}
