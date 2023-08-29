package dynamicsStructhure;

import java.util.Arrays;

public class mergeArray {
    public static void main(String[] args) {
        int[] a = {1, 30, 3, 2, 0, 9};
        int[] b = {11, 30, 2, 6, 9, 0, 125, 6};

        zeroCheck(a, b);
    }

    private static void merge(int[] a, int[] b, int size) {
        int[] c = new int[size];
        int idxA = 0, idxB = 0, idx = 0;
        for (int i = 0; i < c.length; i++, idx++) {
            if (idxA < a.length) {
                if (a[idxA] != 0) {
                    c[i] = a[idxA++];
                } else {
                    i--;
                    idxA++;
                }
            } else {
                if (idxB < b.length) {
                    if (b[idxB] != 0) {
                        c[i] = b[idxB++];
                    } else {
                        i--;
                        idxB++;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(c));
    }

    private static void zeroCheck(int[] a, int[] b) {
        int count = 0;
        boolean isCheck;
        for (int i = 0; i < a.length; i++) {
            isCheck = false;
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    a[i] = b[j] = 0;
                    isCheck = true;
                }
            }
            if (isCheck) count++;
        }

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        int size = a.length + b.length - (count * 2);
        merge(a, b, size);

    }
}
