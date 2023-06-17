package dynamicsStructhure;

import java.util.Arrays;

public class bs {
    public static void main(String[] args) {
        //int[] a = {0, 1, 2, 4, 5, 6, 7};
        int target = 0;
        //         0  1  2  3  4  5  6  7
        //int[] a = {4,5,6,7,0,1,2}; // 0
        //[] a = {1, 3}; // 1
        //int[] a = {1, 3, 5}; // 1
        int[] a = {4, 5, 6, 7, 0, 1, 2}; // 0

        // int[] b = {3, 4, 1, 2, 3};
        //int[] b = {5, 6, 7, 0, 1, 2, 4};
        //int[] b = {0, 1, 2, 4, 5, 6, 7};
        //int[] b = {3, 4, 5, 6, 7, 8, 1, 2, 3};

        //System.out.println(findPeakIdx(a));

        System.out.println(Arrays.toString(a) + " target = " + target);
        System.out.println(" " + "idx = " + findElInRotatedArr(a, target));

    }

    private static int findElInRotatedArr(int[] nums, int target) {
        reversArr(nums, target);
        System.out.print(Arrays.toString(nums));
        int peakIdx = findPeakIdx(nums, target), rHalf = 0, lHalf;

        lHalf = bs(nums, target, 0, peakIdx);
        if (lHalf == -1) {
            rHalf = bs(nums, target, peakIdx + 1, nums.length - 1);
            return rHalf;
        } else return lHalf;
    }

    //                                                                    // 3, 4, 5, 6,     7, 8, 1, 2, 3

    private static void reversArr(int[] arr, int steps) {
        int j = 0, tmp;
        while (j < steps) {
            tmp = arr[arr.length - 1];
            for (int i = arr.length - 1; i > 0; i--) {
                arr[i] = arr[i - 1];
            }
            arr[0] = tmp;
            j++;
        }
    }

    private static int findPeakIdx(int[] a, int target) {                           // 3, 4, 1, 2, 3
        int s = 1, e = a.length - 1, m;
        if (a.length == 1) return 0;

        while (s != e) {
            m = s + ((e - s) / 2);
            if (a[m] < a[m + 1] && a[m] > a[m - 1]) {
                s = m + 1;
            } else if (a[m] < a[m - 1]) {
                return m - 1;
            } else e = m - 1;
        }
        return (s == -1) ? 0 : s;
    }

    private static int bs(int[] a, int target, int s, int e) {
        int m;

        if (a.length == 2) {
            if (target == a[0]) {
                return 1;
            } else if (a[1] == target) return 0;
        }

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

    private static void reversArr1(int[] arr) {
        int[] b = new int[arr.length];
        int pivot = 3, count = 0;

        for (int i = 0; i < arr.length; i++) {
            if ((pivot + i) < arr.length) {
                b[i] = arr[pivot + i];
                count++;
            } else {
                b[i] = arr[i - count];
            }
        }
        System.out.println(Arrays.toString(b));
    }

    private static int bsRev(int[] arr, int target, int s, int e) {
        int m;
        while (s <= e) {
            m = s + ((e - s) / 2);
            if (arr[m] > target) {
                s = m + 1;
            } else if (arr[m] < target) {
                e = m - 1;
            } else return m;
        }
        return -1;
    }
}
