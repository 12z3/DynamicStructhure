package dynamicsStructhure;

import java.util.Arrays;

public class SelectionSort {

    // Със... "За всяко едно число от масива..." започва разказа => Първото нещо което трябва да се напише е:
    // while(...)
    // след което от всичките числа трябва да намерим най-голямото т.е. =>  for (int j = endIdx; j >= 0; j--){...}
    // ;)

    public static void main(String[] args) {
        int[] arr = {1, 6, 4, 3, 2, 9, 8, -1};

        int max, tmp, endIdx, number = 0, maxIdx = -1;
        while (number < arr.length) {
            max = Integer.MIN_VALUE;
            endIdx = arr.length - number - 1;
            for (int j = endIdx; j >= 0; j--) {
                if (arr[j] > max) {
                    max = arr[j];
                    maxIdx = j;
                }
            }
            tmp = arr[endIdx];
            arr[endIdx] = max;
            arr[maxIdx] = tmp;
            number++;
        }

        System.out.println(Arrays.toString(arr));
    }
}
