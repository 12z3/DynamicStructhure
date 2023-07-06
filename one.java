package Recursions;

import java.util.Arrays;

public class one {
    public static void main(String[] args) {
        System.out.println(sum(1, 0, 3));
        System.out.println(sum1(1, 0, 3));
        System.out.println(sum2(1, 0, 3));
        sum3(3, 0);
        System.out.println(sum4(3));
        System.out.println(factorial(4));
        System.out.println(factorialInRange(1, 4));
        System.out.println(factorialInRange1(3, 5));
    }

    static int factorialInRange(int x1, int x2) {             // .....  1 * 2 * 3 ..... 4 5
        if ((x2 - x1) <= 0) return x1;
        return x1 * (factorialInRange((x1 + 1), x2));
    }

    static int factorialInRange1(int x1, int x2) {            // .....  1 * 2 * 3 ..... 4 5
        if (x1 == x2) return x1;
        return x2 * (factorialInRange(x1, x2 - 1));
    }

    // sum(3) = 3 + sum(2) -> 2 + sum(1) -> 1 + sum(0); sum(O) return 0;
    //          3 + 3     <-  2 + 1    <-   1 + 0     <-    0
    static int factorial(int x) {
        if (x == 1) return 1;
        return x * factorial(x - 1);
    }

    static int sum4(int x) {
        if (x == 0) return 0;
        return x + sum4(x - 1);
    }

    static int sum(int x, int sum, int n) {                   // 1 2 3 4 5
        if (x > n) return sum;
        return sum(x + 1, sum + x, n);
    }

    static int sum1(int x, int sum, int n) {
        if (x > n) return sum;
        sum += x;
        x++;
        return sum(x, sum, n);
    }

    static int sum2(int x, int sum, int n) {
        if (x > n) return sum;
        int newSum = sum + x;
        int newX = x + 1;
        return sum(newX, newSum, n);
    }

    static void sum3(int x, int sum) {
        if (x < 1) {
            System.out.println(sum);
            return;
        }
        sum3(x - 1, sum + x);
    }
}
