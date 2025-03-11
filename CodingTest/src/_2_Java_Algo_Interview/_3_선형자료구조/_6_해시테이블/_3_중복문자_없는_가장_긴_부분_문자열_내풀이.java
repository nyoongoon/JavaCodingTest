package _2_Java_Algo_Interview._3_선형자료구조._6_해시테이블;

import java.util.HashSet;
import java.util.Set;

/**
 * 맞았으나 성능 매우 느림
 */
public class _3_중복문자_없는_가장_긴_부분_문자열_내풀이 {
    class Solution {
        public int lengthOfLongestSubstring(String s) {

            String longStr = "";

            for(int i = 0; i<s.length(); i++){
                StringBuilder sb = new StringBuilder();
                Set<Character> set = new HashSet<>();
                for(int j = i; j < s.length(); j++){
                    char c = s.charAt(j);
                    if(set.contains(c)){
                        String str = sb.toString();
                        if(longStr.length() < str.length()){
                            longStr = str;
                        }
                        break;
                    }
                    set.add(c);
                    sb.append(c);
                }
                String str = sb.toString();
                if(longStr.length() < str.length()){
                    longStr = str;
                }
            }

            // System.out.println(longStr);
            return longStr.length();
        }
    }
}
