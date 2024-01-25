package _Theory.Chapter3_NonLinear._12_우선순위큐_연습문제.src;// Practice4
// 문자열 s 가 주어졌을 때, 문자열 내에 동일한 알파벳이 연속적으로 배치되지 않도록 재배치 하세요.
// 재배치가 가능한 경우 재정렬한 문자열을 반환하고 불가능한 경우 null 을 반환하세요.

// 입출력 예시
// 입력: "aabb"
// 출력: "abab"

// 입력: "aaca"
// 출력: null


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Practice4 { // 내풀이 틀림 --->>> 빈도수 우선순위 처리를 하지 않아서 ...
    public static String solution(String s) {
        List<Character> resultList = new ArrayList<>(); //결과 String이 될 리스트
        List<Character> charList = new ArrayList<>(); //순회용 리스트
        Map<Character, Integer> map = new HashMap<>(); //cnt 목적 map..
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        charList.addAll(map.keySet());

        int idx = 0;
        while (!map.isEmpty()) {
            char c = charList.get(idx);
            idx = (idx + 1) % charList.size();

            if (!map.containsKey(c)) {
                continue;
            }
            if (map.get(c) > 0) { //하나씩 차감..
                System.out.println(c);
                if (resultList.size() == 0 || resultList.get(resultList.size() - 1) != c) {
                    resultList.add(c);
                } else {
                    return null; // 바로 이전 요소와 중복 시 null 리턴..
                }
                map.put(c, map.get(c) - 1);
            } else {
                map.remove(c);
            }
        }

        StringBuilder str = new StringBuilder();
        resultList.forEach(str::append);
        return str.toString();
    }

    public static void main(String[] args) {
        // Test code
//        System.out.println(solution("aabb"));
        System.out.println(solution("aaaaabccd"));
//        System.out.println(solution("aaca"));
    }
}
