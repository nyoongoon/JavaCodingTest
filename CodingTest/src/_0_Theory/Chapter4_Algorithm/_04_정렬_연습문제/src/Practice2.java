package _0_Theory.Chapter4_Algorithm._04_정렬_연습문제.src;// Practice2
// 문자열 배열 strs 가 주어졌을 때 anagram 으로 묶어서 출력하는 프로그램을 작성하세요.
// anagram 은 철자 순서를 바꾸면 같아지는 문자를 의미한다.
// 예) elvis <-> lives
// anagram 그룹 내에서 출력 순서는 상관 없다.

// 입출력 예시
// 입력: "eat", "tea", "tan", "ate", "nat", "bat"
// 출력: [[eat, tea, ate], [bat], [tan, nat]]


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Practice2 { // todo 계수정렬..
    public static ArrayList<ArrayList<String>> solution(String[] strs) {
        Map<String, ArrayList<String>> map = new HashMap<>();

        for (String str : strs) {
            String value = str;
            char[] ordered = str.toCharArray();
            sort(ordered);

            String key = String.valueOf(ordered);
            ArrayList<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(value);
            map.put(key, list);
        }

        ArrayList<ArrayList<String>> result = new ArrayList<>();

        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }

    public static void sort(char[] arr) {
        int[] intArr = new int['z' - 'A' + 1];
        for (int i = 0; i < arr.length; i++) {
            intArr[arr[i] - 'A']++;
        }

        int idx = 0;
        for (int i = 0; i < intArr.length; i++) {
            while (intArr[i] > 0) {
                arr[idx++] = (char) (i + 'A');
                intArr[i]--;
            }
        }
    }

    public static void main(String[] args) {
        // Test code
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(solution(strs));

        strs = new String[]{"abc", "bac", "bca", "xyz", "zyx", "aaa"};
        System.out.println(solution(strs));
    }
}
