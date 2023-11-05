package algo.otus;

import algo.otus.algorithm.ArraySort;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        for (int n = 100; n < 100001; n *= 10) {
            int[] array = new int[n];
            Random random = new Random();
            for (int i = 0; i < n; i++) {
                array[i] = random.nextInt(1000);
            }
            ArraySort arraySort = new ArraySort(array);
            long start = System.currentTimeMillis();
            arraySort.binarySearchTreeSort();
            long ms = System.currentTimeMillis() - start;
            arraySort.print(ms, n);
        }
    }
}
