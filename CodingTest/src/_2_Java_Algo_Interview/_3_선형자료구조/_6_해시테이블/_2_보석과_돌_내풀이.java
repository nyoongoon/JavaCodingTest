package _2_Java_Algo_Interview._3_선형자료구조._6_해시테이블;

import java.util.HashSet;
import java.util.Set;

public class _2_보석과_돌_내풀이 {
    class Solution {
        public int numJewelsInStones(String jewels, String stones) {
            Set<Character> set = new HashSet<>();
            for(int i = 0 ; i<jewels.length(); i++){
                char c = jewels.charAt(i);
                set.add(c);
            }
            int cnt = 0;
            for(int i = 0; i<stones.length(); i++){
                char c = stones.charAt(i);
                if(set.contains(c)){
                    cnt++;
                }
            }
            return cnt;
        }
    }
}
