package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring_2 {
	public int lengthOfLongestSubstring(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int max = 0;
		for (int i = 0, j = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				// 중복 발생! -> 중복되었던 요소의 마지막 인덱스 + 1
				// 새로운 서브스트링의 첫번째 인덱스
				// max 계산을 통해서 중복된 값 끼리 비교하여 늦게 나온 값을 뽑기.
				// 그래야 새로운 서브스트링 max비교가 가능.
				j = Math.max(j, map.get(s.charAt(i)) + 1);

			}
			map.put(s.charAt(i), i);
			// i는 현재 인덱스. j는 서브스트링의 첫번째 인덱스
			// max =기존 서브스트링의 길이, i-j+1은 새로운 서브스트링의 길이
			max = Math.max(max, i - j + 1);
		}
		return max;
	}
}
	/*public int lengthOfLongestSubstring(String s) {
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
    }*/

