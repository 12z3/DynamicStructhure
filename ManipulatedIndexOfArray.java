package DynamicsStructhure;

import training.Methods;

import java.util.Scanner;

public class ManipulatedIndexOfArray extends Methods {
    private static final int MY_CONST = 10;

    private static void fillArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = i + 1;
        }

    }

//     TODO: Валидира дали въвеждания литерал е число (int)
//           111 && 1 -> true
//           1a1 && a11 && a && aaa -> false

    public static int validateInputDigit(int[] a) {
        boolean isItInt = true;
        Scanner scanner = new Scanner(System.in);
        StringBuilder stb = new StringBuilder();
        String inputString = "";
        int count = 0, l = 0, index = 0;
        System.out.println("Enter index number.");

        while (true) {
            count = 0;                        // Ако не нулира брояча на всяко ново въвеждане на число се чупи яко кода.
            isItInt = true;
            System.out.print("Index must be in " + 0 + " to " + (a.length - 1) + ": ");
            inputString = (scanner.nextLine());
            stb.append(inputString);

            while (inputString.isEmpty()){
                System.out.print("Index must be in " + 0 + " to " + (a.length - 1) + ": ");
                inputString = (scanner.nextLine());
            }

            for (int j = 0; j < inputString.length(); j++) {
                for (int i = 97; i <= 122; i++) {
                    if (i == inputString.charAt(j)) {
                        count++;
                        isItInt = false;
                        break;
                    }
                }
            }
            printInfo(isItInt, stb, inputString, count);
            if (isItInt) {
                index = Integer.parseInt(inputString);
                break;
            }
        }
        return index;
    }

    public static void printInfo(boolean isItInt, StringBuilder stb, String inputString, int count) {
        System.out.println("isItInt = " + isItInt);
        System.out.println("count = " + count);
        System.out.println("inputString = " + inputString);
        System.out.println("String bulder is: " + stb);
    }

    public static void main(String[] args) {
        int[] a = new int[10], b, c;
        int firstPoint = 0;
        int endPoint = (firstPoint + MY_CONST);
        int halfPoint = (endPoint - firstPoint) / 2;

//        System.out.println("firstPoint = " + firstPoint);
//        System.out.println("halfPoint = " + halfPoint);
//        System.out.println("endPoint = " + endPoint);


        fillArray(a);
        b = c = new int[halfPoint];

        for (int i = halfPoint; i < endPoint; i++) {
            b[i - halfPoint] = a[i];                              // <-
        }
        for (int i = 0; i < halfPoint; i++) {
            c[i] = a[i];
        }

//        System.out.println(Arrays.toString(a));
//        System.out.println(Arrays.toString(b));
//        System.out.println(Arrays.toString(c));

        String str = "12345";
        int randomIndex = (int) ((Math.random() * (a.length)));
        int[] a1 = new int[1];
        a1[0] = randomIndex;
        System.out.println(validateInputIndexFromArray(a));;

    }
}
