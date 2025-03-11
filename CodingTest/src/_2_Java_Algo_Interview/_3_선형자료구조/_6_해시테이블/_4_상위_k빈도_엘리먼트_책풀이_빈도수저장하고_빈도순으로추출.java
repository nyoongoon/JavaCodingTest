package _2_Java_Algo_Interview._3_선형자료구조._6_해시테이블;

import java.util.*;

public class _4_상위_k빈도_엘리먼트_책풀이_빈도수저장하고_빈도순으로추출 {
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> cntMap = new HashMap<>();
            for(int num : nums){
                cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
            }

            Map<Integer, List<Integer>> listMap = new HashMap<>();
            for(Map.Entry<Integer, Integer> entry : cntMap.entrySet()){
                int num = entry.getKey();
                int cnt = entry.getValue();

                List list = listMap.getOrDefault(cnt, new ArrayList<Integer>());
                list.add(num);
                listMap.put(cnt, list);
            }

            int[] result = new int[k];
            int idx = 0;
            for(int i = nums.length; i >= 0; i--){
                // System.out.println("i == " + i);
                if(listMap.containsKey(i)){

                    for(int num : listMap.get(i)){
                        // System.out.println("key == " + i);
                        if(idx < k){
                            // System.out.println("num == " + num);
                            result[idx++] = num;
                        }
                    }
                }
            }
            return result;
        }
    }
}
