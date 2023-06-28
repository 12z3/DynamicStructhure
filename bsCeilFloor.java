package dynamicsStructhure.bS;

import java.util.Arrays;

class bsCeilFloor {
    public static void main(String[] args) {
        int x, y, t = 6;
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        int[] a1 = {1, 2, 3, 5, 6, 7};
        x = floor(a,t);
        y = ceil(a,t);

        System.out.println(Arrays.binarySearch(a, 0,a.length-1,6));
        int idx = Arrays.binarySearch(a,t);
        System.out.printf("el = %d with Idx = %d%n", t, idx);
        System.out.printf("floor: Idx = %d -> el = %d %n", x, a[x]);
        System.out.printf("ceil:  Idx = %d -> el = %d ", y, a[y]);
    }
    static int floor(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                // Не се интересувам дали target е в масива.
                end = mid - 1 ;
            }
        }
        return end;
    }
    static int ceil(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                // Не се интересувам дали target е в масива.
                start = mid + 1 ;
            }
        }
        return start;
    }

    // return the index: greatest number <= target
    static int floorА(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                // ans found
                return mid;
            }
        }
        return end;
    }
}


