package Stack;

import java.util.Scanner;
import java.util.Stack;

public class N25_RemoveParenthesisChar {
    public static void main(String[] args){

        Stack<Character> stk = new Stack<Character>();
        Scanner stdIn = new Scanner(System.in);

        String str = stdIn.nextLine();


        for(char c : str.toCharArray()){
            if(c == ')'){
                while(stk.pop() != '('){

                }
            }else{
                stk.push(c);
            }
        }

        char[] chars = new char[stk.size()];
        int idx = 0;
        while(!stk.empty()){
            chars[idx++] = stk.pop();
        }

        for(int i = chars.length-1; i>=0; i--){
            System.out.print(chars[i]);  // 출력하는 형태 정답 풀이와 좀 다름 !!!
        }


    }
}
