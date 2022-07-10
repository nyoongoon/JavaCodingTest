package Stack;

import java.util.Scanner;
import java.util.Stack;

public class N24_CorrectParenthesis_inf {
    public static void main(String[] args){
        Stack<Character> stk = new Stack<>();
        Scanner stdIn = new Scanner(System.in);
        String str = stdIn.nextLine();
        String answer = "YES";

        for(char x : str.toCharArray()){
            if(x == '('){
                stk.push(x);
            }else{
                if(stk.isEmpty()){
                    answer = "NO";
                    System.out.println(answer);
                    break;
                }else{
                    stk.pop();
                }
            }
        }

        if(stk.isEmpty()){
            System.out.println(answer);
        }else{
            answer = "NO";
            System.out.println(answer); // 여는 괄호가 많은 상황.
        }

    }
}
