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

public class Practice4 {

    public static boolean stringCompare(String s1, String s2) {
        Stack<Character> stk1 = makeStack(new Stack<>(), s1);
        Stack<Character> stk2 = makeStack(new Stack<>(), s2);

        while (!stk1.isEmpty() && !stk2.isEmpty()) {

            char c1 = chooseCharacter(stk1);
            char c2 = chooseCharacter(stk2);

            if(c1 != c2){
                return false;
            }
        }

        return true;
    }

    public static char chooseCharacter(Stack<Character> stk) {
        char c = stk.pop();
        if (c == '#') {
            stk.pop();
            c = stk.pop();
        }
        return c;
    }

    public static Stack<Character> makeStack(Stack<Character> stk, String str) {
        for (int i = 0; i < str.length(); i++) {
            stk.push(str.charAt(i));
        }
        return stk;
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
