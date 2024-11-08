package _0_Theory.Chapter2_Linear._14_선형자료구조_연습문제_2.src;

import java.util.HashMap;
import java.util.Map;

public class Practice4 {
    public static String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < participant.length; i++) {
            int cnt = map.getOrDefault(participant[i], 0);
            map.put(participant[i], cnt + 1);
        }

        for (int i = 0; i < completion.length; i++) {
            int cnt = map.get(completion[i]);

            if (cnt - 1 == 0) {
                map.remove(completion[i]);
                continue;
            }
            map.put(completion[i], cnt - 1);
        }

        for(String str : map.keySet()){
            System.out.println(str);
        }
        return "";
    }

    public static void main(String[] args) {
        // Test code
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        System.out.println(solution(participant, completion));

        participant = new String[]{"marina", "josipa", "nikola", "vinko", "filipa"};
        completion = new String[]{"josipa", "filipa", "marina", "nikola"};
        System.out.println(solution(participant, completion));

        participant = new String[]{"mislav", "stanko", "mislav", "ana"};
        completion = new String[]{"stanko", "ana", "mislav"};
        System.out.println(solution(participant, completion));
    }
}
