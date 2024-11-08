package _0_Theory.Chapter4_Algorithm._08_투포인터_연습문제.src;// Practice
// a, b, c, d 로 이루어진 알파벳 문자열에 대해서
// 다음과 같은 규칙으로 문자열을 정리한 후 남은 문자열을 반환하는 프로그램을 작성하세요.
// 양쪽의 문자를 비교한 후 같으면 삭제하는데, 연속해서 같은 문자가 등장하면 함께 삭제한다.
// 최종적으로 남은 문자열을 반환하세요.

// 입출력 예시
// 입력 s: "ab"
// 출력: "ab"

// 입력 s: "aaabbaa"
// 출력: (없음)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 리스트로 변환해서 풀었는데 투포인터이므로 배열 자체에서 투포인터로 푸는게 더 좋은 풀이 방법일듯..
 */
public class Practice1 {
    public static String solution(String s) {
        //예외처리
        if (s == null || s.length() == 0) {
            return null;
        }

        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }

        int startIdx = 0;
        int endIdx = list.size() - 1;
        while (!list.isEmpty()) {
            int size = list.size();
            if (list.get(0) == list.get(size - 1)) {
                removeCascadeFront(list);

                if (!list.isEmpty()) {
                    removeCascadeRear(list);
                }
            } else {
                break;
            }
        }


        return Arrays.toString(list.toArray());
    }

    private static void removeCascadeFront(List<Character> list) {
        Character removed = list.remove(0);
        while (!list.isEmpty() && removed == list.get(0)) {
            removed = list.remove(0);
        }
    }

    private static void removeCascadeRear(List<Character> list) {
        Character removed = list.remove(list.size() - 1);
        while (!list.isEmpty() && removed == list.get(list.size() - 1)) {
            removed = list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(solution("ab"));         // ab
        System.out.println(solution("aaabbaa"));    //
        System.out.println(solution("aabcddba"));   // cdd
    }
}
