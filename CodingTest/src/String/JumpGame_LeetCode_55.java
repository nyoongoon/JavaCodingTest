package String;
import java.util.Arrays;
import java.util.Scanner;

public class JumpGame_LeetCode_55 {
	
	public static void main(String[] args) {
		JumpGame_LeetCode_55 jl = new JumpGame_LeetCode_55();
		int[] nums = { 2, 3, 1, 1, 4 };
		boolean answer = jl.canJump(nums);
		System.out.println(answer);
	}
	static int dab = 0;
	public boolean canJump(int[] nums) {
		boolean result = jump(0, nums[0], nums, dab);
		return result;
	}

	public boolean jump(int preIdx, int preVal, int[] nums, int dab) {
		if (nums.length == 1) {// 길이가 1인경우
			dab = 1;
			return false;
		} else if (preVal == 0) {
			return false; // 길이가 1이 아닌데 첫째 값이 0 인경우false
		}

		// 마지막 인덱스이상인 경우 true
		if (preVal >= nums.length - 1 || preIdx + nums[preVal] >= nums.length - 1) {
			dab = 1;
			return false;
		}

		int nowIdx = preIdx + nums[preVal];
		int nowVal = nums[nowIdx];
		if (nowIdx == nums.length - 1) {
			dab = 1;
			return false; // 현재 마지막 인덱스
		}



		if (jump(nowIdx, nowVal, nums, dab)) {
			
		} else {

			if (preVal > 1) {
				jump(preIdx, preVal - 1, nums, dab);
				
			}

			if (preIdx > 0) {
				jump(preIdx - 1, nums[preIdx - 1], nums, dab);
			}
		}
		
		boolean answer = false;
		if (dab == 1) {
			answer = true;
		}
		return answer;
	}
}
