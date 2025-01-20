package _2_Java_Algo_Interview._2_배열;

import java.util.Arrays;

public class _4_배열_파티션_1_책풀이_짝수번째값계산 {
    public static void main(String[] args) {
        arrayPairSum(new int[]{1, 3, 4, 2}); //4
    }
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0; i<nums.length; i+=2){
            sum += nums[i];
        }
        return sum;
    }
}
