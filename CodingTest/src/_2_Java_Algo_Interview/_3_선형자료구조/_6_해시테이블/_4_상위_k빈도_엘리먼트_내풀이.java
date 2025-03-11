package _2_Java_Algo_Interview._3_선형자료구조._6_해시테이블;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _4_상위_k빈도_엘리먼트_내풀이 {
    class Solution {
        class Frequent{
            int num;
            int cnt;
            Frequent(int num, int cnt){
                this.num = num;
                this.cnt = cnt;
            }
        }
        public int[] topKFrequent(int[] nums, int k) {
            PriorityQueue<Frequent> pq = new PriorityQueue<>((x, y)-> y.cnt - x.cnt);
            Map<Integer, Integer> map = new HashMap<>();
            for(int n : nums){
                map.put(n, map.getOrDefault(n, 0) + 1);
            }

            for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                pq.add(new Frequent(
                        entry.getKey(),
                        entry.getValue()
                ));
            }

            int[] result = new int[k];
            for(int i = 0; i < k; i++){
                result[i] = pq.poll().num;
            }

            return result;
        }
    }
}
