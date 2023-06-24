package dynamicsStructhure.bS;

import java.util.Arrays;

public class bsRange {
    public static void main(String[] args) {
        int[] a = {1, 3, 4, 5, 6, 7, 8, 11, 12, 13, 14, 45};
        int[] a2 = {1, 2, 3, 3, 3, 3, 3, 3, 12, 13, 14, 45};
        int[] a1 = {1, 1, 3, 3, 3, 3, 12, 12, 12, 12, 12, 45};        // mIdx = 8; [6, 10]

        System.out.println(Arrays.toString(range(a1, 12)));
    }

    private static int[] range(int[] a, int target) {
        int[] x = new int[2];

        int elIdx = midElIdx(a, target);
        System.out.print("mIdx = " + elIdx + "; ");
        //int lIdx = findMinLIdx(a, target, 0, elIdx);
        //int rIdx = findMinRIdx(a, target, elIdx + 1, a.length);

        int lIdx = findMinIdx(a, target, 0, elIdx, false);
        int rIdx = findMinIdx(a, target, elIdx + 1, a.length, true);
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

    private static int midElIdx(int[] a, int target) {
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


//    private static int bsA(int[] a, int target) {
//        int s = 0, e = a.length - 1, m, ans = 0;
//
//        while (s <= e) {
//            m = s + ((e - s) / 2);
//            if (a[m] < target) {
//                s = m + 1;
//            } else if (a[m] > target) {
//                e = m - 1;
//            }else return a[m - 1];
//        }
//        return a[e];
//    }
}
