package dynamicsStructhure.bS;

public class bsCF {
    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4, 5, 7, 6, 8, 9};
        int[] a1 = {1, 2, 3, 4, 5, 7, 8, 9, 8, 7, 6, 5, 4, 3};
        int[] b = {1, 2, 3, 4, 5, 7, 8, 9, 1, 2, 3, 4};

        int target = 6;
        boolean isCeil = true;
        int idx = bsCeilOrFloor(a, target, isCeil);
        System.out.printf("Target = %d; Ceil = %b -> el = %d; idx = %d%n", target, isCeil, a[idx], idx);

        int idx2 = ceil(a, target);
        System.out.println(a[idx2]);

        int idx3 = floor(a, target);
        System.out.println(a[idx3]);

        int idx1 = trianglePeak(a1);
        System.out.printf("Peak = %d on idx = %d%n", a1[idx1], idx1);
    }

    // Ceil, floor с bs:
    // Подредбата е: "s  <  mid  <  e". В задачата за търсене на ел. -> target == mid, return mid;
    // В случая когато target не е в масива се стига до положението в което s = e = mid
    // Има две условия:
    // 1. "if (target < a[mid]) e = mid - 1;" -> е < s -> break; return: каквото e "e". Манипулираш "е".
    // 2. "if (target > a[mid]) s = mid + 1;" -> s > e -> break; return: каквото e "s". Манипулираш "s".
    // E... в зависимост от условието на if-a или "s" ще прескочи "е" или "е" ще прескочи "s" -> while -> break;
    // Особенното в случая е, че target може да го няма в масива (target != mid), но логиката изцяло копира логиката в
    // binary search - алгоритъма. Ако е наличен по-условие или го връщаме като резултат или връщаме предишният или
    // следващият елемент в зависимост от условието.
    // ceil:   e = mid  < s;   return s;
    // floor:  e < mid  = s;   return e;

    private static int zigzagPeak(int[] a, int target) {
        int s = 0, e = a.length - 1, mid = 0;

        while (s <= e) {
            mid = s + (e - s) / 2;
            if (a[mid] > a[mid - 1] && a[mid] < a[mid + 1]) {
                s = mid + 1;
            } else if (a[mid] < a[mid - 1] && a[mid] > a[mid + 1]) {
                e = mid - 1;
            } else return mid;
        }
        return -1;
    }

    private static int trianglePeak(int[] a) {
        int s = 0, e = a.length - 1, mid = -1;

        while (s <= e) {
            mid = s + (e - s) / 2;
            if (a[mid] > a[mid - 1] && a[mid] < a[mid + 1]) {
                s = mid + 1;
            } else if (a[mid] < a[mid - 1] && a[mid] > a[mid + 1]) {
                e = mid - 1;
            } else return mid;
        }
        return mid;
    }


    private static int bsCeilOrFloor(int[] a, int target, boolean isCeil) {
        int s = 0, e = a.length - 1, mid;

        while (s <= e) {
            mid = s + (e - s) / 2;
            if (target < a[mid]) {
                e = mid - 1;
            } else if (target > a[mid]) {
                s = mid + 1;
            } else {
                return isCeil ? mid + 1 : mid - 1;
            }
        }
        return isCeil ? s : e;
    }

    private static int ceil(int[] a, int target) {            // Най-големият от всички по-малки от target;
        int s = 0, e = a.length - 1, mid, ans = -1;

        while (s <= e) {
            mid = s + (e - s) / 2;
            if (target < a[mid]) {
                e = mid - 1;
            } else if (target >= a[mid]) {                   // "=" компенсира един else за случая: target == a[mid]
                s = mid + 1;                                 // виж ceil1.
                ans = s;
            }
        }
        return ans;
    }

    private static int floor(int[] a, int target) {           // Най-малкият от всички по-големи от target;
        int s = 0, e = a.length - 1, mid, ans = -1;

        while (s <= e) {
            mid = s + (e - s) / 2;
            if (target <= a[mid]) {                         // ans е едино от възможните решения....
                ans = e;                                    // От значение е поредноста в този случай на тези 2-а реда
                e = mid - 1;                                // виж ceil.
            } else if (target > a[mid]) {
                s = mid + 1;
            }
        }
        return ans;
    }

    private static int ceil1(int[] a, int target) {
        int s = 0, e = a.length - 1, mid, ans = -1;

        while (s <= e) {
            mid = s + (e - s) / 2;
            if (target < a[mid]) {
                e = mid - 1;
            } else if (target > a[mid]) {
                s = mid + 1;
                //ans = s;
            } else {                                        // При положение, че target е налично в масива
                return mid + 1;
            }
        }
        return s;                                          // Няма значение дали target го има в масива
    }

    private static int floor1(int[] a, int target) {
        int s = 0, e = a.length - 1, mid, ans = -1;

        while (s <= e) {
            mid = s + (e - s) / 2;
            if (target < a[mid]) {
                //ans = e;
                e = mid - 1;
            } else if (target > a[mid]) {
                s = mid + 1;
            } else {                          // При условие, че цикъла не влезе в този else това еднозначно показва,
                return mid - 1;               // че target не се намира в масива.
            }
        }
        return e;
    }
}
