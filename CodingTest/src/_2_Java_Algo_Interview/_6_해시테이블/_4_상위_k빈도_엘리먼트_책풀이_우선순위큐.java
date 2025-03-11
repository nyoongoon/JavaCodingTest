package _2_Java_Algo_Interview._6_해시테이블;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 내풀이는 맵 -> 유선순위큐(객체)에 객체 직접 사용 (값-개수 묶기 위해)
 * 책풀이는 맵 -> 우선순위큐(배열)로 사용
 */
public class _4_상위_k빈도_엘리먼트_책풀이_우선순위큐 {
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int num : nums){
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[1] - x[1]);
            for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                int num = entry.getKey();
                int cnt = entry.getValue();
                pq.add(new int[] {num, cnt});
            }

            int[] result = new int[k];
            for (int i = 0; i < k; i++) {
                result[i] = pq.poll()[0];
            }

            return result;
        }
    }
}
