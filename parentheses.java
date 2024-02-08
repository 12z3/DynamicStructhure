package dynamicsStructure;

import java.util.ArrayDeque;

public class parentheses {
    public static void main(String[] args) {
        String input1 = "(()())";
        String input2 = ")()())";
        String input3 = "())";
        String input4 = "()(())";
        String input = "()(()";

        //System.out.println(longestValidParentheses1(input));
        //System.out.println(longestValidParentheses2(input));

        System.out.println(longestValidParentheses3(input));


    }

    private static int longestValidParentheses3(String s) {         // () ( () - 2            (() - 2
        int cnt = 0;                                                // () ) () - 2
        char[] tmp = s.toCharArray();
        ArrayDeque<Character> chars = new ArrayDeque<>();

        for (int i = 0; i < tmp.length; i++) {
            if (i == 0 && tmp[i] == ')') {
                continue;
            } else {
                if (tmp[i] == '(') {
                    chars.add(tmp[i]);
                }
            }
            if (tmp[i] == ')' && !chars.isEmpty()) {
                cnt++;
                chars.pop();
            }
        }

        if (chars.isEmpty()) {
            return cnt * 2;
        } else {
            return cnt * 2 - 2 * chars.size();
        }

        //return  (cnt == 0) ? 0 : cnt * 2;
    }

    private static int longestValidParentheses2(String s) {
        int cnt = 0;
        char[] tmp = s.toCharArray();
        ArrayDeque<Character> chars = new ArrayDeque<>();
        for (int i = 0; i < tmp.length; i++) {
            if ((tmp[i] == ')' && i == 0)) {          // -> if(!())
                continue;
            } else {
                if (!chars.contains('(') && tmp[i] == '(') {
                    chars.push(tmp[i]);
                    cnt++;
                } else {
                    if (tmp[i] == ')' && chars.contains('(')) {
                        cnt++;
                        chars.pop();
                    }
                }
            }
        }
        return cnt;
    }

    private static int longestValidParentheses1(String s) {
        int cnt = 1;
        char[] tmp = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {

            if (tmp[i] == ')' && i == 0) {
                continue;
            } else if ((tmp[i] == ')')) cnt++;
        }
        return (cnt == 1) ? 0 : cnt;
    }
}
