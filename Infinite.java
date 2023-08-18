package dynamicsStructhure.bS;

public class Infinite {
    public static void main(String[] args) {
        int[] b = getArray();
        int s = 0, e = 1, target = 999;
        findEl(b, target, s, e);
    }

    private static void findEl(int[] a, int target, int s, int e) {
        int res, newS;
        while (target > a[e]) {
            newS = e + 1;
            e = e + (e - s + 1) * 2;
            s = newS;
            //e = (int) Math.exp(e);
        }
        res = (bs(a, target, s, e));
        System.out.printf("el: %d on idx = %d", a[res], res);
    }

//    private static void findEl(int[] a, int target, int newS, int newE) {
//        int res = -1, s, e;
//        while (res == -1) {
//            e = newE;
//            s = newS;
//            res = (bs(a, target, s, e));
//            newS = e + 1;
//            newE = e + (e - s + 1) * 2;
//            //e = (int) Math.exp(e);
//        }
//        System.out.printf("el: %d on idx = %d", a[res], res);
//    }

    private static int bs(int[] a, int target, int s, int e) {
        int m;
        if (target > a[e]) return -1;
        while (s <= e) {
            m = s + (e - s) / 2;
            if (target > a[m]) {
                s = m + 1;
            } else if (target < a[m]) {
                e = m - 1;
            } else return m;
        }
        return -1;
    }

    private static int[] getArray() {
        int idx = 1;
        int[] res = new int[1000_000];
        for (int i = 1; i < res.length; i++) {
            res[idx++ - 1] = i;
        }
        return res;
    }

}
