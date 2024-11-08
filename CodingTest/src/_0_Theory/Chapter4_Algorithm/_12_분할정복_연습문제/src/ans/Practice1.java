package _0_Theory.Chapter4_Algorithm._12_분할정복_연습문제.src.ans;// Practice1
// 정수형 배열 nums 가 주어졌다.
// 연속된 부분 배열의 합 중 가장 큰 값을 출력하세요.

// 입출력 예시
// nums: -5, 0, -3, 4, -1, 3, 1, -5, 8
// 출력: 10

// nums: 5, 4, 0, 7, 8
// 출력: 24

public class Practice1 {

    public static int solution(int[] nums) {
        return getArrayMax(nums, 0, nums.length - 1);
    }

    private static int getArrayMax(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }

        int m = (left + right) / 2;
        int leftSubArrayMax = getArrayMax(nums, left, m);
        int rightSubArrayMax = getArrayMax(nums, m + 1, right);

        int leftRightSubArrayMax = getLeftRightSubArrayMax(nums, left, right);

        return Math.max(leftSubArrayMax, Math.max(rightSubArrayMax, leftRightSubArrayMax));
    }

    private static int getLeftRightSubArrayMax(int[] nums, int left, int right) {
        int m = (left + right) / 2;

        int leftMax = Integer.MIN_VALUE;
        int leftSum = 0;

        for (int i = m; i >= 0; i--) {
            leftSum += nums[i];
            leftMax = Math.max(leftMax, leftSum);
        }

        int rightMax = Integer.MIN_VALUE;
        int rightSum = 0;
        for (int i = m + 1; i < nums.length; i++) {
            rightSum += nums[i];
            rightMax = Math.max(rightSum, rightMax);
        }

        /**
//         * leftMax + rightMax 더하기만 하는 게 맞나..? max 구하는게 맞지 않나..?
         */
        return Math.max(leftMax + rightMax, Math.max(leftMax, rightMax));
    }


    public static void main(String[] args) {
        // Test code
        int[] nums = {-5, 0, -3, 4, -1, 3, 1, -5, 8};
        System.out.println(solution(nums));

        nums = new int[]{5, 4, 0, 7, 8};
        System.out.println(solution(nums));
    }
}
