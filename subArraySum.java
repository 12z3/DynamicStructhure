package dynamicsStructhure.bS;

import java.util.*;

public class subArraySum {
    public static void main(String[] args) {

        int[] a1 = {1, -1, 2, -2, 3, 0, -3, 4, -4, 0};
        int[] a = {1, 1, 2, -4, 3, 0, -3, 4, -4, 0};

        System.out.println(Arrays.toString(a));
        System.out.println(subSums(a, 0));
        System.out.println(subSums1(a, 0));
    }

    private static List<List<Integer>> subSums(int[] a, int sum) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            List<Integer> tmpRes = new ArrayList<>();
            tmpRes.add(a[i]);
            int currentSum = a[i];
            int cnt = 0;

            Loop:
            for (int j = i + 1; j < a.length; j++) {
                currentSum += a[j];
                if ((currentSum == sum)) {
                    tmpRes.add(a[j]);
                    Collections.sort(tmpRes);
                    if (!res.contains(tmpRes)) res.add(tmpRes);
                    cnt++;
                } else {
                    cnt++;
                    if ((cnt > 1)) {
                        break;
                    }
                    if (a[j] == sum) tmpRes.add(a[j]);
                }
            }
        }
        return res;
    }

    private static List<List<Integer>> subSums1(int[] a, int sum) {     // 1, 1, 2, -4, 3, 0, -3, 4, -4, 0
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            List<Integer> tmpRes = new ArrayList<>();
            tmpRes.add(a[i]);
            int currentSum = a[i];

            for (int j = i + 1; j < a.length - 1; j++) {
                currentSum += a[j];
                tmpRes.add(a[j]);
                if ((currentSum == sum)) {
                    if (!res.contains(tmpRes)) res.add(tmpRes);
                    if (a[j + 1] != sum) {
                        break;
                    } else tmpRes.add(a[j + 1]);
                }
            }
        }
        return res;
    }
    private static List<List<Integer>> subSums2(int[] a, int sum) {     // 1, 1, 2, -4, 3, 0, -3, 4, -4, 0
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            List<Integer> tmpRes = new ArrayList<>();
            Set<Integer> sums = new HashSet<>();
            tmpRes.add(a[i]);
            int currentSum = a[i];




        }
        return res;
    }
}
