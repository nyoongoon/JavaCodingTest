package _2_Java_Algo_Interview._2_배열;

import java.util.HashMap;
import java.util.Map;

public class _1_두_수의_합_키_조회_내풀이 {

    public static void main(String[] args) {
        twoSum(new int[]{2,7,11,15}, 9); //[0, 1]
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                int preIdx = map.get(nums[i]);
                return new int[]{preIdx, i};
            }else{
                int interval = target - nums[i];
                map.put(interval, i);
            }
        }

        return null;
    }
}
