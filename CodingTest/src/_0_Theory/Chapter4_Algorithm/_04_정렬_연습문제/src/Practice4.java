package _0_Theory.Chapter4_Algorithm._04_정렬_연습문제.src;// Practice4
// 정수 배열 nums 가 주어졌을 때
// 오름차순으로 정렬하기 위해 배열 내에서 정렬이 필요한 구간의 길이를 출력하는 프로그램을 작성하세요.

// 입출력 예시
// 입력: 2, 6, 4, 8, 5, 3, 9, 10
// 출력: 5

// 입력: 1, 3, 1
// 출력: 2

public class Practice4 {
    public static int solution(int[] nums) { //todo 틀림!!! (예외 상황 있음..)
        int startIdx = 0; //nums[startIdx] 보다 크면서 이후로 작은 값이 없는 것이 endIdx..
        int endIdx = 0;

        startIdx = getStartIdx(nums);

        if(startIdx == -1){
            return 0;
        }

        endIdx = getEndIdx(nums, startIdx);

//        System.out.println("startIdx == " + startIdx);
//        System.out.println("endIdx == " + endIdx);

        return endIdx - startIdx + 1; // 2 조건만 만족시킴.. --> 1조건에서 마지막이 아니라 마지막-1 (작<큰) 의 작을 선택해야함..
    }

    public static int getStartIdx(int[] nums) {
        int startIdx = -1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                startIdx = i;
                break;
            }
        }
        return startIdx;
    }

    public static int getEndIdx(int[] nums, int startIdx) {
        int endIdx = nums.length - 1;

        for (int i = startIdx + 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i] && nums[startIdx] < nums[i]) {
                if (isOrdered(nums, i)) {
                    endIdx = i - 1;
                    break;
                }
            }
        }

        return endIdx;
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

    public static boolean isOrdered(int[] nums, int idx) {
        for (int i = idx; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
