package algo.otus.algorithm;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArraySort {
    private int[] array;

    //Сравнения
    private int cmp = 0;

    //Присваисания
    private int asg = 0;

    public ArraySort(int[] array) {
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

    public void quickSort() {
        quickSort(0, array.length - 1);
    }

    public void mergeSort() {
        mergeSort(0, array.length - 1);
    }

    public void bucketSort() {
        int max = findMax();
        max++;
        int n = array.length;
        ListBucket[] buckets = new ListBucket[n];
        for (int value: array) {
            int nr = (int) (((long) value * (long) n) / (long) max);
            buckets[nr] = new ListBucket(value, buckets[nr]);
            ListBucket item = buckets[nr];
            while (item.next != null) {
                if(moreOrEq(item.next.value, item.value)) {
                    break;
                }
                asg += 3;
                int x = item.value;
                item.value = item.next.value;
                item.next.value = x;
            }
        }
        int j = 0;
        for(ListBucket item : buckets) {
            while(item != null) {
                asg += 2;
                array[j++] = item.value;
                item = item.next;
            }
        }
    }

    class ListBucket {
        public int value;
        public ListBucket next;

        public ListBucket(int value, ListBucket next) {
            this.value = value;
            this.next = next;
        }
    }

    public void countingSort() {
        int[] counts = countElements(array, findMax());
        int[] sorted = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            asg += 3;
            int current = array[i];
            sorted[counts[current] - 1] = current;
            counts[current] -= 1;
        }
        asg++;
        array = sorted;
    }

    public void radixSort() {
        int maximumNumber = findMax();
        int numberOfDigits = calculateNumberOfDigitsIn(maximumNumber);
        int placeValue = 1;
        while (numberOfDigits-- > 0) {
            applyCountingSortOn(placeValue);
            placeValue *= 10;
        }
    }

    private void applyCountingSortOn(int placeValue) {
        int range = 10; // decimal system, numbers from 0-9
        int[] frequency = new int[range];
        for (int num : array) {
            int digit = (num / placeValue) % range;
            asg++;
            frequency[digit]++;
        }
        for (int i = 1; i < range; i++) {
            asg++;
            frequency[i] += frequency[i - 1];
        }
        int[] sortedValues = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            asg += 2;
            int digit = (array[i] / placeValue) % range;
            sortedValues[frequency[digit] - 1] = array[i];
            frequency[digit]--;
        }
        asg++;
        array = sortedValues;
    }

    private int calculateNumberOfDigitsIn(int number) {
        return (int) (Math.log10(number) + 1);
    }

    private int[] countElements(int[] input, int k) {
        int[] c = new int[k + 1];
        for (int i : input) {
            asg++;
            c[i] += 1;
        }
        for (int i = 1; i < c.length; i++) {
            asg++;
            c[i] += c[i - 1];
        }
        return c;
    }

    private int findMax() {
        int max = array[0];
        for (int value: array) {
            if(more(value, max)) {
               asg++;
               max = value;
            }
        }
        return max;
    }

    private void mergeSort(int left, int right) {
        if(left >= right) return;
        int middle = (left + right) / 2;
        mergeSort(left, middle);
        mergeSort(middle + 1, right);
        merge(left, middle, right);
    }

    private void merge(int left, int middle, int right) {
        int[] t = new int[right - left + 1];
        int a = left;
        int b = middle + 1;
        int m = 0;
        while(a <= middle && b <= right) {
            if(more(array[a], array[b])) {
                t[m++] = array[b++];
            } else {
                t[m++] = array[a++];
            }
        }
        while (a <= middle) t[m++] = array[a++];
        while (b <= right) t[m++] = array[b++];
        for (int i = left; i <= right ; i++) {
            array[i] = t[i - left];
        }
        asg += 2 * (right - left + 1);
    }

    public void selectionSort() {
        for (int j = array.length; j > 0 ; j--) {
            swap(findMax(j), j - 1);
        }
    }

    public void heapSort() {
        int length = array.length;
        int n = length - 1;
        for (int h = n / 2 - 1; h >= 0; h--) {
            heapify(h, length);
        }
        for (int j = n; j > 0 ; j--) {
            swap(0, j);
            heapify(0, j);
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

    public void print(long ms, int count) {
        System.out.println("Размер массива = " + count + ",\ncmp = " + this.cmp + "\nasg = " + this.asg + "\ntime = " + ms + " ms");
    }

    private void quickSort(int left, int right) {
        if(left >= right) return;
        int m = split(left, right);
        quickSort(left, m - 1);
        quickSort(m + 1, right);
    }

    private int split(int left, int right) {
        int p = array[right];
        int m = left - 1;
        for (int j = left; j <= right; j++) {
            if(moreOrEq(p, array[j])) {
                swap(++m, j);
            }
        }
        return m;
    }

    private void heapify(int root, int size) {
        int x = root;
        int left = 2 * x + 1;
        int right = 2 * x + 2;
        if(more(size, left) && more(array[left], array[x])) x = left;
        if(more(size, right) && more(array[right], array[x])) x = right;
        if(x == root) return;
        swap(root, x);
        heapify(x, size);
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

    private boolean moreOrEq(int x, int y) {
        cmp++;
        return x >= y;
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

    private int findMax(int index) {
        int maxIndex = 0;
        for (int i = 1; i < index; i++) {
            if(more(array[i], array[maxIndex])) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
