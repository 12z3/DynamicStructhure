package dynamicsStructhure.bS;

import java.util.Arrays;

public class bsInRange {

    // https://www.informatika.bg/lectures/binary-search

    public static void main(String[] args) {
        int[] a = {1, 3, 4, 5, 6, 7, 8, 11, 12, 13, 14, 45};
        int[] a2 = {1, 2, 3, 3, 3, 3, 3, 3, 12, 13, 14, 45};
        int[] a1 = {1, 1, 3, 3, 12, 12, 12, 12, 12, 12, 12, 45};                    // mIdx = 5; [5, 10]

        System.out.println(bsA(a, 7));

        int target = 12;
        System.out.println(Arrays.toString(a1) + " -> " + target);
        System.out.printf("lastIdx = %d; ", a1.length - 1);
        System.out.println("ans = " + Arrays.toString(range(a1, target)));
    }

    private static int[] range(int[] a, int target) {
        int[] x = new int[2], z = {-1, -1};

        int elIdx = targetIdx(a, target);
        if (elIdx == -1) return z;
        System.out.print("elIdx = " + elIdx + "; ");
//        int lIdx = findMinLIdx(a, target, 0, elIdx);
//        int rIdx = findMinRIdx(a, target, elIdx + 1, a.length);

        int lIdx = findMinIdx(a, target, 0, elIdx, false);
        int rIdx = findMinIdx(a, target, elIdx, a.length - 1, true);
        x[0] = (lIdx != -1) ? lIdx : elIdx;
        x[1] = (rIdx != -1) ? rIdx : elIdx;
        return x;
    }

    private static int findMinIdx(int[] a, int target, int s, int e, boolean findR) {
        int m, ans = 0;

        while (s <= e) {
            m = s + ((e - s) / 2);
            if (a[m] < target) {
                s = m + 1;
            } else if (a[m] > target) {
                e = m - 1;
            } else {
                ans = m;
                if (!findR) {
                    e = m - 1;
                } else {
                    s = m + 1;
                }
            }
        }
        return ans;
    }

    private static int targetIdx(int[] a, int target) {
        int s = 0, e = a.length - 1, m;

        while (s <= e) {
            m = s + ((e - s) / 2);
            if (a[m] < target) {
                s = m + 1;
            } else if (a[m] > target) {
                e = m - 1;
            } else return m;
        }
        return -1;
    }

    //-------------------------------------------------------------------

    private static int findMinLIdx(int[] a, int target, int s, int e) {
        int m, ans = 0;

        while (s <= e) {
            m = s + ((e - s) / 2);
            if (a[m] < target) {
                s = m + 1;
            } else if (a[m] > target) {
                e = m - 1;
            } else {
                ans = m;
                e = m - 1;
            }
        }
        return ans;
    }

    private static int findMinRIdx(int[] a, int target, int s, int e) {
        int m, ans = 0;

        while (s <= e) {
            m = s + ((e - s) / 2);
            if (a[m] < target) {
                s = m + 1;
            } else if (a[m] > target) {
                e = m - 1;
            } else {
                ans = m;
                s = m + 1;
            }
        }
        return ans;
    }

    // s         m            e
    // 2, 3, 5,  9,  14, 16, 18                                  e
    //                                                           m                              m
    //               s    m   e                                  s                              e    s
    // 2, 3, 5,  9,  14, 16, 18 -> a[m] > target -> e = m - 1 -> 14, 16, 18 -> a[m] < target -> 14, 16, 18
    // s, e и m трябва да се съберат (14, 16, 18; target 15; s = 14, m = 16, e = 18;  a[m] < target ->
    // s = 14, m = 14, e = 14 -> a[m] < target -> s = m + 1 == 16, m = 14, e = 14 -> край на while и return s)
    // Търси се най-малкият, който е > target. Трябва да "прескочи" верният отговор да провери условието a[m] < target
    // и да премести указателя s. В противен случай сме намерили потенциален отговор, но дали е минималният възможен?
    private static int bsA(int[] a, int target) {
        int s = 0, e = a.length - 1, m, ans = 0;

        while (s <= e) {
            m = s + ((e - s) / 2);
            if (a[m] < target) {
                s = m + 1;
            } else if (a[m] > target) {
                e = m - 1;
            }else return a[m - 1];
        }
        return a[e];
    }
}
