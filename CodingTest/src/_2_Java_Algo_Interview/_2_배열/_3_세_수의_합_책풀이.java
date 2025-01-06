package _2_Java_Algo_Interview._2_배열;

import java.util.List;

public class _3_세_수의_합_책풀이 {
    public static void main(String[] args) {
        threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();

        Arrays.sort(nums);

        for(int i = 0 ; i<nums.length; i++){
            if(i > 0 && nums[i-1]== nums[i]){
                continue;
            }

            int leftIdx = i + 1;
            int rightIdx = nums.length - 1;

            while(leftIdx < rightIdx){
                if(nums[i] + nums[leftIdx] + nums[rightIdx] < 0){
                    leftIdx++;
                }else if(nums[i] + nums[leftIdx] + nums[rightIdx] > 0){
                    rightIdx--;
                }else {
                    answer.add(List.of(nums[i], nums[leftIdx], nums[rightIdx]));

                    while(leftIdx < rightIdx && nums[leftIdx] == nums[leftIdx + 1]){
                        leftIdx++;
                    }
                    while(leftIdx < rightIdx && nums[rightIdx] == nums[rightIdx - 1]){
                        rightIdx--;
                    }

                    leftIdx++;
                    rightIdx--;
                }
            }
        }
        return answer;
    }
}
