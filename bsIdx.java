package dynamicsStructhure.bS;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

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


        long start1 = System.nanoTime();
        findIdx(a, target);
        long end1 = System.nanoTime();
        long resFor = (end1 - start1);

        long start2 = System.nanoTime();
        System.out.println(Arrays.toString(searchRange(a, target)));
        long end2 = System.nanoTime();
        long resBs = (end2 - start2);

        System.out.printf("ForTime = %d microSec%n", resFor / 1000);
        System.out.printf("BSTime = %d microSec%n", resBs / 1000);
        System.out.printf("ForTime - BSTime = %d microSec", (resFor - resBs) / 1000);
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2], x = {-1, -1};

        if (bs(nums, target) == -1) return x;

        ans[0] = findIdx(nums, target, false);    // Търси на ляво от mid в масива:  е = m - 1;
        ans[1] = findIdx(nums, target, true);     // Търси на дясно от mid в масива: s = m + 1;
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
            } else {       // ans е възможен отговор, но на мен ми трябва първия. Така, че ще свивам дясната граница на
                ans = m;   // търсенето докато s <= e
                if (!doesFirstIdxFound) {
                    e = m - 1;             // Логиката е същата, но на обратно. Манипулирам лявата граница на търсенето
                } else s = m + 1;          // ;)
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

    private static void findIdx(int[] a, int target) {
        boolean lFind = false, rFind = false;

        int s = 0, e = a.length - 1, start = -1, end = -1;
        for (int i = 0; i < a.length; i++) {
            if (!lFind && a[s] != target) {
                s++;
            } else if (!lFind) {
                start = s;
                lFind = true;
            }
            if (!rFind && a[e] != target) {
                e--;
            } else if (!rFind) {
                end = e;
                rFind = true;
            }
            if (lFind && rFind) break;
        }

        System.out.printf(" start = %d, end = %d%n", start, end);
    }
}
