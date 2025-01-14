package _2_Java_Algo_Interview._2_배열;

import java.util.Arrays;

public class _4_배열_파티션_1_내풀이 {
    public static void main(String[] args) {
        arrayPairSum(new int[]{1, 3, 4, 2}); //4
    }
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for(int i = nums.length - 1; i>=0; i-=2){
            int min = Math.min(nums[i-1], nums[i]);
            result += min;
        }
        return result;
    }
}
