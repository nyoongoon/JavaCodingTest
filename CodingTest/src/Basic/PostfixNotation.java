package Basic;// 후위표기법 연산
// 참고 설명) 전위/중위/후위 표기법

// 입출력 예시)
// 입력: "2 2 +"
// 출력: 4

// 입력: "2 2 -"
// 출력: 0

import java.util.Stack;

public class PostfixNotation {
    public static double calculate(String string) {
        char[] chars = new char[string.length()/2 + 1];
        int idx = 0;
        for (int i = 0; i < string.length(); i++) {
            char c =  string.charAt(i);
            if(c != ' '){
                chars[idx++] = c;
            }
        }



        return recur(chars, chars.length-1);
    }

    public static double recur(char[] chars, int idx){
        //System.out.println("call");
        //double[] results = new double[2];
        if(idx == 0){
            System.out.println("idx == 0");
            return chars[0] - '0';
        }


        char c = chars[idx];
        double recurResult = 0;
        double cur = 0;
        if(c == '+'){
            cur = chars[idx-1] - '0';
            recurResult = recur(chars, idx-2);

            return recurResult + cur;
        }else if(c == '-'){
            cur = chars[idx-1] - '0';
            recurResult = recur(chars, idx-2);

            return recurResult - cur;
        }else if(c == '*'){
            cur = chars[idx-1] - '0';
            recurResult = recur(chars, idx-2);

            return recurResult * cur;
        }else if(c == '/'){
            cur = chars[idx-1] - '0';
            recurResult = recur(chars, idx-2);

            return recurResult / cur;
        }else{

            return -1;
        }




    }



    public static void main(String[] args) {
        //  Test code
        System.out.println(calculate("2 2 +"));    // 4
        System.out.println(calculate("2 2 -"));    // 0
        System.out.println(calculate("2 2 *"));    // 4
        System.out.println(calculate("2 2 /"));    // 1

        System.out.println(calculate("1 1 + 2 * 3 * 2 / 5 -"));    // 1
        System.out.println(calculate("5 2 * 3 - 8 * 4 /"));        // 14

    }
}
