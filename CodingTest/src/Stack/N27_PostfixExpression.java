package Stack;

import java.util.Scanner;
import java.util.Stack;

public class N27_PostfixExpression { // 내풀이 !!!
    public static void main(String[] args){
        Stack <Integer> stk = new Stack<Integer>();
        Scanner stdIn = new Scanner(System.in);
        String str = stdIn.nextLine();

        for(char c : str.toCharArray()){
            if(!Character.isDigit(c)){
                int b = stk.pop();
                int a = stk.pop();
                // System.out.println(a);
                // System.out.println(b);
                // System.out.println();
                if(c == '+'){
                    stk.push(a+b);
                }else if(c == '-'){
                    stk.push(a-b);
                }else if(c == '*'){
                    stk.push(a*b);
                }else if(c == '/'){
                    stk.push(a/b);
                }else{
                    System.out.println("Error");
                    new Exception().getStackTrace()[0].getLineNumber();
                }

            }else{

                stk.push(c-'0'); // 0을 뺴는게 아니라 '0'을 뺴야함 주의 !!!

            }
        }

        System.out.println(stk.pop());

    }
    
}
