package algo.otus.algorithm.impl;

import java.util.ArrayList;
import java.util.List;

public class SimpleDigit {

    public static int countSimpleEratospheneQuick(int n) {
        int[] digits = new int[n + 1];
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (digits[i] == 0) {
                digits[i] = i;
                list.add(i);
            }
            for (int el: list) {
                long multiply = (long) el * i;
                if (el <= digits[i] && multiply <= n) {
                    digits[(int) multiply] = el;
                }
            }
        }
        return list.size();
    }


    public static int countSimpleEratosphene(int n) {
        boolean[] divs = new boolean[n + 1];
        int count = 0;
        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= n; i++) {
            if (!divs[i]) {
                count++;
                if (i <= sqrt) {
                    for (int j = i * i; j <= n; j += i) {
                        divs[j] = true;
                    }
                }
            }
        }
        return count;
    }

    public static int countSimpleDigit(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if(isSimple(i)) {
                count++;
            }
        }
        return count;
    }

//    private static boolean isSimple(int n) {
//        if(n == 2) return true;
//        for (int i = 2; i < n; i++) {
//            if (n % i == 0) return false;
//        }
//        return true;
//    }

    private static boolean isSimple(int n) {
        if(n == 2) return true;
        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
