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
        for (int i = 0; i < chars.length; i++) {

            if(!stk.isEmpty()){
                char popChar = stk.peek();
//                System.out.println("popChar == " + popChar);
//                System.out.println("chars["+i+"] == " + chars[i]);
                if(popChar == '(' && chars[i]==')'){ // 다르면 없어짐
                    stk.pop();
                }else{
                    stk.push(chars[i]);
                }
            }else{
                stk.push(chars[i]);
            }
        }

        if(stk.isEmpty()){
            System.out.println("PASS!");
        }else{
            System.out.println("FAIL!");
        }

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
