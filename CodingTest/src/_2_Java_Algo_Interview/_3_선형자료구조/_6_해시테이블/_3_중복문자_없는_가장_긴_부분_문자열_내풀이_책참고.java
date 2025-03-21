package _2_Java_Algo_Interview._3_선형자료구조._6_해시테이블;

import java.util.HashSet;
import java.util.Set;

/**
 * 책 풀이가 더 효율적이다
 */
public class _3_중복문자_없는_가장_긴_부분_문자열_내풀이_책참고 {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            String longStr = "";
            Set<Character> set = new HashSet<>();
            int left = 0;
            int right = 0;

            while(right < s.length()){
                if(set.contains(s.charAt(right))){
                    String tmp = s.substring(left, right);
                    if(longStr.length() < tmp.length()){
                        longStr = tmp;
                    }

                    set.remove(s.charAt(left));
                    left++;
                    continue;
                }
                set.add(s.charAt(right));
                right++;
            }
            String tmp = s.substring(left, right);
            if(longStr.length() < tmp.length()){
                longStr = tmp;
            }
            return longStr.length();
        }
    }
}
