package dynamicsStructhure;

import java.util.Arrays;

public class FindPeak {
    public static void main(String[] args) {
        // int[] a = {5, 6, 7, 0, 1, 2, 4};
        // int[] a = { 4, 5, 6, 7, 8,     9, 10, 0, 1, 2,};
        //int[] a = {0, 1, 2, 4, 5, 6, 7};
        int[] a = {4, 5, 6, 7, 8, 9, 10, 0, 1, 2};                   // TODO: К'во Прайм?  <-
        //int[] a = {4, 5, 1, 2, 3, 6};
        //int[] a1 = {4, 5};
        //int[] a = {4, 5, 2, 3, 4, 7};
        //int[] aa = {4, 5, 6, 7, 8, 9};
        //int[] b = {3, 4, 1, 2, 3};
        //         0, 1, 2, 4, 5, 6, 7
        //         4, 5, 6, 7, 0, 1, 2,
        //         4, 5, 6, 7, 8, 9, 10, 0, 1, 2,
        //System.out.println(findPeak(a));
        //System.out.println(findPeakA(a));

        int s = 0, e = a.length - 1, m = s + ((e - s) / 2);
        int l = findPeak(a, s, e);
        int r = findPeak(a, l + 1, e);

        System.out.printf("lPeak = %d, rPeak = %d ", l, r);
        int res = (a[l] > a[r]) ? l : r;
        System.out.println("\n" + "idx = " + res + ",   el = " + a[res]);
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
