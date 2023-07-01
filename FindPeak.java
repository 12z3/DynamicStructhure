package dynamicsStructhure.bS;

import java.util.Arrays;

public class FindPeak {

    // TODO: ascending-Peak-ascending
    // Опити за намиране на максималният елемент в сортиран масив.

    public static void main(String[] args) {
        // int[] a = {5, 6, 7, 0, 1, 2, 4};
        // int[] a = { 4, 5, 6, 7, 8,     9, 10, 0, 1, 2,};
        //int[] a = {0, 1, 2, 4, 5, 6, 7};
        //int[] a = {4, 5, 6, 7, 8, 9, 10, 11, 12, 2};
        //int[] a = {4, 5, 6, 7, 8, 9, 10, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13};
        int[] a = {4, 5, 6, 7, 8, 9, 10, 0, 1, 2, 3, 4, 5, 6, 7};
        //int[] a = {4, 5, 1, 2, 3, 6};
        //int[] a1 = {4, 5};
        //int[] a = {4, 5, 2, 3, 4, 7};
        //int[] a = {6, 7, 0, 1, 2, 4, 5};
        //int[] b = {3, 4, 1, 2, 3};

        //System.out.println(findPeak(a));
        //System.out.println(findPeakA(a));

        int s = 1, e = a.length - 1, m = s + ((e - s) / 2);
        int l = findPeakXIdx(a, s, m);
        int r = findPeakXIdx(a, m, e);

        System.out.print(Arrays.toString(a));
        int res = (a[l] > a[r]) ? l : r;
        System.out.println("\n" + "idx = " + res + ", el = " + a[res]);
    }

    private static int findPeakXIdx(int[] a, int s, int e) {
        int m;
        while (s != e) {
            m = s + ((e - s) / 2);
            if (a[m] < a[m + 1] && a[m] > a[m - 1]) {
                if (a[m] < a[0]) return 0;
                s = m + 1;
            } else if (a[m] < a[m - 1]) {
                return m - 1;
            } else e = m;
        }
        return (s == -1) ? 0 : s;
    }

    private static int findPeak(int[] a, int s, int e) {
        int m;
        while (s != e) {
            m = s + ((e - s) / 2);
            if (a[m] < a[m + 1] && a[m] > a[m - 1]) {
                s = m + 1;
            } else if (a[m] < a[m - 1]) {
                return m - 1;
            } else e = m;
        }
        return (s == -1) ? 0 : s;
    }

    private static int findPeakC(int[] a, int s, int e) {
        int m = 0;
        while (s != e) {
            m = s + ((e - s) / 2);
            if (a[m] < a[m + 1]) {
                s = m + 1;
            } else e = m;
        }
        return s;
    }

    private static int findPeakA(int[] a) {
        int s = 1, e = a.length - 1, m;
        while (s != e) {
            m = s + ((e - s) / 2);
            if (a[m] < a[m + 1] && a[m] > a[m - 1]) {
                s = m + 1;
            } else e = m;
        }
        return s;
    }

    private static int findPeakB(int[] a, int s, int e) {
        int m;
        while (s != e) {
            m = s + ((e - s) / 2);
            if (a[m] < a[m + 1]) {
                s = m + 1;
            } else if (a[m] > a[m + 1]) {
                e = m - 1;
            } else return m;
        }
        return s;
    }
}
