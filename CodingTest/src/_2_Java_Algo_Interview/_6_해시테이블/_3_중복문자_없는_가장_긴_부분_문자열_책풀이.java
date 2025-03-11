package _2_Java_Algo_Interview._6_해시테이블;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * left idx를 건너뛰어서 재할당하는 케이스 때문에 더 효율적
 */
public class _3_중복문자_없는_가장_긴_부분_문자열_책풀이 //todo 한 번 다시 풀어보기
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> used = new HashMap<>();
            int left = 0;
            int right = 0;
            int maxLength = 0;

            for(char c : s.toCharArray()){
                //todo left <= used.get(c)을 하는 이유 몰랐음
                // -> 내부에 있지 않으면 이미 버린 것 -> 현재 left보다 뒤의 버린 값으로 가게 되는 경우 있음
                if(used.containsKey(c) && left <= used.get(c)){
                    left = used.get(c) + 1;
                }
//                else{
//                    System.out.println("left == " + left);
//                    System.out.println("right == " + right);
//                    maxLength = Math.max(maxLength, right - left + 1);
//                }
                //책풀이는 위에인데, 논리적인 순서로 아래가 더 이해가 쉽고 성능도 별 차이 없음
                used.put(c, right);
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            }
            return maxLength;
        }
    }
}
