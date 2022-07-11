package Stack;

import java.util.Scanner;
import java.util.Stack;

public class N27_PostfixExpression_inf { // 강의 풀이 !!!
    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<Integer>();
        Scanner stdIn = new Scanner(System.in);
        String str = stdIn.nextLine();

        for (char x : str.toCharArray()) {
            if (Character.isDigit(x)) {
                stk.push(x - 48); // '0' == 48
            } else {
                int rt = stk.pop();
                int lt = stk.pop();
                if (x == '+') {
                    stk.push(lt + rt);
                } else if (x == '-') {
                    stk.push(lt - rt);
                }else if (x == '*') {
                    stk.push(lt * rt);
                }else if (x == '/') {
                    stk.push(lt / rt);
                }
            }
        }
        System.out.println(stk.get(0));
    }
}
