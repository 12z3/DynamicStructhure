package dynamicsStructhure.bS;

public class bsCF {
    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4, 5, 7, 6, 8, 9};
        int[] a1 = {1, 2, 3, 4, 5, 7, 8, 9, 8, 7, 6, 5, 4, 3};
        int[] b = {1, 2, 3, 4, 5, 7, 8, 9, 1, 2, 3, 4};

        int target = 6;
        boolean isCeil = true;
        int idx = bsCeilOrFloor(a, target, isCeil);
        System.out.printf("Target = %d; Ceil = %b -> el = %d; idx = %d%n", target, isCeil, a[idx], idx);

        int idx2 = ceil1(a, target);
        System.out.println(a[idx2]);

        int idx3 = floor1(a, target);
        System.out.println(a[idx3]);

        int idx1 = trianglePeak(a1);
        System.out.printf("Peak = %d on idx = %d%n", a1[idx1], idx1);
    }

    private static int zigzagPeak(int[] a, int target) {
        int s = 0, e = a.length - 1, mid = 0;

        while (s <= e) {
            mid = s + (e - s) / 2;
            if (a[mid] > a[mid - 1] && a[mid] < a[mid + 1]) {
                s = mid + 1;
            } else if (a[mid] < a[mid - 1] && a[mid] > a[mid + 1]) {
                e = mid - 1;
            } else return mid;
        }
        return -1;
    }

    private static int trianglePeak(int[] a) {
        int s = 0, e = a.length - 1, mid = 0;

        while (s <= e) {
            mid = s + (e - s) / 2;
            if (a[mid] > a[mid - 1] && a[mid] < a[mid + 1]) {
                s = mid + 1;
            } else if (a[mid] < a[mid - 1] && a[mid] > a[mid + 1]) {
                e = mid - 1;
            } else return mid;
        }
        return -1;
    }


    private static int bsCeilOrFloor(int[] a, int target, boolean isCeil) {
        int s = 0, e = a.length - 1, mid;

        while (s <= e) {
            mid = s + (e - s) / 2;
            if (target < a[mid]) {
                e = mid - 1;
            } else if (target > a[mid]) {
                s = mid + 1;
            } else {
                return isCeil ? mid + 1 : mid - 1;
            }
        }
        return isCeil ? s : e;
    }

    private static int ceil(int[] a, int target) {
        int s = 0, e = a.length - 1, mid, ans = -1;

        while (s <= e) {
            mid = s + (e - s) / 2;
            if (target < a[mid]) {
                e = mid - 1;
            } else if (target >= a[mid]) {
                s = mid + 1;
                ans = s;
            }
        }
        return ans;
    }

    private static int floor(int[] a, int target) {
        int s = 0, e = a.length - 1, mid, ans = -1;

        while (s <= e) {
            mid = s + (e - s) / 2;
            if (target <= a[mid]) {
                ans = e;
                e = mid - 1;
            } else if (target > a[mid]) {
                s = mid + 1;
            }
        }
        return ans;
    }

    private static int ceil1(int[] a, int target) {
        int s = 0, e = a.length - 1, mid, ans = -1;

        while (s <= e) {
            mid = s + (e - s) / 2;
            if (target < a[mid]) {
                e = mid - 1;
            } else if (target > a[mid]) {
                s = mid + 1;
                ans = s;
            } else {
                return mid + 1;
            }
        }
        return s;
    }

    private static int floor1(int[] a, int target) {
        int s = 0, e = a.length - 1, mid, ans = -1;

        while (s <= e) {
            mid = s + (e - s) / 2;
            if (target < a[mid]) {
                ans = e;
                e = mid - 1;
            } else if (target > a[mid]) {
                s = mid + 1;
            } else {
                return mid - 1;
            }
        }
        return e;
    }
}
