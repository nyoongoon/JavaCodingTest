package _Theory.Chapter2_Linear._06_스택_연습문제.src;// Practice3
// 후위표기법 연산
// 참고 설명) 전위/중위/후위 표기법

// 입출력 예시)
// 입력: "2 2 + "
// 출력: 4

// 입력: "2 2 -"
// 출력: 0

import java.util.Stack;

public class Practice3 {
    public static double calculate(String string) throws Exception {
        Stack<Double> stk = new Stack<>();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);

            if (Character.isDigit(c)) {
                stk.push((double) (c - '0'));
            }

            if (!Character.isDigit(c) && c != ' ') {
                compute(c, stk);
            }
        }

        return stk.pop();
    }


    public static void compute(char operator, Stack<Double> stk) throws Exception {


        double num2Double = stk.pop();
        double num1Double = stk.pop();

        if (operator == '+') {
            stk.push(num1Double + num2Double);
            return;
        }
        if (operator == '-') {
            stk.push(num1Double - num2Double);
            return;
        }
        if (operator == '*') {
            stk.push(num1Double * num2Double);
            return;
        }
        if (operator == '/') {
            stk.push(num1Double / num2Double);
            return;
        }

        throw new Exception();
    }


    public static void main(String[] args) {
        //  Test code
        try {
            System.out.println(calculate("2 2 +"));    // 4
            System.out.println(calculate("2 2 -"));    // 0
            System.out.println(calculate("2 2 *"));    // 4
            System.out.println(calculate("2 2 /"));    // 1
            System.out.println(calculate("1 1 + 2 * 3 * 2 / 5 -"));    // 1
            System.out.println(calculate("5 2 * 3 - 8 * 4 /"));        // 14
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
