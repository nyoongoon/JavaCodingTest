package _Theory.Chapter2_Linear.LinearDS_07.src;// Practice3
// 후위표기법 연산
// 참고 설명) 전위/중위/후위 표기법

// 입출력 예시)
// 입력: "2 2 + "
// 출력: 4

// 입력: "2 2 -"
// 출력: 0

import java.util.Stack;

public class Practice3_ans {
    public static double calculate(String string) {
        Stack<Double> stk = new Stack<>();


        for(String str : string.split(" ")){
            if(str.equals("+")){
                stk.push(stk.pop() + stk.pop());
            }else if(str.equals("*")){
                stk.push(stk.pop() * stk.pop());
            }else if(str.equals("-")){
                stk.push(-stk.pop() + stk.pop());
            }else if(str.equals("/")){
                stk.push(1/stk.pop() * stk.pop());
            }else{
                stk.push(Double.valueOf(str));
            }
        }


        return stk.pop();
    }


    public static void main(String[] args) {
        //  Test code

        System.out.println(calculate("2 2 +"));    // 4
        System.out.println(calculate("2 2 -"));    // 0
        System.out.println(calculate("2 2 *"));    // 4
        System.out.println(calculate("2 2 /"));    // 1
        System.out.println(calculate("1 1 + 2 * 3 * 2 / 5 -"));    // 1
        System.out.println(calculate("5 2 * 3 - 8 * 4 /"));        // 14


    }
}
