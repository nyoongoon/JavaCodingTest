package Stack;

import java.util.Scanner;
import java.util.Stack;

public class N24_CorrectParenthesis {
    public static void main(String[] args){
        Stack<Character> stk = new Stack<Character>();
        Scanner stdIn = new Scanner(System.in);

        String bracket = stdIn.nextLine();

        for(char c : bracket.toCharArray()){
            // 넣을 때 체크 가능 ?

            if(!stk.empty()){
                char tmp = stk.pop();
                if(tmp == '(' && c == ')'){
                    continue;
                }else{
                    stk.push(tmp);
                }
            }

            stk.push(c);
        }


        if(stk.empty()){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

    }
}
