package _2_Java_Algo_Interview._3_선형자료구조._4_스택_큐;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 해시 맵을 이용해 매핑 테이블 만드는 아이디어 암기
 */
public class _1_유효한_괄호_책풀이 {
    public static void main(String[] args) {
        isValid("()");
    }

    static boolean isValid(String s) {
        Deque<Character> stk = new ArrayDeque<>();
        Map<Character, Character> map = new HashMap<>(){{ // 암기
            put('(', ')');
            put('[', ']');
            put('{', '}');
        }};

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                stk.push(c);
            }else if(stk.isEmpty() || map.get(stk.pop()) != c){
                return false;
            }
        }

        return stk.isEmpty();
    }
}
