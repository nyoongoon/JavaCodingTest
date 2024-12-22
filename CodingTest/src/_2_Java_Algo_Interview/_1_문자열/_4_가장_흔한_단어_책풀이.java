package _2_Java_Algo_Interview._1_문자열;

import java.util.*;

/**
 * 입력값에 대한 전처리 -> 문자열 정규식 사용하기 주의
 * String[] word = p.replaceAll("\\W+", " ").toLowerCase().split(" ");
 * -> \W는 단어 문자가 아닌 것을 의미. cf) \w는 단어 문자
 * -> 문자 뒤에 +를 쓰면 연속적일수도 있는 것을 의미 ex) a+ => a, aa ...
 */
public class _4_가장_흔한_단어_책풀이 {

    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        String result = mostCommonWord(paragraph, banned);
        System.out.println(result);
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        String[] words = paragraph.replaceAll("\\W+", " ").toLowerCase().split(" ");

        Map<String, Integer> counts = new HashMap<>();
        for (String str : words) {
            if (!bannedSet.contains(str)) {
                counts.put(str, counts.getOrDefault(str, 0) + 1);
            }
        }

        return Collections.max(counts.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
