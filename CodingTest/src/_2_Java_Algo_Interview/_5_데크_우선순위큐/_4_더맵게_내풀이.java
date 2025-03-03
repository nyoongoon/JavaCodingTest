package _2_Java_Algo_Interview._5_데크_우선순위큐;

import java.util.PriorityQueue;

public class _4_더맵게_내풀이 {
    static class Solution {
        public int solution(int[] scoville, int K) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int point : scoville){
                pq.add(point);
            }

            int cnt = 0;

            while(pq.size() >= 2 && pq.peek() < K){
                int min1 = pq.poll();
                int min2 = pq.poll();

                pq.add(min1 + (min2 * 2));

                cnt++;
            }

            if(pq.peek() >= K){
                return cnt;
            }else{
                return -1;
            }
        }
    }
}
