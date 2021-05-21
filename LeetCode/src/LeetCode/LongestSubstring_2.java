package LeetCode;

import java.util.HashMap;

public class LongestSubstring_2 {
	public int lengthOfLongestSubstring(String s) {
	  if (s.length()==0) return 0;
      HashMap<Character, Integer> map = new HashMap<Character, Integer>();
      int max=0;
      for (int i=0, j=0; i<s.length(); ++i){
          if (map.containsKey(s.charAt(i))){
              j = Math.max(j,map.get(s.charAt(i))+1);
          }
          map.put(s.charAt(i),i);
          max = Math.max(max,i-j+1);
      }
      return max;
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
}
