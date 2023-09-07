package Some;

import java.util.*;

public class sum3 {
    public static void main(String[] args) {
        int[] a1 = {-1, 0, 1, 2, -1, -4};
        int[] a = {1, 2, -2, -1};
        System.out.println(sum3(a));
    }

    private static List<List<Integer>> sum3(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp;
        int el0, el1, el2;
        for (int i = 0; i < nums.length; i++) {
            el0 = nums[i];

            for (int j = 0; j < sum2X(nums, -el0, i + 1, el0).size(); j++) {
                el1 = sum2X(nums, -el0, i + 1, el0).get(j).get(0);
                el2 = sum2X(nums, -el0, i + 1, el0).get(j).get(1);

                if ((el0 + el1 + el2 == 0)) {
                    tmp = new ArrayList<>();
                    tmp.add(el0);
                    tmp.add(el1);
                    tmp.add(el2);
                    Collections.sort(tmp);
                    if (!res.contains(tmp)) res.add(tmp);
                }
            }
        }
        return res;
    }

    static List<List<Integer>> sum2X(int[] a, int sum, int x, int el0) {            //  -1, 0, 1, 2, -1, -4
        HashMap<Integer, Integer> elDifferent = new HashMap<>();                    //   1, 2, -2, -1  <--
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp;
        int cnt = 0;

        for (int i = 0; i < a.length; i++) {
            if (i == 0 && a[i] == el0) {
                elDifferent.put(a[i], (sum - a[i]));
            } else elDifferent.put(a[i], (sum - a[i] * 2));
            elDifferent.put(a[i], (sum - a[i]));
        }

        for (Map.Entry<Integer, Integer> elDifferentKey : elDifferent.entrySet()) {
            int el1 = elDifferentKey.getKey();
            int el2 = elDifferentKey.getValue();
            if ((elDifferent.containsKey(elDifferentKey.getValue()))) {
                tmp = new ArrayList<>();
                if (el1 > el2) {
                    tmp.add(el2);
                    tmp.add(el1);
                } else {
                    tmp.add(el1);
                    tmp.add(el2);
                }
                if (!res.contains(tmp)) {
                    res.add(tmp);
                    //tmp = null;
                    // System.out.println(el0 + " " + tmp);
                }
            }
        }
        return res;
    }
}
