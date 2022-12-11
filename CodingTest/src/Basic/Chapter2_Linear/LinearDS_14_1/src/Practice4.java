package LinearDS_14_1.src;

import java.util.Stack;

public class Practice4 {
    public static void solution(String str) {
        System.out.println();
        System.out.println();
        String result = "Pass";
        Stack<Character> stk = new Stack<>();
        for (char c : str.toCharArray()) {
            //System.out.println(c);
            if (c == '(' || c == '{' || c == '[') {
                stk.add(c);
                continue;
            }

            if (c == ')') {
                if (stk.peek() == '(') {
                    stk.pop();
                } else {
                    result = "Fail";
                    break;
                }
            } else if (c == '}') {
                if (stk.peek() == '{') {
                    stk.pop();
                } else {
                    result = "Fail";
                    break;
                }
            } else if (c == ']') {
                if (stk.peek() == '[') {
                    stk.pop();
                } else {
                    result = "Fail";
                    break;
                }
            }
        }
        System.out.println(result);

    }

    public static void main(String[] args) {
        // Test code
        solution("[yyyy]-[mm]-[dd]");               // Pass
        solution("System.out.println(arr[0][1))");  // FAIL
        solution("Support [Java or Python(3.x)]");  // PASS
        solution("([[{}])");                        // FAIL
    }
}
