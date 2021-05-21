package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring_2 {
	public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int temp = 0;
		for(int i = 0; i<s.length(); i++) {
			int j = i;
			Set<Character> set = new HashSet<>();
			for(; j<s.length(); j++) {
				if(j==s.length()-1) {
					set.add(s.charAt(j));
					temp = set.size();
					break;
				}
				if(!set.add(s.charAt(j))) {
					temp = set.size();
					break;
				}
			}
			if(temp>max) {
				max = temp;
			}
		}
		return max;
    }
}
