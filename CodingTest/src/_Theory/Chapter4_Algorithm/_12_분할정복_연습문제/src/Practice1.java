package _Theory.Chapter4_Algorithm._12_분할정복_연습문제.src;// Practice1
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

        int leftMax = getArrayMax(nums, left, m);
        int rightMax = getArrayMax(nums, m + 1, right);

        int subMax = getSubArrayMax(nums, left, right);

        return Math.max(leftMax, Math.max(rightMax, subMax));
    }

    private static int getSubArrayMax(int[] nums, int left, int right) {
        int m = (left + right) / 2;
        int maxLeft = Integer.MIN_VALUE;
        int sumLeft = 0;
        for (int i = m; i >= left; i--) {
            sumLeft += nums[i];
            maxLeft = Math.max(sumLeft, maxLeft);
        }

        int maxRight = Integer.MIN_VALUE;
        int sumRight = 0;
        for (int i = m + 1; i <= right; i++) {
            sumRight += nums[i];
            maxRight = Math.max(sumRight, maxRight);
        }

        return maxLeft + maxRight;
    }


    public static void main(String[] args) {
        // Test code
        int[] nums = {-5, 0, -3, 4, -1, 3, 1, -5, 8};
        System.out.println(solution(nums));

        nums = new int[]{5, 4, 0, 7, 8};
        System.out.println(solution(nums));
    }
}
