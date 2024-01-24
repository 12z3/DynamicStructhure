package dynamicsStructure;
import java.util.*;

public class Sum3 {
    public static void main(String[] args) {

        int[] a = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(a, 0));
        System.out.println(twoSum(a, 1));
    }

    private static List<List<Integer>> threeSum(int[] nums, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp;

        for (int i = 0; i < nums.length; i++) {                  // -1, 0, 1, 2, -1, -4
            Set<Integer> midDigits = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                int xDigits = sum - (nums[i] + nums[j]);
                if (midDigits.contains(xDigits)) {
                    tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(xDigits);
                    Collections.sort(tmp);
                    if (!res.contains(tmp)) res.add(tmp);
                } else {
                    midDigits.add(nums[j]);
                }
            }
        }
        return res;
    }

    private static List<List<Integer>> twoSum(int[] a, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> digits = new HashSet<>();
        ArrayList<Integer> tmp;

        for (int i = 0; i < a.length; i++) {
            int xDigit = sum - a[i];
            if (digits.contains(xDigit)) {
                tmp = new ArrayList<>();
                tmp.add(a[i]);
                tmp.add(xDigit);
                Collections.sort(tmp);
                if (!res.contains(tmp)) res.add(tmp);
            } else {
                digits.add(a[i]);
            }
        }
        return res;
    }
}
