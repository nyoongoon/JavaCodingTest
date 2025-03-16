package _2_Java_Algo_Interview._1_문자열;

import java.util.*;

/**
 * 우선순위 큐를 사용했지만 n * logn (횟수 * 힙정력) 로
 * 단순히 map을 순회하여 최대값 구하는 n 보다 성능 좋지 않았음..!
 */
public class _4_가장_흔한_단어_내풀이_다시풀이_1 {

    class Solution {
        class Word{
            String word;
            int cnt;
            Word(String word, int cnt){
                this.word = word;
                this.cnt = cnt;
            }
        }
        public String mostCommonWord(String paragraph, String[] banned) {
            PriorityQueue<Word> pq = new PriorityQueue<>((x, y) -> y.cnt - x.cnt);
            Set<String> set = new HashSet<>();
            for(String str : banned){
                set.add(str);
            }

            Map<String, Integer> map = new HashMap<>();

            // String strs = paragraph.toLowerCase().replaceAll("\\W+", " ");
            // for(String str : strs){
            // System.out.println("strs == " + strs);
            // }

            for(String str : paragraph.toLowerCase().replaceAll("\\W+", " ").split(" ")){
                // System.out.println("str == " + str);
                map.put(str, map.getOrDefault(str, 0) + 1);
            }

            for(Map.Entry<String, Integer> entry : map.entrySet()){
                // System.out.println("entry.getKey() == " + entry.getKey());
                // System.out.println("entry.getValue() == " + entry.getValue());
                pq.add(
                        new Word(entry.getKey(), entry.getValue())
                );
            }

            System.out.println("pq.size() " + pq.size());

            while(!pq.isEmpty()){
                Word word = pq.poll();
                // System.out.println("word ==" + word.word);
                // System.out.println("cnt ==" + word.cnt);
                if(set.contains(word.word)){
                    continue;
                }
                return word.word;
            }

            return null;
        }
    }}
}
