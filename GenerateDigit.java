package dynamicsStructhure;

public class GenerateDigit {
    public static void main(String[] args) {
        long p = 123456, n = 123456, digit = p % 10, sum = 0, number = 0, rem = 0;
        long counter = 0;

        while (n > 0) {
            digit = n % 10;
            sum += digit;
            n /= 10;
        }
        System.out.println("sum = " + sum);

//        while (p > 0){
//            digit = p % 10;
//            if (counter == 0) {
//                number = digit;
//            } else {
//                number = number * 10 + rem;
//            }
//            p /= 10;
//            rem = p % 10;
//            counter++;
//        }

        while (p > 0) {
            rem = p % 10;
            number = number * 10 + rem;
            p /= 10;
        }
        System.out.println("Num = " + number);
    }
}
