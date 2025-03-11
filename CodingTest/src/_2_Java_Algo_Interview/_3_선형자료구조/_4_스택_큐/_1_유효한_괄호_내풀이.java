package _2_Java_Algo_Interview._3_선형자료구조._4_스택_큐;

import java.util.ArrayDeque;
import java.util.Deque;

public class _1_유효한_괄호_내풀이 {
    public static void main(String[] args) {
        isValid("()");
    }

    public static boolean isValid(String s) {
        Deque<Character> stk = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stk.isEmpty()) {
                stk.push(c);
                continue;
            }
            if (isMatch(stk.peek(), c)) {
                stk.pop();
            } else {
                stk.push(c);
            }
        }

        return stk.isEmpty();
    }

    static boolean isMatch(char startChar, char endChar) {
        if (endChar == ')' && startChar == '(') {
            return true;
        } else if (endChar == ']' && startChar == '[') {
            return true;
        } else if (endChar == '}' && startChar == '{') {
            return true;
        } else {
            return false;
        }
    }
}
