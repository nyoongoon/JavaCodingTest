package _0_Theory.Chapter2_Linear._06_스택_연습문제.src;// Practice4
// 두 문자열 비교
// 단, #은 backspace 로 바로 이전의 문자를 삭제하는 기능이라고 가정

// 입출력 예시
// 입력: s1 = "tree", s2 = "th#ree"
// 출력: true

// 입력: s1 = "ab#a", s2 = "aab#"
// 출력: true

// 입력: s1 = "wo#w", s2 = "ww#o"
// 출력: false


import java.util.Stack;

public class Practice4_ans {

    public static boolean stringCompare(String s1, String s2) {
        String str1 = doBackSpace(s1);
        String str2 = doBackSpace(s2);

        return str1.equals(str2);
    }

    public static String doBackSpace(String str){
        Stack<Character> stk = new Stack<>();
        for(char c : str.toCharArray()){
            if(c == '#'){
                stk.pop();
                continue;
            }
            stk.push(c);
        }
        return String.valueOf(stk);
    }


    public static void main(String[] args) {
        // Test code
        String s1 = "tree";
        String s2 = "th#ree";
        System.out.println(stringCompare(s1, s2));

        s1 = "ab#a";
        s2 = "aab#";
        System.out.println(stringCompare(s1, s2));

        s1 = "wo#w";
        s2 = "ww#o";
        System.out.println(stringCompare(s1, s2));
    }
}
