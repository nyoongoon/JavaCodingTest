package Base_Algorithm.Chapter2_Linear.LinearDS_07.src;// Practice2
// 괄호 짝 검사

// 입출력 예시)
// 입력: "("
// 출력: Fail

// 입력: ")"
// 출력: Fail

// 입력: "()"
// 출력: Pass

import java.util.Stack;

public class Practice2 {
    public static void checkParenthesis(String str) {
        Stack<Character> stk = new Stack<>();
        char[] chars = str.toCharArray();

        for (char c : chars){

//            if(stk.isEmpty()){
//                stk.push(c);
//                continue;
//            }

            if(!stk.isEmpty() && isMatched(stk.peek(), c)){
                stk.pop();
                continue;
            }

            stk.push(c);
        }

        if(stk.size() == 0){
            System.out.println("PASS!");
            return;
        }

        System.out.println("FAIL!");
    }

    public static boolean isMatched(char peeked, char parenthesis){
        if(peeked == '(' && parenthesis == ')'){
            return  true;
        }
        return false;
    }

    public static void main(String[] args) {
        // Test code
        checkParenthesis("(");          // FAIL!
        checkParenthesis(")");          // FAIL!
        checkParenthesis("()");         // PASS!
        checkParenthesis("()()()");     // PASS!
        checkParenthesis("(())()");     // PASS!
        checkParenthesis("(((()))");    // FAIL!
    }
}
