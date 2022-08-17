package DynamicsStructhure;

import training.Methods;
import java.util.Arrays;

public class RotatedArray extends Methods {

    private static int[] rotatedArray(int[] a, int k) {
        int[] tmp = new int[a.length];
        boolean isBreak = false;

        if (k >= a.length || k <= - 2) return new int[a.length];

        for (int i = k + 1, j = 0; i < a.length; i++, j++) {
            tmp[j] = a[i];
        }
        for (int i = a.length - 1 - k, j = 0; i < a.length; i++, j++) {
            tmp[i] = a[j];
        }
        return tmp;
    }

    public static void main(String[] args) {

        /**
         @sourse:
         * https://javarevisited.blogspot.com/2015/07/
         how-to-rotate-array-in-java-leetcode-solution.html?utm_source=dlvr.it&utm_medium=facebook

         @task:
         * Problem : Rotate an integer array of n elements after kth index.
         * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7]
         * is rotated to [5,6,7,1,2,3,4]
         *
         @author Javin Paul
         */

        int k = 3;
        int[] a = {1, 2, 3, 4, 5, 6, 7};

        printIntArray(a);
        System.out.println(Arrays.toString(rotatedArray(a, k)));

//        for (int i = k + 1; i < a.length; i++) {
//            if (j <= k + 1) {
//                tmp[j] = a[i];
//                j++;
//            }
//        }
//        j = 0;
//        for (int i = a.length - k - 1; i < a.length; i++) {
//            if (j < tmp.length) {
//                tmp[i] = a[j];
//                j++;
//            }
//        }
    }
}
