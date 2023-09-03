package algo.otus;

import algo.otus.tester.Tester;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Tester tester = new Tester("src/main/resources");
        System.out.println(tester.testLongInOut(n -> luckyTicketCounter(Math.toIntExact(n))));
    }

    public static long luckyTicketCounter(int n) {
        int digitCount = 2 * n;
        int arrayLength = 10 + ((digitCount + 1) / 2) * 9 - 9;
        long[] countArray= new long[arrayLength];
        for (int i = 0; i < 10; i++) {
            countArray[i] = 1;
        }

        for (int i = 0; i < digitCount / 2 - 1; i++) {
            long[] buffer = new long[countArray.length];
            for (int j = 0; j < arrayLength; j++) {
                if (j < 10) {
                    for (int k = 0; k <= j; k++) {
                        buffer[j] += countArray[k];
                    }
                } else {
                    for (int k = j - 9; k <= j; k++) {
                        buffer[j] += countArray[k];
                    }
                }
            }
            countArray = buffer;
        }
        return Arrays.stream(countArray).map(p -> p * p).sum();
    }
}
