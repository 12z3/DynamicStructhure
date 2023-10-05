package dynamicsStructhure;

import java.util.ArrayDeque;
import java.util.List;

public class ArrayDequeTests {
    public static void main(String[] args) {

        // Обмисли каk би изглеждало решението използвайки streamAPI?

        String line = "2 + 1 - 12 + 5 - 6 / 3 * 2";
        String[] input = line.split(" ");
        ArrayDeque<Double> stack = new ArrayDeque<>();
        String operation = "";
        double result = 0;

        for (int i = 0; i < input.length - 1; i++) {
            if (Character.isDigit(input[i].charAt(0))) {
                stack.push((double) Integer.parseInt(input[i]));
            } else {
                operation = String.valueOf(input[i]);
                switch (operation) {
                    case ("+") -> {
                        result = stack.pop();
                        result += Integer.parseInt(input[++i]);
                        stack.push(result);
                    }
                    case ("-") -> {
                        result = stack.pop();
                        result -= Integer.parseInt(input[++i]);
                        stack.push(result);
                    }
                    case ("*") -> {
                        result = stack.pop();
                        result *= Integer.parseInt(input[++i]);
                        stack.push(result);
                    }
                    case ("/") -> {
                        result = stack.pop();
                        result /= Integer.parseInt(input[i + 1]);
                        stack.push(result);
                        i++;
                    }
                }
            }
        }
        System.out.printf("%.2f %n", stack.pop());


        //String players = "Mimi, Pepi, To6ko";
        String players = "Gosho, Pe60, Mi60, Stefan, Krasi";

        int n = 10, k = 1;
        String[] player = players.split(", ");
        ArrayDeque<String> queue = new ArrayDeque<>(List.of(player));
        boolean criteria;

        while (true) {
            if (isCriteria(k, n)) {
                String playerB = queue.remove();
                System.out.println("Removed " + playerB);
                k++;
            } else {
                String playerA = queue.remove();
                queue.add(playerA);
                k++;
            }
            if (queue.size() == 1) {
                System.out.println("Last is " + queue.remove());
                break;
            }
        }
    }

    static boolean isCriteria(int k, int n) {
        return (k % n == 0) ? true : false;
    }
}
