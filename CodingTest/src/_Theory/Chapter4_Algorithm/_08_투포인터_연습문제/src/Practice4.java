package _Theory.Chapter4_Algorithm._08_투포인터_연습문제.src;// Practice
// 주어진 nums 배열에서 3 개의 합이 0이 되는 모든 숫자들을 출력하세요.
// 중복된 숫자 셋은 제외하고 출력하세요.

// 입출력 예시
// nums: {-1, 0, 1, 2, -1, -4}; // 정렬한다 -> 0보다 크면 왼쪽 -> 영보다 작으면 오른쪽
// 출력: [[-1, -1, 2], [-1, 0, 1]]

// nums: {1, -7, 6, 3, 5, 2}
// 출력: [[-7, 1, 6], [-7, 2, 5]]


import java.util.ArrayList;
import java.util.Arrays;

/**
 * 어려움 !
 */
public class Practice4 {
    // nums: {-1, 0, 1, 2, -1, -4};
    // -4, -1, -1, 0 , 1, 2
    public static ArrayList<ArrayList<Integer>> solution(int[] nums) {
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int p1 = i + 1;
            int p2 = nums.length - 1;
            if (i != 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            while (p1 < p2) {
                if (p1 < p2 && nums[i] + nums[p1] + nums[p2] == 0) {
                    result.add(new ArrayList<>(Arrays.asList(nums[i], nums[p1], nums[p2])));
                    while (p1 < p2 && nums[p1] == nums[p1 + 1]) {
                        p1++;
                    }

                    while (p1 < p2 && nums[p2] == nums[p2 - 1]) {
                        p2--;
                    }
                    p1++;
                    p2--;

                } else if (nums[i] + nums[p1] + nums[p2] > 0) {
                    p2--;
                } else {
                    p1++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Test code

        // -4 -1 -1 0 1 2
        int[] nums = {-1, 0, 1, 2, -1, -4};     // [[-1, -1, 2], [-1, 0, 1]]
        System.out.println(solution(nums));

        nums = new int[]{1, -7, 6, 3, 5, 2};   // [[-7, 1, 6], [-7, 2, 5]]
        System.out.println(solution(nums));
    }
}
