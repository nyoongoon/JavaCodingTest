package _2_Java_Algo_Interview._3_선형자료구조._6_해시테이블;

import java.util.HashMap;
import java.util.Map;

public class _5_완주하지못한선수_내풀이 {
    class Solution {
        public String solution(String[] participant, String[] completion) {
            Map<String, Integer> map = new HashMap<>();
            for(String participantNm : participant){
                map.put(participantNm, map.getOrDefault(participantNm, 0) + 1);
            }
            for(String completionNm : completion){
                int cnt = map.get(completionNm);
                if(cnt - 1 <= 0){
                    map.remove(completionNm);
                }else{
                    map.put(completionNm, cnt - 1);
                }
            }

            for(Map.Entry<String, Integer> entry : map.entrySet()){
                return entry.getKey();
            }

            return " ";
        }
    }
}
