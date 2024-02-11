package dynamicsStructure;

import java.util.Arrays;

public class abc {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 0};
        int[] b = {1, 2, 3, 4, 5, 6, 7, 0};
        int[] c = {1, 2, 3, 4, 5, 6, 7, 0};
        int[] d = {1, 2, 3, 4, 5, 6, 7, 0};

        System.out.println(Arrays.toString(a));

        shiftRight(b, 1);
        shiftLeft(a, 1);
        rotatedArr(c, 3);

        System.out.println("shiftLeft from idx: " + Arrays.toString(a));
        System.out.println("shiftRight from idx: " + Arrays.toString(b));
        System.out.println("rotatedArr -> " + Arrays.toString(c));
        //System.out.println("rotated around pivot -> " + Arrays.toString(rotatedFromPivot(d, 6)));
    }


    static void shiftRight(int[] a, int idx) {
        int tmp = a[a.length - 1];
        for (int i = a.length - 1; i >= idx; i--) {
            a[i] = a[i - 1];
        }
        a[idx] = tmp;
    }

    static void shiftLeft(int[] a, int idx) {
        int tmp = a[idx];
        for (int i = idx; i < a.length - 1; i++) {
            a[i] = a[i + 1];
        }
        a[a.length - 1] = tmp;
    }
                                                            //                     1  2
    static int[] rotatedFromPivot(int[] a, int pvt) {        //  1, 2, 3, 4, 5, 6, 7, 0 - 7 size
        int tmp;                                             //  0, 7, 6, 5, 4, 3, 2, 1
        int[] res = new int[a.length];                       //  0, 7, 6, 5, 4, 3, 2, 1
        for (int i = a.length - 1, j = 0; i >= (a.length - pvt - 2); i--, j++) {
            tmp = a[j];
            res[j] = a[i];
           if(j < pvt) res[res.length - 1 - j] = tmp;
        }
        return res;
    }

    private static void rotatedArr(int[] arr, int steps) {
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
}
