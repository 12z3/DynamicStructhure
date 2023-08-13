package dynamicsStructhure.bS;

import java.util.Arrays;

class bsCeilFloor {
    public static void main(String[] args) {
        int x, y, t = 6;
        int[] a = {1, 2, 3, 4, 5, 7};
        int[] a1 = {1, 2, 3, 5, 6, 7};
        x = floor(a,t);
        y = ceil(a,t);

        int idx = Arrays.binarySearch(a, t);
        System.out.println(Arrays.binarySearch(a, 0,a.length-1,6));
        System.out.printf("el = %d with Idx = %d%n", t, idx);
        System.out.printf("floor: Idx = %d -> el = %d %n", x, a[x]);
        System.out.printf("ceil:  Idx = %d -> el = %d ", y, a[y]);
    }

    // И в двата слузая условието за край на цикъла е едно и също "while (start <= end)".
    // И в двата слузая условията за промяна на границите са едни и същи.
    // Разликата е само в условието при което "target == arr[mid]" или !(start <= end).
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
    static int ceil(int[] arr, int target) {                       // ceil == lowerBound
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

    private static int upperBound(int[] arr, int x, int n) {
        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] > x) {
                ans = mid;
                //look for smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1; // look on the right
            }
        }
        return ans;
    }

    protected static int lowerBound(int []arr, int n, int x) {
        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] >= x) {
                ans = mid;
                //look for smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1; // look on the right
            }
        }
        return ans;
    }






    // return the index: greatest number <= target
    static int floorA(int[] arr, int target) {
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


