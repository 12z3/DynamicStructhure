package dynamicsStructhure;

public class RBS {
    public static void main(String[] args) {
        int[] a = {4, 5, 6, 7, 10, 0, 1, 2, 3, 4, 78, 88, 90, 100};
        int[] a7 = { 1, 5, 3, 4};
        int[] c = {4, 5, 7, 8, 9, 10, 0, 1, 2, 3, 4, 78, 88, 90, 100};
        int[] b = {4, 5, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4, 3};

        int resultA = peek(a, 0, (a.length - 1));
        int resultB = peek(a, resultA + 1, a.length - 1);

        System.out.println(a[resultA]);
        if (resultB == -1){
            System.out.println(a[a.length - 1]);
        }else System.out.println(a[resultB]);

        System.out.println((peekPointer(a)));
    }

    // При ans = -1 -> че масива не е завъртян.
    // Това са всичките въможни четери случая - Масива е Сортиран и завъртян n-пъти;
    // 1. a[m] > a[m+1]
    // 2. a[m] < a[m-1]
    // 1. a[s] > a[m+1] -> всички след mid са < от тези преди средния => е = m - 1.
    // 1. a[s] < a[m+1] -> всички след mid са > от тези преди средния => s = m + 1.
    private static int peek(int[] a, int s, int e) {        // todo:  4, 5, 6, 7, 0, 1, 2 - един връх.
        int m;
        boolean isTrue = false;

        while (s <= e) {                                    // ans = m: m > m + 1 or ans = m - 1: m < m - 1;
            m = s + (e - s) / 2;
            if (m > s && a[m] < a[m - 1]) {
                return m - 1;
            }
            if (m < e && a[m] > a[m + 1]) {
                return m;
            }
            if (a[s] < a[m]) {
                s = m + 1;
            } else if (a[s] >= a[m]) {
                e = m - 1;
            }
        }
        return -1;
    }

    static int peekPointer(int[] a) {                        // 4, 5, 7, 8, 9, 10, 0, 1, 2, 3, 4, 78, 88, 90, 100
        int lPointer = 0, rPointer = a.length - 1;

        for (int i = 0; i < a.length; i++) {
            if (a[lPointer] < a[lPointer + 1]) {
                lPointer++;
            } else return lPointer;

            if (a[rPointer - 1] < a[rPointer]) {
                rPointer--;
            } else return a.length - 1;
        }
        return -1;
    }
}
