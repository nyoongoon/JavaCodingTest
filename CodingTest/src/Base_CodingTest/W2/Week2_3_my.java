package Base_CodingTest;

import java.util.Stack;

public class Week2_3_my {
    public static void main(String[] args) {
        String code = "6{a2{b4{c}d}e}f";
        solution(code);
    }

    public static String solution(String code) {

        return recur(code);
    }

    public static String recur(String str){
        String result = "";
        char[] chars = str.toCharArray();
        int idx = 0;

        while(idx < chars.length){
            char c = chars[idx];
            if(Character.isDigit(c)){

                int n = c - '0';

                Stack<Character> stk = new Stack<>();
                stk.push(chars[++idx]); //{
                //System.out.println(stk.peek()); // <-

                String sub = "{";
                while(!stk.isEmpty()){
                    idx++;
                    sub += chars[idx];
                    if(chars[idx] == '{'){
                        stk.push('{');
                    }else if(chars[idx] == '}'){
                        stk.pop();
                    }
                    //idx++;
                }
                int subLen = sub.length() - 1;
                String recurResult = recur(sub.substring(1, subLen));
                for(int i = 0; i<n; i++){
                    result += recurResult;
                }
                idx++;
            }else {
                result += c;
                idx++;
            }
        }


        return result;
    }
}
