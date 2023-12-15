package algo.otus;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // https://habr.com/ru/articles/307220/
        String string = "у попа была собака";
        String find = "поп";
        String stringForPrefix = find + "@" + string;
        int[] prefixed = prefixFunction(stringForPrefix);
        int length = find.length();
        int index = findIndex(prefixed, length);
        if(index == -1) {
            System.out.println("Данная подстрока отсутствует в исходной строке");
        } else {
            int secondIndex = index - length - 1;
            int firstIndex = secondIndex - length + 1;
            System.out.println("Найдены индексы: " + firstIndex + ", " + secondIndex + " -> " + string.substring(firstIndex, secondIndex + 1));
        }
    }

    private static int findIndex(int[] prefixed, int stringLength) {
        for (int i = 0; i < prefixed.length; i++) {
            if(prefixed[i] == stringLength) return i;
        }
        return -1;
    }

    private static int[] prefixFunction(String string) {
        int length = string.length();
        int[] p = new int[length];
        for (int i = 1; i < length; i++) {
            int j = p[i - 1];
            while((j > 0) && (string.charAt(i) != string.charAt(j))) {
                j = p[j - 1];
            }
            if(string.charAt(i) == string.charAt(j)) j++;
            p[i] = j;
        }
        return p;
    }

//    vector<size_t> prefix_function (string s)
//    {
//        size_t n =  s.length();
//        vector<size_t> pi(n); // в i-м элементе (его индекс i-1) количество совпавших символов в начале и конце для подстроки длины i.
//        // p[0]=0 всегда, p[1]=1, если начинается с двух одинаковых
//        for (size_t i=1; i<n; ++i)
//        {
//            // ищем, какой префикс-суффикс можно расширить
//            size_t j = pi[i-1]; // длина предыдущего префикса-суффикса, возможно нулевая
//            while ((j > 0) && (s[i] != s[j])) // этот нельзя расширить,
//                j = pi[j-1];   // берем длину меньшего префикса-суффикса
//
//            if (s[i] == s[j])
//                ++j;  // расширяем найденный (возможно пустой) префикс-суффикс
//            pi[i] = j;
//        }
//        return pi;
//    }
}
