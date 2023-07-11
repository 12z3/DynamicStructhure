package task;

import java.util.*;

public class rndTest {
    public static void main(String[] args) {
        int[] x = {1, 2, 3, 4, 5, 6, 7};  // 7 - 2 = 5
        int[] a = {1, 1, 1, 3, 3, 3, 3, 7, 7};  // 7 - 2 = 5
        int[] y = {1, 0, 3, 2, 0};
        int[] t = {13, 46, 24, 52, 20, 9};
        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(rotatedArr(x, 3)));
        //System.out.println(Arrays.toString(rotatedArr1(x, 2)));

        for (Map.Entry<Integer, Integer> el : countDigitsMatch(a).entrySet()) System.out.print(el + "; ");
        System.out.println();
        for (Map.Entry<Integer, Integer> el : countDigitsMatch1(a).entrySet()) System.out.print(el + "; ");
        System.out.println();
        for (Map.Entry<Integer, Integer> el : countDigitsMatch2(a).entrySet()) System.out.print(el + "; ");
        System.out.println();
        System.out.println(Arrays.toString(swap(x, 1, 6)));

        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        int ans = majorityElement(arr);
        System.out.println("The majority element is: " + ans);
        sumProblem(y, 3);
        selection_sort(t);


    }

    static int[] rotatedArr(int[] a, int pivot) {
        int[] res = new int[a.length];

        for (int start = 0, end = a.length - 1 - start, k = 0; start < res.length; start++, end--) {
            if (end >= pivot) res[start] = a[end];
            else res[start] = a[k++];
        }
        return res;
    }

    static int[] rotatedArr1(int[] a, int pivot) {
        int[] tmp = new int[pivot];
        int count = 0;

        for (int i = 0, c = 0; i < a.length; i++) {
            if (i < pivot) tmp[i] = a[i];
            if (i < a.length - tmp.length) {
                a[i] = a[a.length - i - 1];
                count++;
            } else a[count++] = tmp[c++];
        }
        return a;
    }

    static int[] swap(int[] a, int pos1, int pos2) {
        int tmp = a[pos1];
        a[pos1] = a[pos2];
        a[pos2] = tmp;
        return a;
    }

    static Map<Integer, Integer> countDigitsMatch(int[] a) {
        Map<Integer, Integer> digitsCount = new LinkedHashMap<>();

        for (int j : a) digitsCount.put(j, 0);
        for (int j : a) {
            if (digitsCount.containsKey(j)) {
                digitsCount.put(j, digitsCount.get(j) + 1);
            }
        }
        return digitsCount;
    }

    static Map<Integer, Integer> countDigitsMatch1(int[] a) {
        Map<Integer, Integer> countDigits = new HashMap<>();
        //Ако мапа не съдържа ключа  a[i] то добави го със стойност 1;
        // В противен случай презапиши стойността на ключ a[i] с еденица от горе.
        for (int i = 0; i < a.length; i++) {
            if ((!countDigits.containsKey(a[i]))) {
                countDigits.put(a[i], 1);
            } else {
                countDigits.put(a[i], countDigits.get(a[i]) + 1);
            }
        }
        return countDigits;
    }

    static Map<Integer, Integer> countDigitsMatch2(int[] a) {
        Map<Integer, Integer> countDigits = new HashMap<>();
        //Ако мапа не съдържа ключа  a[i] то добави го със стойност 1;
        // В противен случай презапиши стойността на ключ a[i] с еденица от горе.
        for (int i = 0; i < a.length; i++) {
            // Дай ми стойността на ключа a[i] в противен случай(ако няма такава) върни 0,1...или каквото там си задал.
            int count = countDigits.getOrDefault(a[i], 0);
            countDigits.put(a[i], count + 1);
        }
        return countDigits;
    }

    // https://takeuforward.org/data-structure/two-sum-check-if-a-pair-with-given-sum-exists-in-array/
    static void sumProblem(int[] a, int target) {            // 2, 3, 1, 4    t = 4
        Map<Integer, Integer> tmp = new HashMap<>();
        Map<Integer, Integer> res = new HashMap<>();


        for (int i = 0; i < a.length; i++) tmp.put(i, a[i]);
        for (int i = 0; i < a.length; i++) {
            int selected = tmp.get(i);
            int searchingEl = (target - selected);
            tmp.remove(i);
            if (tmp.containsValue(searchingEl)) {
                res.put(a[i], searchingEl);
            }
        }

        for (Map.Entry<Integer, Integer> el : res.entrySet())
            System.out.print(el.getKey() + " -> " + el.getValue() + "; ");

    }

    // https://takeuforward.org/data-structure/find-the-majority-element-that-occurs-more-than-n-2-times/
    public static int majorityElement(int[] v) {            // 2, 2, 1, 1, 1, 2, 2
        //size of the given array:
        int n = v.length;
        int cnt = 0; // count
        int el = 0; // Element

        //applying the algorithm:
        for (int i = 0; i < n; i++) {
            if (cnt == 0) {
                cnt = 1;
                el = v[i];
            } else if (el == v[i]) cnt++;
            else cnt--;
        }

        //checking if the stored element
        // is the majority element:
        int cnt1 = 0;
        for (int i = 0; i < n; i++) {
            if (v[i] == el) cnt1++;
        }

        if (cnt1 > (n / 2)) return el;
        return -1;
    }

    // https://takeuforward.org/sorting/selection-sort-algorithm/
    // Взима 1-ят ел и го Обявява за мин. Сравнява го със всички останали. Ако е най-малкият си остава на мястото.
    // Ако ли Не то разменя местата на този ел с най-малкият от всички останали елементи.
    static void selection_sort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int mini = i;                             // <-  !!!
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[mini]) {
                    mini = j;
                }
            }
            //swap
            int temp = arr[mini];
            arr[mini] = arr[i];
            arr[i] = temp;
        }

        System.out.println("After selection sort:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
