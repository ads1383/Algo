package algo.otus.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleSort {
    private int[] array;

    //Сравнения
    private int cmp = 0;

    //Присваисания
    private int asg = 0;

    public SimpleSort(int[] array) {
        this.array = array;
    }

    public void bubbleSort() {
        for (int j = array.length - 1; j > 0; j--) {
            for (int i = 0; i < j; i++) {
                if (more(array[i], array[i + 1])) {
                    swap(i, i + 1);
                }
            }

        }
    }

    public void insertionSort() {
        for (int j = 1; j < array.length; j++) {
            for (int i = j; i > 0 && more(array[i - 1], array[i]); i--) {
                swap(i, i - 1);
            }
        }
    }

    public void insertionShift() {
        int i;
        for (int j = 1; j < array.length; j++) {
            int k = array[j];
            asg++;
            for (i = j; i > 0 && more(array[i - 1], k); i--) {
                array[i] = array[i - 1];
                asg++;
            }
            array[i] = k;
            asg++;
        }
    }

    public void insertionBinary() {
        int i;
        for (int j = 1; j < array.length; j++) {
            int k = array[j];
            asg++;
            int p = binarySearch(k, 0, j - 1);
            for (i = j; i > p; i--) {
                array[i] = array[i - 1];
                asg++;
            }
            array[i] = k;
            asg++;
        }
    }

    public void shellSort() {
        int length = array.length;
        for (int gap = length / 2; gap > 0; gap /= 2) {
            for (int j = gap; j < length; j++) {
                for (int i = j; i >= gap && more(array[i - gap], array[i]); i -= gap) {
                    swap(i - gap, i);
                }
            }
        }
    }

    private int binarySearch(int key, int low, int high) {
        if (high <= low) return key >= array[low] ? low + 1 : low;
        int mid = (high + low) / 2;
        cmp++;
        if (key >= array[mid]) {
            return binarySearch(key, mid + 1, high);
        } else {
            return binarySearch(key, low, mid);
        }
    }

    public void setSortedArray() {
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
    }

    public void setReversed() {
        this.array = Arrays.stream(array)
                .map(i -> array[array.length - i - 1])
                .toArray();
    }

    public int[] getArray() {
        return array;
    }

    public void print() {
        System.out.println(Arrays.stream(array).mapToObj(String::valueOf).collect(Collectors.joining(", ")));
    }

    public void print(long ms) {
        System.out.println(Arrays.stream(array).mapToObj(String::valueOf).collect(Collectors.joining(", ")) + "\n" +
                "cmp = " + cmp + "\n" +
                "asg = " + asg + "\n" +
                "time = " + ms + " ms");
    }

    private void swap(int i, int j) {
        asg += 3;
        int buffer = array[i];
        array[i] = array[j];
        array[j] = buffer;
    }

    private boolean more(int x, int y) {
        cmp++;
        return x > y;
    }
}
