package _2_Java_Algo_Interview._2_배열;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 감도 안옴 ;; -> 책 보고 풀었으나 풀이 방식이 살짝 다름 참고
 */
public class _3_세_수의_합_내풀이 {
    public static void main(String[] args) {
        threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            int startIdx = i + 1;
            int endIdx = nums.length - 1;
            while (startIdx < endIdx) {

                if (i < startIdx - 1 && nums[startIdx - 1] == nums[startIdx] && endIdx < nums.length - 1 && nums[endIdx] == nums[endIdx + 1]) {
                    startIdx++;
                    endIdx--;
                    continue;
                }

                if (nums[i] + nums[startIdx] + nums[endIdx] < 0) {
                    startIdx++;
                } else if (nums[i] + nums[startIdx] + nums[endIdx] > 0) {
                    endIdx--;
                } else { //nums[i] + nums[startIdx] + nums[endIdx] == 0
                    List<Integer> threeSumArr = new ArrayList<>();
                    threeSumArr.add(nums[i]);
                    threeSumArr.add(nums[startIdx]);
                    threeSumArr.add(nums[endIdx]);

                    answer.add(threeSumArr);
                    startIdx++;
                    endIdx--;
                }
            }
        }

        return answer;
    }
}
