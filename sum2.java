package Some;

import java.util.*;

public class sum2 {
    public static void main(String[] args) {
        int[] a = {3, 4, 2, 8, 1, 9, 5, 0, 5, -4};
        int[] a1 = {3, 4, 2, 4, 8, 1, 9, 5, 0, 5, -4};
        findPair(a, 5);
        findPairA(a1, 5);
    }

    static void findPair(int[] a, int sum) {                                  // 3, 4, 2, 8, 1, 9 = 15
        HashMap<Integer, Integer> elDifferent = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp;

        for (int i = 0; i < a.length; i++) elDifferent.put(a[i], (sum - a[i]));

        for (Map.Entry<Integer, Integer> elDifferentKey : elDifferent.entrySet()) {
            int el1 = elDifferentKey.getKey();
            int el2 = elDifferentKey.getValue();
            if ((elDifferent.containsKey(elDifferentKey.getValue()))) {
                tmp = new ArrayList<>();

                //Collections.sort(tmp);
                if (el1 > el2) {
                    tmp.add(el2);
                    tmp.add(el1);
                } else {
                    tmp.add(el1);
                    tmp.add(el2);
                }
                if (!res.contains(tmp)) res.add(tmp);
            }
        }
        System.out.println(res);
    }

    static void findPairA(int[] nums, int sum) {                                  // 3, 4, 2, 4, 8, 1, 9, 5, 0, 5, -4
        HashMap<Integer, Integer> elDifferent = new HashMap<>();                  // Map -> <el, validNum>
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp;
        int validNum = -1;

        for (int i = 0; i < nums.length; i++) {
            validNum = sum - nums[i];
            if (!elDifferent.containsKey(nums[i])) {
                tmp = new ArrayList<>();
                elDifferent.put(nums[i], validNum);
                if (nums[i] > elDifferent.get(nums[i])) {
                    tmp.add(elDifferent.get(nums[i]));
                    tmp.add(nums[i]);
                } else {
                    tmp.add(nums[i]);
                    tmp.add(elDifferent.get(nums[i]));
                    res.add(tmp);                                               // Тук е "кучето"
                }
            }
        }
        System.out.print(res + " ");
    }

    static void findPair1(int[] a, int sum) {
        HashMap<Integer, Integer> tmp = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmpRes;

        for (int i = 0; i < a.length; i++) {
            tmp.put(Math.abs(sum - a[i]), a[i]);
        }

        for (Map.Entry<Integer, Integer> el : tmp.entrySet()) {
            if ((el.getValue() + el.getKey()) == sum) {
                tmpRes = new ArrayList<>();
                tmpRes.add(el.getKey());
                tmpRes.add(el.getValue());
                if (!res.contains(tmpRes)) res.add(tmpRes);
            } else {
                System.out.println(" ;( == -1");
                break;
            }
        }
        System.out.println(res);
    }

    private static void findPairBS(int[] a) {

    }

    private static void findPairPointers(int[] a) {

    }


}
