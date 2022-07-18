package DynamicsStructhure;

import training.Methods;
import java.util.Scanner;

public class ArrayTaskSquare extends Methods {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        timeAndData();

        int[][] a = new int[5][5];
        for (int row = 0; row < a.length; row++) {
            for (int col = 0; col < a[row].length; col++) {

                a[0][col] = col + 1;                                             // Първият ред
                if (col == a[row].length - 1) {                                  // Последната колона
                    a[a.length - row - 1][col] = row + 1;                        // a[5-4-1][4] = 4 + 1
                }                                                                // Последният ред (от Ред: 18) -
                a[a.length - 1][a[row].length - col - 1] = col + 1;              // a[5 -1][5-4-1] = 4 + 1;]
                a[row][0] = row + 1;                                             // Първата колона
            }
        }
        for (int row = 0; row < a.length; row++) {
            for (int col = 0; col < a[row].length; col++) {
                if (a[row][col] == 0) {
                    System.out.print("  ");
                } else System.out.print(a[row][col] + " ");
            }
            System.out.println();
        }
    }
}
