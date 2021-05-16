package LeetCode;

import java.util.HashMap;
import java.util.Map;
/*
//시간복잡도, 공간복잡도
 	1. 2중 for문 
 	- 시간 O(n^2)
 	- 공간 O(n)
 	2. 해쉬맵 사용
 	- 시간 O(n)
 	- 공간 O(n)
*/
class TwoSum_1 {
	   public int[] twoSum(int[] nums, int target) {
	        int[] answer  = new int[2];
	    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	    	for(int i= 0; i<nums.length;i++) { 
	    		if(map.containsKey(target-nums[i])) {
	    			answer[0] =	map.get(target-nums[i]);
	                //내가 쓴 답.. --> 그냥 바로 넣어도 됨!!
	                //map.put(nums[i], i);
	                //answer[1] = map.get(nums[i]);
	                answer[i] = i;
	                return answer;
	    		}else{
	            map.put(nums[i], i);
	            }
	            
	    	}
	      	return null;
	    }
}

/* 2중 for문 
public int[] twoSum(int[] nums, int target) {
int[] answer  = new int[2];
for(int i = 0; i<nums.length;i++) {
	for(int j = i + 1; j<nums.length; j++) {
		if((nums[i] + nums[j]) == target) {
			answer[0] = i;
			answer[1] = j;
			return answer;
		}
	}
}
return null;
}*/
