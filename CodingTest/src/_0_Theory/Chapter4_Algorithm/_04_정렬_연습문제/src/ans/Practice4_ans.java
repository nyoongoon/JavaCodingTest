package _0_Theory.Chapter4_Algorithm._04_정렬_연습문제.src.ans;

/**
 * 내가 찾은 방향. -> idx++ 진행하며 해당 값이 max보다 클 때 해당 값 이후로 오름차순이면 타겟은 해당값의 idx-1 이다. -> 마지막 오름차순이 아닌 값의 인덱스 구하기 !!
 * 해설 -> 같은 타겟 구하는데 방식의 해석이 조금 다름!
 * -> idx++ 진행하면서 현재 값이 max 보다 작으면 타겟 ->  max 가 보다 크다 == 오름차순이다. <-> max 보다 작다 == 오름차순이 아니다.. -> 마지막 오름차순이 아닌 값의 인덱스 구하기 !!
 * --> max 보다 작은 마지막 인덱스를 구하는 것!
 * --> min도 같은 이치로 idx-- 진행하면서 min보다 큰 값이 타겟..
 */
public class Practice4_ans {

    public static int solution(int[] nums) {
        int startIdx = 0;
        int min = Integer.MAX_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (min < nums[i]) {
                startIdx = i;
                continue;
            }
            min = nums[i];
        }

        int endIdx = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (max > nums[i]) {
                endIdx = i;
                continue;
            }
            max = nums[i];
        }

        return endIdx - startIdx + 1;  // startIdx의 기본값 0 endIdx 기본값은 -1으로하여 둘다 결과 없을 때 0이 되는 테크닉 기억..!
    }


    public static void main(String[] args) {
        // Test code
        int[] nums = {2, 6, 4, 8, 5, 3, 9, 10};
        System.out.println(solution(nums));

        nums = new int[]{1, 3, 1};
        System.out.println(solution(nums));

        nums = new int[]{1, 9, 3, 4, 5};
        System.out.println(solution(nums));

        nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(solution(nums));
    }
}
