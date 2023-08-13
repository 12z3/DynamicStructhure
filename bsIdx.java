package dynamicsStructhure.bS;

import java.util.Arrays;

public class bsIdx {

    // Намира първият и последният индекс на които се среща даден елемент.

    public static void main(String[] args) {
        int[] a1 = {1, 7, 7, 8, 8, 8, 8, 9, 10, 11, 12, 13, 15};
        int[] a = {0, 0, 3, 3, 12, 12, 12, 12, 12, 12, 12, 45};
        int target = 12;

//        System.out.print(findFirstIdx(a, target) + " ");
//        System.out.println(findLastIdx(a, target));
//        System.out.print(findIdx(a, target, false) + " ");
//        System.out.println(findIdx(a, target, true));

        System.out.println(Arrays.toString(searchRange(a, target)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2], x = {-1, -1};

        if (bs(nums, target) == -1) return x;

        ans[0] = findIdx(nums, target, false);
        ans[1] = findIdx(nums, target, true);
        return ans;
    }

    // else {е равносилно на намерил си числото, но не знаеш дали е първото, последното или е някъде по средата.}
    // isFirstIdxWasFind -> определя кой указател ще манипулирам "e" за първият или "s" за последният индекс.
    // Или: 1: Намирам числото някъде в масива.
    //      -> else{
    //      2: Търся най-малкият негов индекс.
    //      3: Търся най-големият такъв.
    //      }
    private static int findIdx(int[] a, int target, boolean doesFirstIdxFound) {
        int s = 0, e = a.length - 1, m, ans = -1;

        while (s <= e) {
            m = s + ((e - s) / 2);
            if (target > a[m]) {
                s = m + 1;
            } else if (target < a[m]) {
                e = m - 1;
            } else {
                ans = m;
                if (!doesFirstIdxFound) {
                    e = m - 1;
                } else s = m + 1;
            }
        }
        return ans;
    }

    // За да намери първият idx  "свива" масива от края към началото докато е изпълнено s <= e -> [e < s = m].
    // ans го играе възможен отговор. Ако няма следващ такъв кандидат то ще се изпълни условието s > e,
    // ако ли пък е наличен след преоразмеряването ще бъде намерен и записан в ans. И така докато s <= e.
    private static int findFirstIdx(int[] a, int target) {
        int s = 0, e = a.length - 1, m, ans = 0;

        while (s <= e) {
            m = s + ((e - s) / 2);
            if (target > a[m]) {
                s = m + 1;
            } else if (target < a[m]) {
                e = m - 1;
            } else {
                ans = m;
                e = m - 1;
            }
        }
        return ans;
    }

    // За да намери последният idx "свива" масива от началото към края докато е изпълнено s <= e -> [e = m < s].
    private static int findLastIdx(int[] a, int target) {
        int s = 0, e = a.length - 1, m, ans = 0;

        while (s <= e) {
            m = s + ((e - s) / 2);
            if (target > a[m]) {
                s = m + 1;
            } else if (target < a[m]) {
                e = m - 1;
            } else {
                ans = m;
                s = m + 1;
            }
        }
        return ans;
    }

    private static int bs(int[] a, int target) {
        int s = 0, e = a.length - 1, m;
        while (s <= e) {
            m = s + ((e - s) / 2);
            if (target > a[m]) {
                s = m + 1;
            } else if (target < a[m]) {
                e = m - 1;
            } else return m;
        }
        return -1;
    }
}
