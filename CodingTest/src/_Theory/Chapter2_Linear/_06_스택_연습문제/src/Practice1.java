package _Theory.Chapter2_Linear._06_스택_연습문제.src;// Practice1
// 문자열 뒤집기

// 입출력 예시)
// 입력: "Hello"
// 출력: "OlleH"

// 입력: 1 3 5 7 9
// 출력: 9 7 5 3 1

import java.util.Stack;

public class Practice1 {
    public static String reverseString(String str) {
        Stack<Character> stk = new Stack<>();
        char[] chars = str.toCharArray();
        char[] resultChars = new char[chars.length];
        for(char c : chars){
            stk.push(c);
        }

        for (int i = 0; i < resultChars.length; i++) {
            resultChars[i] = stk.pop();
        }
        return new String(resultChars);
    }

    public static void main(String[] args) {
        // Test code
        String result = reverseString("Hello");
        System.out.println("result = " + result);

        result = reverseString("1 3 5 7 9");
        System.out.println("result = " + result);
    }
}
