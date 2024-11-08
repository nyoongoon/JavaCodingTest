package _0_Theory.Chapter2_Linear._13_선형자료구조_연습문제.src;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Practice4_ans {
    public static void solution(String str) {
        Stack<String> stk = new Stack<>();
        Map<String, String> map = new HashMap<>();
        map.put("(", ")");
        map.put("[", "]");
        map.put("{", "}");

        for(String s : str.split("")){
            if(map.containsKey(s)){
                stk.push(s);
                continue;
            }
            if(map.containsValue(s) && !map.get(stk.peek()).equals(s)){
                System.out.println("FAIL");
                return;
            }
            if(map.containsValue(s) && map.get(stk.peek()).equals(s)){
                stk.pop();
                continue;
            }
        }

        if (stk.size() == 0){
            System.out.println("PASS");
            return;
        }

        System.out.println("FAIL");
    }



    public static void main(String[] args) {
        // Test code
        solution("[yyyy]-[mm]-[dd]");               // Pass
        solution("System.out.println(arr[0][1))");  // FAIL
        solution("Support [Java or Python(3.x)]");  // PASS
        solution("([[{}])");                        // FAIL
    }
}
