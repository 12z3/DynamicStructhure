package dynamicsStructhure;

public class bsPeakArray {
    public static void main(String[] args) {
        //int[] x1 = {-4, -3, -2, -1, 0, 1, 5, 6, 7, 8, 5, 4, 3, 2, 1};
        //           0   1   2   3  4  5  6  7  8  9  10 11 12 13 14
        //int[] x = {1, 2, 3, 4, 5, 3, 1};
        //int[] x = {1, 2, 3, 4, 5, 3, 1};
        // int[] x = {3, 5, 3, 2, 0};
        //int[] x = {1, 5, 2};
        int[] x = {0, 5, 3, 1};
        //int[] x = {1, 2, 5, 1};
        //int[] x = {1, 2, 3, 2, 1, 0};
        //int[] x = {0, 3, 1};
        //int[] x = {1, 2, 3, 5, 6, 4, 2};
//        System.out.println(bs(x));
//        System.out.println(bs1(x));
        //System.out.println(bs3(x, 2));
        System.out.println(findPeak(x));
        System.out.println(bsPeakArr(x, 1));
    }

    //--------------------------------------------------------------------------

    private static int bsPeakArr(int[] arr, int target) {
        int resL, resR, ans;
        boolean isDec;

        int peakIdx = findPeak(arr);
        resL = binarySearch(arr, target, 0, peakIdx, false);
        resR = binarySearch(arr, target, peakIdx + 1, arr.length - 1, true);

        if (resL == -1) {
            ans = resR;
        } else if (resR == -1) {
            ans = resL;
        } else ans = Math.min(resL, resR);

        return ans;
    }

    private static int findPeak(int[] arr) {
        int s = 0, e = arr.length - 1, m;

        while (s != e) {
            m = s + ((e - s) / 2);
            if (arr[m] < arr[m + 1]) {
                s = m + 1;
            } else if (arr[m] > arr[m + 1]) {
                e = m;
            } else return m;
        }
        return s;
    }

    public static int binarySearch(int[] arr, int target, int s, int e, boolean isDec) {
        int m;

        while (s <= e) {
            m = s + ((e - s) / 2);

            if (isDec) {
                if (arr[m] < target) {
                    e = m - 1;
                } else if (arr[m] > target) {
                    s = m + 1;
                } else return m;
            } else if (arr[m] > target) {
                e = m - 1;
            } else if (arr[m] < target) {
                s = m + 1;
            } else return m;
        }
        return -1;
    }

    //--------------------------------------------------------------------------


    // Трябва да намериш макс ел - върха.
    private static int bs3(int[] arr, int target) {
        int s = 0, e = arr.length - 1, m, resL = 0, resR = 0, ans = 0;

        m = s + ((e - s) / 2);
        s = m;
        resL = bs3(arr, target, s, e, m);

        s = 0;
        e = m;
        resR = bs3(arr, target, s, e, m);

        if (resL == -1) {
            ans = resR;
        } else if (resR == -1) {
            ans = resL;
        } else ans = Math.min(resL, resR);

        return ans;
    }

    public static int bs3(int[] arr, int target, int s, int e, int m) {

        while (s <= e) {
            m = s + ((e - s) / 2);

            if (arr[m] > target) {
                e = m - 1;
            } else if (arr[m] < target) {
                s = m + 1;
            } else return m;
        }
        return -1;
    }

    // Разделя масива на две, проверява следващия елемент дали е
    // >< от средния и повтаря операцията докато не намери максималният.
    private static int bs1(int[] arr) {
        int s = 0, e = arr.length - 1, m;

        while (s <= e) {
            m = s + ((e - s) / 2);
            if (arr[m] < arr[m + 1]) {
                s = m + 1;
            } else if (arr[m] < arr[m - 1]) {
                e = m - 1;
            } else return m;
        }
        return -1;
    }

    public int bs2(int[] arr) {
        int s = 0, e = arr.length - 1, m;

        while (s != e) {
            m = s + ((e - s) / 2);
            if (arr[m] < arr[m + 1]) {
                s = m + 1;
            } else if (arr[m] < arr[m - 1]) {
                e = m;
            } else return m;
        }
        return s;

    }

    // Не работи с {-4, -3, -2, -1, 0, 1, 5, 6, 7, 8, 5, 4, 3, 2, 1}; заради idx = m + 1;
    private static int bs(int[] arr) {
        int s = 0, e = arr.length - 1, max = Integer.MIN_VALUE, m = 0, idx = 0;

        while (s <= e) {
            m = s + ((e - s) / 2);
            if (arr[m] < arr[m + 1]) {
                idx = m + 1;
                s = m + 1;
            } else if (arr[m] < arr[m - 1]) {
                return idx;
            } else return m;
        }
        return -1;
    }
}
