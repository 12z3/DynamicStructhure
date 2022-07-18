package DynamicsStructhure;
import training.Methods;

public class ArraysN extends Methods {
    public static void main(String[] args) {
        timeAndData();

        /**         c
         *        r 0+0    1+0    2+0     3+0     4+0     5
         *          0+1                                   1
         *          0+2                                   2
         *          3             3+2     3+3             3
         *          4                                     4
         *          5                                     5
         *          0+5    1+5    2+5     3+5     4+5     5
         */


        int position, n = 5;
        for (int row = 1; row <= n; row++) {

            for (int coll = 1; coll <= n; coll++) {
                position = row * 10 + coll;
                System.out.print(position + "  ");
            }
            System.out.println();
        }

        /**
         Интересно:
         */
        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= 10; j++) {
                System.out.print(i + j + " ");
            }
            System.out.println();
        }





    }


}
