package _2_Java_Algo_Interview._2_배열;

import java.util.Arrays;

public class _5_배열_자신을_제외한_배열의_곱_내풀이_다시풀기 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 3, 5, 7})));
    }
    public static int[] productExceptSelf(int[] nums) {
        int[] excepSelfProduct = new int[nums.length];
        int[] excepSelfReverseProduct = new int[nums.length];
        int[] resultArr = new int[nums.length];
        int p = 1;
        for(int i = 0; i < nums.length; i++){
            excepSelfProduct[i] = p;
            p *= nums[i];
        }
        p = 1;
        for(int i = nums.length-1; i >= 0; i--){
            excepSelfReverseProduct[i] = p;
            p *= nums[i];
        }
        for(int i = 0 ; i < resultArr.length; i++){
            resultArr[i] = excepSelfProduct[i] * excepSelfReverseProduct[i];
        }

        return resultArr;
    }
}
