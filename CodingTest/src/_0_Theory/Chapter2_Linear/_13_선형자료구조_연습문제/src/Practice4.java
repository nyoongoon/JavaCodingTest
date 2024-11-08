package _0_Theory.Chapter2_Linear._13_선형자료구조_연습문제.src;


import java.util.HashMap;
import java.util.Map;

public class Practice4 {
    public static void solution(String str) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('(', 0);
        map.put('[', 0);
        map.put('{', 0);

        for (int i = 0; i < str.length(); i++) {
            check(map, str.charAt(i));
        }

        for (Character key : map.keySet()) {
            if (map.get(key) != 0) {
                System.out.println("FAIL");
                return;
            }
        }
        System.out.println("PASS");
    }

    public static void check(Map<Character, Integer> map, char c) {
        if (c == '(') {
            map.put('(', map.get('(') + 1);
        } else if (c == '{') {
            map.put('{', map.get('{') + 1);
        } else if (c == '[') {
            map.put('[', map.get('[') + 1);
        } else if (c == ')') {
            map.put('(', map.get('(') - 1);
        } else if (c == '}') {
            map.put('{', map.get('{') - 1);
        } else if (c == ']') {
            map.put('[', map.get('[') - 1);
        }
    }

    public static void main(String[] args) {
        // Test code
        solution("[yyyy]-[mm]-[dd]");               // Pass
        solution("System.out.println(arr[0][1))");  // FAIL
        solution("Support [Java or Python(3.x)]");  // PASS
        solution("([[{}])");                        // FAIL
    }
}
