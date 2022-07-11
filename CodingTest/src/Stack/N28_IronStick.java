package Stack;

import java.util.Scanner;
import java.util.Stack;

public class N28_IronStick { // 내풀이 !!!
    public static void main(String[] args){
        //Stack<Character> stk = new Stack<>();
        Scanner stdIn = new Scanner(System.in);
        String str = stdIn.nextLine();
        char prev = ' ';
        int stick = 0;
        int answer = 0;

        for(char c : str.toCharArray()){
            if(prev == '(' && c == ')'){
                stick-=1;
                answer += stick;
            }else if(c == ')'){
                answer += 1;
                stick -= 1;
            }else{
                stick+=1;
            }
            prev = c;

        }

        System.out.println(answer);
    }
}
