package _2_Java_Algo_Interview._6_해시테이블;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * left idx를 건너뛰어서 재할당하는 케이스 때문에 더 효율적
 */
public class _3_중복문자_없는_가장_긴_부분_문자열_책풀이 {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> used = new HashMap<>();
            int left = 0;
            int right = 0;
            int maxLength = 0;

            for(char c : s.toCharArray()){
                //todo left <= used.get(c)을 하는 이유 몰랐음
                // -> 슬라이딩 윈도우 내부에 있을 경우만 업데이트하지 않으며녀 right 보다 큰 left로 업데이트 되는 경우가 되버림
                // -> 중복이 나타나더라도 left값이 업데이트 되지 않아야 더 긴 문자열이 되는 경우
                // -> 내부에 있지 않으면 이미 버린 것
                if(used.containsKey(c) && left <= used.get(c)){
                    left = used.get(c) + 1;
                }else{
                    System.out.println("left == " + left);
                    System.out.println("right == " + right);
                    maxLength = Math.max(maxLength, right - left + 1);
                }
                used.put(c, right);
                right++;
            }
            return maxLength;
        }
    }
}
