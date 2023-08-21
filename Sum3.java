package LeetCode;

import java.util.*;

public class Sum3 {

    // https://leetcode.com/problems/3sum/

    public static void main(String[] args) {
        int[] a = {-1, 0, 1, 2, -1, -4};   // -4, -1, -1, 0, 1, 2
        int[] a7 = {34, 55, 79, 28, 46, 33, 2, 48, 31, -3, 84, 71, 52, -3, 93, 15,
                21, -43, 57, -6, 86, 56, 94, 74, 83, -14, 28, -66, 46, -49, 62,
                -11, 43, 65, 77, 12, 47, 61, 26, 1, 13, 29, 55, -82, 76, 26, 15,
                -29, 36, -29, 10, -70, 69, 17, 499};
        int[] a4 = {-1, -1, -1, 1};
        int[] a5 = {-1, 0, 1, 0};
        int[] a3 = {1, 2, -2, -1};
        int[] a1 = {-2, 0, 1, 1, 2};
        int[] a2 = {-3, -2, 1, 0};
        int[] a6 = {3, 0, -2, -1, 1, 2};
        //-2,-1,  0,  1, 2, 3
        // 0  1   2   3  4  5 - idx
        // 1  2   3   4  5  6 - j
        int[] b1 = {1, 2, 3, 4, 5, 6 - 7};

//        Arrays.sort(a);
//        System.out.println(Arrays.toString(a));

        for (List<Integer> el : threeSum(a)) System.out.print(el + " ");

        //System.out.println(bs(a,2,0,1));
//        for (List<Integer> el : threeSum(a)) System.out.println(el);
//        System.out.println();
        // for (List<Integer> el : threeSumA(a)) System.out.println(el);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp;
        List<Integer> num = new ArrayList<>();
        int a = 0, b = 0, c = 0, idx = 0, idx1 = 0;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) num.add(nums[i]);
        while (num.size() > 1) {
            // idx = 0;
            a = num.get(0);
            for (int j = idx; j < num.size(); j++) {
                b = num.get(j);
                c = -(a + b);
                if ((bsList(num, c, 0, j, num.size()) != -1)) {
                    tmp = new ArrayList<>();
                    tmp.add(a);
                    tmp.add(b);
                    tmp.add(c);
                    Collections.sort(tmp);
                    if (!res.contains(tmp)) res.add(tmp);
                }
            }
            idx++;
            idx1++;
            num.remove(0);
        }

        return res;
    }

    public static List<List<Integer>> threeSumA(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayDeque<Integer> num = new ArrayDeque<>();
        int a = 0, b = 0, c;

        for (int i = 0; i < nums.length; i++) num.add(nums[i]);       //  3, 0, -2, -1, 1, 2
        int n = num.size();                                           // -2,-1,  0,  1, 2, 3
        while (num.size() > 1) {
            a = num.pop();
            b = num.pop();
            c = -(a + b);
            if (num.contains(c)) {
                List<Integer> memoRes = new ArrayList<>();
                memoRes.add(a);
                memoRes.add(b);
                memoRes.add(c);
                Collections.sort(memoRes);
                if (!res.contains(memoRes)) res.add(memoRes);
                memoRes = null;
            }
            num.addLast(b);
            num.addFirst(a);
        }
        return res;
    }

    private static int bsArr(int[] a, int target, int idx1, int idx2, int size) {
        int s = 0, e = size - 1, m;
        while (s <= e) {
            m = s + (e - s) / 2;
            if (target > a[m]) {
                s = m + 1;
            } else if (target < a[m]) {
                e = m - 1;
            } else {
                if ((a[m] == target) && (m == idx1 || m == idx2)) {
                    return -1;
                } else if ((a[m] == target) && (m != idx1 && m != idx2)) {
                    return m;
                }
            }
        }
        return -1;
    }

    private static int bsList(List<Integer> a, int target, int idx1, int idx2, int size) {
        int s = 0, e = size - 1, m;
        while ((s <= e) && a.size() > 2) {
            m = s + (e - s) / 2;
            if (target > a.get(m)) {
                s = m + 1;
            } else if (target < a.get(m)) {
                e = m - 1;
            } else {
                if ((a.get(m) == target) && (m == idx1 || m == idx2)) {
                    return -1;
                } else if ((a.get(m) == target) && (m != idx1 && m != idx2)) {
                    return m;
                }
            }
        }
        return -1;
    }

    private static List<List<Integer>> sum3B(int[] nums) {      // 1 2 3 4 5 6 7 8 9 --> 8
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmpRes;
        int idx = 0, s, e, a, b, c;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //s = idx + 1;
            s = 0;
            e = nums.length - 1;
            a = nums[i];
            while (s < e) {

                if (s == i) s++;
                if (e == i) e--;

                if (a == -(nums[s] + nums[e])) {
                    tmpRes = new ArrayList<>();
                    tmpRes.add(a);
                    tmpRes.add(nums[s]);
                    tmpRes.add(nums[e]);
                    Collections.sort(tmpRes);
                    if (!res.contains(tmpRes)) res.add(tmpRes);
                    s++;
                    e--;
                } else if (a > (nums[s] + nums[e])) {
                    s++;
                } else e--;
            }
            idx++;
        }
        return res;
    }

    private static List<List<Integer>> sum3BF(int[] nums) {              // <-  ;)     Time Limit Exceeded
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmpRes;

        System.out.println(Arrays.toString(nums));
        int idx1 = 0, idx2 = idx1 + 1, idx3 = idx2 + 1, a, b, c;
        for (int i = idx1; i < nums.length; i++) {
            a = nums[i];
            for (int j = idx2; j < nums.length; j++) {
                b = nums[j];
                if (i == j) continue;
                for (int k = idx3; k < nums.length; k++) {
                    c = nums[k];
                    if (k == j) continue;
                    if (k == i) continue;
                    if (((a + b + c) == 0)) {
                        tmpRes = new ArrayList<>();
                        tmpRes.add(a);
                        tmpRes.add(b);
                        tmpRes.add(c);
                        Collections.sort(tmpRes);
                        if (!res.contains(tmpRes)) res.add(tmpRes);
                    }
                }
            }
        }
        return res;
    }

    private static List<List<Integer>> sum2(int[] a, int target) {      // 1 2 3 4 5 6  7 8 9 --> 8
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmpRes;
        int s = 0, e = a.length - 1;

        Arrays.sort(a);
        while (s < e) {
            if (target == (a[s] + a[e])) {
                tmpRes = new ArrayList<>();
                tmpRes.add(a[s]);
                tmpRes.add(a[e]);
                res.add(tmpRes);
                s++;
                e--;
            } else if (target > (a[s] + a[e])) {
                s++;
            } else e--;
        }
        return res;
    }

    private static int[] findTwoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            } else {
                numMap.put(nums[i], i);
            }
        }
        return new int[]{};
    }

//    public static List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        List<Integer> tmp = new ArrayList<>();
//        List<Integer> memo;
//
//        for (int i = 0; i < nums.length - 1; i++) {
//            int a = nums[i];
//            int b = nums[i + 1];
//            int c = -(a + b);
//
//            for (int j = i + 2; j < nums.length; j++) tmp.add(nums[j]);
//            Collections.sort(tmp);
//
//            if (bs(tmp, c) != -1) {
//                memo = new ArrayList<>();
//                memo.add(a);
//                memo.add(b);
//                memo.add(c);
//                res.add(memo);
//            }
//            //i += 2;
//        }
//        return res;
//    }
}



