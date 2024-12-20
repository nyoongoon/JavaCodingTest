package _0_Theory.Chapter4_Algorithm._06_이진탐색_연습문제.src;// Practice5
// 정수형 배열 nums 와 정수 m 이 주어졌다.
// nums 에는 양의 정수 값들이 들어 있고, m 은 배열을 부분 배열로 분리할 수 있는 수이다.
// nums 배열을 m 개의 부분 배열로 분리할 때,
// 각 부분 배열의 합중 가장 큰 값이 최소가 되도록 분리했을 때의 합을 출력하세요.
//
// 입출력 예시
// nums: 7, 2, 5, 10, 8
// m: 2
// 출력: 18
//
// nums: 1, 2, 3, 4, 5
// m: 2
// 출력: 9


public class Practice5 {

    public static int solution(int[] nums, int m) {
        int left = 0;
        int right = 0;

        for (int n : nums) {
            left = Math.max(n, left);
            right += n;
        }

        while (left <= right) {
            int mid = (left + right) / 2;
            int cur = 0;
            int cnt = 1;
            for (int n : nums) {
                if (cur + n > mid) {
                    cnt++;
                    cur = 0;
                }
                cur += n;
            }

            if (cnt > m) {// cnt가(부분배열이) 크다 -> mid가 작다 -> mid 키우기
                left = mid + 1;
            } else { //cnt가(부분배열이) 같거나 작다 -> mid가 크다 -> mid 줄이기
                right = mid - 1;
            }
        }

        return left;
    }


    public static void main(String[] args) {
        // Test code
        int[] nums = {7, 2, 5, 10, 8};
        System.out.println(solution(nums, 2));  // 18

        nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(solution(nums, 2));  // 9

        nums = new int[]{1, 4, 4};
        System.out.println(solution(nums, 3));  // 4
    }
}
