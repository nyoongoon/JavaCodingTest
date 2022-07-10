package Stack;

import java.util.Scanner;
import java.util.Stack;

public class N25_RemoveParenthesisChar_inf {
    public static void main(String[] args){
        Stack<Character> stk = new Stack<Character>();
        Scanner stdIn = new Scanner(System.in);
        String answer = "";
        String str = stdIn.nextLine();

        for(char x : str.toCharArray()){
            if(x == ')'){
                while(stk.pop() != '('){
                    continue;
                }
            }else{
                stk.push(x);
            }
        }

        for(int i = 0; i<stk.size(); i++){
            answer += stk.get(i);   // get으로 하면 편함 (인덱스로 접근 가능 !!!)
        }
        System.out.println(answer);

    }
}
